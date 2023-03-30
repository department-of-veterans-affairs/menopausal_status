package gov.va.vinci.menopause.ae;

import gov.va.vinci.leo.AnnotationLibrarian;
import gov.va.vinci.leo.ae.LeoBaseAnnotator;
import gov.va.vinci.leo.descriptors.LeoConfigurationParameter;
import gov.va.vinci.leo.tools.CasTools;
import gov.va.vinci.leo.types.CSI;
import gov.va.vinci.leo.types.ParsedDate;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.uima.resource.ResourceInitializationException;

import java.text.SimpleDateFormat;
import java.util.regex.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
//import java.sql.Date;

public class DateParserAE extends LeoBaseAnnotator {

//    @LeoConfigurationParameter(mandatory = true, description = "The date-like input annotation")
//    private String inputType = null;
//
//    @LeoConfigurationParameter(mandatory = true, description = "The output annotation type")
//    private String outputType = null;

    /*
numbers = "(^a(?=\s)|one|two|three|four|five|six|seven|eight|nine|ten| \
      eleven|twelve|thirteen|fourteen|fifteen|sixteen|seventeen| \
      eighteen|nineteen|twenty|thirty|forty|fifty|sixty|seventy|eighty| \
      ninety|hundred|thousand)"
day = "(monday|tuesday|wednesday|thursday|friday|saturday|sunday)"
month = "((january|february|march|april|may|june|july|august|september| \
          october|november|december)|((jan|feb|mar|apr|jun|jul|aug|sept|sep|oct|nov|dec)(?=\W)))"
mm = "(1|2|3|4|5|6|7|8|9|(10)|(11)|(12)|(01)|(02)|(03)|(04)|(05)|(06)|(07)|(08)|(09))"
dmy = "(year|day|week|month)"
rel_day = "(today|yesterday|tomorrow|tonight|tonite)"
exp1 = "(before|after|earlier|later|ago)"
exp2 = "(this|next|last)"
iso = "((^|(?<=\s))" + mm + "[/\.]\d{1,2}[/\.]\d{2,4}(?=\D))" #"(^|(?<=\s))\d{1,2}[/\-\.]\d{1,2}[/\-\.]\d{2,4}(?=\D)" #"\d+[/-]\d+[/-]\d+ \d+:\d+:\d+\.\d+"
year = "(?<=\s)[12][09]\d{2}(?=\D)" #"((?<=\s)\d{4}|^\d{4})"
mmyyyy = "((?<=\D)" + mm +"/([12][09])?\d{2}(?=\D))" #"(?<=\s)([1-9]|(10)|(11)|1/(19|20)?\d{2}(?=\D)"
season = "(spring|summer|fall|winter)"
longdate = "(" + month + "( \d{1,2}| of)?.? " + year + ")"
regxp1 = "((\d+|(" + numbers + "[-\s]?)+) " + dmy + "s? " + exp1 + ")"
regxp2 = "(" + exp2 + " (" + dmy + "|" + week_day + "|" + month + "))"
regxp3 = "(in (\d+|(" + numbers + "[-\s]?)+) " + dmy + "s?)"
regxp4 = "(" + season + "( of)? " + year + ")"
     */

    @LeoConfigurationParameter( description = "Whether to assume day specificity")
    private boolean dayPriority = true;

    private final String[] dayMonthYear = new String[] {
            "yyyyMMdd",
            "M-d-yy",
            "M/d/yy",
            "M.d.yy",
            "M-d-yyyy",
            "M/d/yyyy",
            "M.d.yyyy",
            "MMM d, yyyy",
            "MMM d,yyyy",
            "MMM.d,yyyy",
            "MMMd,yyyy",
            "MMMd, yyyy",
            "MMM d, yyyy'@'HH:mm",
            "MMM d,yyyy'@'HH:mm",
            "d MMM yyyy",
            "MMM d yyyy",
            "(M/d/yy)",
            "(M/d/yyyy)",
    };

    private final String[] noYear = new String[] {
            "M/d",
            "M-d",
            "M.d",
            "MMM d"
    };

