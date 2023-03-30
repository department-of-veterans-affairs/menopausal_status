package gov.va.vinci.menopause;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

public class TestDateUtils {

    private static String[] noDate = new String[] {
            "MMM yy",
            "MMM yyyy",
            "MM-yyyy",
            "MM/yyyy"
    };

    private static String[] dayMonthYear = new String[] {
            "yyyyMMdd",
            "MM-dd-yy",
            "MM/dd/yy",
            "MM.dd.yy",
            "MM-dd-yyyy",
            "MM/dd/yyyy",
            "MM.dd.yyyy",
            "M-dd-yy",
            "M/dd/yy",
            "M.dd.yy",
            "M-dd-yyyy",
            "M/dd/yyyy",
            "M.dd.yyyy",
            "MMM dd, yyyy",
            "MMM dd, yyyy@HH:mm",
            "dd MMM yyyy",
            "(M/d/yyyy)",
            "MMM ''yy"
    };

    public static void main(String[] args) {
        Date d = null;
        try {
            d = DateUtils.parseDate("Mar '21", dayMonthYear);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(d.toString());
    }
}
