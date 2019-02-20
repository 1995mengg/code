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

@Controller//����һ��������
public class LoginController {
	@Autowired
	UserService us;
	@RequestMapping("/tologin.do")
	//ȥ��¼ҳ��
	public String tologin(){
		return "login";
	}
	@RequestMapping("/login.do")
	//ȥ��ҳ��
	public String login(QueryLogin login,HttpSession session,ModelMap model) {
		//1,������֤��
		String ocode=(String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		//���ɵ���֤���ҳ�����֤�벻���
		if (!ocode.equals(login.getChkcode())) {
			model.addAttribute("MSG", "��֤����������������");
			return "login";
		}
		//��֤�˺�����
		//װ������
		QueryUser query=new QueryUser();
		query.setLoginname(login.getUsername());
		//MD5����
		MD5 md5=new MD5();
		//����
		query.setPassword(md5.getMD5ofStr(login.getPassword()));
		//���ص�¼ҳ��
		List<TUser> users=us.queryByCon(query);
		//��¼ʧ��
		if (users==null||users.size()!=1) {
			model.addAttribute("MSG", "�û��������������");
			return "login";
		}
		//��½�ɹ�װsession
		session.setAttribute("CUSER", users.get(0));
		return "main";
		
	}
	
	
	
	@RequestMapping("/top.do")
	//����
	public String top(ModelMap model) {
		model.addAttribute("TODAY",DateUtil.getStrDate());
		return "top";
	}
	@RequestMapping("/left.do")
	//���˵�
	public String left(HttpSession session,ModelMap model) {
		//��õ�ǰ��¼�û�
		TUser cu=(TUser)session.getAttribute("CUSER");
		//��ø��û�Ȩ���б�
		List<TPermission> list1=us.queryByUid(cu.getId());
		//���ز˵�
		model.addAttribute("MENU", us.genMenu(list1));
		return "left";
		
	}
	@RequestMapping("/right")
	//�Ҳ�ҳ��
	public String right() {
		return "right";
		
	}

}
