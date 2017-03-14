package com.github.jasjisdo.states.core;

import javaslang.Tuple;
import org.joda.time.DateTime;

import java.util.function.Predicate;

/**
 *
 */
public class StateDemo implements IStateContext {

    private IState state;
    private IState previousState;

    public StateDemo() {
        this.state = null;
    }

    @Override
    public IState getCurrentState() {
        return state;
    }

    @Override
    public void setCurrentState(IState state) {
        this.state = state;
    }

    @Override
    public IState getPreviousState(){
        return previousState;
    }

    @Override
    public void setPreviousState(IState previousState){
        this.previousState = previousState;
    }

    public static void main(String... args) {

        boolean aBoolean = true;
        EndState endState = new EndState(aBoolean);

        // [Start] --(A)--> [End]
        Predicate<Boolean> predicate = b -> b; // A
        @SuppressWarnings("unchecked")
        StartState startState = new StartState(aBoolean,
                Tuple.of(endState, predicate, b -> System.out.println(DateTime.now().toDate()))
        );

        StateDemo stateDemo = new StateDemo();
        stateDemo.setCurrentState(startState);
        System.out.println("state: " + stateDemo.getCurrentState());

        System.out.println("do: [Start] --(A)--> [End]; with A: x -> " + predicate.test(aBoolean));
        startState.doTransition(stateDemo);

        System.out.println("previous state: " + stateDemo.getPreviousState());
        System.out.println("current state: " + stateDemo.getCurrentState());

    }



}
