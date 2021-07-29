package classes.weather;

import java.util.*;
import classes.aircrafts.*;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable)
    {
        if (flyable.getHeight() > 0)
        {
            observers.add(flyable);
            System.out.println("\033[0;32mTower says: " + flyable.getClass().getSimpleName() + "#" + flyable.getName() + "(" + flyable.getId() + ") registered to weather tower.\033[0;0m");
        }
    }

    public void unregister(Flyable flyable)
    {
        System.out.println("\033[31m" + flyable.getClass().getSimpleName() + "#" + flyable.getName() + "(" + flyable.getId() + ") landing.\033[0m");
        System.out.println("\033[31mTower says: " + flyable.getClass().getSimpleName() + "#" + flyable.getName() + "(" + + flyable.getId() +  ") unregistered from weather tower.\033[0m");
    }

    protected void conditionsChanged() {
        for (Flyable flyable : observers)
            flyable.updateConditions();
    }

    public ArrayList<Flyable> getObservers() {
        return observers;
    }
}
