package PersonData;

import java.util.ArrayList;
import java.util.HashMap;

public class Person {
    private String name;
    private String schuldEiser;
    private double schuld;
    private HashMap<String, Double> schuldList = new HashMap<>();

    public Person(String name) {
        this.name = name;
        this.schuldEiser = "None";
        this.schuld = 0.0;
//        this.schuldList.put(schuldEiser,schuld);
    }

    public void setSchuldList(HashMap<String, Double> schuldList) {
        this.schuldList = schuldList;
    }

    public HashMap<String, Double> getSchuldList() {
        return schuldList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSchuld(String eiserName) {
        return schuldList.get(eiserName);
    }

    public void setSchuld(String eiserName, double schuld) {
        if(!schuldList.containsKey(eiserName)){
//            if(schuldList.containsKey("None")<2){
//                schuldList.r
//            }
            schuldList.put(eiserName, schuld);
        }else {
            this.schuldList.replace(eiserName, schuldList.get(eiserName), schuld);
        }
    }

//    public String getSchuldEiser(String eiserName) {
//        return schuldList.;
//    }

    public void setSchuldEiser(String schuldEiser) {
        if(!schuldList.containsKey(schuldEiser)){
            this.schuldList.put(schuldEiser,0.0);
        }
    }

    @Override
    public String toString() {
        String zin="";
        for(String i:schuldList.keySet()){
            zin += name + " is " + schuldList.get(i) + " in dept to " + i + "\n";
        }
        return zin;
    }
}

