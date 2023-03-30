package gov.va.vinci.menopause.ae;

import gov.va.vinci.leo.AnnotationLibrarian;
import gov.va.vinci.leo.ae.LeoBaseAnnotator;
import gov.va.vinci.menopause.types.TermContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import java.util.Collection;

public class ContextFilterAE extends LeoBaseAnnotator {
    @Override
    public void annotate(JCas aJCas) throws AnalysisEngineProcessException {
        Collection<TermContext> anns = AnnotationLibrarian.getAllAnnotationsOfType(aJCas, TermContext.type, false);

        try {
            for (TermContext ann : anns) {
                if (ann.getNegation().equalsIgnoreCase("negated")) {
                    Collection<Annotation> anchors = AnnotationLibrarian.getAllCoveredAnnotations(ann);
                    for (Annotation anchor : anchors) {
                        if (!(anchor instanceof TermContext)) {
                            aJCas.removeFsFromIndexes(anchor);
                        }
                    }
                } else if (!ann.getExperiencer().equalsIgnoreCase("patient")) {
                    Collection<Annotation> anchors = AnnotationLibrarian.getAllCoveredAnnotations(ann);
                    for (Annotation anchor : anchors) {
                        if (!(anchor instanceof TermContext)) {
                            aJCas.removeFsFromIndexes(anchor);
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            throw new AnalysisEngineProcessException(e);
        }
    }
}
