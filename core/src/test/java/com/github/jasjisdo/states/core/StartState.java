package com.github.jasjisdo.states.core;

import javaslang.Tuple3;
import javaslang.control.Try;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by domann on 17.02.17.
 */
public class StartState extends AbstractState<Boolean> {


    public StartState(Boolean aBoolean, List<Tuple3<IState<Boolean>, Predicate<Boolean>, Try.CheckedConsumer<Boolean>>> successors) {
        super(aBoolean, successors);
    }

    public StartState(Boolean aBoolean, Tuple3<IState<Boolean>, Predicate<Boolean>, Try.CheckedConsumer<Boolean>>... successors) {
        super(aBoolean, successors);
    }
}
