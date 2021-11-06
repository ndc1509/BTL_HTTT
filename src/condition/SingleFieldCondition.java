package condition;

import java.util.Optional;
import common.AbstractCondition;
import common.Fact;

public abstract class SingleFieldCondition extends AbstractCondition {
    private final String field;

    public SingleFieldCondition(String field) {
        this.field = field;
    }
   
    protected <T> Optional<T> fact(Fact fact) {
        return Optional.ofNullable(fact.getFact(field));
    }
}
