package common;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cuong
 */
public class BaseRule<T extends Fact> implements Rule<T> {
    private String name;
    private int priority;
    private boolean exclusive;
    private Condition condition;
    private Action<T> action;

    public BaseRule(String name, int priority, boolean exclusive, Condition condition, Action<T> action) {
        this.name = name;
        this.priority = priority;
        this.exclusive = exclusive;
        this.condition = condition;
        this.action = action;
    }

    
    
    @Override
    public Rule<T> given(Condition condition) {
        this.condition = condition;
        return this;
    }

    @Override
    public Rule<T> then(Action<T> action) {
        this.action = action;
        return this;
    }

    @Override
    public boolean evaluate(T fact) {
        return condition.satisfy(fact);
    }

    @Override
    public void doAction(T fact) {
        action.doAction(fact);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isExclusive() {
        return exclusive;
    }

    public void setExclusive(boolean exclusive) {
        this.exclusive = exclusive;
    }
    
    
}