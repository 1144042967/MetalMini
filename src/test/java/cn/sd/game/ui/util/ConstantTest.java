package cn.sd.game.ui.util;

import org.junit.Test;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Created with Software Dept.
 * <p>
 *
 * @author : 江荣展
 * Date: 2018-10-29
 * Time: 13:16
 * Description: ConstantTest
 */
public class ConstantTest {
    @Test
    public void printFontSize() {
        Font font = new Font("Verdana", Font.PLAIN, 12);
        FontRenderContext frc = new FontRenderContext(null, true, true);
        String s = "一二三四五六七八九十";
        for (int i = 1; i < s.length(); i++) {
            String subS = s.substring(0, i);
            Rectangle2D r2D = font.getStringBounds(subS, frc);
            System.out.println(r2D);
        }
    }
}