package cn.com.bestpay.portal.common.utils;


import org.apache.log4j.Logger;

import java.security.MessageDigest;

/**
 * @author lyz
 * 
 */
public class MD5 {
	private static Logger logger = Logger.getLogger(MD5.class);
	
	private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
			'a', 'b', 'c', 'd', 'e', 'f' };

	/**
	 * 传入参数：一个字节数组 传出参数：字节数组的MD5结果字符串
	 * @author lyz
	 * @param bytesSrc
	 * @return
	 */
	public static String getMD5(byte[] bytesSrc) {
		String result = "";
		// 用来将字节转换成16进制表示的字符
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(bytesSrc);
			// MD5的计算结果是一个128 位的长整数，字节表示是16个字节
			byte tmp[] = md.digest(); 
			// 每个字节用16进制表示，使用两个字符，表示成16进制需要32个字符
			char str[] = new char[16 * 2];
			// 表示转换结果中对应的字符位置
			int k = 0; 
			// 从第一个字节开始，对 MD5 的每一个字节
			for (int i = 0; i < 16; i++) { 
				// 转换成 16 进制字符的转换
				byte byte0 = tmp[i]; // 取第i个字节
				// 取字节中高 4 位的数字转换，>>> 为逻辑右移，将符号位一起右移
				str[k++] = HEX_DIGITS[byte0 >>> 4 & 0xf];
				// 取字节中低 4 位的数字转换
				str[k++] = HEX_DIGITS[byte0 & 0xf];
			}
			// 换后的结果转换为字符串
			result = new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return result;
	}
	public static String MD5Encode(String origin){
		String resultString = null;
			try {
				resultString=new String(origin);
				MessageDigest md = MessageDigest.getInstance("MD5");
				resultString=byteArrayToHexString(md.digest(resultString.getBytes("utf-8")));
			}catch (Exception ex){
				logger.error(ex);
			}
			return resultString;
		}
	public static String byteArrayToHexString(byte[] b){
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++){
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}
	private static String byteToHexString(byte b){
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
	private final static String[] hexDigits = {
	      "0", "1", "2", "3", "4", "5", "6", "7", 
	      "8", "9", "a", "b", "c", "d", "e", "f"}; 

	/**
	 * @see
	 * @author lyz
	 * @param args
	 */
	public static void main(String args[]) {
		// 计算"a"的MD5代码，应该为：0cc175b9c0f1b6a831c399e269772661
		String md5 = MD5.getMD5("".getBytes());
		System.out.println(md5);
	}

}
