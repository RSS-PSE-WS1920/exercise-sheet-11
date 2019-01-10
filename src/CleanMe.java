import static java.lang.Integer.parseInt;

import java.util.Calendar;

public class CleanMe {

    static String[] weekDays = new String[] {
            "Sun", "Mon", "Tues", "Wednes", "Thurs", "Fri", "Satur"
    };
    
    static void setCalendarDate(final Calendar cal, final String date, final String sep) {
        final String[] fs = date.split(sep);
        cal.set(parseInt(fs[0]), parseInt(fs[1]) - 1, parseInt(fs[2]));
    }
    
    public static void main(final String[] args) {
        final Calendar cal = Calendar.getInstance();
        if (args.length >= 1) {
            if (args[0].indexOf("-") >= 0) {
                setCalendarDate(cal, args[0], "-");
            } else if (args[0].indexOf("/") >= 0) {
                setCalendarDate(cal, args[0], "/");
            } else if (args[0].indexOf(".") >= 0) {
                final String[] fs = args[0].split(".");
                cal.set(parseInt(fs[0]), parseInt(fs[1]) - 1, parseInt(fs[2]));
            }
        }
        final int wd = cal.get(Calendar.DAY_OF_WEEK);
        System.out.printf("%sday\n", weekDays[wd - 1]);
    }

}
