package com.zs.pms.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 权限表
 * @author Administrator
 *
 */

public class TPermission implements Serializable{
	private int id;
	private String pname;
	private int pid;
	private int lev;
	private int isleaf;
	private int sort;
	private String url;
	private String icon;
	
	//子权限集
	private List<TPermission> children=new ArrayList<TPermission>();
	//添加子权限的方法
	public void addChlid(TPermission per) {
		children.add(per);
	}
	
	
	public List<TPermission> getChildren() {
		return children;
	}
	public void setChildren(List<TPermission> children) {
		this.children = children;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getLev() {
		return lev;
	}
	public void setLev(int lev) {
		this.lev = lev;
	}
	public int getIsleaf() {
		return isleaf;
	}
	public void setIsleaf(int isleaf) {
		this.isleaf = isleaf;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
}
