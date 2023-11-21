package flyweight;

import java.util.HashMap;
import java.util.Map;

public class BigCharFactory {
    private static final BigCharFactory INSTANCE = new BigCharFactory();
    private final Map<Character, BigChar> pool = new HashMap<>();

    private BigCharFactory() {
    }

    public static BigCharFactory getInstance() {
        return INSTANCE;
    }

    public synchronized BigChar getBigChar(char charName) {
        return pool.getOrDefault(charName, createBigChar(charName));
    }

    private BigChar createBigChar(char charName) {
        return pool.put(charName, new BigChar(charName));
    }
}
