
package com.flatmap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FlatMapExample {

    public static void main(String[] args) throws IOException {
        String currentPath = new java.io.File(".").getCanonicalPath();
        System.out.println("Current dir:" + currentPath);

        Stream<String> stream1 =
                Files.lines(Paths.get("java8/src/main/java/com/flatmap/files/TomSawyer01.txt"));
        Stream<String> stream2 =
                Files.lines(Paths.get("java8/src/main/java/com/flatmap/files/TomSawyer02.txt"));
        Stream<String> stream3 =
                Files.lines(Paths.get("java8/src/main/java/com/flatmap/files/TomSawyer03.txt"));
        // System.out.println(stream1.count());

        Stream<Stream<String>> streamOfStreams = Stream.of(stream1, stream2, stream3);
        // System.out.println(streamOfStreams.count());


        Stream<String> streamOfLines = streamOfStreams.flatMap(Function.identity());

        Function<String, Stream<String>> lineSplitterFunction =
                s -> Pattern.compile(" ").splitAsStream(s);

        Stream<String> streamOfwords = streamOfLines.flatMap(lineSplitterFunction)
                .map(s -> s.toUpperCase()).filter(s -> s.length() >= 4).distinct();
        System.out.println(streamOfwords.count());
    }
}
