package com.github.jasjisdo.states.core;

import com.google.common.collect.Lists;
import javaslang.Tuple;
import javaslang.Tuple3;
import javaslang.control.Try;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;


public class AbstractState<T> implements IState<T> {

    private T t;

    private List<Tuple3<IState, Predicate<T>, Try.CheckedConsumer<T>>> successors;

    public AbstractState(T t) {
        this.t = t;
        this.successors = new ArrayList<>();
    }

    public AbstractState(T t, List<Tuple3<IState, Predicate<T>, Try.CheckedConsumer<T>>> successors) {
        this.t = t;
        this.successors = successors;
    }

    @SafeVarargs
    public AbstractState(T t, Tuple3<IState, Predicate<T>, Try.CheckedConsumer<T>>... successors) {
        this.t = t;
        this.successors = Lists.newArrayList(successors);
    }

    @Override
    public void doTransition(IStateContext context) {

        if(context.getCurrentState() != null) {
            context.setPreviousState(context.getCurrentState());
        }

        // set this state as new state
        context.setCurrentState(this);

        // check if predicate is fulfilled to update state.
        Optional<Tuple3<IState, Predicate<T>, Try.CheckedConsumer<T>>> opState = successors.stream()
                .filter(s -> s._2.test(t))
                .findFirst();

        // update state
        if (opState.isPresent()) {
            Tuple3<IState, Predicate<T>, Try.CheckedConsumer<T>> tuple3 = opState.get();
            IState newState = tuple3._1;
            context.setCurrentState(newState);
            try {
                tuple3._3.accept(t);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Override
    public List<Tuple3<IState, Predicate<T>, Try.CheckedConsumer<T>>> getSuccessors() {
        return successors;
    }

    public void setSuccessors(List<Tuple3<IState, Predicate<T>, Try.CheckedConsumer<T>>> successors) {
        this.successors = successors;
    }

    @Override
    public boolean addSuccessor(IState succState, Predicate<T> predicate, Try.CheckedConsumer<T> consumer) {
        return successors.add(Tuple.of(succState, predicate, consumer));
    }

    @Override
    public boolean removeSuccessor(IState succState, Predicate<T> predicate, Try.CheckedConsumer<T> consumer) {
        return successors.remove(Tuple.of(succState, predicate, consumer));
    }

}
