package pl.edu.agh.internetshop;

import java.util.Date;

public class OrderLog {

    Order order;
    Date date;
//   put here another atributes which you want to log

    public OrderLog(Order o){
        order = o;
    }
}
