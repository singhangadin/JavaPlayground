package com.github.angads25.javaplayground.java9.flowapi;

import java.util.concurrent.Flow;

public class MySubscriber<T> implements Flow.Subscriber<T> {
    private Flow.Subscription subscription;

    @Override public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override public void onNext(T item) {
        System.out.println("Got item: " + item);
        subscription.request(1);
    }

    @Override public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override public void onComplete() {
        System.out.println("Done");
    }
}
