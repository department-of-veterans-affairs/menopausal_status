package gov.va.vinci.menopause;

import gov.va.vinci.leo.annotationpattern.ae.AnnotationPatternAnnotator;
import gov.va.vinci.leo.context.ae.ContextAnnotator;
import gov.va.vinci.leo.descriptors.LeoTypeSystemDescription;
import gov.va.vinci.leo.descriptors.TypeDescriptionBuilder;
import gov.va.vinci.leo.regex.ae.RegexAnnotator;
import gov.va.vinci.leo.sentence.ae.AnchoredSentenceAnnotator;
import gov.va.vinci.leo.sentence.ae.SentenceAnnotator;
import gov.va.vinci.leo.types.TypeLibrarian;
import gov.va.vinci.leo.window.ae.WindowAnnotator;
import jdk.nashorn.internal.codegen.types.Type;

import java.io.File;

public class TypeSystem {
    public enum PARENT_CLASS {
        WINDOW("gov.va.vinci.leo.window.types.Window"),
        REGEX("gov.va.vinci.leo.regex.types.RegularExpressionType"),
        APA("gov.va.vinci.leo.annotationpattern.types.AnnotationPatternType"),
        CONTEXT("gov.va.vinci.leo.context.types.Context"),
        SENTENCE("gov.va.vinci.leo.sentence.types.Sentence"),
        ANCHORED_SENTENCE("gov.va.vinci.leo.sentence.types.AnchoredSentence");

        public String type;

        private PARENT_CLASS(String type) {
            this.type = type;
        }
        public String getType() {
            return this.type;
        }
    }

    public static final String[] regex_types = new String[]{
            "gov.va.vinci.menopause.types.Term"
            ,"gov.va.vinci.menopause.types.Menopause"
            ,"gov.va.vinci.menopause.types.Perimenopause"
            ,"gov.va.vinci.menopause.types.Postmenopause"
            ,"gov.va.vinci.menopause.types.NaturalMenopause"
            ,"gov.va.vinci.menopause.types.SurgicalMenopause"
            ,"gov.va.vinci.menopause.types.Symptom"
            ,"gov.va.vinci.menopause.types.Treatment"
            ,"gov.va.vinci.menopause.types.LastMenstrualPeriod"
            ,"gov.va.vinci.menopause.types.Exclude"
            ,"gov.va.vinci.menopause.types.BirthControl"
            ,"gov.va.vinci.menopause.types.BirthControlSection"
            ,"gov.va.vinci.menopause.types.Date"
            //,""
    };

    public static final String[] pattern_types = new String[]{
            "gov.va.vinci.menopause.types.TermPattern"
            ,"gov.va.vinci.menopause.types.MenopauseDiagnosisDate"
            ,"gov.va.vinci.menopause.types.SurgicalMenopauseDate"
            ,"gov.va.vinci.menopause.types.MenstrualInterruption"
            ,"gov.va.vinci.menopause.types.LastMenstrualDate"
            ,"gov.va.vinci.menopause.types.SurgicalMenopauseList"
            ,"gov.va.vinci.menopause.types.BirthControlStatement"
            //,"gov.va.vinci.menopause.types.SurgicalMenopauseLaterality"
    };

    public static final String[] windowsTypes = new String[]{
    };
    public static final String[] contextTypes = new String[]{
            "gov.va.vinci.menopause.types.TermContext"
    };
    public static final String[] sentenceTypes = new String[]{
    };
    public static final String[] anchoredTypes = new String[]{
    };



    public static LeoTypeSystemDescription getLeoTypeSystemDescription_DuplicateTypes() {
        LeoTypeSystemDescription types = new LeoTypeSystemDescription();
        types.addType(TypeDescriptionBuilder.create("gov.va.vinci.leo.types.DuplicateType", "", "uima.tcas.Annotation")
                .addFeature("original", "The original annotation. ", "uima.tcas.Annotation")
                .addFeature("ExtraAnnotationFeature", "Just in case feature ", "uima.tcas.Annotation")
                .addFeature("ExtraStringFeature", "Just in case feature ", "uima.cas.String")
                .getTypeDescription());
        return types;
    }

