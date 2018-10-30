package cn.sd.game.ui.util;

import cn.sd.game.ui.domain.Location;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

/**
 * 作者 江荣展
 * 类名 Constant
 * 时间 2018/10/26 22:20
 */
public class Constant {
    /**
     * 活动窗口标题
     */
    public static final Color ACTIVE_TITLE = new Color(Color.BLACK.getRed(), Color.BLACK.getGreen(), Color.BLACK.getBlue(), 255);
    /**
     * 活动窗口字体颜色
     */
    public static final Color ACTIVE_TITLE_FONT_COLOR = Color.WHITE;
    /**
     * 活动窗口字体
     */
    public static final Font ACTIVE_TITLE_FONT = new Font("微软雅黑", Font.PLAIN, 12);
    /**
     * 活动窗口背景
     */
    public static final Color ACTIVE_BG = new Color(Color.LIGHT_GRAY.getRed(), Color.LIGHT_GRAY.getGreen(), Color.LIGHT_GRAY.getBlue(), 150);
    /**
     * 活动窗口背景颜色
     */
    public static final Color ACTIVE_BG_FONT_COLOR = Color.BLACK;
    /**
     * 活动窗口背景字体
     */
    public static final Font ACTIVE_BG_FONT = new Font("微软雅黑", Font.PLAIN, 12);
    /**
     * 非活动窗口标题
     */
    public static final Color PASSIVE_TITLE = new Color(Color.BLACK.getRed(), Color.BLACK.getGreen(), Color.BLACK.getBlue(), 100);
    /**
     * 非活动窗口背景
     */
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
        g.drawRect(x, y, w - 1, h - 1);
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

    /**
     * 绘制标题
     */
    public static void drawTitle(Graphics g, Color color, String text, Font font, int x, int y, int w, int h) {
        Color c = g.getColor();
        g.setColor(color);
        drawTitle(g, text, font, new Location(x, y, w, h));
        g.setColor(c);
    }

    /**
     * 绘制标题
     */
    public static void drawTitle(Graphics g, Color color, String text, Font font, Location location) {
        Color c = g.getColor();
        g.setColor(color);
        drawTitle(g, text, font, location);
        g.setColor(c);
    }

    private static void drawTitle(Graphics g, String s, Font font, Location r) {
        FontRenderContext frc = new FontRenderContext(null, true, true);
        Rectangle2D r2D = font.getStringBounds(s, frc);
        int rWidth = (int) Math.round(r2D.getWidth());
        int rHeight = (int) Math.round(r2D.getHeight());
        int rX = (int) Math.round(r2D.getX());
        int rY = (int) Math.round(r2D.getY());
        int a = (r.w / 2) - (rWidth / 2) - rX;
        int b = (r.h / 2) - (rHeight / 2) - rY;
        g.setFont(font);
        g.drawString(s, r.x + a, r.y + b);
    }

    /**
     * 绘制内容
     */
    public static void drawContent(Graphics g, Color color, String text, Font font, Location location) {
        Color c = g.getColor();
        g.setColor(color);
        drawContent(g, text, font, location);
        g.setColor(c);
    }

    private static void drawContent(Graphics g, String s, Font font, Location r) {
        FontRenderContext frc = new FontRenderContext(null, true, true);
        Rectangle2D r2D = font.getStringBounds(s.charAt(0) + "", frc);
        int rWidth = (int) Math.round(r2D.getWidth());
        int rHeight = (int) Math.round(r2D.getHeight());
        int rY = (int) Math.round(r2D.getY());
        int padding = 20;
        int maxRow = (r.h - padding * 2) / rHeight;
        int maxCol = (r.w - padding * 2) / rWidth;
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                int index = i * maxCol + j;
                if (index >= s.length()) {
                    return;
                }
                g.drawString(s.charAt(index) + "", r.x + padding + rWidth * j, r.y + padding + rHeight * i - rY);
            }
        }
    }
}
