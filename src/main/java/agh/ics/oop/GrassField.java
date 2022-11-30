package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;

public class GrassField extends AbstractWorldMap {
    private final int numberOfGrassOnMap;
    private MapBoundary mapBoundary = new MapBoundary();

    public GrassField(int numberOfGrassOnMap) {
        this.numberOfGrassOnMap = numberOfGrassOnMap;

        initGrassOnMap();
    }

    private void initGrassOnMap() {
        for (int i = 0; i < numberOfGrassOnMap; i++) {
            Vector2d randomPlace = randomPlaceOfGrass();
            Grass grass = new Grass(randomPlace);
            elementsOnMap.put(randomPlace, grass);
            mapBoundary.putNewElement(grass.position);
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
        return mapBoundary.leftBottomCorner();
    }

    @Override
    public Vector2d getLastPoint() {
        return mapBoundary.rightTopCorner();
    }

    @Override
    public void positionChanged(PositionChangeEvent event){
        moveGrassIfIs(event.newPosition());

        IWorldElement element = elementsOnMap.get(event.oldPosition());
        elementsOnMap.remove(event.oldPosition());
        elementsOnMap.put(event.newPosition(), element);

        mapBoundary.positionChanged(event);
    }

    @Override
    public boolean place(Animal animal) {
        moveGrassIfIs(animal.position);
        mapBoundary.putNewElement(animal.position);

        if(canMoveTo(animal.getPosition())){
            elementsOnMap.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    public void moveGrassIfIs(Vector2d animalPosition) {
        if(objectAt(animalPosition) instanceof Grass grass){
            Vector2d newPosition = randomPlaceOfGrass();
            mapBoundary.positionChanged(new PositionChangeEvent(grass.position, newPosition));

            elementsOnMap.remove(grass.position);
            grass.position = newPosition;
            elementsOnMap.put(newPosition, grass);
        }
    }
}
