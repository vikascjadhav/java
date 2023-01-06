package com.parallelstream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStream1 {
    public static void main(String[] args) {
        // List<String> list = new ArrayList<>();
        // Stream.iterate("+", s -> s + "+").parallel().limit(1000).forEach(s -> list.add(s));
        // System.out.println(list.size());

        // Above may give exception or wrong size
        List<String> list1 = Stream.iterate("+", s -> s + "+").parallel().limit(1000)
                .collect(Collectors.toList());
        System.out.println(list1.size());
    }
}
