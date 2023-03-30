package gov.va.vinci.menopause.ae;

import gov.va.vinci.leo.AnnotationLibrarian;
import gov.va.vinci.leo.ae.LeoBaseAnnotator;
import gov.va.vinci.leo.types.ParsedDate;
import gov.va.vinci.menopause.types.*;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DatePatternAE extends LeoBaseAnnotator {
    @Override
    public void annotate(JCas aJCas) throws AnalysisEngineProcessException {
        Collection<MenopauseDiagnosisDate> menopause = AnnotationLibrarian.getAllAnnotationsOfType(aJCas, MenopauseDiagnosisDate.type, false);
        Collection<SurgicalMenopauseDate> surgical = AnnotationLibrarian.getAllAnnotationsOfType(aJCas, SurgicalMenopauseDate.type, false);
        Collection<LastMenstrualDate> lmp = AnnotationLibrarian.getAllAnnotationsOfType(aJCas, LastMenstrualDate.type, false);
        Collection<MenstrualInterruption> interruption = AnnotationLibrarian.getAllAnnotationsOfType(aJCas, MenstrualInterruption.type, false);
        Collection<BirthControlStatement> bc = AnnotationLibrarian.getAllAnnotationsOfType(aJCas, BirthControlStatement.type, false);

        for(MenopauseDiagnosisDate men : menopause) {
            int[] menopauseTypes = new int[] {Postmenopause.type, NaturalMenopause.type, Menopause.type};
            try {
                String conceptStr = null;
                for (int type : menopauseTypes) {
                    ArrayList<Annotation> concepts = new ArrayList<>( AnnotationLibrarian.getAllCoveredAnnotationsOfType(men, type, false));
                    if (concepts.size() > 0) {
                        conceptStr = concepts.get(0).getCoveredText();
                        break;
                    }
                }
                men.setConcept(conceptStr);
                ArrayList<Annotation> concepts = new ArrayList<>( AnnotationLibrarian.getAllCoveredAnnotationsOfType(men, ParsedDate.type, false));
                men.setDate(((ParsedDate)concepts.get(0)).getDate1());
                men.setRelativeQty(((ParsedDate)concepts.get(0)).getRelativeQuantity());
                men.setRelativeUnit(((ParsedDate)concepts.get(0)).getRelativeUnit());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        for(SurgicalMenopauseDate men : surgical) {
            int[] surgeryTypes = new int[] {SurgicalMenopauseList.type, SurgicalMenopause.type};
            try {
                String conceptStr = null;
                for (int type : surgeryTypes) {
                    ArrayList<Annotation> concepts = new ArrayList<>( AnnotationLibrarian.getAllCoveredAnnotationsOfType(men, type, false));
                    if (concepts.size() > 0) {
                        conceptStr = concepts.get(0).getCoveredText();
                        break;
                    }
                }
                men.setConcept(conceptStr);
                ArrayList<Annotation> concepts = new ArrayList<>( AnnotationLibrarian.getAllCoveredAnnotationsOfType(men, ParsedDate.type, false));
                men.setDate(((ParsedDate)concepts.get(0)).getDate1());
                men.setRelativeQty(((ParsedDate)concepts.get(0)).getRelativeQuantity());
                men.setRelativeUnit(((ParsedDate)concepts.get(0)).getRelativeUnit());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        for(LastMenstrualDate l : lmp) {
            try {
                ArrayList<Annotation> concepts = new ArrayList<>( AnnotationLibrarian.getAllCoveredAnnotationsOfType(l, LastMenstrualPeriod.type, false));
                l.setConcept(concepts.get(0).getCoveredText());
                concepts = new ArrayList<>( AnnotationLibrarian.getAllCoveredAnnotationsOfType(l, ParsedDate.type, false));
                l.setDate(((ParsedDate)concepts.get(0)).getDate1());
                l.setRelativeQty(((ParsedDate)concepts.get(0)).getRelativeQuantity());
                l.setRelativeUnit(((ParsedDate)concepts.get(0)).getRelativeUnit());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        for(MenstrualInterruption i : interruption) {
            try {
                ArrayList<Annotation> concepts = new ArrayList<>( AnnotationLibrarian.getAllCoveredAnnotationsOfType(i, BirthControl.type, false));
                i.setConcept(concepts.get(concepts.size()-1).getCoveredText());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        for(BirthControlStatement i : bc) {
            try {
                ArrayList<Annotation> concepts = new ArrayList<>( AnnotationLibrarian.getAllCoveredAnnotationsOfType(i, BirthControl.type, false));
                i.setConcept(concepts.get(concepts.size()-1).getCoveredText());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
