package com.zs.pms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zs.pms.po.TDep;


public interface DepService {
	public List<TDep> queryByPid(int pid);
}
