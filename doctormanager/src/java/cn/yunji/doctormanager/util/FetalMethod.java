package cn.yunji.doctormanager.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

import cn.yunji.doctormanager.entity.FetalException;


/**
 * 胎心算法的相关方法
 * 
 * @author yinzx
 */
public class FetalMethod {
    public static void main(String[] args) {
        // List<Integer> ylist = FetalMethod.getrandomYList();
        // List<Double> prelist = FetalMethod.pretreatment( ylist);
        // prelist =FetalMethod.pretreatment2(prelist,4);
        // BigDecimal value=volatility(prelist, 1,140);
        // System.out.println(value);
        int[] a = { 1, 2, 3 };
        //System.out.println(Arrays.toString(a));
    }

    /**
     * @author yinzx
     * @return 随机生成list 来表示纵坐标
     */
    public static List<Integer> getrandomYList() {
        //System.out.println("00000");
        List<Integer> yList = new ArrayList<>();

        int[] a = { 132, 135, 134, 135, 136, 136, 134, 135, 133, 133, 135, 136, 136, 137, 138, 136, 137, 137, 137, 139,
                139, 138, 138, 137, 137, 138, 137, 138, 139, 138, 138, 137, 139, 139, 139, 138, 140, 139, 139, 138, 139,
                138, 138, 136, 137, 136, 137, 137, 137, 135, 137, 137, 138, 137, 138, 138, 139, 138, 139, 138, 139, 137,
                138, 137, 137, 135, 137, 136, 137, 137, 139, 138, 139, 139, 140, 140, 141, 139, 140, 140, 142, 142, 142,
                141, 141, 141, 142, 141, 142, 143, 143, 144, 145, 145, 145, 146, 146, 145, 145, 146, 145, 143, 144, 142,
                142, 141, 140, 141, 139, 138, 139, 138, 138, 136, 137, 136, 137, 137, 137, 135, 135, 136, 136, 137, 138,
                136, 137, 137, 137, 136, 138, 137, 138, 137, 136, 135, 135, 134, 133, 134, 135, 137, 136, 138, 139, 142,
                143, 142, 144, 146, 148, 149, 151, 149, 152, 150, 153, 155, 157, 156, 155, 156, 158, 159, 158, 159, 157,
                156, 156, 156, 155, 153, 152, 151, 150, 152, 152, 151, 152, 150, 148, 148, 147, 146, 147, 148, 148, 147,
                147, 145, 145, 146, 145, 143, 140, 140, 140, 138, 137, 139, 139, 138, 138, 136, 137, 136, 137, 137, 137,
                135, 136, 135, 136, 136, 134, 135, 135, 136, 136, 137, 138, 136, 136, 137, 137, 137, 139, 138, 136, 137,
                138, 137, 139, 139, 139, 138, 140, 139, 139, 138, 139, 138, 138, 136, 137, 136, 137, 137, 137, 135, 137,
                137, 138, 137, 138, 138, 139, 138, 139, 138, 139, 137, 138, 137, 137, 135, 137, 136, 137, 137, 137, 137,
                138, 137, 138, 138, 139, 138, 139, 138, 139, 137, 138, 137, 137, 135, 137, 136, 137, 137, 139, 138, 139,
                139, 140, 140, 141, 139, 140, 140, 142, 140, 142, 142, 143, 141, 141, 140, 140, 140, 140, 139, 140, 138,
                138, 137, 137, 137, 138, 138, 139, 138, 138, 137, 138, 138, 138, 137, 139, 139, 139, 138, 138, 138, 139,
                137, 139, 138, 139, 139, 141, 139, 139, 137, 138, 140, 139, 137, 138, 138, 140, 143, 145, 146, 148, 146,
                146, 145, 145, 146, 148, 147, 147, 148, 146, 148, 149, 150, 151, 150, 152, 153, 153, 152, 154, 154, 155,
                155, 154, 156, 155, 156, 154, 157, 154, 157, 156, 154, 158, 154, 155, 157, 156, 157, 158, 158, 158, 161,
                159, 160, 160, 161, 160, 162, 163, 164, 165, 165, 166, 168, 165, 166, 166, 165, 166, 168, 166, 167, 166,
                167, 166, 165, 165, 165, 165, 164, 163, 160, 164, 161, 160, 164, 161, 162, 160, 161, 158, 158, 159, 157,
                157, 156, 158, 157, 159, 155, 153, 152, 151, 150, 152, 151, 150, 150, 148, 148, 147, 145, 145, 142, 143,
                143, 144, 142, 143, 142, 144, 143, 145, 143, 145, 144, 145, 143, 144, 145, 144, 146, 145, 144, 142, 140,
                138, 137, 137, 135, 137, 136, 137, 137, 135, 136, 136, 137, 138, 136, 137, 137, 137, 136, 139, 138, 138,
                136, 137, 136, 137, 137, 137, 135, 135, 136, 136, 137, 138, 136, 137, 137, 137, 136, 138, 137, 139, 139,
                139, 138, 140, 139, 139, 138, 139, 138, 138, 136, 137, 136, 137, 137, 137, 135, 137, 137, 138, 137, 138,
                138, 139, 138, 139, 138, 139, 137, 138, 137, 137, 135, 137, 136, 137, 137, 139, 138, 139, 139, 140, 140,
                141, 139, 140, 140, 138, 137, 138, 137, 136, 135, 135, 134, 133, 134, 135, 136, 136, 137, 138, 136, 137,
                137, 137, 139, 139, 138, 138, 137, 137, 138, 137, 138, 139, 138, 138, 137, 139, 139, 139, 138, 140, 139,
                139, 138, 139, 138, 138, 136, 137, 136, 137, 137, 137, 135, 135, 133, 130, 128, 126, 128, 125, 126, 125,
                121, 118, 116, 113, 115, 114, 113, 112, 110, 110, 109, 110, 108, 107, 108, 107, 107, 106, 107, 105, 104,
                103, 103, 104, 105, 107, 105, 106, 108, 108, 109, 106, 107, 106, 108, 110, 113, 115, 118, 117, 119, 118,
                117, 119, 120, 123, 121, 122, 123, 121, 123, 122, 125, 126, 128, 129, 130, 132, 133, 135, 134, 136, 135,
                137, 137, 138, 136, 137, 138, 136, 138, 139, 138, 137, 137, 136, 138, 138, 136, 137, 136, 137, 138, 136,
                136, 135, 137, 138, 135, 138, 138, 138, 137, 139, 139, 139, 138, 140, 139, 139, 138, 139, 138, 138, 136,
                137, 136, 137, 137, 137, 135, 137, 137, 138, 137, 138, 138, 139, 138, 139, 138, 139, 137, 138, 137, 137,
                135, 137, 136, 137, 137, 139, 138, 139, 139, 140, 140, 141, 139, 140, 140, 138, 137, 136, 138, 138, 137,
                136, 135, 134, 136, 135, 136, 136, 137, 138, 136, 137, 137, 137, 136, 138, 137, 138, 137, 136, 135, 135,
                134, 133, 134, 135, 137, 136, 138, 139, 142, 143, 142, 144, 146, 148, 149, 151, 149, 152, 150, 153, 155,
                157, 156, 155, 156, 158, 159, 158, 159, 157, 156, 156, 156, 155, 153, 152, 151, 150, 152, 152, 151, 152,
                150, 148, 148, 147, 146, 147, 148, 148, 147, 147, 145, 145, 146, 145, 143, 140, 140, 140, 138, 137, 139,
                139, 138, 138, 136, 137, 136, 137, 137, 137, 135, 136, 135, 136, 136, 134, 135, 135, 136, 136, 137, 138,
                136, 136, 137, 137, 137, 139, 138, 136, 137, 138, 137, 139, 139, 139, 138, 140, 139, 139, 138, 139, 138,
                138, 136, 137, 136, 137, 137, 137, 135, 137, 137, 138, 137, 138, 138, 139, 138, 139, 138, 139, 137, 138,
                137, 137, 135, 137, 136, 137, 137, 137, 137, 138, 137, 138, 138, 139, 138, 139, 138, 139, 137, 138, 137,
                137, 135, 137, 136, 137, 137, 139, 138, 139, 139, 140, 140, 141, 139, 140, 140, 142, 140, 142, 142, 143,
                141, 141, 140, 140, 140, 140, 139, 140, 138, 138, 137, 137, 137, 138, 138, 139, 138, 138, 137, 138, 138,
                138, 137, 139, 139, 139, 138, 138, 138, 139, 137, 139, 138, 139, 139, 141, 139, 139, 137, 138, 140, 139,
                137, 138, 138, 140, 143, 145, 146, 148, 146, 146, 145, 145, 146, 148, 147, 147, 148, 146, 148, 149, 150,
                151, 150, 152, 153, 153, 152, 154, 154, 155, 155, 154, 156, 155, 156, 154, 157, 154, 157, 156, 154, 158,
                154, 155, 157, 156, 157, 158, 158, 158, 161, 159, 160, 160, 161, 160, 162, 163, 164, 165, 165, 166, 168,
                165, 166, 166, 165, 166, 168, 166, 167, 166, 167, 166, 165, 165, 165, 165, 164, 163, 160, 164, 161, 160,
                164, 161, 162, 160, 161, 158, 158, 159, 157, 157, 156, 158, 157, 159, 155, 153, 152, 151, 150, 152, 151,
                150, 150, 148, 148, 147, 145, 145, 142, 143, 143, 144, 142, 143, 142, 144, 143, 145, 143, 145, 144, 145,
                143, 144, 145, 144, 146, 145, 144, 142, 140, 138, 137, 137, 135, 137, 136, 137, 137, 135, 136, 136, 137,
                138, 136, 137, 137, 137, 136, 139, 138, 138, 136, 137, 136, 137, 137, 137, 135, 135, 136, 136, 137, 138,
                136, 137, 137, 137, 136, 138, 137, 136, 138, 138, 137, 136, 135, 134, 136, 135, 136, 136, 137, 138, 136,
                137, 137, 137, 136 };
        for (int i = 0; i < a.length; i++) {
            yList.add(a[i]);
        }

        return yList;
    }

