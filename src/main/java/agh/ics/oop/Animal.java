package agh.ics.oop;

public class Animal {
    private MapDirection direction;
    private Vector2d position;
    private final Vector2d zeroPoint = new Vector2d(0, 0);
    private final Vector2d lastPoint = new Vector2d(4, 4);

    public Animal(){
        direction = MapDirection.NORTH;
        position = new Vector2d(2, 2);
    }

    @Override
    public String toString(){
        return "orientacja: " + direction + ", pozycja: " + position;
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public Animal move(MoveDirection direction){
        switch (direction){
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> {
                Vector2d newPosition = position.add(this.direction.toUnitVector());
                if(newPosition.precedes(lastPoint) && newPosition.follows(zeroPoint)){
                        position = newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d newPosition = position.subtract(this.direction.toUnitVector());
                if(newPosition.precedes(lastPoint) && newPosition.follows(zeroPoint)){
                    position = newPosition;
                }
            }
        }

        return this;
    }

    public MapDirection getDirection() {
        return direction;
    }

    public void setDirection(MapDirection direction) {
        this.direction = direction;
    }

    public Vector2d getPosition() {
        return position;
    }

    public void setPosition(Vector2d position) {
        if(position.precedes(lastPoint) && position.follows(zeroPoint)){
            this.position = position;
        }
    }
}