    public static LeoTypeSystemDescription getLeoTypeSystemDescription() {
        LeoTypeSystemDescription types = new LeoTypeSystemDescription();
        /** Leo Bones **/

        types.addType(TypeLibrarian.getCSITypeSystemDescription());
        types.addTypeSystemDescription(new WindowAnnotator().getLeoTypeSystemDescription());
        types.addTypeSystemDescription(new RegexAnnotator().getLeoTypeSystemDescription());
        types.addTypeSystemDescription(new AnnotationPatternAnnotator().getLeoTypeSystemDescription());
        types.addTypeSystemDescription(new SentenceAnnotator().getLeoTypeSystemDescription());
        types.addTypeSystemDescription(new AnchoredSentenceAnnotator().getLeoTypeSystemDescription());
        types.addTypeSystemDescription(new ContextAnnotator().getLeoTypeSystemDescription());
         types.addTypeSystemDescription(getLeoTypeSystemDescription_PipelineTypes());
        /**/
        return types;
    }

    public static LeoTypeSystemDescription getLeoTypeSystemDescription_PipelineTypes() {
        LeoTypeSystemDescription description = new LeoTypeSystemDescription();
        try {

            description.addType(TypeDescriptionBuilder.create("gov.va.vinci.leo.types.ParsedDate", "", "uima.tcas.Annotation")
                    .addFeature("Date1", "Parsed Date", "uima.cas.String")
                    .addFeature("Date2", "Parsed Date (if range)", "uima.cas.String")
                    .addFeature("RelativeQuantity", "Part of relative date", "uima.cas.String")
                    .addFeature("RelativeUnit", "Part of relative date", "uima.cas.String")
                    .getTypeDescription());

            for (String r : regex_types) {
                //description.addType(r, "RegEx type", PARENT_CLASS.REGEX.type);
                description.addType(TypeDescriptionBuilder.create(r, "", PARENT_CLASS.REGEX.type)
                        .addFeature("Laterality", "", "uima.cas.String")
                        .getTypeDescription());
            }
            for (String r : pattern_types) {
                description.addType(TypeDescriptionBuilder.create(r, "", PARENT_CLASS.APA.type)
                        .addFeature("Concept", "", "uima.cas.String")
                        .addFeature("Date", "", "uima.cas.String")
                        .addFeature("RelativeQty", "", "uima.cas.String")
                        .addFeature("RelativeUnit", "", "uima.cas.String")
                        .getTypeDescription());

                //description.addType(r, "Annotation Pattern Annotator type", PARENT_CLASS.APA.type);
            }
            for (String r : windowsTypes) {
                description.addType(r, "Window type", PARENT_CLASS.WINDOW.type);
            }
            for (String r : contextTypes) {
                description.addType(r, "Context type", PARENT_CLASS.CONTEXT.type);
            }
            for (String r : sentenceTypes) {
                description.addType(r, "Sentence type", PARENT_CLASS.SENTENCE.type);
            }
            for (String r : anchoredTypes) {
                description.addType(r, "Anchored sentence type", PARENT_CLASS.ANCHORED_SENTENCE.type);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return description;
    }


    public static LeoTypeSystemDescription getLeoTypeSystemDescription_MethodTemplate() {
        LeoTypeSystemDescription description = new LeoTypeSystemDescription();
        return description;
    }

    /**
     * Generate type descriptor
     *
     * @param args
     */
    /**
     * Generate type files and descriptor
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            LeoTypeSystemDescription types = new LeoTypeSystemDescription();
            types.addTypeSystemDescription(getLeoTypeSystemDescription());

            File srcDir = new File("generated-sources/src");
            srcDir.mkdirs();

            File classesDir = new File("generated-sources/classes");
            classesDir.mkdirs();

            types.jCasGen(srcDir.getCanonicalPath(), classesDir.getCanonicalPath());

            File resDir = new File("generated-sources/");
            resDir.mkdirs();

            types.toXML(resDir.getCanonicalPath() + "/TypeSystem.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

