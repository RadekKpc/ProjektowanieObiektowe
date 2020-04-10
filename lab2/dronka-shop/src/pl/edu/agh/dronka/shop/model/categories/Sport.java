package pl.edu.agh.dronka.shop.model.categories;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.ICategory;

import java.util.LinkedHashMap;
import java.util.Map;

public class Sport implements ICategory {
    private String displayedName;

    public Sport(){
        displayedName = "Sport";

    }
    @Override
    public Map<String, Object> getPropertiesMap() {
        return null;
    }

    @Override
    public void setBoolianPropertie(Boolean b, int propertieNumber) {

    }

    @Override
    public boolean getBoolianProperie(int propertieNumber) {
        return false;
    }

    @Override
    public boolean equals(ICategory c) {
        return true;
    }

    @Override
    public String getDisplayName() {
        return displayedName;
    }
}
