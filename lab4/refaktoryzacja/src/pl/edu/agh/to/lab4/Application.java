package pl.edu.agh.to.lab4;

import java.util.Iterator;

public class Application {

    public static void main(String[] args) {
        CompositeAggregate compositeAggregate = new CompositeAggregate();
        compositeAggregate.addAggregate(new PersonDataProvider());
        compositeAggregate.addAggregate(new PrisonersDatabase());
        compositeAggregate.addAggregate(new StudentDataProvider());

        Finder finder = new Finder(compositeAggregate);

        CompositeSearchStrategy strategy = new CompositeSearchStrategy();
        strategy.addSearchStrategy(new AgeSearchStrategy(18));
        strategy.addSearchStrategy(new NameSearchStrategy("Janusz"));

        finder.display(strategy);

    }
}
