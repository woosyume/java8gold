package app;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class App {
    public static void main(String[] args) throws Exception {
        // LocalDate xmas = new Localdate ... New로 생성하려고 했기 때문에 Compile error. 생성자가 private

        LocalDate christmasDay = LocalDate.of(2016, Month.DECEMBER, 25);
        System.out.println(christmasDay); // 2016-12-25

        LocalDate nextDecade = christmasDay.plusYears(10);
        System.out.println(nextDecade);

        nextDecade.plusDays(15); // nextDecade 변수의 값을 변경하지는 않는다.
        System.out.println(nextDecade);

        LocalDate xmas = LocalDate.of(2017, 12, 25);
        DayOfWeek xmasDay = xmas.getDayOfWeek();
        System.out.println("Christmas is " + xmasDay);
        
        System.out.println("*************************");

        ZonedDateTime departure = ZonedDateTime.of(2017, 1, 1, 3, 0, 0, 0, ZoneId.of("UTC-7"));
        System.out.println("departure=" + departure); // departure=2017-01-01T03:00-07:00[UTC-07:00]
        // UTC-7은 UTC로부터 7시간 늦은 표준시. UTC가 10시면 UTC-7은 3시.

        ZonedDateTime arrival = ZonedDateTime.of(2017, 1, 1, 9, 0, 0, 0, ZoneId.of("UTC-9")); 
        System.out.println("arrival=" + arrival); // 2017-01-01T09:00-09:00[UTC-09:00]
        
        long hrs = ChronoUnit.HOURS.between(departure, arrival);
        System.out.println("This flight is for " + hrs + "hours."); // 시차는 6시간 + 표준시 차이에 따른 2시간 = 8시간

        System.out.println("*************************");

        ZoneId zone1 = ZoneId.of("Asia/Tokyo");
        ZoneId zone2 = ZoneId.of("America/Los_Angeles");
        LocalDate date1 = LocalDate.of(2017, 2, 1);
        LocalDate date2 = LocalDate.of(2017, 4, 1);
        LocalTime time = LocalTime.of(0, 00);

        ZonedDateTime zdt1 = ZonedDateTime.of(date1, time, zone1);
        ZonedDateTime zdt2 = ZonedDateTime.of(date1, time, zone2);

        System.out.println("zdt1=" + zdt1);
        System.out.println("zdt2=" + zdt2);
        // zdt1=2017-02-01T00:00+09:00[Asia/Tokyo]
        // zdt2=2017-02-01T00:00-08:00[America/Los_Angeles] 

        long hrs1 = ChronoUnit.HOURS.between(zdt2, zdt1);
        System.out.println("Time difference between Tokyo and LA is " + hrs1 + "hours in " + zdt1.getMonth());

        ZonedDateTime zdt3 = ZonedDateTime.of(date2, time, zone1);
        ZonedDateTime zdt4 = ZonedDateTime.of(date2, time, zone2);

        long hrs2 = ChronoUnit.HOURS.between(zdt4, zdt3);
        System.out.println("Time difference between Tokyo and LA is " + hrs2 + "hours in " + zdt1.getMonth());

        System.out.println("*************************");

        // LocalTime time = LocalTime.of(0, 00);
        LocalDate date = LocalDate.of(2017, 2, 1);
        LocalDateTime dt = LocalDateTime.of(date, time);

        ZonedDateTime zdt = dt.atZone(ZoneId.of("Asia/Tokyo"));
        Instant instant = zdt.toInstant();
        // Instant : 지정한 시점의 날짜 / 시각을 표현. 타임스탬프로서 쓰인다.
        System.out.println(instant);
    }
}