package main;

import java.util.Map;
import java.util.NoSuchElementException;

public class Data {
    private static final Map<Character, Integer> humanMap = Map.of(
            'S', 5,
            'W', 2,
            'T', 3,
            'P', 1);

    private static final Map<Character, Integer> swamperMap = Map.of(
            'S', 2,
            'W', 2,
            'T', 5,
            'P', 2);

    private static final Map<Character, Integer> woodmanMap = Map.of(
            'S', 3,
            'W', 3,
            'T', 2,
            'P', 2  );

    public static int getData(String species, Character terrain) {
        switch (species) {
            case "Human" -> {
                return humanMap.get(terrain);
            }
            case "Swamper" -> {
                return swamperMap.get(terrain);
            }
            case "Woodman" -> {
                return woodmanMap.get(terrain);
            }
            default -> throw new NoSuchElementException("Check input Data");
        }
    }


}
