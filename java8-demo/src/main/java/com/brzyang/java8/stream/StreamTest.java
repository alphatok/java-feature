package com.brzyang.java8.stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        String[] array = {"a", "b", "c"};
        Stream.of(array).forEach(System.out::println);

        System.out.println(Stream.of(array).map(String::toLowerCase).collect(Collectors.joining()));
        List<String> result = Stream.of(array).map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(result.size());

        List<Person> people = Arrays.asList(
                new Person("mario@reversecoding.net", "Mario", 27),
                new Person("luigi@reversecoding.net", "Luigi", 30),
                new Person("steve@reversecoding.net", "Steve", 20)
        );
        Map<String, Integer> mapNameAge =
                people.stream()
                        .collect(Collectors.toMap(
                                Person::getName,
                                Person::getAge,
                                (u,v) -> { throw new IllegalStateException(String.format("Duplicate key %s", u)); },
                                LinkedHashMap::new
                        ));

        System.out.println(mapNameAge);

    }
}
