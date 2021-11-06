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
public interface Rule<T extends Fact>{
    String getName();
    
    int getPriority();
    
    boolean isExclusive();
    
    Rule<T> given(Condition condition);
    
    Rule<T> then(Action<T> action);
    
    boolean evaluate(T fact);
    
    void doAction(T fact);
}
