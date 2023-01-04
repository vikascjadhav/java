package com.practice.java8.date;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;

public class Java8Date {

    public static void main(String[] args) throws InterruptedException {
        Instant now = Instant.now();

        Thread.sleep(100);
        Instant later = Instant.now();
        Duration d = Duration.between(now, later);
        System.out.println(d.toMillis());


        LocalDate fromLocalDate = LocalDate.now();
        LocalDate toLocalDate = LocalDate.now();

        Period p = fromLocalDate.until(toLocalDate);


        System.out.println(fromLocalDate);
        System.out.println(p);

    }

}
