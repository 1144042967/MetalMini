package cn.sd.game.ui.window;

import cn.sd.game.ui.base.AbstractWindow;
import cn.sd.game.ui.domain.Location;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * Created with Software Dept.
 * <p>
 *
 * @author : 江荣展
 * Date: 2018-10-25
 * Time: 13:22
 * Description: MessageWindow
 */
public class MessageWindow extends AbstractWindow {
    private Graphics g;

    @Override
    public void paint(BufferedImage image) {
        this.g = image.getGraphics();
        Color title = new Color(Color.BLACK.getRed(), Color.BLACK.getGreen(), Color.BLACK.getBlue(), 50);
        Color bg = new Color(Color.LIGHT_GRAY.getRed(), Color.LIGHT_GRAY.getGreen(), Color.LIGHT_GRAY.getBlue(), 50);
        Color board = bg;
        if (this.isActive()) {
            title = new Color(Color.BLACK.getRed(), Color.BLACK.getGreen(), Color.BLACK.getBlue(), 200);
            bg = new Color(Color.LIGHT_GRAY.getRed(), Color.LIGHT_GRAY.getGreen(), Color.LIGHT_GRAY.getBlue(), 100);
            board = title;
        }
        Location location = getLocation();
        fillRect(g, title, location.x, location.y, location.w, 20);
        fillRect(g, bg, location.x, location.y + 20, location.w, location.h - 20);
        if (isActive()) {
            drawRect(g, board, location.x, location.y + 20, location.w - 1, location.h - 21);
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_S) {
            this.setVisible(!this.isVisible());
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            this.setActive(!this.isActive());
        }
    }
}