    /**
     * @author yinzx
     * @return 随机生成list 来表示时间 横坐标
     * @throws ParseException
     */
    public static List<Date> getdateXList() throws ParseException {
        List<Date> xList = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 60; j++) {
                Date value = df.parse("2017-07-29 09:" + i + ":" + j);
                xList.add(value);// 为纵坐标赋值
            }
        }
        return xList;
    }

    /**
     * @author yinzx
     * @return 生成指定长度的list 横坐标索引列表（连续整数）
     * @throws ParseException
     */
    public static List<Integer> getList(int length) {
        List<Integer> xList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            xList.add(i);// 为纵坐标赋值

        }
        return xList;
    }

    /**
     * 通过散点值求导，返回数组
     * 
     * @author yinzx
     * @param 集合ylist
     *            来表示散点纵坐标
     * @return（数组） 差分 散点求导
     */
    public static Double[] diff(List<Integer> ylist) {
        int length = ylist.size();
        Double[] diffa = new Double[length];
        for (int i = 1; i < length - 1; i++) {
            diffa[i] = (double) ((ylist.get(i + 1) - ylist.get(i - 1)) / 2); // 中心差分求导
        }
        return diffa;
    }

    /**
     * @author yinzx
     * @return 随机生成二维数组 a[][] 来表示散点坐标
     */
    private static int[][] getFetalData() {
        int[][] a = new int[2][1200];
        for (int i = 0; i < 1200; i++) {
            a[0][i] = i; // 为横坐标赋值
            a[1][i] = (int) (Math.random() * 70) + 100;// 为纵坐标赋值

        }

        return a;
    }

    /**
     * @author yinzx
     * @param 二维数组
     *            a[][] 来表示散点坐标
     * @return 差分 散点求导
     */
    private static int[][] diff(int[][] a) {
        int length = a[0].length;
        int[][] diffa = new int[2][length];

        for (int i = 1; i < length - 1; i++) {
            diffa[0][i] = a[0][i];// 记录横坐标
            diffa[1][i] = (a[1][i + 1] - a[1][i - 1]) / (a[0][i + 1] - a[0][i - 1]); // 中心差分求导
        }

        return diffa;
    }

    /**
     * 数据初步预处理：五点三次平滑法对曲线进行平滑处理、降噪
     * 
     * @param xlist
     *            观察点数据的横坐标(整数 索引值)
     * @param ylist
     *            观察点数据的纵坐标
     * @return
     */
    public static List<Double> pretreatment(List<Integer> ylist) {
        List<Double> prelist = new ArrayList<>();
        int len = ylist.size();
        if (len > 3) {
            Double FHR0 = (double) ((69 * ylist.get(0) + 4 * ylist.get(1) - 6 * ylist.get(2) + 4 * ylist.get(3)
                    - ylist.get(4)) / 70);
            prelist.add(FHR0);
            Double FHR1 = (double) ((2 * ylist.get(0) + 27 * ylist.get(1) + 12 * ylist.get(2) - 8 * ylist.get(3)
                    + 2 * ylist.get(4)) / 35);
            prelist.add(FHR1);

            for (int i = 2; i < len - 2; i++) {
                Double FHRi = (double) (((-3) * ylist.get(i - 2) + 12 * ylist.get(i - 1) + 17 * ylist.get(i)
                        + 12 * ylist.get(i + 1) - 3 * ylist.get(i + 2)) / 35);
                prelist.add(FHRi);
            }
            Double FHRn_1 = (double) ((2 * ylist.get(len - 5) - 8 * ylist.get(len - 4) + 12 * ylist.get(len - 3)
                    + 27 * ylist.get(len - 2) + 2 * ylist.get(len - 1)) / 35);
            prelist.add(FHRn_1);
            Double FHRn = (double) (((-1) * ylist.get(len - 5) + 4 * ylist.get(len - 4) - 6 * ylist.get(len - 3)
                    + 4 * ylist.get(len - 2) + 69 * ylist.get(len - 1)) / 70);
            prelist.add(FHRn);
        }

        return prelist;
    }

    /**
     * 进一步降噪： 递归进行多次平滑
     * 
     * @param xlist
     *            观察点数据的横坐标(整数 索引值)
     * @param ylist
     *            初步处理后数据的纵坐标
     * @param n
     *            进行平滑次数
     * @return
     */
    public static List<Double> pretreatment2(List<Double> ylist, int n) {

        List<Double> prelist = new ArrayList<>();
        int len = ylist.size();
        if (len > 4) {
            Double FHR0 = (double) ((69 * ylist.get(0) + 4 * ylist.get(1) - 6 * ylist.get(2) + 4 * ylist.get(3)
                    - ylist.get(4)) / 70);
            prelist.add(FHR0);
            Double FHR1 = (double) ((2 * ylist.get(0) + 27 * ylist.get(1) + 12 * ylist.get(2) - 8 * ylist.get(3)
                    + 2 * ylist.get(4)) / 35);
            prelist.add(FHR1);

            for (int i = 2; i < len - 2; i++) {
                Double FHRi = (double) (((-3) * ylist.get(i - 2) + 12 * ylist.get(i - 1) + 17 * ylist.get(i)
                        + 12 * ylist.get(i + 1) - 3 * ylist.get(i + 2)) / 35);
                prelist.add(FHRi);
            }
            Double FHRn_1 = (double) ((2 * ylist.get(len - 5) - 8 * ylist.get(len - 4) + 12 * ylist.get(len - 3)
                    + 27 * ylist.get(len - 2) + 2 * ylist.get(len - 1)) / 35);
            prelist.add(FHRn_1);
            Double FHRn = (double) (((-1) * ylist.get(len - 5) + 4 * ylist.get(len - 4) - 6 * ylist.get(len - 3)
                    + 4 * ylist.get(len - 2) + 69 * ylist.get(len - 1)) / 70);
            prelist.add(FHRn);
            if (n > 0) {
                return pretreatment2(prelist, n - 1);
            } else {
                return prelist;
            }

        }
        return null;

    }

    /**
     * 胎心基线的确定：数据预处理后，找出胎心基线
     * 
     * @param ylist
     *            ylist 预处理后数据的纵坐标
     * @return 胎心基线的均值
     */
    public static Integer getBaseFHR(List<Double> ylist) {
        int len = ylist.size();
        //System.out.println("length=" + len);
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int count = 0; // 计算调整后的极差为0 的频数
        int count1 = 0; // 计算调整后的极差为5 的频数
        int count2 = 0; // 计算调整后的极差为10 的频数
        if (len > 6) {

            for (int i = 4; i < len - 4; i++) {
                // 存取相邻的9个点 5个点
                List<Double> sub = new ArrayList<>();
                sub.add(ylist.get(i - 4));
                sub.add(ylist.get(i - 3));
                sub.add(ylist.get(i - 2));
                sub.add(ylist.get(i - 1));
                sub.add(ylist.get(i));
                sub.add(ylist.get(i + 1));
                sub.add(ylist.get(i + 2));
                sub.add(ylist.get(i + 3));
                sub.add(ylist.get(i + 4));
                double max = getMax(sub);
                double min = getMin(sub);
                // 找出联系9个点的极差
                double R = max - min;
                int R2; // 调整后的极差

                if (R <= 10) {
                    // 极差小于10bpm 为稳定部分
                    int a = (int) R / 5;
                    int b = (int) R % 5;
                    if (b <= 4) {
                        R2 = 5 * a;
                    } else {
                        R2 = 5 * (a + 1);
                    }

                    // 计算调整后的频数分布情况
                    switch (R2) {
                        case 0: {
                            count++;
                            list.add(getAvg2(sub));
                            break;
                        }
                        case 5: {
                            count1++;
                            list1.add(getAvg2(sub));
                            break;
                        }
                        case 10: {
                            count2++;
                            list2.add(getAvg2(sub));
                            break;
                        }
                    }
                }

            }
            // 比较频数分布情况,得出最稳定的部分 点集
            int[] arr = { count, count1, count2 };
            int index = getMax(arr);

            if (index == 0) {
                try {
                    return getAvg(list);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                
            } else if (index == 1) {
                try {
                    return getAvg(list1);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            } else {
                try {
                    return getAvg(list2);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        }
        return 0;
    }

    /**
     * 确定宫缩基值,为求出宫缩基线做准备
     * 
     * @param ylist
     *            预处理后宫缩数据的纵坐标
     * @param n
     *            通过n调整阈值
     * @return 宫缩基值
     */
    public static double getBaseValue(List<Double> ylist, int n) {
        int avgValue = getAvg2(ylist);
        //System.out.println("avgValue=" + avgValue);
        // 定义阈值 threshold为 （均值+n）mmHg
        int threshold = avgValue + n;
        int len = 0;
        try {
            len = ylist.size();
        } catch (Exception e) {
            // TODO: handle exception
            return 0;
        }
      
        List<Double> plist = new ArrayList<>(); // 用于存放稳定部分的数据
        for (int i = 0; i < len; i++) {
            if (ylist.get(i) < threshold) {
                // 小于阈值的部分为稳定部分
                plist.add(ylist.get(i));
            }
        }
        double max = getMax(plist);
        double min = getMin(plist);
        // System.out.println("max=" + max);
        // System.out.println("min=" + min);
        int R = (int) (max - min); // 稳定部分的极差
        // 以1mmHg为区间长度 进行频数分布分析
        int[] count = new int[R + 1]; // 用于存储 各区间的频数
        // 对稳定部分进行 频数分布计数
        for (int i = 0; i < plist.size(); i++) {
            int num = (int) (plist.get(i) - min);
            count[num]++;
        }
        // 找出频数最大的区间
        int[] index = new int[5];
        for (int i = 0; i < 5; i++) {
            index[i] = getMax(count);
            // System.out.println(Arrays.toString(count));
            count[index[i]] = 0;
        }
        double sum = 0.0;
        for (int i : index) {
            sum += i;
        }

        return (sum / 5) + min;
    }

    /**
     * 计算宫缩基线
     * 
     * @param ylist
     *            预处理后宫缩数据的纵坐标
     * @param n
     *            滤波进行操作的总次数
     * @param b
     *            预设参数
     * @return
     */
    public static List<Double> getBaseLine(List<Double> ylist, int n, int b) {

        int a; // 修剪的阈值
        // 宫缩基值 P
        double P = getBaseValue(ylist, 40);
        //System.out.println("P=" + P);
        // 对曲线进行修剪 （待增加前后向滤波处理）
        for (int i = 0; i < ylist.size(); i++) {
            // 计算阈值
            a = b * (n + 1 - i);
            if (ylist.get(i) > P + a) {
                ylist.set(i, P);
            }
        }
        return ylist;
    }

    /**
     * 通过最小二乘法 将散点数据进行函数拟合，得到拟合函数值
     * 
     * @author yinzx
     * @param xlist
     *            观察点数据的横坐标(整数 索引值)
     * @param ylist
     *            预处理后的数据的纵坐标
     * @param n
     *            多项式的最高次幂
     * 
     * @return 拟合函数值
     */

    public static List<Double> fittingData(List<Integer> xlist, List<Double> ylist, int n) {
        // 带权重的观察点数据序列：
        final WeightedObservedPoints points = new WeightedObservedPoints();
        for (int i = 0; i < xlist.size(); i++) {
            points.add(xlist.get(i), ylist.get(i));
        }
        // 实例化一个(最高次幂为n次)多项式拟合。
        final PolynomialCurveFitter fitter = PolynomialCurveFitter.create(n);
        // 多项式函数对应系数.
        final double[] coeff = fitter.fit(points.toList());
        // 初始化拟合函数对应的函数值的集合
        List<Double> fitList = new ArrayList<>();
        for (int i = 0; i < xlist.size(); i++) {
            double fun = 0.0;// 记录拟合函数值

            for (int j = 0; j <= n; j++) {
                fun = fun + coeff[j] * Math.pow(xlist.get(i), j);
            }

            fitList.add(fun);
        }
        return fitList;
    }

    /**
     * 计算曲线 波动率
     * 
     * @param ylist
     *            预处理后的数据的纵坐标
     * @param t
     *            1秒t个点
     * @param P
     *            胎心基准值
     * @return
     */
    public static BigDecimal volatility(List<Double> ylist, int t, int P) {
        List<Double> u = new ArrayList<>();
        int length = ylist.size();

        BigDecimal a = null;
        if (length > 0) {
            u.add(0.0);
            double sum = 0.0;
            for (int i = 1; i < length; i++) {

                double ui = Math.log((ylist.get(i) / ylist.get(i - 1)));
                // double ui=Math.log(ylist.get(i));
                sum += ui;
                u.add(ui);
            }
            // System.out.println("sum="+sum);
            double avg = sum / length;
            // 计算标准差
            double sum2 = 0;
            for (int i = 0; i < length; i++) {

                sum2 += (u.get(i) - avg) * (u.get(i) - avg);

            }
            double vol = Math.sqrt(sum2 / (length - 1));
            double volatility = vol * Math.sqrt(60 * t);
            //System.out.println("1/f=" + (1 / (volatility)));
            a = new BigDecimal(volatility * P).setScale(0, BigDecimal.ROUND_HALF_UP);

        }
        return a;
    }

    /**
     * 通过拟合散点值求导，返回集合
     * 
     * @author yinzx
     * @param 集合fitlist
     *            来表示拟合散点纵坐标
     * @return（集合） 中心差分 散点求导
     */

    public static List<Double> diffitList(List<Double> fitlist) {
        int length = 0;
        try {
            length = fitlist.size();
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
     
        List<Double> diffa = new ArrayList<>();
        diffa.add((double) 0);
        for (int i = 1; i < length - 1; i++) {
            diffa.add((double) ((fitlist.get(i + 1) - fitlist.get(i - 1)) / 2)); // 中心差分求导
        }
        return diffa;
    }

    /**
     * 通过拟合函数值与实际函数值 计算二者间的误差
     * 
     * @param fitList
     *            拟合函数值
     * @param ylist
     *            实际函数值
     * @return error 误差值
     */
    public static List<Double> error(List<Double> fitList, List<Integer> ylist) {
        List<Double> error = new ArrayList<>();
        for (int i = 0; i < ylist.size(); i++) {
            error.add(fitList.get(i) - ylist.get(i));
        }
        return error;
    }

    /**
     * 去除 出现 内含 的异常项
     * 
     * @author yinzx
     * @param 分析异常结果集合list
     * @return 分析异常结果集合list
     */
    public static List<FetalException> distinct(List<FetalException> list) {
         try{
            // 待优化： 可以先按类型划分好，再依次遍历 去除内含项
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).getFirst() <= list.get(i + 1).getFirst()
                        && list.get(i).getEndindex() >= list.get(i + 1).getEndindex()
                        && list.get(i).getType() == list.get(i + 1).getType()) {
                    //System.out.println("*********************   去除内含项      ***********************************");
                    //System.out.println(list.get(i));
                    //System.out.println(list.get(i + 1));
                    list.remove(i); // 移除后 集合长度会 减1
                    i--;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }

    /**
     * 分析异常项，计算最大值和最小值,上升时间，最大改变值
     * 
     * @param t
     *            表示1秒多少个点
     * @author yinzx
     * @param 分析异常结果集合list
     * @return 分析异常结果集合list
     */
    public static List<FetalException> getMaxAndMin(List<FetalException> list, List<Integer> ylist, int t) {
        try {
            int l = list.size();
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            int first = 0;
            int end = 0;
            int max = 0; // 预设最大值
            int min = 0; // 预设最小值
            try {
                first = list.get(i).getFirst();
                end = list.get(i).getEndindex();
                max = ylist.get(first); // 预设最大值
                min = ylist.get(first); // 预设最小值
            } catch (Exception ex) {
                continue;
            }
            int risetime = 0;// 上升时间
            int changeValue = 0;// 最大改变值
            int baseValue = list.get(i).getBasevalue();
            for (int j = first; j < end; j++) {
                if (max <= ylist.get(j)) {
                    max = ylist.get(j);
                    if (list.get(i).getType() == 2) {
                        changeValue = ylist.get(j) - baseValue; // 加速的最大上升
                                                                // 改变值
                        risetime = (j - first) / t; // 加速的最大上升时间
                        list.get(i).setPeak(j);
                    }

                }
                if (min >= ylist.get(j)) {
                    min = ylist.get(j);
                    if (list.get(i).getType() == 3) {
                        changeValue = baseValue - ylist.get(j); // 减速的最大下降
                                                                // 改变值
                        risetime = (j - first) / t; // 减速的最大下降时间
                        list.get(i).setPeak(j);
                    }
                }
            }
            list.get(i).setMax(max);
            list.get(i).setMin(min);
            list.get(i).setChangevalue(changeValue);
            list.get(i).setRisetime(risetime);
        }
        return list;
    }

    /**
     * 分析异常项，增添描述
     * 
     * @author yinzx
     * @param 分析异常结果集合list
     * @param t
     *            表示1秒内 t个点
     * @return 分析异常结果集合list
     */
    public static List<FetalException> analysis(List<FetalException> list, int t) {
        try {
            int l = list.size();
        } catch (Exception e) {
            // TODO: handle exception
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getType() == 2) {
                int times = list.get(i).getEndindex() - list.get(i).getFirst();
                // 极差
                int d = list.get(i).getMax() - list.get(i).getMin();
                // System.out.println("d=" + d);
                String decs;
                if (d >= 15) {
                    decs = "反应型加速：增速大于15bpm，持续时间大于15s；";
                } else {
                    decs = "小加速；";
                }
                list.get(i).setDecs(decs);
                // 若胎心加速在2~10min内-->延长加速 （暂定1秒1个点）
                if (times >= 120 * t && times <= 600 * t) {
                    decs = "胎心加速在2~10min内，疑似延长加速；";
                    list.get(i).setDecs(decs);
                }

            } else if (list.get(i).getType() == 3) {
                // int times = list.get(i).getEndindex() -
                // list.get(i).getFirst();
                // // 若胎心减速超过2min-->延长减速 （暂定1秒1个点）
                // if (times >= 120) {
                // String decs = list.get(i).getDecs();
                // decs = decs + "持续时间超过2min，疑似延长减速；";
                // list.get(i).setDecs(decs);
                // }
                // if (list.get(i).getMin() > 70 && list.get(i).getMin() < 80) {
                // String decs = list.get(i).getDecs();
                // decs = decs + "低谷70~80bpm，疑似中度变异减速；";
                // list.get(i).setDecs(decs);
                // }
                // if (list.get(i).getMin() < 70 && times > 60) {
                // String decs = list.get(i).getDecs();
                // decs = decs + "低谷小于70bpm，且持续>60s,疑似重度变异减速；";
                // list.get(i).setDecs(decs);
                // }
            }
        }
        return list;
    }

    /**
     * 结合胎动，对胎心加速增加描述
     * 
     * @param fMlist
     *            胎动发生 的时间点集
     * @param fH
     *            胎心的具体信息
     * @return
     */
    public static List<FetalException> addFMMsg(List<Integer> fMlist, List<FetalException> fH) {
        int length = 0;
        int length2=0;
        try {
            length = fMlist.size();
            length2=fH.size(); 
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
      
        List<FetalException> Msglist = new ArrayList<>();
        if (length > 0 && length2>0) {
            int base = fH.get(0).getBasevalue();
            for (int i = 0; i < length; i++) {
                FetalException msg = new FetalException(4, fMlist.get(i));
                msg.setBasevalue(base);
                Msglist.add(msg);
                fH.add(msg);
            }
        }

        return fH;
    }

    /**
     * 结合宫缩 对胎心减速进行进一步区分判定
     * 
     * @param t
     *            表示1秒多少个点
     * @param fhMsg
     *            胎心的具体类别信息
     * @param ucMsg
     *            宫缩的具体信息
     * @return
     */
    public static List<FetalException> classifyFHRR(List<FetalException> fhMsg, List<FetalException> ucMsg, int t) {
        int length = 0;
        try {
            length = fhMsg.size();
        } catch (Exception e) {
            // TODO: handle exception
        }
        for (int k = 0; k < length; k++) {
            if (fhMsg.get(k).getType() == 3) {
                FetalException deceleration = fhMsg.get(k); // 得到减速项
                // 持续时长
                int times = deceleration.getEndindex() - deceleration.getFirst();
                // 起点——>波谷的时长
                int peaktime = deceleration.getPeak() - deceleration.getFirst();
                // 若胎心减速超过2min,小于10min-->延长减速 （暂定1秒1个点）
                if (times >= 120 * t && times <= 600 * t) {
                    String decs = "持续时间超过2min，疑似延长减速；";
                    fhMsg.get(k).setDecs(decs);
                    fhMsg.get(k).setDtype(5);
                }
                if (peaktime < 30 * t) {
                    // 变异减速：起点-->波谷小于30s
                    deceleration.setDtype(2);
                    String decs = "减速起点减至波谷小于30s，疑似变异减速；";
                    fhMsg.get(k).setDecs(decs);
                    if (deceleration.getMin() > 70 && deceleration.getMin() < 80) {
                        if (fhMsg.get(k).getDecs() == null) {
                            decs = "低谷70~80bpm，疑似中度变异减速；";
                            fhMsg.get(k).setDecs(decs);
                            fhMsg.get(k).setDtype(3);
                        } else {
                            decs = decs + "低谷70~80bpm，疑似中度变异减速；";
                            fhMsg.get(k).setDecs(decs);
                            fhMsg.get(k).setDtype(3);
                        }

                    }
                    if (deceleration.getMin() < 70 && times > 60) {
                        if (fhMsg.get(k).getDecs() == null) {
                            decs = "低谷小于70bpm，且持续>60s,疑似重度变异减速；";
                            fhMsg.get(k).setDecs(decs);
                            fhMsg.get(k).setDtype(4);
                        } else {
                            decs = decs + "低谷小于70bpm，且持续>60s,疑似重度变异减速；";
                            fhMsg.get(k).setDecs(decs);
                            fhMsg.get(k).setDtype(4);
                        }
                    }
                } else if (peaktime >= 30 * t) {
                    // 早晚期减速 的起点-->波谷大于等于30s
                    // 进一步区分 早期减速、晚期减速
                    for (int j = 0; j < ucMsg.size(); j++) {
                        FetalException uc = ucMsg.get(j);
                        if (deceleration.getPeak() - uc.getPeak() <= 15 * t
                                || uc.getPeak() - deceleration.getPeak() <= 15 * t) {
                            // 早期减速：减速的波谷与宫缩波峰几乎一致，相差小于15s
                            String decs = "减速的波谷与宫缩波峰几乎一致，相差小于15s，疑似早期减速；";
                            fhMsg.get(k).setDecs(decs);
                            fhMsg.get(k).setDtype(0);
                            break;
                        } else if (uc.getPeak() - deceleration.getPeak() >= 30 * t
                                && uc.getPeak() - deceleration.getPeak() <= 60 * t) {
                            // 晚期减速：减速波谷落后于波峰30~60s
                            String decs = "减速波谷落后于波峰30~60s，疑似晚期减速；";
                            fhMsg.get(k).setDecs(decs);
                            fhMsg.get(k).setDtype(1);
                            break;
                        }

                    }
                }

            }
        }

        return fhMsg;
    }

    /**
     * 分析宫缩曲线得到相关的宫缩信息
     * 
     * @param t
     *            表示1秒多少个点
     * @param demo
     * @return
     */
    public static List<FetalException> getUcMsg(UcDemo demo, int t) {
        List<Double> ylist = demo.getPlist();
        List<Double> diflist = demo.getDifList();
        List<Double> baseline = demo.getBaseline();
        List<FetalException> list = new ArrayList<>();
        FetalException exception;
        int length = ylist.size();
        if (length > 0) {
            for (int i = 0; i < length - 2; i++) {
                // 根的存在性定理, 找出所有的极大值
                if (diflist.get(i) >= 0 && diflist.get(i + 1) <= 0) {
                    // 在[i,i+1]中，存在极大值
                    if (ylist.get(i) > baseline.get(i) + 20) {
                        // 极大值大于对应基线值20mmHg，则可能出现宫缩
                        exception = new FetalException(5, i); // 记录疑似宫缩的极大值对应的索引
                        // System.out.println(i + ":" + ylist.get(i));
                        list.add(exception);
                    }
                }
            }
            // 遍历极大值点
            //System.out.println("list.length=" + list.size());
            for (int i = 0; i < list.size(); i++) {
                FetalException fe = list.get(i);
                int p = fe.getPeak();
                //System.out.println("p=" + p);
                // 从极大值点开始 往前搜索 至第一个幅值小于对应基线值+5mmHg的宫缩点--->宫缩起点
                for (int j = p; j > 0; j--) {
                    if (ylist.get(j) < baseline.get(j) + 5) {
                        fe.setFirst(j);
                        break;
                    }
                }
                if (fe.getFirst() <= 0) {
                    fe.setFirst(0); // 保证该属性有值
                }
                // 从极大值点开始 往后搜索 至第一个幅值小于对应基线值+5mmHg的宫缩点--->宫缩终点
                for (int j = p; j < length - 2; j++) {
                    if (ylist.get(j) < baseline.get(j) + 5) {
                        fe.setEndindex(j);
                        break;
                    }
                }
                if (fe.getEndindex() <= 0) {
                    fe.setEndindex(0); // 保证该属性有值
                }
                // 两个宫缩点之间间隔不能超过50个点
                if (fe.getEndindex() - fe.getFirst() > 50 * t) {
                    // System.out.println("start：" + fe.getFirst() + " end=" +
                    // fe.getEndindex());
                } else {
                    // 有效的宫缩

                }

            }
        }

        return list;
    }

    /**
     * 获取胎心曲线中的具体信息
     * 
     * @param t
     *            表示1秒 t个点
     * @param demo
     * @param speedUpTimes
     *            加速时长（秒）
     * @param declareTimes
     *            减速时长（秒）
     * @return List<FetalException> 异常信息集合
     */
    public static List<FetalException> getFetalMsg(FetalDemo demo, int t, int speedUpTimes, int declareTimes) {
        List<Double> ylist = demo.getPrelist();
        // List<Double> diflist = demo.getDifList();
        int length =0;
        try {
            length = ylist.size();
        } catch (Exception e) {
            // TODO: handle exception
        }
     
        Integer baseFHR = demo.getBaseFHR();
        // int first = 0; // 首次出现异常范围的时候
        // int count = 0; // 用于记录持续出现的次数（时间）
        //
        // int end = 0; // 记录结束的index值
        List<FetalException> list = new ArrayList<>();
        FetalException FhMsg;

        if (length > 0) {
            // 加速
            for (int i = 0; i < length; i++) {
                int peak = i;
                if (ylist.get(i) >= baseFHR + 10) {
                    FhMsg = new FetalException(baseFHR);
                    peak = i;// 用于记录峰值出现的索引,初始为i；
                    double max = ylist.get(i);
                    // 找出峰值和对应的索引时间
                    for (int j = i; j < i + 60 * t; j++) {
                        if (j >= length - 1) {
                            break; // 防止索引超过范围
                        }
                        if (max < ylist.get(j)) {
                            max = ylist.get(j);
                            peak = j;
                        }
                    }
                    FhMsg.setType(2);
                    FhMsg.setPeak(peak);
                    FhMsg.setMax((int) max);
                    // 从峰值开始向前搜索，出现首个比基线+3小的点----> 加速起点
                    for (int j = peak; j > 0; j--) {
                        if (ylist.get(j) < baseFHR + 3) {
                            FhMsg.setFirst(j);
                            break;
                        }
                    }
                    // 从峰值开始向后搜索，出现首个比基线+3小的点----> 加速终点
                    for (int j = peak; j < length - 1; j++) {
                        if (ylist.get(j) < baseFHR + 3) {
                            FhMsg.setEndindex(j);
                            break;
                        }
                    }
                    if ((FhMsg.getEndindex() - FhMsg.getFirst()) / t > speedUpTimes) {
                        list.add(FhMsg);
                    }
                    if (FhMsg.getEndindex() != 0) {
                        i = FhMsg.getEndindex();
                    } else {
                        i = peak;
                    }
                }
            }
            // 减速
            for (int i = 0; i < length; i++) {
                int peak = i;
                if (ylist.get(i) <= baseFHR - 15) {
                    FhMsg = new FetalException(baseFHR);
                    peak = i;// 用于记录谷值出现的索引,初始为i；
                    double min = ylist.get(i);
                    // 找出谷值和对应的索引时间
                    for (int j = i; j < i + 60 * t; j++) {
                        if (j >= length - 1) {
                            break; // 防止索引超过范围
                        }
                        if (min > ylist.get(j)) {
                            min = ylist.get(j);
                            peak = j;
                        }
                    }
                    FhMsg.setType(3);
                    FhMsg.setPeak(peak);
                    FhMsg.setMin((int) min);
                    // 从谷值开始向前搜索，出现首个比基线-3大的点----> 减速起点
                    for (int j = peak; j > 0; j--) {
                        if (ylist.get(j) > baseFHR - 3) {
                            FhMsg.setFirst(j);
                            break;
                        }
                    }
                    // 从谷值开始向后搜索，出现首个比基线-3大的点----> 减速终点
                    for (int j = peak; j < length - 1; j++) {
                        if (ylist.get(j) > baseFHR - 3) {
                            FhMsg.setEndindex(j);
                            break;
                        }
                    }
                    // 判断加速时长大小，
                    if ((FhMsg.getEndindex() - FhMsg.getFirst()) / t > declareTimes) {
                        list.add(FhMsg);
                    }

                    if (FhMsg.getEndindex() != 0) {
                        i = FhMsg.getEndindex();
                    } else {
                        i = peak;
                    }
                }
            }
            // 心动过速异常
            int count = 0;
            FhMsg = new FetalException(baseFHR);
            for (int i = 0; i < length; i++) {
                if (ylist.get(i) > 160) {
                    int first = i; // 记录首次实现的index值
                    FhMsg.setFirst(first);
                    FhMsg.setType(0);
                    count++;
                } else if (ylist.get(i) <= 160 || ylist.get(i) >= 110) {
                    // 说明恢复正常bpm
                    if (count >= 600 * t) {
                        int end = count + FhMsg.getFirst();// 记录结束的index值
                        FhMsg.setEndindex(end);
                        list.add(FhMsg);
                        FhMsg = new FetalException(baseFHR);
                    }
                    count = 0;
                }
            }
            // 如果结束遍历数据，仍然未恢复在正常范围内
            if (count >= 600 * t) {
                int end = count + FhMsg.getFirst();// 记录结束的index值
                FhMsg.setEndindex(end);
                list.add(FhMsg);
            }

            // 心速过缓异常
            count = 0;
            FhMsg = new FetalException(baseFHR);
            for (int i = 0; i < length; i++) {
                if (ylist.get(i) < 110) {
                    int first = i; // 记录首次实现的index值
                    FhMsg.setFirst(first);
                    FhMsg.setType(1);
                    count++;
                } else if (ylist.get(i) <= 160 || ylist.get(i) >= 110) {
                    // 说明恢复正常bpm
                    if (count >= 600 * t) {
                        int end = count + FhMsg.getFirst();// 记录结束的index值
                        FhMsg.setEndindex(end);
                        list.add(FhMsg);
                        FhMsg = new FetalException(baseFHR);
                    }
                    count = 0;
                }
            }
            // 如果结束遍历数据，仍然未恢复在正常范围内
            if (count >= 600 * t) {
                int end = count + FhMsg.getFirst();// 记录结束的index值
                FhMsg.setEndindex(end);
                list.add(FhMsg);
            }
        }
        return list;
    }

    /**
     * 根据胎心分析得出的详细信息 计算改良后的Fisher得分
     * 
     * @param Msglist
     * @param ylist
     *            预处理后的胎心率点
     * @param t
     *            表示1秒 t个点
     * @return
     */
    public static Fischer getFischer(List<FetalException> Msglist, List<Double> ylist, int t) {
        Fischer fischer = new Fischer();
        int speedupTimes = 0; // 计算加速次数
        String decelerate = null; // 记录减速
        int variation = 0; // 计算振幅变异
        int weekly = 0; // 计算周期
        int baseline = 0; // 胎心基线
        for (int i = 0; i < Msglist.size(); i++) {
            FetalException msg = Msglist.get(i);
            if (msg.getType() == 2) {
                // 加速
                speedupTimes++;
                baseline = msg.getBasevalue();
                if (variation < msg.getChangevalue()) {
                    variation = msg.getChangevalue();
                }
                if (variation < msg.getMax() - baseline) {
                    variation = msg.getMax() - baseline;
                }

            } else if (msg.getType() == 3) {
                // 减速
                decelerate = "偶发减速";
                if (msg.getDtype() == 1) {
                    // 晚期减速LD
                    decelerate = "LD";
                    fischer.setDecelerateSorce(0);

                } else if (msg.getDtype() > 1 && msg.getDtype() < 5) {
                    // 变异减速VD
                    decelerate = "VD";
                    fischer.setDecelerateSorce(1);
                } else {
                    fischer.setDecelerateSorce(2);
                }
            }
        }
        weekly = volatility(ylist, t, baseline).intValue();
        fischer.setFweekly(weekly);
        if (weekly <= 1) {
            fischer.setFweeklyScore(0);
        } else if (weekly <= 6) {
            fischer.setFweeklyScore(1);
        } else if (weekly > 6) {
            fischer.setFweeklyScore(2);
        }

        if (decelerate == null) {
            // 无减速
            fischer.setDecelerate("无");
            fischer.setDecelerateSorce(2);
        } else {
            fischer.setDecelerate(decelerate);
        }
        // 计算胎心基线得分
        fischer.setFline(baseline);
        if (baseline < 100 || baseline > 180) {
            fischer.setFlineScore(0);
        } else if ((baseline >= 100 && baseline < 120) || (baseline > 160 && baseline <= 180)) {
            fischer.setFlineScore(1);
        } else if (baseline >= 120 && baseline <= 160) {
            fischer.setFlineScore(2);
        }
        // 计算振幅变异得分
        fischer.setFwave(variation);
        if (variation >= 0 && variation <= 4) {
            fischer.setFwaveScore(0);
        } else if ((variation > 4 && variation < 10) || variation > 30) {
            fischer.setFwaveScore(1);
        } else if (variation >= 10 && variation <= 30) {
            fischer.setFwaveScore(2);
        }
        // 计算加速得分
        fischer.setSpeedUp(speedupTimes);
        if (speedupTimes == 0) {
            fischer.setSpeedUpScore(0);
        } else if (speedupTimes >= 1 || speedupTimes <= 4) {
            fischer.setSpeedUpScore(1);
        } else if (speedupTimes > 4) {
            fischer.setSpeedUpScore(2);
        }
        return fischer;
    }

    /**
     * 根据胎心分析得出的详细信息 计算的Fisher得分
     * 
     * @param Msglist
     * @param ylist
     *            预处理后的胎心率点
     * @param t
     *            表示1秒 t个点
     * @return
     */
    public static Fischer getPastFischer(List<FetalException> Msglist, List<Double> ylist, int t) {
        Fischer fischer = new Fischer();
        int speedupTimes = 0; // 计算加速次数
        String decelerate = null; // 记录减速
        int variation = 0; // 计算振幅变异
        int weekly = 0; // 计算周期
        int baseline = 0; // 胎心基线
        for (int i = 0; i < Msglist.size(); i++) {
            FetalException msg = Msglist.get(i);
            if (msg.getType() == 2) {
                // 加速
                speedupTimes++;
                baseline = msg.getBasevalue();
                if (variation < msg.getChangevalue()) {
                    variation = msg.getChangevalue();
                }
                if (variation < msg.getMax() - baseline) {
                    variation = msg.getMax() - baseline;
                }

            } else if (msg.getType() == 3) {
                decelerate = "偶发减速";
                fischer.setDecelerateSorce(2);
                if (msg.getDtype() > 1 && msg.getDtype() < 4) {
                    // 变异减速VD
                    decelerate = "轻度VD";
                    fischer.setDecelerateSorce(1);
                } else if (msg.getDtype() == 0) {
                    // 早期减速ED
                    decelerate = "ED";
                    fischer.setDecelerateSorce(1);
                } else if (msg.getDtype() == 1) {
                    // 晚期减速LD
                    decelerate = "LD";
                    fischer.setDecelerateSorce(0);
                } else if (msg.getDtype() == 4) {
                    // 重度减速VD
                    decelerate = "重度VD";
                    fischer.setDecelerateSorce(0);
                }
            }
        }
        weekly = volatility(ylist, t, baseline).intValue();
        fischer.setFweekly(weekly);
        if (weekly <= 1) {
            fischer.setFweeklyScore(0);
        } else if (weekly <= 6) {
            fischer.setFweeklyScore(1);
        } else if (weekly > 6) {
            fischer.setFweeklyScore(2);
        }

        if (decelerate == null) {
            // 无减速
            fischer.setDecelerate("无");
            fischer.setDecelerateSorce(2);
        } else {
            fischer.setDecelerate(decelerate);
        }
        // 计算胎心基线得分
        fischer.setFline(baseline);
        if (baseline < 100 || baseline > 180) {
            fischer.setFlineScore(0);
        } else if ((baseline >= 100 && baseline < 120) || (baseline > 160 && baseline <= 180)) {
            fischer.setFlineScore(1);
        } else if (baseline >= 120 && baseline <= 160) {
            fischer.setFlineScore(2);
        }
        // 计算振幅变异得分
        fischer.setFwave(variation);
        if (variation >= 0 && variation <= 4) {
            fischer.setFwaveScore(0);
        } else if ((variation > 4 && variation < 10) || variation > 30) {
            fischer.setFwaveScore(1);
        } else if (variation >= 10 && variation <= 30) {
            fischer.setFwaveScore(2);
        }
        // 计算加速得分
        fischer.setSpeedUp(speedupTimes);
        if (speedupTimes == 0) {
            fischer.setSpeedUpScore(0);
        } else if (speedupTimes > 0) {
            fischer.setSpeedUpScore(2);
        } else {
            fischer.setSpeedUpScore(1);
        }
        return fischer;
    }

    /**
     * 根据胎心分析得出的详细信息 计算NST得分
     * 
     * @param Msglist
     * @return
     */
    public static NSTscore getNST(List<FetalException> Msglist) {
        NSTscore nst = new NSTscore();
        int speedupTimes = 0; // 计算加速次数
        int moves = 0; // 计算胎动次数
        int variation = 0;// 计算振幅变异
        int changeValue = 0; // 计算FHR最大改变值
        int risetime = 0; // 计算 最大上升时间
        int baseline = 0; // 胎心基线
        boolean flag = false;
        for (int i = 0; i < Msglist.size(); i++) {
            FetalException msg = Msglist.get(i);
            if (msg.getType() == 2) {
                // 加速
                speedupTimes++;
                baseline = msg.getBasevalue();
                if (changeValue < msg.getChangevalue()) {
                    changeValue = msg.getChangevalue();
                }
                if (risetime < msg.getRisetime()) {
                    risetime = msg.getRisetime();
                }
                if (variation < msg.getMax() - baseline) {
                    variation = msg.getMax() - baseline;
                }
            } else if (msg.getType() == 4) {
                flag = true;
                moves++;
            }
        }

        // 计算胎心基线得分
        nst.setFline(baseline);
        if (baseline < 100 || baseline > 180) {
            nst.setFlineScore(0);
        } else if ((baseline >= 100 && baseline < 120) || (baseline > 160 && baseline <= 180)) {
            nst.setFlineScore(1);
        } else if (baseline >= 120 && baseline <= 160) {
            nst.setFlineScore(2);
        }
        // 计算振幅变异得分
        nst.setFwave(variation);
        if (variation >= 0 && variation <= 4) {
            nst.setFwaveScore(0);
        } else if ((variation > 4 && variation < 10) || variation > 30) {
            nst.setFwaveScore(1);
        } else if (variation >= 10 && variation <= 30) {
            nst.setFwaveScore(2);
        }
        // 计算上升时间得分
        nst.setFrise(risetime);
        if (risetime >= 0 && risetime <= 9) {
            nst.setFriseScore(0);
        } else if (risetime >= 10 && risetime <= 14) {
            nst.setFriseScore(1);
        } else if (risetime > 14) {
            nst.setFriseScore(2);
        }
        // 计算上升幅度得分
        nst.setFchange(changeValue);
        if (changeValue >= 0 && changeValue <= 9) {
            nst.setFchangeScore(0);
        } else if (changeValue >= 10 && changeValue <= 14) {
            nst.setFchangeScore(1);
        } else if (changeValue > 14) {
            nst.setFchangeScore(2);
        }
        if (flag) {
            nst.setFmove(moves);
            if (moves == 0) {
                nst.setFmoveScore(0);
            } else if (moves == 1 || moves == 2) {
                nst.setFmoveScore(1);
            } else if (moves > 2) {
                nst.setFmoveScore(2);
            }
        } else {
            nst.setFmove(speedupTimes);
            if (speedupTimes == 0) {
                nst.setFmoveScore(0);
            } else if (speedupTimes == 1 || speedupTimes == 2) {
                nst.setFmoveScore(1);
            } else if (speedupTimes > 2) {
                nst.setFmoveScore(2);
            }
        }
        return nst;
    }

    /**
     * 根据胎心分析得出的详细信息 计算的Krebs得分
     * 
     * @param Msglist
     * @param ylist
     *            预处理后的胎心率点
     * @param t
     *            表示1秒 t个点
     * @return
     */
    public static Krebs getKrebs(List<FetalException> Msglist, List<Double> ylist, int t) {
        Krebs krebs = new Krebs();
        int speedupTimes = 0; // 计算加速次数
        int decelerate = 0; // 记录减速
        int moves = 0; // 计算胎动次数
        int variation = 0; // 计算振幅变异
        int weekly = 0; // 计算周期
        int baseline = 0; // 胎心基线
        boolean flag = false;
        for (int i = 0; i < Msglist.size(); i++) {
            FetalException msg = Msglist.get(i);
            if (msg.getType() == 2) {
                // 加速
                speedupTimes++;
                baseline = msg.getBasevalue();
                if (variation < msg.getChangevalue()) {
                    variation = msg.getChangevalue();
                }
                if (variation < msg.getMax() - baseline) {
                    variation = msg.getMax() - baseline;
                }
            } else if (msg.getType() == 3) {
                // 减速
                decelerate++;

            } else if (msg.getType() == 4) {
                flag = true;
                moves++;
            }
        }
        // 计算周期变异
        weekly = volatility(ylist, t, baseline).intValue();
        krebs.setFweekly(weekly);
        if (weekly <= 1) {
            krebs.setFweeklyScore(0);
        } else if (weekly <= 6) {
            krebs.setFweeklyScore(1);
        } else if (weekly > 6) {
            krebs.setFweeklyScore(2);
        }
        // 计算减速得分
        krebs.setDecelerate(decelerate);
        if (decelerate == 0) {
            krebs.setDecelerateSorce(2);
        } else if (decelerate == 1 || decelerate == 2) {
            krebs.setDecelerateSorce(1);
        } else if (decelerate > 2) {
            krebs.setDecelerateSorce(0);
        }
        // 计算胎心基线得分
        krebs.setFline(baseline);
        if (baseline < 100 || baseline > 180) {
            krebs.setFlineScore(0);
        } else if ((baseline >= 100 && baseline < 120) || (baseline > 160 && baseline <= 180)) {
            krebs.setFlineScore(1);
        } else if (baseline >= 120 && baseline <= 160) {
            krebs.setFlineScore(2);
        }
        // 计算振幅变异得分
        krebs.setFwave(variation);
        if (variation >= 0 && variation <= 4) {
            krebs.setFwaveScore(0);
        } else if ((variation > 4 && variation < 10) || variation > 25) {
            krebs.setFwaveScore(1);
        } else if (variation >= 10 && variation <= 25) {
            krebs.setFwaveScore(2);
        }
        // 计算加速得分
        krebs.setSpeedUp(speedupTimes);
        if (speedupTimes == 0) {
            krebs.setSpeedUpScore(0);
        } else if (speedupTimes >= 1 || speedupTimes <= 4) {
            krebs.setSpeedUpScore(1);
        } else if (speedupTimes > 4) {
            krebs.setSpeedUpScore(2);
        }
        if (flag) {
            krebs.setFmove(moves);
            if (moves == 0) {
                krebs.setFmoveScore(0);
            } else if (moves == 1 || moves == 2) {
                krebs.setFmoveScore(1);
            } else if (moves > 2) {
                krebs.setFmoveScore(2);
            }
        } else {
            krebs.setFmove(speedupTimes);
            if (speedupTimes == 0) {
                krebs.setFmoveScore(0);
            } else if (speedupTimes == 1 || speedupTimes == 2) {
                krebs.setFmoveScore(1);
            } else if (speedupTimes > 2) {
                krebs.setFmoveScore(2);
            }
        }
        return krebs;
    }

    /**
     * 计算的最大值
     * 
     * @return max
     */
    public static double getMax(List<Double> a) {
        double max = a.get(0);

        for (int i = 0; i < a.size(); i++) {
            if (max <= a.get(i)) {
                max = a.get(i);
            }
        }
        return max;
    }

    /**
     * 计算数组之中的最大值,返回最大值 对应索引值
     * 
     * @return index
     */
    public static int getMax(int[] arr) {
        int max = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max <= arr[i]) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    /**
     * 计算的最小值
     * 
     * @return min
     */
    public static double getMin(List<Double> a) {
        double min = a.get(0);

        for (int i = 0; i < a.size(); i++) {
            if (min >= a.get(i)) {
                min = a.get(i);
            }
        }
        return min;
    }

    /**
     * 计算的平均值
     * 
     * @return avg
     */

    public static int getAvg(List<Integer> list) {

        int sum = 0;
        int len = list.size();
        for (int i = 0; i < len; i++) {
            sum += list.get(i);
        }
        int result = 0;
        try {
            result = (int) (sum / len);
        } catch (ArithmeticException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    public static int getAvg2(List<Double> list) {

        double sum = 0.0;
        int len = list.size();
        for (int i = 0; i < len; i++) {
            sum += list.get(i);
        }
        return (int) (sum / len);
    }

    // 利用序列号 进行深拷贝
    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }

    // 数组转换成list
    public static List<Integer> changeToList(int[] a) {
        List<Integer> list = new ArrayList<>();
        if (a != null) {
            for (int i = 0; i < a.length; i++) {
                list.add(a[i]);
            }
        }

        return list;
    }
}
