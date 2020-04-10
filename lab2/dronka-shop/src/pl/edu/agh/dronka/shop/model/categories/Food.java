package pl.edu.agh.dronka.shop.model.categories;
import pl.edu.agh.dronka.shop.model.ICategory;

import java.util.LinkedHashMap;
import java.util.Map;

public class Food implements ICategory {
    private String displayedName;
    private String dataPrzydatnosci;

    public Food(String dataPrzydatnosci){
        displayedName = "Żywność";
        this.dataPrzydatnosci = dataPrzydatnosci;
    }
    @Override
    public Map<String, Object> getPropertiesMap() {
        Map<String, Object> propertiesMap = new LinkedHashMap<>();

        propertiesMap.put("data przydatnosci", dataPrzydatnosci);

        return propertiesMap;
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
