package com.practice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionExample {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20);

        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println("sum of element");
        System.out.println(sum);

        List<Integer> list1 = Arrays.asList(10, 20);
        Optional<Integer> min = list1.stream().reduce(Integer::min);

        System.out.println("min elemen");
        System.out.println(min);


    }
}
