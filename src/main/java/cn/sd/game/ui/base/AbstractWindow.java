package cn.sd.game.ui.base;

import cn.sd.game.ui.MetalUserInterfaceManger;
import cn.sd.game.ui.domain.Location;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;

/**
 * Created with Software Dept.
 * <p>
 *
 * @author : 江荣展
 * Date: 2018-10-20
 * Time: 16:34
 * Description: AbstractWindow 抽象窗口
 */
public abstract class AbstractWindow implements InterfaceWindow {
    /**
     * 布局管理器
     */
    protected MetalUserInterfaceManger manger;
    /**
     * 缓存的图片
     */
    protected volatile BufferedImage image;
    /**
     * 位置
     */
    protected volatile Location location;
    /**
     * 可视
     */
    private volatile boolean visible = false;
    /**
     * 前台活动状态
     */
    private volatile boolean active = false;

    public MetalUserInterfaceManger getManger() {
        return manger;
    }

    public void setManger(MetalUserInterfaceManger manger) {
        this.manger = manger;
    }

    public BufferedImage getImage() {
        return image;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        Location local = this.location;
        this.location = location;
        if (local == null || local.w != location.w || local.h != location.h) {
            this.image = new BufferedImage(location.w, location.h, BufferedImage.TYPE_INT_ARGB);
            this.update();
        }
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
        this.update();
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        if (this.active != active) {
            this.active = active;
            this.update();
        }
    }

    /**
     * 刷新画面
     */
    protected abstract void update();

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
    }
}
