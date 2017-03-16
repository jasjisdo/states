package com.github.jasjisdo.states.core;

/**
 * Created by domann on 16.03.17.
 */
@Deprecated
public interface GenericState<T> extends IState {

    boolean addTransition(GenericTransition<T> transition);

    boolean removeTransition(GenericTransition<T> transition);

}
