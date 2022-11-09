package agh.ics.oop;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position;
    private final IWorldMap map;

    public Animal(IWorldMap map, Vector2d initialPosition){
        position = initialPosition;
        this.map = map;
    }

    @Override
    public String toString(){
        return direction.toString();
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public Animal move(MoveDirection direction){
        switch (direction){
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> {
                moveForward(position.add(this.direction.toUnitVector()));
            }
            case BACKWARD -> {
                moveForward(position.add(this.direction.toUnitVector().opposite()));
            }
        }

        return this;
    }

    private void moveForward(Vector2d newPosition){
        if(map.canMoveTo(newPosition)){
            position = newPosition;
        }
    }

    public MapDirection getDirection() {
        return direction;
    }

    public Vector2d getPosition() {
        return position;
    }
}
