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

        for (Iterator<Flyable> it = observers.iterator(); it.hasNext(); ) {
            Flyable flyable = it.next();

            // Precheck height before change conditions
            if (flyable.getHeight() <= 0)
            {
                it.remove();
                unregister(flyable);
            }
            flyable.updateConditions();

            // After update conditions for this Flyable, check height value
            if (flyable.getHeight() <= 0)
            {
                it.remove();
                unregister(flyable);
            }
        }
    }

    public ArrayList<Flyable> getObservers() {
        return observers;
    }
}
