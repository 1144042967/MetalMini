package cn.sd.game.ui.domain;

/**
 * Created with Software Dept.
 * <p>
 *
 * @author : 江荣展
 * Date: 2018-10-20
 * Time: 16:39
 * Description: Location 位置
 */
public class Location {
    /**
     * 左距
     */
    public int x;
    /**
     * 上距
     */
    public int y;
    /**
     * 宽度
     */
    public int w;
    /**
     * 高度
     */
    public int h;

    public Location(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
}
