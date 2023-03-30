package gov.va.vinci.menopause.pipeline;

import gov.va.vinci.leo.merger.ae.MergeAnnotator;
import gov.va.vinci.menopause.TypeSystem;
import gov.va.vinci.leo.annotationpattern.ae.AnnotationPatternAnnotator;
import gov.va.vinci.leo.context.ae.ContextAnnotator;
import gov.va.vinci.leo.descriptors.LeoAEDescriptor;
import gov.va.vinci.leo.descriptors.LeoTypeSystemDescription;
import gov.va.vinci.leo.filter.ae.FilterAnnotator;
import gov.va.vinci.leo.regex.ae.RegexAnnotator;
import gov.va.vinci.leo.sentence.ae.AnchoredSentenceAnnotator;
import gov.va.vinci.leo.tools.LeoUtils;
import gov.va.vinci.menopause.ae.ContextFilterAE;
import gov.va.vinci.menopause.ae.DateParserAE;
import gov.va.vinci.menopause.ae.DatePatternAE;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.HashMap;


public class Pipeline extends BasePipeline {
    private static final Logger log = Logger.getLogger(LeoUtils.getRuntimeClass().toString());

    private String TYPE_REGEX = TypeSystem.PARENT_CLASS.REGEX.getType();
    private String TYPE_PATTERN = TypeSystem.PARENT_CLASS.APA.getType();
    private String SENTENCE_TYPE = TypeSystem.PARENT_CLASS.ANCHORED_SENTENCE.getType();
    private String RESOURCE_TERM = "src/main/resources/term_regex.txt";
    private String RESOURCE_PATTERN = "src/main/resources/context.pattern";
    private String RESOURCE_CONTEXT = "src/main/resources/contextRules.txt";
    private String TYPE_TERM =         "gov.va.vinci.menopause.types.Term";
    private String TYPE_CONTEXT_PATTERN = "gov.va.vinci.menopause.types.TermPattern";
    private String TYPE_WINDOW_FEATURE = "Anchor";
    private String TYPE_CONTEXT = "gov.va.vinci.menopause.types.TermContext";
    private String TERM_CONCEPT = "Term";
    private String RESOURCE_GROOVY = "src/main/resources/term_list.groovy";

    /**
     * Constructors
     */

    public Pipeline() {
        this(null);
    }

    public Pipeline(HashMap args) {

        if (args.containsKey("RESOURCE_GROOVY"))  RESOURCE_GROOVY  = (String) args.get("RESOURCE_GROOVY");
        if (args.containsKey("RESOURCE_TERM"))    RESOURCE_TERM    = (String) args.get("RESOURCE_TERM");
        if (args.containsKey("RESOURCE_CONTEXT")) RESOURCE_CONTEXT = (String) args.get("RESOURCE_CONTEXT");
        if (args.containsKey("RESOURCE_PATTERN")) RESOURCE_PATTERN = (String) args.get("RESOURCE_PATTERN");
        if (args.containsKey("TERM_CONCEPT")) TERM_CONCEPT = (String) args.get("TERM_CONCEPT");
        pipeline = new LeoAEDescriptor();

        /** Add the regex annotator first **/
        try {
            if( new File(RESOURCE_GROOVY).exists()) {
                System.out.println("Using terms in --- " + RESOURCE_GROOVY) ;
                pipeline.addDelegate(new RegexAnnotator()
                        .setGroovyConfigFile(RESOURCE_GROOVY)
                        .setName("RegexTermAnnotator")
                        .setOutputType(TYPE_TERM)
                        .getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));
            }else {
                System.out.println("Resource file was not found -- " + RESOURCE_GROOVY);
            }

            pipeline.addDelegate(new FilterAnnotator()
                    .setTypesToKeep(new String[]{"gov.va.vinci.menopause.types.Perimenopause",
                            "gov.va.vinci.menopause.types.Postmenopause",
                            "gov.va.vinci.menopause.types.NaturalMenopause",
                            "gov.va.vinci.menopause.types.SurgicalMenopause"
                    })
                    .setTypesToDelete(new String[] {
                            "gov.va.vinci.menopause.types.Menopause"
                    })
                    .getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));

