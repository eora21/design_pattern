package interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CommandListNode extends Node {
    private final List<Node> nodes = new ArrayList<>();

    @Override
    public void parse(Context context) throws ParseException {
        while (true) {
            if (Objects.isNull(context.currentToken())) {
                throw new ParseException("Error: Missing 'end'");
            }

            if (context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            }

            Node commandNode = new CommandNode();
            commandNode.parse(context);
            nodes.add(commandNode);
        }
    }

    @Override
    public String getDescription() {
        return nodes.stream()
                .map(Node::getDescription)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
