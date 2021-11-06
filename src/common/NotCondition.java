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
public class NotCondition extends AbstractCondition {
    private final Condition condition;

    public NotCondition(Condition condition) {
        this.condition = condition;
    }
    
    public static Condition reverse(Condition condition) {
        return new NotCondition(condition);
    }

    @Override
    protected boolean test(Fact fact) {
        return !condition.satisfy(fact);
    }
}