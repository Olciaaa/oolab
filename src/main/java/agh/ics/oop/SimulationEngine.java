package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine {
    private MoveDirection[] moves;
    private ArrayList<Animal> animals = new ArrayList<>();
    private IWorldMap map;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] animalsPositions) {
        this.moves = moves;

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
        this.map = map;
        System.out.println(map.toString());
    }

    @Override
    public void run() {
        int animalIdx = 0;

        for (MoveDirection move:moves) {
            animals.get(animalIdx % animals.size()).move(move);

            System.out.println("move" + move);
            System.out.println(map.toString());

            animalIdx += 1;
        }
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
}
