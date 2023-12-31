package interpreter;

public abstract class Node {
    public abstract void parse(Context context) throws ParseException;

    public abstract String getDescription();
}
