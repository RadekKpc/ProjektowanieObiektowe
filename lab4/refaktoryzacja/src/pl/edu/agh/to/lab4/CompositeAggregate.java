package pl.edu.agh.to.lab4;

import java.util.*;

public class CompositeAggregate implements SuspectAggreagate{

    Collection<SuspectAggreagate> aggreagates = new ArrayList<>();
    Collection<Iterator<? extends Suspect>> iterators = new ArrayList<>();

    public CompositeAggregate(){}

    public void addAggregate(SuspectAggreagate a){
        aggreagates.add(a);
        iterators.add(a.iterator());
    }

    @Override
    public Iterator<? extends Suspect> iterator() {
        Iterator<? extends Suspect> iterator = new Iterator<Suspect>() {
            @Override
            public boolean hasNext() {
                boolean has = false;
                for(Iterator<? extends Suspect> i : iterators){
                    if(i.hasNext()){
                        has = true;
                        break;
                    }
                }
                return has;
            }

            @Override
            public Suspect next() {
                if(!hasNext())return null;
                for(Iterator<? extends Suspect> i : iterators){
                    if(i.hasNext()){
                        return  i.next();
                    }
                }
                return null;
            }
        };
        return iterator;
    }
}
