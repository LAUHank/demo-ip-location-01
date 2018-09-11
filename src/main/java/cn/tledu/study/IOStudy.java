package cn.tledu.study;

import java.util.List;

import cn.tledu.pojo.IPLocPojo;
import cn.tledu.util.IOUtil;

public class IOStudy {
	public static void test() {
		String path = "ip_loc.txt";
		List<String> list = IOUtil.readLines(path);
		for (String str : list) {
			String[] strarr = str.split("\\t");
			if (strarr.length == 3) {
				IPLocPojo p = new IPLocPojo(strarr[0], strarr[1], strarr[2]);
				System.out.println(p);
			}
		}
	}
	public static void main(String[] args) {
		test();
	}

}
