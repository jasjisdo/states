package com.github.jasjisdo.states.core;

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

        EndState endState = new EndState();

        // [Start] --(A)--> [End]
        Predicate<Boolean> predicate = b -> b; // A
        @SuppressWarnings("unchecked")

        ITransition transition = new Transition<>(true, predicate, () -> System.out.println("Hello Reflex"), endState);
        StartState startState = new StartState(transition);

        StateDemo stateDemo = new StateDemo();
        stateDemo.setCurrentState(startState);
        System.out.println("state: " + stateDemo.getCurrentState());

        System.out.println("do: [Start] --(A)--> [End]; with A: x -> " + predicate.test(true));
        startState.doTransition(stateDemo);

        System.out.println("previous state: " + stateDemo.getPreviousState());
        System.out.println("current state: " + stateDemo.getCurrentState());

    }



}
