package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap{
    private final Vector2d zeroPoint;
    private final Vector2d lastPoint;
    //private ArrayList<ArrayList<Animal>> animalsPositions = new ArrayList<ArrayList<Animal>>();
    private ArrayList<Animal> animalsOnMap = new ArrayList<>();

    public RectangularMap(int width, int height) {
        this.zeroPoint = new Vector2d(0, 0);
        this.lastPoint = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && position.precedes(lastPoint) && position.follows(zeroPoint);
    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            animalsOnMap.add(animal);
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
        for (Animal animal:animalsOnMap
             ) {
            if(animal.getPosition().equals(position)){
                return animal;
            }
        }

        return null;
    }

    @Override
    public String toString(){
        return new MapVisualiser(this).draw(zeroPoint, lastPoint);
    }

    public ArrayList<Animal> getAnimalsOnMap(){
        return animalsOnMap;
    }
}
