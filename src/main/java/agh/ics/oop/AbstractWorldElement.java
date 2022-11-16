package agh.ics.oop;

public abstract class AbstractWorldElement implements IWorldElement {

    protected Vector2d position;

    protected AbstractWorldElement(Vector2d position) {
        this.position = position;
    }

    @Override
    public Vector2d getPosition() {
        return position;
    }
}
