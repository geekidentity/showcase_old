package com.justdoit.showcase.system.util;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

/**
 * 获取系统运行的操作系统相关信息，
 * 使用SIGAR 获取系统信息，SIGAR 底层是C 实现的，所以要相应的库文件。
 * @see https://support.hyperic.com/display/SIGAR/Home
 * 
 * @author 侯法超
 * @date 2016年7月7日  下午8:25:48
 */
public class OSUtil {
	private static Sigar sigar = new Sigar();
	
	/**
	 * 获取系统总的CPU利用率
	 * @return
	 * @throws SigarException
	 */
	public static String getCpuRate() throws SigarException {
		double rate = sigar.getCpuPerc().getCombined();
		return String.format("%.2f", rate*100);
	}
	
	/**
	 * 获取系统总的内存利用率
	 * @return
	 * @throws SigarException 
	 */
	public static String getMemRate() throws SigarException {
		Mem mem = sigar.getMem();
		double total = mem.getTotal();
		double usage = mem.getUsed();
		double rate = usage/total;
		return String.format("%.2f", rate);
	}
	
	/**
	 * 获取系统总的逻辑CPU数量
	 * @return
	 * @throws SigarException
	 */
	public static int getCpuCount() throws SigarException {
		return sigar.getCpuList().length;
	}
	
	public static String getOSName() throws SigarException {
		return sigar.getNetInfo().getHostName();
	}
	
	
	public static void main(String[] args) throws SigarException {
		System.out.println(getOSName());
		System.out.println(OperatingSystem.getInstance().getName());;
	}
}
