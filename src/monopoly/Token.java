package monopoly;

import javax.swing.*;
import java.awt.*;

public class Token {
    private final Player player;
    private Integer x, y;
    private final Integer width, height;
    private final ImageIcon image;
    private int position = 0;

    public Token(Player player, int width, int height, String image) {
        this.player = player;
        this.width = width;
        this.height = height;
        this.image = new ImageIcon(image);
        updateXY(Constants.BoardConstants.go);
    }

    public void paint(Graphics g, Panel p) {
        g.drawImage(image.getImage(), x, y, width, height, p);
    }

    public int getPosition() {
        return position;
    }
    public void setPosition() {
        position = player.getPosition();
        BoardComponent bc = Constants.BoardConstants.positionMap.get(position);
        if (position == 10) {
            if (player.getIsInJail()) {
                x = bc.getX() + bc.getWidth() - width;
                y = bc.getY();
            }
            else {
                x = bc.getX();
                y = bc.getY() + bc.getHeight() - height;
            }
        }
        else updateXY(bc);
    }

    private void updateXY(BoardComponent bc) {
        x = bc.getX() + bc.getWidth() / 2 - width / 2;
        y = bc.getY() + bc.getHeight() / 2 - height / 2;
    }
}
