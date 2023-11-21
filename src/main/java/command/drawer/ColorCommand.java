package command.drawer;

import command.command.Command;
import java.awt.Color;

public class ColorCommand implements Command {
    private final Drawable drawable;
    private final Color color;

    public ColorCommand(Drawable drawable, Color color) {
        this.drawable = drawable;
        this.color = color;
    }

    @Override
    public void execute() {
        drawable.updateColor(color);
    }
}
