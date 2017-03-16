package com.github.jasjisdo.states.core;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;


public class State implements IState {

    private List<ITransition> transitions;

    public State() {
        this.transitions = new ArrayList<>();
    }

    public State(ITransition... transitions) {
        this.transitions = Lists.newArrayList(transitions);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String getName() {
        return toString();
    }

    @Override
    public boolean addTransition(ITransition transition) {
        return transitions.add(transition);
    }

    @Override
    public boolean removeTransition(ITransition transition) {
        return transitions.remove(transition);
    }

    @Override
    public List<ITransition> getTransitions() {
        return transitions;
    }
}
