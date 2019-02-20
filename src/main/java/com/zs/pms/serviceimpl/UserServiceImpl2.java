package com.zs.pms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.pms.dao.UserDao2;
import com.zs.pms.po.QueryUser;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService2;
@Service
public class UserServiceImpl2 implements UserService2{
UserDao2 dao;
	@Override
	public List<TUser> queryByCon(QueryUser query) {
		
		// TODO Auto-generated method stub
		return dao.queryByCont(query);
	}

}
