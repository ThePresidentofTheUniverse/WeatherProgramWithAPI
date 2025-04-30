import java.util.Calendar;
import java.util.Date;

public class SevenDayDatesGrabber {


    public static void main(String[] args) {
        calendar();
    }
    // Grabs today's date and the next six days also.
    public static Calendar calendar(){

        Calendar c = Calendar.getInstance();
        String converter;

        String[] labelDates = new String[7];

        c.setTime(new Date());

        int index = 0;
        for (int i = 0; i < 7; i++){
            System.out.println(index);
            c.add(Calendar.DATE, (index));

            converter = c.getTime().toString();

            StringBuilder sb = new StringBuilder(converter); //about to make this fancy

            converter = sb.delete(3, 28).toString();// beautifies it.

            labelDates[index] = converter;



            System.out.println(labelDates[index]);
            index++;


        }

        index=0; //resets the index


        return c;
    }
}
