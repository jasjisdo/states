package com.github.jasjisdo.states.core;

import de.dailab.jiactng.agentcore.knowledge.IFact;

import java.util.List;

/**
 *
 */
public interface IState extends IFact {

    String getName();

    default void doTransition(IStateContext context) {

        if (context.getCurrentState() != null) {
            context.setPreviousState(context.getCurrentState());
        }

        // set this state as new state
        context.setCurrentState(this);

        ITransition transition = getTransitions().stream()
                .filter(ITransition::isFulFilled)
                .findFirst().orElse(null);

        if (transition != null) {
            // update state
            context.setCurrentState(transition.getSuccessor());
            try {
                transition.performReflex();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

    }

    List<ITransition> getTransitions();

    boolean addTransitions(ITransition... transitions);

    boolean removeTransitions(ITransition... transitions);
}
