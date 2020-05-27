package pl.edu.agh.internetshop;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class OrderHistoryTest {

    @Test
    public void filterTest(){
        //given
        SearchStrategy s1 = mock(SearchStrategy.class);
        OrderHistory history = new OrderHistory(s1);
        OrderLog o0 = mock(OrderLog.class);
        OrderLog o1 = mock(OrderLog.class);
        OrderLog o2 = mock(OrderLog.class);
        OrderLog o3= mock(OrderLog.class);
        ArrayList<OrderLog> ol = new ArrayList<>();
        ol.add(o0);
        ol.add(o1);
        ol.add(o2);
        ol.add(o3);

        ArrayList<OrderLog> expected = new ArrayList<>();
        expected.add(o0);
        expected.add(o2);
        //when
        when(s1.filter(o0)).thenReturn(true);
        when(s1.filter(o1)).thenReturn(false);
        when(s1.filter(o2)).thenReturn(true);
        when(s1.filter(o3)).thenReturn(false);
        history.strategy = s1;
        history.history = ol;
        ArrayList<OrderLog> res = history.filter();

        //then
        assertEquals(2, res.size());
        assertEquals(o0, res.get(0));
        assertEquals(o2, res.get(1));
    }
}
