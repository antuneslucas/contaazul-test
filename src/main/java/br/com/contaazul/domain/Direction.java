package br.com.contaazul.domain;

import java.util.HashMap;
import java.util.Map;

public enum Direction {

    NORTH(0, 'N'),
    EAST (1, 'E'),
    SOUTH(2, 'S'),
    WEST (3, 'W');

    private final int value; //this value works like a clock in clockwise direction. If you are facing North and start to turn to right you will face East, South, West, North again and so on.
    private final char code;

    private Direction(int value, char code) {
        this.value = value;
        this.code = code;
    }

    private static final Map<Integer, Direction> VALUE_MAP = new HashMap<>();

    static {
        for (Direction direction : values())
            VALUE_MAP.put(direction.getValue(), direction);
    }

    public int getValue() {
        return value;
    }

    public char getCode() {
        return code;
    }

    public static Direction getByValue(Integer value) {
        return VALUE_MAP.get(value);
    }

}