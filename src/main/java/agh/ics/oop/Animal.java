package agh.ics.oop;

public class Animal extends AbstractWorldElement {

    private MapDirection direction = MapDirection.NORTH;
    private final IWorldMap map;

    public Animal(IWorldMap map, Vector2d initialPosition){
        super(initialPosition);
        this.map = map;
    }

    @Override
    public String toString() {
        return direction.toString();
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public Animal move(MoveDirection direction) {
        switch (direction){
            case RIGHT -> rotate(this.direction.next());
            case LEFT -> rotate(this.direction.previous());
            case FORWARD -> move(position.add(this.direction.toUnitVector()));  //metoda jest definiowana jako nazwa + LISTA ARGUMENTÓW
            case BACKWARD -> move(position.add(this.direction.toUnitVector().opposite()));
        }

        return this;
    }

    private void rotate(MapDirection direction) {
        this.direction = direction;
    }

    private void move(Vector2d newPosition) {
        if(map.canMoveTo(newPosition)){
            map.grassWasAte(newPosition);
            position = newPosition;
        }
    }

    public MapDirection getDirection() {
        return direction;
    }
}
