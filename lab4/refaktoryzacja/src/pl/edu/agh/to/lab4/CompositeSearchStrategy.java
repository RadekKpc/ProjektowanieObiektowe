package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;

public class CompositeSearchStrategy implements SearchStrategy{

    Collection<SearchStrategy> strategies = new ArrayList<>();

    @Override
    public boolean filter(Suspect suspect) {
        boolean flag = true;
        for (SearchStrategy s : strategies){
            if(!s.filter(suspect)){
                flag = false;
                break;
            }
        }
        return flag;

    }

    public void addSearchStrategy(SearchStrategy s){
        strategies.add(s);
    }
}
