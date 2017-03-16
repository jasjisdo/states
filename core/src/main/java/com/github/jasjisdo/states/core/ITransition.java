package com.github.jasjisdo.states.core;

import java.io.Serializable;

/**
 * Created by domann on 16.03.17.
 */
public interface ITransition extends Serializable {

    boolean isFulFilled();

    void setSuccessor(IState successor);

    IState getSuccessor();

    void performReflex() throws Throwable;

}
