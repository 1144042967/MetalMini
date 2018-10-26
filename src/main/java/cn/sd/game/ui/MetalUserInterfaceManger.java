package cn.sd.game.ui;

import cn.sd.game.ui.base.AbstractWindow;
import cn.sd.game.ui.util.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with Software Dept.
 * <p>
 *
 * @author : 江荣展
 * Date: 2018-10-20
 * Time: 16:00
 * Description: MetalUserInterfaceManger 主面板
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


    public void addWindow(AbstractWindow window) {
        windowList.add(window);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (AbstractWindow window : windowList) {
            if (window.isVisible()) {
                BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
                window.paint(image);
                if (!window.isActive()) {
                    image = Constant.blur(image);
                }
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            }
        }
    }
}
