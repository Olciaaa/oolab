package agh.ics.oop;

enum Direction {
    FORWARD,
    BACKWARD,
    RIGHT,
    LEFT,
    WRONG;

    public static Direction fromCode(String argument){
        switch(argument) {
            case "f" -> {return FORWARD;}
            case "b" -> {return BACKWARD;}
            case "l" -> {return LEFT;}
            case "r" -> {return RIGHT;}
            default -> {return WRONG;}
        }
    }
}
