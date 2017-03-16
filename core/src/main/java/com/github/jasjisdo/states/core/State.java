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
        return this.getClass().getName();
    }

    @Override
    public String getName() {
        return toString();
    }

    @Override
    public boolean addTransitions(ITransition... transitions) {
        return this.transitions.addAll(Lists.newArrayList(transitions));
    }

    @Override
    public boolean removeTransitions(ITransition... transitions) {
        return this.transitions.removeAll(Lists.newArrayList(transitions));
    }

    @Override
    public List<ITransition> getTransitions() {
        return transitions;
    }
}
