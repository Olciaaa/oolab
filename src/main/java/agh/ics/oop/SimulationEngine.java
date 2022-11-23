package agh.ics.oop;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class SimulationEngine implements IEngine {
    private MoveDirection[] moves;
    private ArrayList<Animal> animals = new ArrayList<>();
    private IWorldMap map;
    private JFrame f;
    private JTextArea textField;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] animalsPositions) {
        this.moves = moves;

        for (Vector2d animalPosition:animalsPositions) {
            Animal animal = new Animal(map, animalPosition);

            if(map.place(animal)){
                animals.add(animal);
                animal.addObserver((IPositionChangeObserver) map);
            }
            else{
                throw new IllegalArgumentException(animal.position + " is not legal move specification.");
            }
            //mógłby być ten wyjątek w funkcji place, ale ona jest booleanem (według interfejsu z zajęć wcześniej) to już ją tak zostawiłam w spokoju. A chyba nieładnie byłoby nie zwracać w niej false jak jest źle i zwracać true jak jest super :/
        }
        this.map = map;
        System.out.println(map.toString());
        //setupMovementSimulation();
    }

    @Override
    public void run() throws InterruptedException {
        int animalIdx = 0;

        for (MoveDirection move:moves
             ) {
            animals.get(animalIdx % animals.size()).move(move);

            System.out.println("move" + move);
            System.out.println(map.toString());

            animalIdx += 1;

            //Thread.sleep(300);
            //textField.setText(map.toString());
        }
    }

    private void setupMovementSimulation() {
        f = new JFrame();
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);

        textField = new JTextArea(map.toString());

        textField.setBounds(10, 10, 10 + 50 * (map.getLastPoint().x() - map.getZeroPoint().x()), 10 + 50 * (map.getLastPoint().y() - map.getZeroPoint().y()));
        Font font = new Font("Helvetica", Font.BOLD, 20);
        textField.setFont(font);
        f.add(textField);
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
}
