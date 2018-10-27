package cn.sd.game.ui.window;

import cn.sd.game.ui.base.AbstractWindow;
import cn.sd.game.ui.util.Constant;

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

    @Override
    public void update() {
        BufferedImage image = new BufferedImage(location.w, location.h, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        if (this.isActive()) {
            Constant.fillRect(g, Constant.ACTIVE_TITLE, 0, 0, location.w, 20);
            Constant.fillRect(g, Constant.ACTIVE_BG, 0, 20, location.w, location.h - 20);
            Constant.drawRect(g, Constant.ACTIVE_TITLE, 0, 20, location.w - 1, location.h - 21);
        } else {
            Constant.fillRect(g, Constant.PASSIVE_TITLE, 0, 0, location.w, 20);
            Constant.fillRect(g, Constant.PASSIVE_BG, 0, 20, location.w, location.h - 20);
        }
        this.image = image;
    }


    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_S) {
            this.setVisible(!this.isVisible());
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            this.setActive(!this.isActive());
            this.update();
            this.manger.bubble(this);
        }
    }
}
