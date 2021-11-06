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
public class OrConditionGroup extends ConditionGroup {

    public OrConditionGroup or(Condition...conditions) {
        addConditions(conditions);
        return this;
    }

    @Override
    protected boolean test(Fact fact) {
        return conditions().stream().anyMatch(cond -> cond.satisfy(fact));
    }
}

