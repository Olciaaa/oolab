package agh.ics.oop;

public enum MoveDirection {
    FORWARD,
    BACKWARD,
    RIGHT,
    LEFT;

    public static MoveDirection fromCode(String argument){
        return switch(argument) {
            case "f" -> FORWARD;
            case "b" -> BACKWARD;
            case "l" -> LEFT;
            case "r" -> RIGHT;
            default -> null;
        };
    }
}
