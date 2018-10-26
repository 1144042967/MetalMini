package cn.sd.game.ui.base;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

/**
 * Created with Software Dept.
 * <p>
 *
 * @author : 江荣展
 * Date: 2018-10-20
 * Time: 17:25
 * Description: InterfaceWindow
 */
public interface InterfaceWindow {
    /**
     * 绘制
     *
     * @param g 绘图句柄
     */
    void paint(Graphics g);

    /**
     * 按下并弹起按键
     *
     * @param e 按键参数
     */
    void keyTyped(KeyEvent e);

    /**
     * 按下按键
     *
     * @param e 按键参数
     */
    void keyPressed(KeyEvent e);

    /**
     * 弹起按键
     *
     * @param e 按键参数
     */
    void keyReleased(KeyEvent e);

    /**
     * 鼠标点击
     *
     * @param e 点击参数
     */
    void mouseClicked(MouseEvent e);

    /**
     * 鼠标按下
     *
     * @param e 点击参数
     */
    void mousePressed(MouseEvent e);

    /**
     * 鼠标释放
     *
     * @param e 点击参数
     */
    void mouseReleased(MouseEvent e);

    /**
     * 鼠标进入界面
     *
     * @param e 点击参数
     */
    void mouseEntered(MouseEvent e);

    /**
     * 鼠标进入离开
     *
     * @param e 点击参数
     */
    void mouseExited(MouseEvent e);

    /**
     * 鼠标拖动事件
     *
     * @param e 拖动事件参数
     */
    void mouseDragged(MouseEvent e);

    /**
     * 鼠标移动事件
     *
     * @param e 移动事件参数
     */
    void mouseMoved(MouseEvent e);

    /**
     * 鼠标中键滚动
     *
     * @param e 中键滚动参数
     */
    void mouseWheelMoved(MouseWheelEvent e);
}
