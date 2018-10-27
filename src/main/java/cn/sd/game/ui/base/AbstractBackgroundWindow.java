package cn.sd.game.ui.base;

import cn.sd.game.ui.util.Constant;

import java.awt.*;

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
    @Override
    protected synchronized void update() {
        Graphics g = this.image.getGraphics();
        if (isActive()) {
            Constant.fillRect(g, Constant.ACTIVE_BG, location);
        } else {
            Constant.fillRect(g, Constant.PASSIVE_BG, location);
            this.image = Constant.blur(image);
        }
    }
}
