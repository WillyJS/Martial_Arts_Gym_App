package main.java.memoranda;

import java.util.ArrayList;

public class Room {

    ArrayList<DojoClass> dojoClasses;

    public Room() {
        dojoClasses = new ArrayList<DojoClass>();
    }

    public ArrayList<DojoClass> getDojoClasses() {
        return dojoClasses;
    }

    public void setDojoClasses(ArrayList<DojoClass> dojoClasses) {
        this.dojoClasses = dojoClasses;
    }

}
