package cn.sd.game.ui.util;

import cn.sd.game.ui.domain.Location;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

/**
 * 作者 江荣展
 * 类名 Constant
 * 时间 2018/10/26 22:20
 */
public class Constant {

    public static final Color ACTIVE_TITLE = new Color(Color.BLACK.getRed(), Color.BLACK.getGreen(), Color.BLACK.getBlue(), 255);
    public static final Color ACTIVE_BG = new Color(Color.LIGHT_GRAY.getRed(), Color.LIGHT_GRAY.getGreen(), Color.LIGHT_GRAY.getBlue(), 150);

    public static final Color PASSIVE_TITLE = new Color(Color.BLACK.getRed(), Color.BLACK.getGreen(), Color.BLACK.getBlue(), 100);
    public static final Color PASSIVE_BG = new Color(Color.LIGHT_GRAY.getRed(), Color.LIGHT_GRAY.getGreen(), Color.LIGHT_GRAY.getBlue(), 100);

    public static final Image IMAGE = Toolkit.getDefaultToolkit().getImage("LF.png");

    private static final ConvolveOp CONVOLVE_OP;

    static {
        float[] data = {
                0.0625f, 0.125f, 0.0625f,
                0.125f, 0.025f, 0.125f,
                0.0625f, 0.125f, 0.0625f
        };
        Kernel kernel = new Kernel(3, 3, data);
        CONVOLVE_OP = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
    }

    /**
     * 对图片进行模糊
     *
     * @param image 源图片
     * @return 模糊后的图片
     */
    public static BufferedImage blur(BufferedImage image) {
        BufferedImage filteredImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        CONVOLVE_OP.filter(image, filteredImage);
        return filteredImage;
    }

    /**
     * 画矩形框
     */
    public static void drawRect(Graphics g, Color color, int x, int y, int w, int h) {
        Color c = g.getColor();
        g.setColor(color);
        g.drawRect(x, y, w, h);
        g.setColor(c);
    }

    /**
     * 画矩形框
     */
    public static void drawRect(Graphics g, Color color, Location location) {
        drawRect(g, color, location.x, location.y, location.w, location.h);
    }

    /**
     * 填充矩形
     */
    public static void fillRect(Graphics g, Color color, int x, int y, int w, int h) {
        Color c = g.getColor();
        g.setColor(color);
        g.fillRect(x, y, w, h);
        g.setColor(c);
    }

    /**
     * 填充矩形
     */
    public static void fillRect(Graphics g, Color color, Location location) {
        fillRect(g, color, location.x, location.y, location.w, location.h);
    }

    public static void drawText(String text, Font font, int x, int y) {

    }

}
