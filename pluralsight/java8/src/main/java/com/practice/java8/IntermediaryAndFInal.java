package com.practice.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermediaryAndFInal {


    public static void main(String[] args) {
        Stream<String> s = Stream.of("one", "two", "three", "four", "five");
        List<String> list = new ArrayList<>();
        Predicate<String> p1 = Predicate.isEqual("two");
        Predicate<String> p2 = Predicate.isEqual("three");
        s.peek(System.out::println).filter(p1.or(p2)).forEach((x) -> {
            System.out.println(x);
            list.add(x);
        });
        System.out.println("Print filtered list size =" + list.size());
        list.stream().forEach(System.out::println);

    }

}
