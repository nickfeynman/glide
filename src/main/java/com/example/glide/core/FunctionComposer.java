package com.example.glide.core;

import java.util.function.Function;


public class FunctionComposer<T, R> {
    private final Function<T, R> currentFunction;

    public FunctionComposer(Function<T, R> currentFunction) {
        this.currentFunction = currentFunction;
    }

    public <V> FunctionComposer<T, V> andThen(Step<? super R, ? extends V> step) {
        return new FunctionComposer<>(currentFunction.andThen(step));
    }

    public <V> FunctionComposer<T, V> transform(Transform<? super R, ? extends V> transformation) {
        return new FunctionComposer<>(currentFunction.andThen(transformation));
    }

    public R apply(T t) {
        return currentFunction.apply(t);
    }

    public static <T, R> FunctionComposer<T, R> of(Step<T, R> step) {
        return new FunctionComposer<>(step);
    }

    public static <T, R> FunctionComposer<T, R> of(Transform<T, R> transform) {
        return new FunctionComposer<>(transform);
    }
}
