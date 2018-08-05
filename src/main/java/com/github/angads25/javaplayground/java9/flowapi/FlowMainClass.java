package com.github.angads25.javaplayground.java9.flowapi;

import java.util.Arrays;
import java.util.concurrent.SubmissionPublisher;

public class FlowMainClass {

    public static void main(String args[]) {
        //Create Publisher
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

//        MyTransformProcessor<String, Integer> transformProcessor = new MyTransformProcessor<>(Integer::parseInt);

        //Register Subscriber
        MySubscriber<String> subscriber = new MySubscriber<>();
        publisher.subscribe(subscriber);

        //Publish items
        System.out.println("Publishing Items...");
        String[] items = {"1", "x", "2", "x", "3", "x"};
        Arrays.stream(items).forEach(System.out::println);
        publisher.close();
    }
}
