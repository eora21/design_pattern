package interpreter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PrimitiveCommandNode extends Node {
    private static final Set<String> PRIMITIVE_COMMAND = Set.of("go", "right", "left");
    private String name;

    @Override
    public void parse(Context context) throws ParseException {
        name = context.currentToken();

        if (Objects.isNull(name)) {
            throw new ParseException("Error: Missing <primitive command>");
        }

        if (PRIMITIVE_COMMAND.contains(name)) {
            context.skipToken(name);
            return;
        }

        throw new ParseException("Error: Unknown <primitive command>: '" + name + "'");
    }

    @Override
    public String getDescription() {
        return name;
    }
}
