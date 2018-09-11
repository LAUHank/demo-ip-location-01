package cn.tledu.service;

import java.util.List;

import cn.tledu.pojo.IPLocPojo;
import cn.tledu.util.IPUtil;

public class DataSearcher {
	private static String path = "ip_loc.txt";//"ip_loc.txt";
	public static String getLocation(String ipStr) {
		String res = "未找到";
		long ipLong = IPUtil.stringToLong(ipStr);
		List<IPLocPojo> list = DataLoader.load(path);
		for (IPLocPojo pojo : list) {
			if (ipLong >= pojo.getStartIPLong() && ipLong <= pojo.getEndIPLong()) {
				res = pojo.getLocation();
			}
		}
		return res;
	}
	
	public static String getLocationByBinSearch(String ipStr) {
		String res = "未找到";
		//要有一个排序后的list
		List<IPLocPojo> list = DataLoader.sortedLoad(path, null);
//		for (IPLocPojo pojo : list) {
//			System.out.println(pojo);
//		}
		//调用二分查找算法
		long ipLong = IPUtil.stringToLong(ipStr);
		int index = binSearch(list, ipLong, 0, list.size() - 1);
		if (index > -1) {
			res = list.get(index).getLocation();
		}
		return res;
	}
	
	private static int binSearch(List<IPLocPojo> array, long key, int startPos, int endPos) {
		int res = -1;
		if (startPos <= endPos) {
			int mid = (startPos + endPos) / 2;
			IPLocPojo pojo = array.get(mid);
			if (key >= pojo.getStartIPLong() && key <= pojo.getEndIPLong()) {
				return mid;
			} else if (key < pojo.getStartIPLong()) {
				return binSearch(array, key, startPos, mid - 1);
			} else if (key > pojo.getEndIPLong()) {
				return binSearch(array, key, mid + 1, endPos);
			}
		}
		return res;
	}
	
}
