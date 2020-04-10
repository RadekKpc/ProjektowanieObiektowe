package pl.edu.agh.dronka.shop.model.categories;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.ICategory;

import java.util.LinkedHashMap;
import java.util.Map;

public class Elecrtronics implements ICategory {

    private String displayedName;
    private boolean mobilny;
    private boolean gwarancja;

    public Elecrtronics(boolean mobilny,boolean gwarancja){
        displayedName = "Elektronika";
        this.mobilny = mobilny;
        this.gwarancja = gwarancja;
    }
    @Override
    public Map<String, Object> getPropertiesMap() {
        Map<String, Object> propertiesMap = new LinkedHashMap<>();

        propertiesMap.put("Mobilny", mobilny);
        propertiesMap.put("Gwarancja", gwarancja);

        return propertiesMap;
    }

    @Override
    public void setBoolianPropertie(Boolean b, int propertieNumber) {
        if(propertieNumber == 0)this.mobilny = b;
        if(propertieNumber == 1)this.gwarancja = b;
    }

    @Override
    public boolean getBoolianProperie(int propertieNumber) {
        if(propertieNumber == 0)return this.mobilny;
        if(propertieNumber == 1)return this.gwarancja;
        return false;
    }

    @Override
    public boolean equals(ICategory c) {
        if(!(mobilny || gwarancja))return true;
        if(mobilny && gwarancja)return mobilny == c.getBoolianProperie(0) && gwarancja == c.getBoolianProperie(1);
        if(!mobilny)return c.getBoolianProperie(1);
        if(!gwarancja)return c.getBoolianProperie(0);
        return  false;

    }

    @Override
    public String getDisplayName() {

        return displayedName;
    }

}
