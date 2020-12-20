package ru.bmstu.iu9.lab3;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

public class MainClass {




    public static void main(String[] args) {

        if (args.length != 3){
            System.out.println("Not enough arguments");
        }

        String airportPath = args[0];
        String flightsPath = args[1];

        SparkConf conf = new SparkConf().setAppName("example");
        JavaSparkContext context = new JavaSparkContext(conf);

        Function2
    }

}
