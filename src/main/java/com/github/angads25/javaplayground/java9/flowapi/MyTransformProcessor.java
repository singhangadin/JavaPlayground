package com.github.angads25.javaplayground.java9.flowapi;

import java.util.function.Function;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class MyTransformProcessor<T, R> extends SubmissionPublisher<R> implements Flow.Processor<T, R> {
    private Function function;
    private Flow.Subscription subscription;

    public MyTransformProcessor(Function<? super T, ? extends R> function) {
        super();
        this.function = function;
    }

    @Override public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override public void onNext(T item) {
        submit((R) function.apply(item));
        subscription.request(1);
    }

    @Override public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override public void onComplete() {
        close();
    }
}
