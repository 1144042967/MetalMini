package cn.sd.game.controller;

import cn.sd.game.ui.MetalUserInterfaceManger;
import cn.sd.game.ui.domain.Location;
import cn.sd.game.ui.window.MenuWindow;
import cn.sd.game.ui.window.MessageWindow;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Created with Software Dept.
 * <p>
 *
 * @author : 江荣展
 * Date: 2018-10-25
 * Time: 15:41
 * Description: MainController
 */
public class MainController {

    public static void main(String[] args) {

        MessageWindow messageWindow = new MessageWindow();
        messageWindow.setLocation(new Location(100, 100, 300, 300));
        messageWindow.setVisible(true);

        MessageWindow messageWindow2 = new MessageWindow();
        messageWindow2.setLocation(new Location(200, 200, 300, 300));
        messageWindow2.setVisible(true);
        messageWindow2.setActive(true);

        MenuWindow menuWindow = new MenuWindow();
        menuWindow.setLocation(new Location(300,50,300,300));
        menuWindow.setVisible(true);

        MetalUserInterfaceManger manger = new MetalUserInterfaceManger();
        manger.addWindow(messageWindow);
        manger.addWindow(messageWindow2);
        manger.addWindow(menuWindow);

        JFrame frame = new JFrame("TEST");
        frame.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                manger.requestFocus(true);
            }
        });
        frame.setSize(1024, 768);
        frame.setContentPane(manger);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        new Timer(40, e -> {
            manger.repaint();
        }).start();
    }

}
