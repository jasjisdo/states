package com.github.jasjisdo.states.core;

import javaslang.control.Try;

import java.util.function.Predicate;

/**
 * Created by domann on 16.03.17.
 */
public interface GenericTransition<T> extends ITransition{

    void setPredicate(Predicate<T> predicate);

    Predicate<T> getPredicate();

    void setReflex(Try.CheckedRunnable reflex);

    Try.CheckedRunnable getReflex();

}
