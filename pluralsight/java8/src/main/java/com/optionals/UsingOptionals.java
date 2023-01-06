package com.optionals;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.List;

public class UsingOptionals {
    public static void main(String[] args) {
        Double num = 10_000d;
        Optional<Double> opt = NewMath.sqrt(num);
        if (opt.isPresent()) {
            System.out.println(opt.get());
        }

        opt = NewMath.inv(num);
        if (opt.isPresent()) {
            System.out.println(opt.get());
        }

        Function<Double, Stream<Double>> flatMapper =
                d -> NewMath.inv(d).flatMap(inv -> NewMath.sqrt(inv)).map(sqrt -> Stream.of(sqrt))
                        .orElseGet(() -> Stream.empty());

        List<Double> doubles = ThreadLocalRandom.current().doubles(10_000).boxed().parallel()
                .flatMap(flatMapper).collect(Collectors.toList());

        System.out.println(doubles.size());



    }

}
