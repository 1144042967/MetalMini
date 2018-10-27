package cn.sd.game.ui;

import cn.sd.game.ui.base.AbstractWindow;
import cn.sd.game.ui.domain.Location;
import cn.sd.game.ui.util.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with Software Dept.
 * <p>
 *
 * @author : 江荣展
 * Date: 2018-10-20
 * Time: 16:00
 * Description: MetalUserInterfaceManger 主面板窗口控制器
 */
public class MetalUserInterfaceManger extends JPanel {

    private List<AbstractWindow> windowList = new ArrayList<>();

    public MetalUserInterfaceManger() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                for (AbstractWindow window : windowList) {
                    window.keyTyped(e);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                for (AbstractWindow window : windowList) {
                    window.keyPressed(e);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                for (AbstractWindow window : windowList) {
                    window.keyReleased(e);
                }
            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (AbstractWindow window : windowList) {
                    window.mouseClicked(e);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                for (AbstractWindow window : windowList) {
                    window.mousePressed(e);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                for (AbstractWindow window : windowList) {
                    window.mouseReleased(e);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                for (AbstractWindow window : windowList) {
                    window.mouseEntered(e);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                for (AbstractWindow window : windowList) {
                    window.mouseExited(e);
                }
            }
        });
        this.addMouseWheelListener(e -> windowList.forEach(w -> w.mouseWheelMoved(e)));

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                for (AbstractWindow window : windowList) {
                    window.mouseDragged(e);
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                for (AbstractWindow window : windowList) {
                    window.mouseMoved(e);
                }
            }
        });
    }

    /**
     * 注册窗口
     *
     * @param window 窗口
     */
    public void addWindow(AbstractWindow window) {
        windowList.add(window);
        window.setManger(this);
    }

    /**
     * 将窗口浮到上面来
     *
     * @param window 窗口
     */
    public synchronized void bubble(AbstractWindow window) {
        ArrayList<AbstractWindow> newList = new ArrayList<>(windowList);
        if (newList.contains(window)) {
            newList.remove(window);
            newList.add(window);
        }
        windowList = newList;
    }

    @Override
    protected void paintComponent(Graphics g) {
        //绘制背景
        g.drawImage(Constant.IMAGE, 0, 0, getWidth(), getHeight(), null);
        for (AbstractWindow window : windowList) {
            if (window.isVisible()) {
                //绘制可见窗口
                Location location = window.getLocation();
                g.drawImage(window.getImage(), location.x, location.y, location.x + location.w, location.y + location.h, 0, 0, location.w, location.h, null);
            }
        }
    }
}
