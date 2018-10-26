package cn.sd.game.ui.base;

import cn.sd.game.ui.domain.Location;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.List;

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
     * 位置
     */
    private Location location;
    /**
     * 可视
     */
    private boolean visible = false;
    /**
     * 前台活动状态
     */
    private boolean active = false;
    /**
     * 子窗口列表
     */
    private List<AbstractWindow> sonWindowList;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<AbstractWindow> getSonWindowList() {
        return sonWindowList;
    }

    public void setSonWindowList(List<AbstractWindow> sonWindowList) {
        this.sonWindowList = sonWindowList;
    }

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

    /**
     * 画矩形框
     */
    protected void drawRect(Graphics g, Color color, int x, int y, int w, int h) {
        Color c = g.getColor();
        g.setColor(color);
        g.drawRect(x, y, w, h);
        g.setColor(c);
    }

    /**
     * 画矩形框
     */
    protected void drawRect(Graphics g, Color color, Location location) {
        drawRect(g, color, location.x, location.y, location.w, location.h);
    }

    /**
     * 填充矩形
     */
    protected void fillRect(Graphics g, Color color, int x, int y, int w, int h) {
        Color c = g.getColor();
        g.setColor(color);
        g.fillRect(x, y, w, h);
        g.setColor(c);
    }

    /**
     * 填充矩形
     */
    protected void fillRect(Graphics g, Color color, Location location) {
        fillRect(g, color, location.x, location.y, location.w, location.h);
    }
}
