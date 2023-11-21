package interpreter;

public class CommandNode extends Node {
    private Node node;

    @Override
    public void parse(Context context) throws ParseException {
        if (context.currentToken().equals("repeat")) {
            node = new RepeatCommandNode();
            node.parse(context);
            return;
        }

        node = new PrimitiveCommandNode();
        node.parse(context);
    }

    @Override
    public String getDescription() {
        return node.getDescription();
    }
}
