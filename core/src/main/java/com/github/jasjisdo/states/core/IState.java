package com.github.jasjisdo.states.core;

import de.dailab.jiactng.agentcore.knowledge.IFact;
import javaslang.Tuple3;
import javaslang.control.Try;

import java.util.List;
import java.util.function.Predicate;

/**
 *
 */
public interface IState<T> extends IFact {

    void doTransition(IStateContext context);

    List<Tuple3<IState, Predicate<T>, Try.CheckedConsumer<T>>> getSuccessors();

    void setSuccessors(List<Tuple3<IState, Predicate<T>, Try.CheckedConsumer<T>>> successors);

    boolean addSuccessor(IState succState, Predicate<T> predicate, Try.CheckedConsumer<T> consumer);

    boolean removeSuccessor(IState succState, Predicate<T> predicate, Try.CheckedConsumer<T> consumer);

}
