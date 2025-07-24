package com.bhas.complex.payload;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Random;

public class GenerateBirthDate {

  public static String getRandomNumberString() {
    Random rnd = new Random();
    int number = rnd.nextInt(999999);
    return String.format("%06d", number);
  }
  public static void main(String[] args) {
    Random random = new Random();
    int minDay = (int) LocalDate.of(1960, 1, 1).toEpochDay();
    int maxDay = (int) LocalDate.of(1990, 1, 1).toEpochDay();
    long randomDay = minDay + random.nextInt(maxDay - minDay);
    LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
    LocalDateTime l = LocalDateTime.of(randomBirthDate, LocalTime.of(12, 10, 30));
    System.out.println(l);
    System.out.println(getRandomNumberString());
    String generatedString = RandomStringUtils.randomAlphanumeric(5).toUpperCase();

    System.out.println(generatedString);
  }
}
