package com.practice.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import javafx.scene.control.TableView.ResizeFeatures;

public class ChainConsumers {

    public static void main(String[] args) {
        // Stream s = Stream.of(null)
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");

        Consumer<String> c1 = System.out::println;
        List<String> result = new ArrayList<>();
        Consumer<String> c2 = result::add;
        strings.forEach(c1.andThen(c2));

        System.out.println(result.size());

    }
}
