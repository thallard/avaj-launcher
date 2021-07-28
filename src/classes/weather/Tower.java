package classes.weather;

import java.util.*;
import classes.aircrafts.*;

public class Tower {
    private ArrayList<Flyable> observers;

    public Tower()
    {
        System.out.println("ici fdp fdp fdp");
        observers = new ArrayList<>();
    }

    public void register(Flyable flyable)
    {
        observers.add(flyable);
        System.out.println("taille de l'arraylist = " + this.observers.size());
    }

    public void unregister(Flyable flyable)
    {
        System.out.println(getClass().getSimpleName() + "#" + flyable.getName() + "(" + flyable.getId() + ") landing.");
        observers.remove(flyable);

    }

    protected void conditionsChanged() {
        System.out.println("taille de l'arraylist = " + this.observers.size());
        for (int i = 0; i < this.observers.size(); i++) {
            System.out.println(this.observers.get(i).getHeight());
            if (this.observers.get(i).getHeight() <= 0)
                unregister(this.observers.get(i));
        }
    }
}
