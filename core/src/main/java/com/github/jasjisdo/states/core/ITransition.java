package com.github.jasjisdo.states.core;

/**
 * Created by domann on 16.03.17.
 */
public interface ITransition {

    boolean isFulFilled();

    void setSuccessor(IState successor);

    IState getSuccessor();

    void performReflex() throws Throwable;

}
