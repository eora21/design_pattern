package command.drawer;

import command.command.Command;
import java.awt.Point;

public class DrawCommand implements Command {
    protected final Drawable drawable;
    private final Point position;

    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    @Override
    public void execute() {
        drawable.draw(position.x, position.y);
    }
}
