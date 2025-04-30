import java.util.Calendar;
import java.util.Date;

public class SevenDayDatesGrabber {

    // Grabs today's date and the next six days also.
    public static String[] dateFinder(){

        Calendar c = Calendar.getInstance();
        String converter;

        String[] labelDates = new String[7];

        c.add(Calendar.DATE, (0)); //Adds the initial date.
        converter = c.getTime().toString(); //converts to string
        StringBuilder sb = new StringBuilder(converter); //about to make this fancy
        converter = sb.delete(3, 28).toString();// beautifies it.
        labelDates[0] = converter; //Adds to label dates
        int index = 0;
        for (int i = 0; i < 6; i++){ //A for-loop that cycles through each day, incrementing.
            c.add(Calendar.DATE, (1));

            converter = c.getTime().toString();

            sb = new StringBuilder(converter); //about to make this fancy

            converter = sb.delete(3, 28).toString();// beautifies it.

            labelDates[index + 1] = converter; //Plus-one to allow current day to exist.

            //System.out.println(labelDates[index]);
            index++;

        }

        return labelDates;
    }
}
