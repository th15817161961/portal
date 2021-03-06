package cn.com.bestpay.common.utils;

import java.math.BigDecimal;

public class NumberUtil {
    public static double round(double d, int i) {
        if (i < 0) {
            throw new RuntimeException("The scale must be a positive integer or zero");
        } else {
            BigDecimal bigDecimal = new BigDecimal(Double.toString(d));
            BigDecimal bigDecimal1 = new BigDecimal("1");
            return bigDecimal.divide(bigDecimal1, i, 4).doubleValue();
        }
    }

    public static String convertYuanString(long l) {
        String s = l + "";
        if (s.length() < 3)
            s = StringUtil.fillLeft(s, '0', 3);
        return s.substring(0, s.length() - 2) + "." + s.substring(s.length() - 2);
    }

    public static long convertFenLong(String s) {
        if (s == null || "".equals(s))
            return 0L;
        else
            return (long) round(Double.parseDouble(s) * 100D, 0);
    }

    public static long newConvertFenLong(String s) {
        if (s == null || "".equals(s)) {
            return 0L;
        } else {
            BigDecimal bigdecimal = (new BigDecimal(s)).multiply(new BigDecimal(100));
            return bigdecimal.longValue();
        }
    }

}
