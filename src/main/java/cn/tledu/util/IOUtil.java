package cn.tledu.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IOUtil {
	public static List<String> readLines(String path) {
		return readLines(path, "utf-8");
	}
	
	public static List<String> readLines(String path, String encoding) {
		List<String> list = new ArrayList<String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(IOUtil.class.getClassLoader().getResourceAsStream(path), encoding));
			String line = null;
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(br);
		}
		return list;
	}
}
