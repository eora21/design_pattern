package interpreter;

public class Context {
    private final String[] tokens;
    private String lastToken;
    private int index;

    public Context(String text) {
        this.tokens = text.split("\\s+");
        this.index = 0;
        nextToken();
    }

    public String nextToken() {
        if (index < tokens.length) {
            lastToken = tokens[index++];
            return lastToken;
        }

        return null;
    }

    public String currentToken() {
        return lastToken;
    }

    public void skipToken(String token) throws ParseException {
        if (currentToken() == null) {
            throw new ParseException("Error: '" + token + "' is expected, but no more token is found.");
        }

        if (token.equals(currentToken())) {
            nextToken();
            return;
        }

        throw new ParseException("Error: '" + token + "' is expected, but " + currentToken() + " is found.");
    }

    public int currentNumber() throws ParseException {
        if (currentToken() == null) {
            throw new ParseException("Error: No more token.");
        }

        return Integer.parseInt(currentToken());
    }
}
