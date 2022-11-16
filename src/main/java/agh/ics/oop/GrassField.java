package agh.ics.oop;

import java.util.ArrayList;

public class GrassField extends AbstractWorldMap {
    private final int numberOfGrassOnMap;

    public GrassField(int numberOfGrassOnMap) {
        this.numberOfGrassOnMap = numberOfGrassOnMap;

        initGrassOnMap();
    }

    private void initGrassOnMap() {
        for (int i = 0; i < numberOfGrassOnMap; i++) {
            elementsOnMap.add(new Grass(randomPlaceOfGrass()));
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

        for (IWorldElement element:elementsOnMap
             ) {
            point = point.lowerLeft(element.getPosition());
        }

        return point;
    }

    @Override
    public Vector2d getLastPoint() {
        Vector2d point = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

        for (IWorldElement element:elementsOnMap
        ) {
            point = point.upperRight(element.getPosition());
        }

        return point;
    }

    //zadanie dodatkowe
    @Override
    public boolean grassWasAte(Vector2d position) {
        if(objectAt(position) instanceof Grass){
            moveGrass((Grass) objectAt(position));
            return true;
        }
        return false;
    }

    public void moveGrass(Grass grass) {
        grass.position = randomPlaceOfGrass();
    }
}
