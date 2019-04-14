import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;
import java.util.stream.Stream;

public class AgeCalculator {

    public static void main(String[] arg) {

        LocalDate date = LocalDate.of(1981, Month.JANUARY, 22);
        LocalTime time = LocalTime.of(10,30);
        LocalDateTime localDateTime = LocalDateTime.of(date, time);

        DateTimeFormatter shortF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(date.getDayOfWeek() + shortF.format(localDateTime));

        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1.getDayOfWeek());

        System.out.println(over18(19) ? "Yes" : "No");

         //System.out.println(calculateAge());

    }

    static boolean over18(int age) {
        if(age>=18) {
            return true;
        }
        return false;
    }

    static String calculateAge() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter day: ");
        String day = scanner.next();
        System.out.println("Enter month: ");
        String month = scanner.next();
        System.out.println("Enter year: ");
        String year = scanner.next();

        LocalDate dob = LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));

        LocalDate now = LocalDate.now();


        Integer y=0, m=0, d=0;

        Period p = Period.between(dob, now);

        d = p.getDays();
        m = p.getMonths();
        y = p.getYears();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        return "You were born on: " + " " + dob.getDayOfWeek() + " " + dob.format(f) +
                " .You are: " + y + " years " + m + " month " + d + " old";
    }
}
