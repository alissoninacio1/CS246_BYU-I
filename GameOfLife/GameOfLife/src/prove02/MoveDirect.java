package prove02;

//creatures movements as constants using enum
public enum MoveDirect {
    UNDETERMINED, UP, RIGHT, DOWN, LEFT;

    public static MoveDirect fromInt(int i) {
        return switch (i) {
            case 0 -> MoveDirect.UP;
            case 1 -> MoveDirect.RIGHT;
            case 2 -> MoveDirect.DOWN;
            case 3 -> MoveDirect.LEFT;
            default -> MoveDirect.UNDETERMINED;
        };
    }
}






