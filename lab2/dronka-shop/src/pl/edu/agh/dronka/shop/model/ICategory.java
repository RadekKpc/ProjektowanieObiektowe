package pl.edu.agh.dronka.shop.model;

import java.util.ArrayList;
import java.util.Map;

public interface ICategory {


    String getDisplayName();
    Map<String, Object> getPropertiesMap();
    void setBoolianPropertie(Boolean b,int propertieNumber);
    boolean getBoolianProperie(int propertieNumber);
    boolean equals(ICategory c);
}
