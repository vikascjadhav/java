package com.practice.java8.maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapEnhancments {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(MapEnhancments.class.getResourceAsStream("persons.txt")))) {

            Stream<String> lines = bufferedReader.lines();
            lines.forEach(line -> {
                String[] strs = line.split(" ");
                Person person = new Person();
                person.setName(strs[0]);
                person.setAge(Integer.parseInt(strs[1]));
                person.setGender(strs[2]);
                persons.add(person);
            });

            persons.stream().forEach(System.out::println);
            System.out.println(persons.size());

            Map<Integer, List<Person>> mapByAge =
                    persons.stream().collect(Collectors.groupingBy(Person::getAge));

            Map<String, List<Person>> mapByGender =
                    persons.stream().collect(Collectors.groupingBy(Person::getGender));

            mapByAge.forEach((age, list) -> System.out.println("age= " + age + " list =" + list));
            mapByGender.forEach(
                    (gender, list) -> System.out.println("gender= " + gender + " list =" + list));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
