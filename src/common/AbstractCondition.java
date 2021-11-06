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
public abstract class AbstractCondition implements Condition {
    private boolean reverse;

    protected abstract boolean test(Fact fact);

    @Override
    public boolean satisfy(Fact fact) {
        return reverse != test(fact);
    }

    @Override
    public Condition reverse() {
        reverse = !reverse;
        return this;
    }
}
