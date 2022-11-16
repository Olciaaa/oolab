package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public abstract class AbstractWorldMap implements IWorldMap {
    protected ArrayList<IWorldElement> elementsOnMap = new ArrayList<>();
    public abstract Vector2d getZeroPoint();
    public abstract Vector2d getLastPoint();

    @Override
    public boolean canMoveTo(Vector2d position) {
        //return !(objectAt(position).getClass() == Animal.class);
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            elementsOnMap.add(0, animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (IWorldElement element: elementsOnMap
        ) {
            if(element.getPosition().equals(position)){
                return element;
            }
        }

        return null;
    }

    public ArrayList<IWorldElement> getElementsOnMap() {
        return elementsOnMap;
    }

    @Override
    public String toString(){
        return new MapVisualiser(this).draw(getZeroPoint(), getLastPoint());
    }

    @Override
    public boolean grassWasAte(Vector2d newPosition){
        return false;
    }
}
