package com.github.jasjisdo.states.core;

import javaslang.control.Try;

import java.util.function.Predicate;

/**
 *
 */
public class Transition<T> implements GenericTransition<T> {

    private T t;
    private Predicate<T> predicate;
    private Try.CheckedRunnable reflex;
    private IState successor;

    public Transition(T t, Predicate<T> predicate, IState successor) {
        this.t = t;
        this.predicate = predicate;
        this.successor = successor;
    }

    public Transition(T t, Predicate<T> predicate, Try.CheckedRunnable reflex, IState successor) {
        this.t = t;
        this.predicate = predicate;
        this.reflex = reflex;
        this.successor = successor;
    }

    @Override
    public String toString() {
        return "Transition{" +
                "successor=" + successor.getName() +
                '}';
    }

    @Override
    public boolean isFulFilled() {
        return predicate.test(t);
    }

    @Override
    public void setSuccessor(IState successor) {
        this.successor = successor;
    }

    @Override
    public IState getSuccessor() {
        return successor;
    }

    @Override
    public void performReflex() throws Throwable {
        if(reflex != null) {
            reflex.run();
        }
    }

    @Override
    public void setPredicate(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    @Override
    public Predicate<T> getPredicate() {
        return predicate;
    }

    @Override
    public void setReflex(Try.CheckedRunnable reflex) {
        this.reflex = reflex;
    }

    @Override
    public Try.CheckedRunnable getReflex() {
        return reflex;
    }

}
