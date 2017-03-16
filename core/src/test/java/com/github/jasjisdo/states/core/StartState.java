package com.github.jasjisdo.states.core;

import javaslang.Tuple3;
import javaslang.control.Try;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by domann on 17.02.17.
 */
public class StartState extends State {

    public StartState(ITransition... transitions) {
        super(transitions);
    }

}
