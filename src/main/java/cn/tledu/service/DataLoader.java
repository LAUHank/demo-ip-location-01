package cn.tledu.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cn.tledu.pojo.IPLocPojo;
import cn.tledu.util.IOUtil;

public class DataLoader {
	public static List<IPLocPojo> load(String path) {
		List<IPLocPojo> list = new ArrayList<IPLocPojo>();
//		String path = "ip_loc.txt";
		List<String> strList = IOUtil.readLines(path);
		for (String str : strList) {
			String[] strarr = str.split("\\t");
			if (strarr.length == 3) {
				IPLocPojo p = new IPLocPojo(strarr[0], strarr[1], strarr[2]);
				list.add(p);
			}
		}
		return list;
	}
	
	public static List<IPLocPojo> sortedLoad(String path, Comparator<IPLocPojo> comp) {
		List<IPLocPojo> list = load(path);
		if (comp != null) {
			Collections.sort(list, comp);
		} else {
			Collections.sort(list);
		}
		return list;
	}
}
