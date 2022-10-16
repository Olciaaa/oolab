package agh.ics.oop;

enum Direction {
    FORWARD,
    BACKWARD,
    RIGHT,
    LEFT,
    WRONG;

    public static Direction fromCode(String argument){
        return switch(argument) {
            case "f" -> FORWARD;
            case "b" -> BACKWARD;
            case "l" -> LEFT;
            case "r" -> RIGHT;
            default -> WRONG;
        };
    }
}
