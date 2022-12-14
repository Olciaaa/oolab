package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap {
    protected Map<Vector2d, IWorldElement> elementsOnMap = new HashMap<>();
    public abstract Vector2d getZeroPoint();
    public abstract Vector2d getLastPoint();

    @Override
    public void positionChanged(PositionChangeEvent event) {
        IWorldElement element = elementsOnMap.get(event.oldPosition());
        elementsOnMap.remove(event.oldPosition());
        elementsOnMap.put(event.newPosition(), element);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        //return !(objectAt(position).getClass() == Animal.class);
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            elementsOnMap.put(animal.getPosition(), animal);
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
        if(elementsOnMap.containsKey(position)){
            return elementsOnMap.get(position);
        }
        return null;
    }

    public Map<Vector2d, IWorldElement> getElementsOnMap() {
        return elementsOnMap;
    }

    @Override
    public String toString() {
        return new MapVisualiser(this).draw(getZeroPoint(), getLastPoint());
    }


}
