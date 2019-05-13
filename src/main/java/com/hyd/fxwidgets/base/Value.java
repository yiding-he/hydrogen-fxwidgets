package com.hyd.fxwidgets.base;

public class Value<T> {

    private T t;

    public Value(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