            pipeline.addDelegate(new AnnotationPatternAnnotator()
                    .setResource("src/main/resources/surgical_menopause_list.txt")
                    .setOutputType("gov.va.vinci.menopause.types.SurgicalMenopauseList")
                    .setName("SurgicalMenopauseListAnnotator")
                    .getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));

            pipeline.addDelegate(new FilterAnnotator()
                    .setTypesToKeep(new String[]{
                            "gov.va.vinci.menopause.types.SurgicalMenopauseList"
                    })
                    .setTypesToDelete(new String[] {
                            "gov.va.vinci.menopause.types.SurgicalMenopause"
                    })
                    .getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));

            pipeline.addDelegate(new FilterAnnotator()
                    .setTypesToKeep(new String[]{
                            "gov.va.vinci.menopause.types.BirthControlSection"
                    })
                    .setTypesToDelete(new String[] {
                            "gov.va.vinci.menopause.types.BirthControl"
                    })
                    .getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));

            pipeline.addDelegate(new MergeAnnotator()
                    .setTypesToMerge(new String[]{
                            "gov.va.vinci.menopause.types.Date"
                    })
                    .getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));

            pipeline.addDelegate(new MergeAnnotator()
                    .setTypesToMerge(new String[]{
                            "gov.va.vinci.menopause.types.BirthControl"
                    })
                    .getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));

            /* SentenceAnnotation  */
            pipeline.addDelegate(new AnchoredSentenceAnnotator()
                    .setSpanSize(200)
                    .setAnchorFeature(TYPE_WINDOW_FEATURE)
                    .setInputTypes("gov.va.vinci.menopause.types.Menopause"
                            ,"gov.va.vinci.menopause.types.Postmenopause"
                            ,"gov.va.vinci.menopause.types.NaturalMenopause"
                            ,"gov.va.vinci.menopause.types.SurgicalMenopause"
                            ,"gov.va.vinci.menopause.types.SurgicalMenopauseList")
                    .setOutputType(SENTENCE_TYPE)
                    .setName("TermSentenceAnnotator")
                    .getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));

            pipeline.addDelegate(new ContextAnnotator()
                    .setConceptFeatureName(TYPE_WINDOW_FEATURE)
                    .setResourceFile(RESOURCE_CONTEXT)
                    .setInputTypes(new String[]{SENTENCE_TYPE})
                    .setOutputType(TYPE_CONTEXT)
                    .getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));

            pipeline.addDelegate(new ContextFilterAE().getLeoAEDescriptor());

            pipeline.addDelegate(new DateParserAE()
                    .setDayPriority(false)
                    .setInputTypes("gov.va.vinci.menopause.types.Date")
                    .getLeoAEDescriptor());

            pipeline.addDelegate(new AnnotationPatternAnnotator()
                    .setResource("src/main/resources/menopause_patterns.txt")
                    .setOutputType("gov.va.vinci.menopause.types.MenopauseDiagnosisDate")
                    .setName("MenopauseDateAnnotator")
                    .getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));

            pipeline.addDelegate(new AnnotationPatternAnnotator()
                    .setResource("src/main/resources/LMP_pattern.txt")
                    .setOutputType("gov.va.vinci.menopause.types.LastMenstrualDate")
                    .setName("LMPDateAnnotator")
                    .getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));

            pipeline.addDelegate(new AnnotationPatternAnnotator()
                    .setResource("src/main/resources/surgical_menopause_patterns.txt")
                    .setOutputType("gov.va.vinci.menopause.types.SurgicalMenopauseDate")
                    .setName("SurgicalMenopauseDateAnnotator")
                    .getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));

            pipeline.addDelegate(new AnnotationPatternAnnotator()
                    .setResource("src/main/resources/interruption_pattern.txt")
                    .setOutputType("gov.va.vinci.menopause.types.MenstrualInterruption")
                    .setName("MenopauseInterruptionAnnotator")
                    .getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));

            pipeline.addDelegate(new AnnotationPatternAnnotator()
                    .setResource("src/main/resources/bc_pattern.txt")
                    .setOutputType("gov.va.vinci.menopause.types.BirthControlStatement")
                    .setName("MenopauseInterruptionAnnotator")
                    .getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));

            pipeline.addDelegate(new DatePatternAE().getLeoAEDescriptor());

//            pipeline.addDelegate(new FilterAnnotator()
//                    .setTypesToKeep(new String[]{"gov.va.vinci.menopause.types.LastMenstrualDate",
//                            "gov.va.vinci.menopause.types.MenopauseDiagnosisDate"
//                    })
//                    .setTypesToDelete(new String[] {
//                            "gov.va.vinci.menopause.types.Menopause"
//                            ,"gov.va.vinci.menopause.types.Postmenopause"
//                            ,"gov.va.vinci.menopause.types.SurgicalMenopause"
//                            ,"gov.va.vinci.menopause.types.NaturalMenopause"
//                            ,"gov.va.vinci.menopause.types.LastMenstrualPeriod"
//                            ,"gov.va.vinci.menopause.types.Date"
//                    })
//                    .getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected LeoTypeSystemDescription defineTypeSystem() {
        description = TypeSystem.getLeoTypeSystemDescription();
        return description;
    }


}