    private final String[] noDate = new String[] {
            "MMyy", //prevent 0304 from being parsed as jan 1, 304 AD
            "MMyyyy",
            "MMM yy",
            "MMM yyyy",
            "MMM ''yy", // january '21
            "M-yyyy",
            "M/yyyy",
            "M-yyyy",
            "M/yyyy",
            "M-yy",
            "M/yy",
            "MMMyyyy"
    };

    private final String[] extras = new String[] {
            "yyyy",
            "yyyy'''s'",
            "yyyy's'",
            "d/M/yy",
            "d-M-/yy",
            "d/M/yyyy",
            "d-m-yyyy"
    };

    private String[] patternsToUse = null;

    private final String unitOfTime = "(day|week|month|year)s?";
    private final String qty = "(\\d+)";


    private Pattern unitPattern = null;
    private Pattern qtyPattern = null;


    @Override
    public void initialize(UimaContext aContext) throws ResourceInitializationException {
        super.initialize(aContext);
        unitPattern = Pattern.compile(unitOfTime, Pattern.CASE_INSENSITIVE);
        qtyPattern = Pattern.compile(qty, Pattern.CASE_INSENSITIVE);

        ArrayList<String> patterns = new ArrayList<String>(Arrays.asList(dayMonthYear));
        if (dayPriority) {
            patterns.addAll(Arrays.asList(noYear));
        }
        else {
            patterns.addAll(Arrays.asList(noDate));
        }

        patterns.addAll(Arrays.asList(extras));


        patternsToUse = new String[patterns.size()];
        patterns.toArray(patternsToUse);
    }

    @Override
    public void annotate(JCas aJCas) throws AnalysisEngineProcessException {
        for(String inputType : inputTypes) {
            try {
                Collection<Annotation> anns = AnnotationLibrarian.getAllAnnotationsOfType(aJCas,inputType, false);
                for(Annotation ann : anns) {
                    ParsedDate date = new ParsedDate(aJCas, ann.getBegin(), ann.getEnd());
                    String text = ann.getCoveredText().toLowerCase().replaceAll("\\s+", " ");
                    try {
                        Date res = DateUtils.parseDateStrictly(text, patternsToUse);
                        date.setDate1(new SimpleDateFormat("MM-dd-yyyy").format(res));
                    }
                    catch (ParseException e) {
                        //date math eventually
                        //CSI b = AnnotationLibrarian.getAllAnnotationsOfType(aJCas,CSI.type, false);
                        // Date referenceDateTime = //get referencedatetime
                        if (text.contains("ago")) { // 3 weeks ago
                            try {
                                Matcher match = unitPattern.matcher(text);
                                match.find();
                                String unit = match.group(0);

                                match = qtyPattern.matcher(text);
                                match.find();
                                Integer qty = -1 * Integer.parseInt(match.group(0));

                                date.setRelativeQuantity(qty.toString());
                                date.setRelativeUnit(unit);
                            }
                            catch (Exception e2) {
                                System.out.println("Date parse failed for: " + text);
                            }
                        }
                        else if (text.contains("in")) { // in 3 weeks
                            try {
                                Matcher match = unitPattern.matcher(text);
                                match.find();
                                String unit = match.group(0);

                                match = qtyPattern.matcher(text);
                                match.find();
                                Integer qty = Integer.parseInt(match.group(0));

                                date.setRelativeQuantity(qty.toString());
                                date.setRelativeUnit(unit);
                            }
                            catch (Exception e2) {
                                System.out.println("Date parse failed for: " + text);
                            }
                        }
                        else {
                            //System.out.println("Date format not supported: " + text);
                        }
                    }
                    // if both dates are not null
//                    if (date.getRelativeQuantity() != null || date.getDate1() != null) {
                        aJCas.addFsToIndexes(date);
 //                   }
                }
            } catch (CASException e) {
                throw new AnalysisEngineProcessException(e);
            }
        }
    }

    /**
     *
     * @param priority
     * @return
     */
    public DateParserAE setDayPriority(boolean priority) {
        this.dayPriority = priority;
        return this;
    }

//    public DateParserAE setInputType(String _inputType) {
//        this.inputType = _inputType;
//        return this;
//    }
//
//    @Override
//    public DateParserAE setOutputType(String _outputType) {
//        this.outputType = _outputType;
//        return this;
//    }
}
