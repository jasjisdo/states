package com.github.jasjisdo.states.core;

/**
 * Created by domann on 17.02.17.
 */
public class StartState extends AbstractState {

    public static final String NAME = "StartState";

    public StartState(ITransition... transitions) {
        super(transitions);
    }

    @Override
    public String getName() {
        return NAME;
    }

}
