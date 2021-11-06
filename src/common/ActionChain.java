package common;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cuong
 */
public class ActionChain<T extends Fact> implements Action<T> {
    private List<Action<T>> actions;

    private ActionChain(List<Action<T>> actions) {
        this.actions = new ArrayList<>();
        this.actions.addAll(actions);
    }

    public static <A extends Fact> ActionChain<A> all(List<Action<A>> actions) {
        return new ActionChain<>(actions);
    }

    public ActionChain<T> then(Action<T> action) {
        if (this.actions == null) {
            this.actions = new ArrayList<>();
        }

        this.actions.add(action);
        return this;
    }

    @Override
    public void doAction(T fact) {
        actions.forEach(act -> act.doAction(fact));
    }
}