package com.practice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapExample {
    public static void main(String[] args) {

        List<Integer> one = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> two = Arrays.asList(3, 4, 5);
        List<Integer> three = Arrays.asList(7, 8);

        List<List<Integer>> listOfList = Arrays.asList(one, two, three);

        Function<List<Integer>, Stream<Integer>> faltMapper = l -> l.stream();
        // listOfList.stream().map(l -> l.size()).forEach(System.out::println);
        listOfList.stream().flatMap(faltMapper).forEach(System.out::println);

    }
}
