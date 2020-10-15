package algorithm;

import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.List;

/**
 * 判断一个人的坐标是否在 城市X 内，即：点是否在多边形内
 * 射线法，以人的坐标沿x轴做射线，判断与城市所有边交点的个数，奇数个就在城市内，否则在城市外
 * <p>
 * 参考：
 * https://blog.csdn.net/WilliamSun0122/article/details/77994526
 * https://blog.csdn.net/xxssyyyyssxx/article/details/86348486
 *
 * @author: fupeng
 * @date: 2020/7/21 12:14
 */
public class IsPointInPolygon {

    private static final int POLYGON_MIN_SIZE = 3;

    /**
     * 判断一个人目前的位置（2，3）是否在 X 城市内。即：判断点（2，3）是否在以点（3，2）、（4，5）、（5，3）围起来的多边形内
     * <p>
     * y轴
     * ||
     * ||
     * ||      point(2,5) ×       (4,5)
     * ||
     * ||
     * ||
     * ||      point(2,3) ×  point(4,3)√  (5,3)  point(7,3) ×
     * ||
     * ||                  (3,2)
     * ||
     * ||
     * ||
     * ||==================================================   x轴
     *
     * @param args
     */
    public static void main(String[] args) {
        // 人的坐标
        Point2D.Double point1 = new Point2D.Double(2.0, 3.0);
        Point2D.Double point2 = new Point2D.Double(7.0, 3.0);
        Point2D.Double point3 = new Point2D.Double(2.0, 5.0);
        Point2D.Double point4 = new Point2D.Double(4.0, 3.0);
        // 城市的坐标点
        List<Point2D.Double> cityPoints = Arrays.asList(
                new Point2D.Double(3.0, 2.0),
                new Point2D.Double(4.0, 5.0),
                new Point2D.Double(5.0, 3.0)
        );
        System.out.println(isPointInPolygon(point1, cityPoints));
        System.out.println(isPointInPolygon(point2, cityPoints));
        System.out.println(isPointInPolygon(point3, cityPoints));
        System.out.println(isPointInPolygon(point4, cityPoints));

    }

    public static boolean isPointInPolygon(Point2D.Double point, List<Point2D.Double> polygon) {
        assertParams(point, polygon);
        int count = 0;
        double x1, x2, y1, y2;
        // 人的坐标点水平向右射线与边的交点的x坐标
        double dLon;
        int size = polygon.size();
        for (int index = 0; index < size; index++) {
            if (index == size - 1) {
                x1 = polygon.get(index).getX();
                y1 = polygon.get(index).getY();
                x2 = polygon.get(0).getX();
                y2 = polygon.get(0).getY();
            } else {
                x1 = polygon.get(index).getX();
                y1 = polygon.get(index).getY();
                x2 = polygon.get(index + 1).getX();
                y2 = polygon.get(index + 1).getY();
            }
            /**
             * 以下语句判断A点是否在边的两端点的水平平行线之间，在则可能有交点
             * 注意: 如果与直线的顶点相交，则与纵坐标y值大的那个顶点相交，才认为是点与直线相交
             */
            if (((point.y > y1) && (point.y <= y2)) || ((point.y > y2) && (point.y <= y1))) {
                // line (x1, y1) -> (x2, y2) 不是水平线，即 y1 != y2
                if (Math.abs(y1 - y2) > 0) {
                    /**
                     * 计算以 (point.x, point.y) 点向右的射线与 line (x1, y1) -> (x2, y2) 交点的x坐标，（dLon，point.y）
                     *
                     * point.y - y1       y2 - y1                     (point.y - y1) * (x2 - x1)
                     * ------------  =  -----------  =>  dLon = x1 + -----------------------------
                     * dLon - x1          x2 - x1                              y2 - y1
                     */
                    dLon = x1 + ((point.y - y1) * (x2 - x1)) / (y2 - y1);
                    // 如果交点在A点右侧（说明是做射线与 边的交点），则射线与边的全部交点数加一：
                    if (dLon > point.x) {
                        count++;
                    }
                }
            }
        }
        // 交点为奇数个，则人在城市内
        return (count % 2) != 0;
    }

    private static void assertParams(Point2D.Double point, List<Point2D.Double> polygon) {
        if (null == point || null == polygon || polygon.size() < POLYGON_MIN_SIZE) {
            throw new IllegalArgumentException("参数不能为空，且多边形点数大于3");
        }
    }

}
