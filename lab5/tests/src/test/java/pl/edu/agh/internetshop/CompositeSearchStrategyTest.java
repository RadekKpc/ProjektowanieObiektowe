package pl.edu.agh.internetshop;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CompositeSearchStrategyTest {

    @Test
    public void SearchOneFalse(){
        //given
        CompositeSearchStrategy strategy = new CompositeSearchStrategy();
        SearchStrategy s1 = mock(SearchStrategy.class);
        SearchStrategy s2 = mock(SearchStrategy.class);
        SearchStrategy s3 = mock(SearchStrategy.class);
        SearchStrategy s4 = mock(SearchStrategy.class);
        OrderLog o = mock(OrderLog.class);
        //when

        when(s1.filter(o)).thenReturn(true);
        when(s1.filter(o)).thenReturn(true);
        when(s1.filter(o)).thenReturn(true);
        when(s1.filter(o)).thenReturn(false);

        strategy.addSearchStrategy(s1);
        strategy.addSearchStrategy(s2);
        strategy.addSearchStrategy(s3);
        strategy.addSearchStrategy(s4);
        //then
        assertFalse(strategy.filter(o));
    }
    public void SearchAllTrue(){
        //given
        CompositeSearchStrategy strategy = new CompositeSearchStrategy();
        SearchStrategy s1 = mock(SearchStrategy.class);
        SearchStrategy s2 = mock(SearchStrategy.class);
        SearchStrategy s3 = mock(SearchStrategy.class);
        SearchStrategy s4 = mock(SearchStrategy.class);
        OrderLog o = mock(OrderLog.class);
        //when

        when(s1.filter(o)).thenReturn(true);
        when(s1.filter(o)).thenReturn(true);
        when(s1.filter(o)).thenReturn(true);
        when(s1.filter(o)).thenReturn(true);

        strategy.addSearchStrategy(s1);
        strategy.addSearchStrategy(s2);
        strategy.addSearchStrategy(s3);
        strategy.addSearchStrategy(s4);
        //then
        assertTrue(strategy.filter(o));
    }

}
