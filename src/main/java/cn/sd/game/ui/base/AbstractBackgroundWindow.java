package cn.sd.game.ui.base;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created with Software Dept.
 * <p>
 *
 * @author : 江荣展
 * Date: 2018-10-26
 * Time: 16:12
 * Description: AbstractBackgroundWindow 带背景的窗口
 */
public class AbstractBackgroundWindow extends AbstractWindow {
    private Color front;
    private Color background;

    public AbstractBackgroundWindow(Color front, Color background) {
        this.front = front;
        this.background = background;
    }

    @Override
    public void paint(BufferedImage image) {
        Graphics g = image.getGraphics();
        if (isActive()) {
            fillRect(g, front, getLocation());
        } else {
            fillRect(g, background, getLocation());
        }
    }
}
