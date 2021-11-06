package fact;

import common.Fact;

public class DefaultFact implements Fact {
    private final FactPairs kvFacts;

    public DefaultFact(FactPairs kvFacts) {
        this.kvFacts = kvFacts;
    }

    
    
    @Override
    public <T> T getFact(String key) {
        return (T) kvFacts.value(key);
    }
}
