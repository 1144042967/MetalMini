package cn.sd.game.ui.window;

import cn.sd.game.ui.base.AbstractWindow;
import cn.sd.game.ui.domain.Location;
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

    private String content = "";

    @Override
    public void update() {
        BufferedImage image = new BufferedImage(location.w, location.h, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        if (this.isActive()) {
            //绘制标题
            Location titleLocation = new Location(0, 0, location.w, 20);
            Constant.fillRect(g, Constant.ACTIVE_TITLE, titleLocation);
            Constant.drawTitle(g, Constant.ACTIVE_TITLE_FONT_COLOR, "消息窗口", Constant.ACTIVE_TITLE_FONT, titleLocation);
            //绘制内容
            Location contentLocation = new Location(0, 20, location.w, location.h - 20);
            Constant.fillRect(g, Constant.ACTIVE_BG, contentLocation);
            Constant.drawRect(g, Constant.ACTIVE_TITLE, contentLocation);
            Constant.drawContent(g, Constant.ACTIVE_BG_FONT_COLOR, content, Constant.ACTIVE_TITLE_FONT, contentLocation);
        } else {
            Constant.fillRect(g, Constant.PASSIVE_TITLE, 0, 0, location.w, 20);
            Constant.fillRect(g, Constant.PASSIVE_BG, 0, 20, location.w, location.h - 20);
        }
        this.image = image;
    }

    /**
     * 设置内容
     *
     * @param content 窗口内容
     */
    public void setContent(String content) {
        this.content = content;
        this.update();
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
