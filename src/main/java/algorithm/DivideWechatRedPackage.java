package algorithm;

import java.math.BigDecimal;
import java.util.*;

/**
 * 微信群抢红包
 *
 * 线段切割法
 * 原理：
 * 把红包总金额想象成一条很长的线段，而每个人抢到的金额，则是这条主线段所拆分出的若干子线段。
 * 当 N 个人一起抢红包的时候，就需要确定 N-1 个切割点。
 * 因此，当 N 个人一起抢总金额为 M元 的红包时，我们需要做 N-1 次随机运算，以此确定 N-1 个切割点。
 * 随机的范围区间是[1，100* M）。当所有切割点确定以后，子线段的长度也随之确定。这样每个人来抢红包的时候，只需要顺次领取与子线段长度等价的红包金额即可。
 * <p>
 * author: fupeng
 * time: 2020-07-04 14:30
 */
public class DivideWechatRedPackage {

    public static void main(String[] args) {
        DivideWechatRedPackage divideWechatRedPackage = new DivideWechatRedPackage();
        List<BigDecimal> redPackageList = divideWechatRedPackage.divideRedPackage(BigDecimal.valueOf(100.00), 10);

        // 打印微信红包
        redPackageList.forEach(System.out::println);
    }

    /**
     * 分割红包
     * @param total 红包总金额
     * @param count 红包个数
     * @return
     */
    private List<BigDecimal> divideRedPackage(BigDecimal total, int count) {
        int fen = total.multiply(BigDecimal.valueOf(100)).intValue();
        if (fen < count) {
            System.out.println("红包金额太小，不够分配");
            return new ArrayList();
        }
        if (count < 1) {
            System.out.println("红包个数最少为1");
            return new ArrayList();
        }

        // 确定 N-1 个分割点
        List<Integer> boards = new ArrayList<>();
        boards.add(0);
        boards.add(fen);
        Random random = new Random();
        while (boards.size() <= count) {
            int index = random.nextInt(fen);
            if (!boards.contains(index)) {
                boards.add(random.nextInt(fen));
            }
        }

        // 排序
        Collections.sort(boards);

        List<BigDecimal> redPackageList = new ArrayList();
        for (int i = 0; i < count; i++) {
            redPackageList.add(BigDecimal.valueOf(boards.get(i + 1) - boards.get(i)).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_DOWN));
        }
        return redPackageList;
    }

}
