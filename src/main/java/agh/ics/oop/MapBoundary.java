package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver{
    private SortedSet<Vector2d> elementsPositionsSortedX = new TreeSet<>((o1, o2) -> {
        if (o1.x() == o2.x()) {
            return o1.y() - o2.y();
        }
        return o1.x() - o2.x();
    });

    private SortedSet<Vector2d> elementsPositionsSortedY = new TreeSet<>((o1, o2) -> {
        if (o1.y() == o2.y()) {
            return o1.x() - o2.x();
        }
        return o1.y() - o2.y();
    });

    public Vector2d leftBottomCorner(){
        return new Vector2d(elementsPositionsSortedX.first().x(), elementsPositionsSortedY.first().y());
    }

    public Vector2d rightTopCorner(){
        return new Vector2d(elementsPositionsSortedX.last().x(), elementsPositionsSortedY.last().y());
    }

    public void putNewElement(Vector2d position) {
        elementsPositionsSortedX.add(position);
        elementsPositionsSortedY.add(position);
    }

    @Override
    public void positionChanged(PositionChangeEvent event) {
        elementsPositionsSortedX.remove(event.oldPosition());
        elementsPositionsSortedY.remove(event.oldPosition());
        elementsPositionsSortedX.add(event.newPosition());
        elementsPositionsSortedY.add(event.newPosition());
    }
}
