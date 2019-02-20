package com.zs.pms.service;

import java.util.List;

import com.zs.pms.po.QueryUser;
import com.zs.pms.po.TUser;

public interface UserService2 {
	public List<TUser> queryByCon(QueryUser query);

}
