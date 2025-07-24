package com.bhas.complex.payload;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;

public class DateUtil {

  public static LocalDateTime getBirthDateInRange(){
    Random random = new Random();
    int minDay = (int) LocalDate.of(1970, 1, 1).toEpochDay();
    int maxDay = (int) LocalDate.of(1990, 1, 1).toEpochDay();
    long randomDay = minDay + random.nextInt(maxDay - minDay);
    LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
    LocalDateTime dateWithTime = LocalDateTime.of(randomBirthDate, LocalTime.of(12, 10, 30));
    return dateWithTime;
  }

  public static LocalDateTime getHireDateInRange(){
    Random random = new Random();
    int minDay = (int) LocalDate.of(2020, 2, 10).toEpochDay();
    int maxDay = (int) LocalDate.of(2020, 5, 28).toEpochDay();
    long randomDay = minDay + random.nextInt(maxDay - minDay);
    LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
    LocalDateTime dateWithTime = LocalDateTime.of(randomBirthDate, LocalTime.of(12, 10, 30));
    return dateWithTime;
  }

  public static LocalDateTime getEffectiveDateInRange(){
    Random random = new Random();
    int minDay = (int) LocalDate.of(2020, 6, 1).toEpochDay();
    int maxDay = (int) LocalDate.of(2021, 12, 31).toEpochDay();
    long randomDay = minDay + random.nextInt(maxDay - minDay);
    LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
    LocalDateTime dateWithTime = LocalDateTime.of(randomBirthDate, LocalTime.of(12, 10, 30));
    return dateWithTime;
  }


  public static String getRegistrationDate(int expiryInYears) throws ParseException {
    LocalDateTime today = LocalDateTime.now();
    LocalDateTime expiryDate = today.plusYears(expiryInYears);
    LocalDateTime registrationDate = expiryDate.plusYears(-10);
    return "Date: \n" + registrationDate.getDayOfMonth() + "th " +registrationDate.getMonth()+" "+registrationDate.getYear() + "\nTime:\n" +
            getCurrentTime(registrationDate).replace(".", ":");
  }

  public static String getCurrentTime(LocalDateTime dateWithTime) throws ParseException {
    String time = dateWithTime.getHour() +"."+ dateWithTime.getMinute();
    SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HH.mm");
    Date date = simpleTimeFormat.parse(time);
    SimpleDateFormat  requiredTimeFormat = new SimpleDateFormat("hh.mm aa");
    return requiredTimeFormat.format(date);
  }

  public static String getExpiryDateWithTime(int year) throws ParseException {
    LocalDateTime todayDateWithTime = LocalDateTime.now();
    LocalDateTime expiryDateWithTime = todayDateWithTime.plusYears(year);

    return "Date: \n" + expiryDateWithTime.getDayOfMonth() + "th " +expiryDateWithTime.getMonth()+" "+expiryDateWithTime.getYear() + "\nTime:\n" +
            getCurrentTime(expiryDateWithTime).replace(".",":");
  }

  public static long getNumberOfDaysRemainingForPolicyToExpire(String policyRegistrationDate){
    Integer dayOfMonth = Integer.parseInt(policyRegistrationDate.split(" ")[0].replaceAll("[a-z]", ""));
    Integer month = Month.valueOf(policyRegistrationDate.split(" ")[1]).getNumber();
    Integer year = Integer.parseInt(policyRegistrationDate.split(" ")[2]);
    LocalDate givenDate = LocalDate.of(year, month, dayOfMonth);
    LocalDate expiryDate = givenDate.plusYears(10);
    return ChronoUnit.DAYS.between(givenDate, expiryDate);
  }


  public enum Month {
    January(1),
    February(2),
    March(3),
    April(4),
    May(5),
    June(6),
    July(7),
    August(8),
    September(9),
    October(10),
    November(11),
    December(12);

    private final int number;

    Month (int number) {
      this.number = number;
    }

    public int getNumber() {
      return number;
    }
  }

  public static void main(String[] args) throws ParseException {

    System.out.println("Expiry date of the policy after 10 years with time");
    System.out.println(getExpiryDateWithTime(10));

    System.out.println("Registration date of the policy which is going to expire in next year");
    System.out.println(getRegistrationDate(1));

    System.out.println("Expiry date of the policy after 1 years with time");
    System.out.println(getExpiryDateWithTime(1));

    System.out.println("Number of days remain for policy to expire");
    System.out.println(getNumberOfDaysRemainingForPolicyToExpire("1st April 2015") + " days");

  }
}
