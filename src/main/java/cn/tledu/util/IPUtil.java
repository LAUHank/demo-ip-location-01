package cn.tledu.util;

public class IPUtil {
	public static String longToString(long ipLong) {
		String ipStr = "";
		StringBuffer sb = new StringBuffer();
		long l1 = ipLong >>> 24 & 0x000000FF;
		sb.append(l1).append(".");//192.
		long l2 = ipLong >>> 16 & 0x000000FF;
		sb.append(l2).append(".");//192.168.
		long l3 = ipLong >>> 8 & 0x000000FF;
		sb.append(l3).append(".");//192.168.0.
		long l4 = ipLong & 0x000000FF;
		sb.append(l4);//192.168.0.1
		ipStr = sb.toString();
		return ipStr;
	}
	
	public static long stringToLong(String ipStr) {
		long ipLong = 0L;
		//192.168.0.1 切割为4部分
		String[] strarr = ipStr.split("\\.");
//		for (String str : strarr) {
//			long l = Long.valueOf(str);
//			System.out.println(l);
//		}
		if (strarr.length == 4) {
			ipLong += Long.valueOf(strarr[0]) << 24;
			ipLong += Long.valueOf(strarr[1]) << 16;
			ipLong += Long.valueOf(strarr[2]) << 8;
			ipLong += Long.valueOf(strarr[3]);
		}
		//把这4个数拼成1个数
		return ipLong;
	}
	

}
