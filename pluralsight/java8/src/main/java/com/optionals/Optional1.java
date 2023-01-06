package com.optionals;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class Optional1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        OptionalDouble value = list.stream().mapToInt(s -> s.intValue()).average();
        System.out.println(value.isPresent());

    }

}
