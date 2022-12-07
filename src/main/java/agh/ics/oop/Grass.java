package agh.ics.oop;

public class Grass extends AbstractWorldElement {

    public Grass(Vector2d position) {
        super(position);
    }

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public String getPicture() {
        return "src/main/resources/grass.png";
    }
}
