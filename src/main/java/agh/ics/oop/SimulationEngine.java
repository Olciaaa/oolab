package agh.ics.oop;

import agh.ics.oop.gui.App;

import java.util.ArrayList;

public class SimulationEngine implements IEngine, Runnable {
    private MoveDirection[] moves;
    private final ArrayList<Animal> animals = new ArrayList<>();
    private final IWorldMap map;
    private final App application;
    private final int moveDelay;

    public SimulationEngine(IWorldMap map, Vector2d[] animalsPositions, App application, int moveDelay) {
        this.map = map;
        this.application = application;
        this.moveDelay = moveDelay;
        addAnimalsToMap(animalsPositions);
    }

    public void setMoves(MoveDirection[] moves) {
        this.moves = moves;
    }

    private void addAnimalsToMap(Vector2d[] animalsPositions){
        for (Vector2d animalPosition:animalsPositions) {
            Animal animal = new Animal(map, animalPosition);

            if(map.place(animal)){
                animals.add(animal);
                animal.addObserver(map);
            }
            else{
                throw new IllegalArgumentException(animal.position + " is not legal move specification.");
            }
        }
    }

    @Override
    public void run() {
        int animalIdx = 0;

        for (MoveDirection move:moves) {
            try {
                Thread.sleep(moveDelay);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

            animals.get(animalIdx % animals.size()).move(move);
            application.redrawMap();

            animalIdx += 1;
        }
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
}
