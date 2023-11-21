package flyweight;

public class BigString {
    private final BigChar[] bigChars;

    public BigString(String text) {
        BigCharFactory factory = BigCharFactory.getInstance();

        bigChars = text.chars()
                .mapToObj(ch -> (char) ch)
                .map(factory::getBigChar)
                .toArray(BigChar[]::new);
    }

    public void print() {
        for (BigChar bigChar : bigChars) {
            bigChar.print();
        }
    }
}
