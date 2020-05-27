package pl.edu.agh.internetshop;

import jdk.internal.org.jline.reader.History;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class OrderHistory {

    Collection<OrderLog> history;
    SearchStrategy strategy;

    public OrderHistory(SearchStrategy strategy) {
        this.history = new LinkedList<>();
        this.strategy = strategy;
    }

    public Collection<OrderLog> getHistory() {
        return history;
    }

    public void addLog(OrderLog o){
        this.history.add(o);
    }

    public SearchStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public ArrayList<OrderLog> filter(){
        ArrayList<OrderLog> result = new ArrayList<>();
        for (OrderLog o: this.history) {
            if(strategy.filter(o)){
                result.add(o);
            }
        }
        return result;
    }
}
