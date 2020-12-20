package ru.bmstu.iu9.lab3;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;

import java.util.Iterator;

public class MainClass {




    public static void main(String[] args) {

        if (args.length != 3){
            System.out.println("Not enough arguments");
        }

        String airportPath = args[0];
        String flightsPath = args[1];

        SparkConf conf = new SparkConf().setAppName("example");
        JavaSparkContext context = new JavaSparkContext(conf);

        Function2 removeHeaders = new Function2<Integer, Iterator<String>, Iterator<String>>() {
            @Override
            public Iterator<String> call(Integer index, Iterator<String> iterator) throws Exception {

                if (index == 0 && iterator.hasNext()){
                    iterator.next();
                    return iterator;
                }else {
                    return iterator;
                }

                return null;
            }
        }
    }

}
