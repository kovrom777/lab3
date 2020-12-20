package ru.bmstu.iu9.lab3;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import scala.Tuple2;

import java.util.Iterator;
import java.util.Map;

public class MainClass {


    public static final String COMMA_SPLIT = ",";
    public static final String QUOTATION_MARK_CONSTANT = "\"";
    public static final int TABLE_DELAY_ID = 18;
    public static final String EMPTY_STRING = "";
    public static final int TABLE_DESTINATION_ID = 14;
    public static final int TABLE_AIRPORT_ID = 11;

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
            }
        };

        JavaRDD<String> intputAirportRdd = context.textFile(airportPath).mapPartitionsWithIndex(removeHeaders, false);
        JavaRDD<String> intputFlightsRdd = context.textFile(flightsPath).mapPartitionsWithIndex(removeHeaders, false);

        JavaPairRDD<Integer, String> airportNames = intputAirportRdd.mapToPair(line -> {
           String[] airportArray = line.split("COMMA_SPLIT");
           String airport = "";
           for (int i = 1; i< airportArray.length; i++) {
               airport += airportArray[i];
           }
               String preParsedId = airportArray[0].replace(QUOTATION_MARK_CONSTANT, EMPTY_STRING);
               int flightId = Integer.parseInt(preParsedId);
               return new Tuple2<>(flightId, airport);
        });

        Map<Integer, String> airName = airportNames.collectAsMap();

        JavaPairRDD<Tuple2<Integer, Integer>, AirportDataSerializable> resultRdd = intputFlightsRdd.mapToPair(line ->{
           String[] items = line.split(COMMA_SPLIT);
           if (items[TABLE_DELAY_ID].equals(EMPTY_STRING)){
               return new Tuple2<>(new Tuple2<>(Integer.parseInt(items[TABLE_DELAY_ID]),
                                                Integer.parseInt(items[TABLE_DESTINATION_ID])),
                                    new AirportDataSerializable(Integer.parseInt(items[TABLE_DELAY_ID]),
                                                                Integer.parseInt(items[TABLE_DESTINATION_ID]),
                                                        0,
                                                        true));
           }else{
               return new Tuple2<>(new Tuple2<>(Integer.parseInt(items[TABLE_DELAY_ID]),
                       Integer.parseInt(items[TABLE_DESTINATION_ID])),
                       new AirportDataSerializable(Integer.parseInt(items[TABLE_DELAY_ID]),
                               Integer.parseInt(items[TABLE_DESTINATION_ID]),
                               Double.parseDouble(items[18]),
                               true));
           }
        });
    }

}
