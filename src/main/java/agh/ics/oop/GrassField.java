package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;

public class GrassField extends AbstractWorldMap {
    private final int numberOfGrassOnMap;

    public GrassField(int numberOfGrassOnMap) {
        this.numberOfGrassOnMap = numberOfGrassOnMap;

        initGrassOnMap();
    }

    private void initGrassOnMap() {
        for (int i = 0; i < numberOfGrassOnMap; i++) {
            Vector2d randomPlace = randomPlaceOfGrass();
            elementsOnMap.put(randomPlace, new Grass(randomPlace));
        }
    }

    private Vector2d randomPlaceOfGrass() {
        Vector2d randomVector =  new Vector2d((int)(Math.random() * Math.sqrt(numberOfGrassOnMap * 10)), (int)(Math.random() * Math.sqrt(numberOfGrassOnMap * 10)));

        while(isOccupied(randomVector)){
            randomVector = new Vector2d((int)(Math.random() * Math.sqrt(numberOfGrassOnMap * 10)), (int)(Math.random() * Math.sqrt(numberOfGrassOnMap * 10)));
        }

        return randomVector;
    }

    @Override
    public Vector2d getZeroPoint() {
        Vector2d point = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);

        for (Vector2d key:elementsOnMap.keySet()
             ) {
            point = point.lowerLeft(key);
        }

        return point;
    }

    @Override
    public Vector2d getLastPoint() {
        Vector2d point = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

        for (Vector2d key:elementsOnMap.keySet()
        ) {
            point = point.upperRight(key);
        }

        return point;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        moveGrassIfIs(newPosition);

        IWorldElement element = elementsOnMap.get(oldPosition);
        elementsOnMap.remove(oldPosition);
        elementsOnMap.put(newPosition, element);
    }

    @Override
    public boolean place(Animal animal) {
        moveGrassIfIs(animal.position);

        if(canMoveTo(animal.getPosition())){
            elementsOnMap.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    public void moveGrassIfIs(Vector2d animalPosition) {
        if(objectAt(animalPosition) instanceof Grass grass){
            Vector2d newPosition = randomPlaceOfGrass();
            elementsOnMap.remove(grass.position);
            grass.position = newPosition;
            elementsOnMap.put(newPosition, grass);
        }
    }
}
