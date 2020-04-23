package Java8_Streams_Tutorial;

/*
    This class contains 15 examples of using Java 8 streams for hands on practise
    Use java 8 or above for using Streams

    Advantages of streams:
        1. efficient
        2. heavy use of lambda expression
        3. can use parallel stream "ParallelStreams" for multi threaded operations

    Stream is  kind of a pipeline. it has a source followed by zero or more intermediate operations
    and a terminal operations.

    Stream source ------>
        can be created from amy collection

    Stream Operation ------>
        can either be intermediate or terminal

        --> Intermediate operations - filter, map, flatmap or sort
            --> some intermediate ops are
                anyMatch(), distinct(), filter(), findFirst(), flatMap(), map(), skip(), sorted()
        --> Terminal operatoions - forEach, collect, reduce are either void or return non stream result
            --> forEach applies the same function to each element
            --> collect saves element to a collection
            --> other options reduce the stream into a single summary element, some of them are
                count(), max(), min(), reduce()    ---   a,b,c.... => Z



    Source -- Filter -- Sort -- Map -- Collect

 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8_Streams {

    public static void main(String[] args) throws IOException {

        ArrayList<String> al = (ArrayList<String>)List.of("10");

        //1. Integer stream
        IntStream
                .range(1,10)
                .forEach(System.out::println);

        System.out.println();

        //2. Integer stream with skip
        IntStream
                .range(1,10)
                .skip(5)
                .forEach(System.out::println);

        System.out.println();

        //3. Integer stream with sum
        System.out.println(
        IntStream
                .range(1,5)
                .sum()
        );

        System.out.println();

        //4. Stream.of, sorted, findFirst
        Stream.of("Ava", "Aneri" ,"Alberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println();

        //5. Stream from an array , sort, filter & print
        //filter accepts a predicate --> predicate accepts an argument and returns a boolean
        String[] names = {"Al", "Ankit", "kushal", "Sarika", "priya","Era"};

        Arrays.stream(names)
                .filter(x -> x.startsWith("A"))
                .sorted()
                .forEach(System.out::println);

        System.out.println();

        //6. Average of squares of an int of an array
        Arrays.stream(new int[]{2,5,7,8,9})
                .map(x -> x * x)   //map each item to its square
                .average()
                .ifPresent(System.out::println);

        System.out.println();

        //7. Stream from a list, filter and print
        List<String> people = Arrays.asList("Al", "Ankit", "kushal", "Sarika", "priya","Era");
        people.stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);

        System.out.println();

        //8. Stream from a list, filter and print the name of person with highest length
        people.stream()
                .max(Comparator.comparingInt(String::length))
                .ifPresent(System.out::println);

        System.out.println();

        //9. Stream rows from a text file, sort, filter and print
        Stream<String> bands = Files.lines(Paths.get("band.txt"));  //add IOException
        bands.sorted()
                .filter(x -> x.length() >13)
                .forEach(System.out::println);
        bands.close();

        System.out.println();

        //10. Stream rows from text files and save to list
        List<String> bands2 = Files.lines(Paths.get("band.txt"))
                .filter(x -> x.contains("jit"))
                .collect(Collectors.toList());
        bands2.forEach(System.out::println);

        System.out.println();

        //11. Stream rows from csv files and count the rows
        Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
        int rowCount = (int) rows1.map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .count();
        System.out.println("rowCount : "+rowCount);
        rows1.close();

        System.out.println();

        //12. Stream rows from csv files, parse data from rows
        Stream<String> rows2 = Files.lines(Paths.get("data.txt"));
        rows2.map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1])>15)
                .forEach(x -> System.out.println(x[0] +" "+x[1]+" "+x[2]));
        rows2.close();

        System.out.println();

        //13. Stream rows from csv files and store it into a hashMap
        Stream<String> rows3 = Files.lines(Paths.get("data.txt"));
        Map<String, Integer> map = rows3.map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .collect(Collectors.toMap(x -> x[0], x -> Integer.parseInt(x[1])));
        rows3.close();

        for (String key : map.keySet()) {
            System.out.println(key +" , "+map.get(key));
        }

        System.out.println();

        //14. Reduction - sum
        Double total = Stream.of(2.3, 1.4, 7.8)
                .reduce(0.0, (Double a, Double b) -> (a + b)); // 0.0 -> starting value, Double a -> running total, Double b -> new elememt we are pssing in
        System.out.println(total);

        //15. Reduction - summaryStatistic
        IntSummaryStatistics result = IntStream.of(3, 5, 7, 9, 1, 2)
                .summaryStatistics();
        System.out.println(result);

    }
}
