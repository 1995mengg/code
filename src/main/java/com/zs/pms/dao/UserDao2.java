package com.zs.pms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.zs.pms.po.QueryUser;
import com.zs.pms.po.TUser;

/**
 * Ê¹ÓÃ×¢½â
 * @author Administrator
 *
 */

@Repository
public interface UserDao2 {
	
	@Select("select * from tuser where sex=#{sex}")
	public List<TUser> queryByCont(QueryUser query);
	

}
