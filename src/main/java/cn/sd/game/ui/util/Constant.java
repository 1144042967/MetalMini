package cn.sd.game.ui.util;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

/**
 * 作者 江荣展
 * 类名 Constant
 * 时间 2018/10/26 22:20
 */
public class Constant {

    private static final ConvolveOp convolveOp;

    static {
        float[] data = {
                0.0625f, 0.125f, 0.0625f,
                0.125f, 0.025f, 0.125f,
                0.0625f, 0.125f, 0.0625f
        };
        Kernel kernel = new Kernel(3, 3, data);
        convolveOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
    }

    /**
     * 对图片进行模糊
     *
     * @param image 源图片
     * @return 模糊后的图片
     */
    public static BufferedImage blur(BufferedImage image) {
        BufferedImage filteredImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        convolveOp.filter(image, filteredImage);
        return filteredImage;
    }
}
