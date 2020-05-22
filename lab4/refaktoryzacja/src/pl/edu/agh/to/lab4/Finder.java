package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class Finder {

    private CompositeAggregate compositeAggregate;

    public Finder(CompositeAggregate compositeAggregate) {
        this.compositeAggregate = compositeAggregate;
    }

    public void display(SearchStrategy strategy) {
        ArrayList<Suspect> suspected = new ArrayList<Suspect>();

        for (Iterator<? extends Suspect> it = compositeAggregate.iterator(); it.hasNext(); ) {
            Suspect suspect = it.next();
            if (suspect.canBeAccused() && strategy.filter(suspect)) {
                suspected.add(suspect);
            }
            if (suspected.size() >= 10) {
                break;
            }
        }

        System.out.println("Znalazlem " + suspected.size() + " pasujacych podejrzanych!");

        for (Suspect n : suspected) {
            System.out.println(n.display());
        }

    }
}
