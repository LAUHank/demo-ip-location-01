package cn.tledu.study;

import cn.tledu.util.IPUtil;

public class IPStudy {

	public static void test() {
		String ipStr = "127.0.0.1";
		long ipLong = IPUtil.stringToLong(ipStr);
		System.out.println(IPUtil.longToString(ipLong));
	}
	public static void main(String[] args) {
		test();
	}

}
