package cn.sd.game.ui.window;

import cn.sd.game.ui.base.AbstractBackgroundWindow;
import cn.sd.game.ui.util.Constant;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created with Software Dept.
 * <p>
 *
 * @author : 江荣展
 * Date: 2018-10-27
 * Time: 15:10
 * Description: MenuWindow
 */
public class MenuWindow extends AbstractBackgroundWindow {
    @Override
    protected synchronized void update() {
        BufferedImage image = new BufferedImage(location.w, location.h, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        Constant.drawRect(g,Color.RED,0, 0, location.w, location.h);

        this.image = image;
    }
}
