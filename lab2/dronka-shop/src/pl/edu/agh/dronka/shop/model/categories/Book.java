package pl.edu.agh.dronka.shop.model.categories;
import pl.edu.agh.dronka.shop.model.ICategory;

import java.util.LinkedHashMap;
import java.util.Map;

public class Book implements ICategory {
    private String displayedName;
    private int liczbaStron;
    public boolean twardaOprawa;

    public Book(int liczbaStron,boolean twardaOprawa){
        displayedName = "Książki";
        this.liczbaStron = liczbaStron;
        this.twardaOprawa = twardaOprawa;
    }
    @Override
    public Map<String, Object> getPropertiesMap() {
        Map<String, Object> propertiesMap = new LinkedHashMap<>();

        propertiesMap.put("Liczba stron", liczbaStron);
        propertiesMap.put("Oprawa", twardaOprawa);

        return propertiesMap;
    }



    @Override
    public String getDisplayName() {

        return displayedName;
    }

    public boolean equals(ICategory book) {
        if(twardaOprawa == false)return true;
        return (this.twardaOprawa &&  book.getBoolianProperie(0));
    }
    @Override
    public void setBoolianPropertie(Boolean b, int propertieNumber) {
        if(propertieNumber == 0)this.twardaOprawa =b;
    }

    @Override
    public boolean getBoolianProperie(int propertieNumber) {
        if(propertieNumber == 0)return this.twardaOprawa;
        return false;
    }

}
