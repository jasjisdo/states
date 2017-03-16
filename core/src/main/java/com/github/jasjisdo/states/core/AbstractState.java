package com.github.jasjisdo.states.core;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractState implements IState {

    private List<ITransition> transitions;

    public AbstractState() {
        this.transitions = new ArrayList<>();
    }

    public AbstractState(ITransition... transitions) {
        this.transitions = Lists.newArrayList(transitions);
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public abstract String getName();

    @Override
    public boolean addTransition(ITransition transition) {
        return transitions.add(transition);
    }

    @Override
    public boolean removeTransition(ITransition transition) {
        return transitions.remove(transition);
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
