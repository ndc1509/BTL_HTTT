package common;


import java.util.ArrayList;
import java.util.Arrays;
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
public abstract class ConditionGroup extends AbstractCondition {
    private List<Condition> conditions = new ArrayList<>();

    public static AndConditionGroup all(Condition...conditions) {
        AndConditionGroup group = new AndConditionGroup();
        group.and(conditions);
        return group;
    }

    public static OrConditionGroup any(Condition...conditions) {
        OrConditionGroup group = new OrConditionGroup();
        group.or(conditions);
        return group;
    }

    protected void addConditions(Condition...conditions) {
        this.conditions.addAll(Arrays.asList(conditions));
    }

    protected List<Condition> conditions() {
        return conditions;
    }
}