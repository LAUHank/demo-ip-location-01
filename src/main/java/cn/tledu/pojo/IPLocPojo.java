package cn.tledu.pojo;

import cn.tledu.util.IPUtil;

public class IPLocPojo implements Comparable<IPLocPojo> {
	private String startIP;
	private String endIP;
	private String location;
	private long startIPLong;
	private long endIPLong;
	public IPLocPojo(String startIP, String endIP, String location) {
		super();
		this.startIP = startIP;
		this.endIP = endIP;
		this.location = location;
		this.startIPLong = IPUtil.stringToLong(startIP);
		this.endIPLong = IPUtil.stringToLong(endIP);
	}
	public String getStartIP() {
		return startIP;
	}
	public void setStartIP(String startIP) {
		this.startIP = startIP;
	}
	public String getEndIP() {
		return endIP;
	}
	public void setEndIP(String endIP) {
		this.endIP = endIP;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getStartIPLong() {
		return startIPLong;
	}
	public void setStartIPLong(long startIPLong) {
		this.startIPLong = startIPLong;
	}
	public long getEndIPLong() {
		return endIPLong;
	}
	public void setEndIPLong(long endIPLong) {
		this.endIPLong = endIPLong;
	}
	@Override
	public String toString() {
		return "IPLocPojo [startIP=" + startIP + ", endIP=" + endIP
				+ ", location=" + location + ", startIPLong=" + startIPLong
				+ ", endIPLong=" + endIPLong + "]";
	}
	@Override
	public int compareTo(IPLocPojo o) {
		Long l1 = this.endIPLong;
		Long l2 = o.startIPLong;
		return l1.compareTo(l2);
	}
}
