package com.zs.pms.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zs.pms.dao.UserDao;
import com.zs.pms.po.QueryLogin;
import com.zs.pms.po.QueryUser;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.utils.DateUtil;
import com.zs.pms.utils.MD5;

@Controller//这是一个控制器
public class LoginController {
	@Autowired
	UserService us;
	@RequestMapping("/tologin.do")
	//去登录页面
	public String tologin(){
		return "login";
	}
	@RequestMapping("/login.do")
	//去主页面
	public String login(QueryLogin login,HttpSession session,ModelMap model) {
		//1,生成验证码
		String ocode=(String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		//生成的验证码和页面的验证码不相等
		if (!ocode.equals(login.getChkcode())) {
			model.addAttribute("MSG", "验证码有误，请重新输入");
			return "login";
		}
		//验证账号密码
		//装在数据
		QueryUser query=new QueryUser();
		query.setLoginname(login.getUsername());
		//MD5加密
		MD5 md5=new MD5();
		//密码
		query.setPassword(md5.getMD5ofStr(login.getPassword()));
		//返回登录页面
		List<TUser> users=us.queryByCon(query);
		//登录失败
		if (users==null||users.size()!=1) {
			model.addAttribute("MSG", "用户名或者密码错误");
			return "login";
		}
		//登陆成功装session
		session.setAttribute("CUSER", users.get(0));
		return "main";
		
	}
	
	
	
	@RequestMapping("/top.do")
	//顶部
	public String top(ModelMap model) {
		model.addAttribute("TODAY",DateUtil.getStrDate());
		return "top";
	}
	@RequestMapping("/left.do")
	//左侧菜单
	public String left(HttpSession session,ModelMap model) {
		//获得当前登录用户
		TUser cu=(TUser)session.getAttribute("CUSER");
		//获得该用户权限列表
		List<TPermission> list1=us.queryByUid(cu.getId());
		//返回菜单
		model.addAttribute("MENU", us.genMenu(list1));
		return "left";
		
	}
	@RequestMapping("/right")
	//右侧页面
	public String right() {
		return "right";
		
	}

}
