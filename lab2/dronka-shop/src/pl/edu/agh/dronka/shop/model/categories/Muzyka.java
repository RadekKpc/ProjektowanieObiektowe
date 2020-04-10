package pl.edu.agh.dronka.shop.model.categories;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.ICategory;

import java.util.LinkedHashMap;
import java.util.Map;

public class Muzyka implements ICategory {

    private String displayedName;
    private GatunekMuzyki gatunekMuzyki;
    private boolean video;

    public Muzyka(boolean video,GatunekMuzyki gatunekMuzyki){
        displayedName = "Muzyka";
        this.video = video;
        this.gatunekMuzyki = gatunekMuzyki;
    }
    @Override
    public Map<String, Object> getPropertiesMap() {
        Map<String, Object> propertiesMap = new LinkedHashMap<>();

        propertiesMap.put("Doalczone Video", video);
        propertiesMap.put("Gatunek Muzyki", gatunekMuzyki);

        return propertiesMap;
    }

    @Override
    public void setBoolianPropertie(Boolean b, int propertieNumber) {
        if(propertieNumber == 0)this.video = b;
    }

    @Override
    public boolean getBoolianProperie(int propertieNumber) {
        return video;
    }

    @Override
    public boolean equals(ICategory c) {
        if(!video)return true;
        return c.getBoolianProperie(0) == this.video;
    }

    @Override
    public String getDisplayName() {

        return displayedName;
    }

}
