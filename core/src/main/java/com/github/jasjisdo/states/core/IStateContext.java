package com.github.jasjisdo.states.core;

import java.io.Serializable;

/**
 *
 */
public interface IStateContext extends Serializable {

    IState getCurrentState();

    void setCurrentState(IState state);

    IState getPreviousState();

    void setPreviousState(IState state);

}
