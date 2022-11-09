package agh.ics.oop;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class SimulationEngine implements IEngine{
    private MoveDirection[] moves;
    private ArrayList<Animal> animals = new ArrayList<>();
    private IWorldMap map;
    private JFrame f;
    private JTextArea textField;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] animalsPositions){
        this.moves = moves;

        for (Vector2d animalPosition:animalsPositions) {
            Animal animal = new Animal(map, animalPosition);

            if(map.place(animal)){
                animals.add(animal);
            }
        }
        this.map = map;
        System.out.println(map.toString());
        setupMovementSimulation();
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

            Thread.sleep(400);
            textField.setText(map.toString());
        }
    }

    private void setupMovementSimulation() {
        f = new JFrame();
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);

        textField = new JTextArea(map.toString());
        textField.setBounds(80, 70, 240, 260);
        Font font = new Font("Helvetica", Font.BOLD, 20);
        textField.setFont(font);
        f.add(textField);
    }

    public ArrayList<Animal> getAnimals(){
        return animals;
    }
}
