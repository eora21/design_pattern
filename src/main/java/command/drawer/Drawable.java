package command.drawer;

import java.awt.Color;

public interface Drawable {
    void draw(int x, int y);

    void updateColor(Color color);
}
