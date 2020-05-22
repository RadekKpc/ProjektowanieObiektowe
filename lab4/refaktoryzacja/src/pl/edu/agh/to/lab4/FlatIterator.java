package pl.edu.agh.to.lab4;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FlatIterator implements Iterator {

    private Map<String, Collection<Prisoner>> prisoners = new HashMap<String, Collection<Prisoner>>();
    private int iterationState;
    private Prisoner currentPrisoner;
    FlatIterator(Map<String, Collection<Prisoner>> prisoners){
        this.prisoners = prisoners;
        iterationState = 0;

    }
    @Override
    public boolean hasNext() {
        int length = 0;
        for (Collection<Prisoner> prisonerCollection : prisoners.values()) {
            length += prisonerCollection.size();
       }
        return iterationState < length;
    }

    @Override
    public Prisoner next() {
        boolean returnInNextInteration = false;

        if(iterationState == 0){
            returnInNextInteration = true;
        }
        for (Collection<Prisoner> prisonerCollection : prisoners.values()) {
            for (Prisoner prisoner : prisonerCollection) {
                if (returnInNextInteration) {
                    currentPrisoner = prisoner;
                    iterationState ++;
                    return currentPrisoner;
                }

                if (prisoner == currentPrisoner) {
                    returnInNextInteration = true;
                }


            }
        }
        return null;
    }
}
