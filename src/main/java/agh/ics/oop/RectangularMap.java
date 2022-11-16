package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap extends AbstractWorldMap {
    private final Vector2d zeroPoint;
    private final Vector2d lastPoint;
    private ArrayList<IWorldElement> elementsOnMap = new ArrayList<>();

    public RectangularMap(int width, int height) {
        this.zeroPoint = new Vector2d(0, 0);
        this.lastPoint = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal) && position.precedes(lastPoint) && position.follows(zeroPoint);
    }

    @Override
    public Vector2d getZeroPoint() {
        return zeroPoint;
    }

    @Override
    public Vector2d getLastPoint() {
        return lastPoint;
    }
}
