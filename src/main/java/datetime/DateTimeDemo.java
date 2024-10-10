package datetime;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public class DateTimeDemo {

    public static void main(String[] args) {
        // JAVA DATE TIME API
        LocalDate now = LocalDate.now();
        System.out.println(now.getYear());
        System.out.println(now.getDayOfWeek());

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime.getHour());
    }
}
