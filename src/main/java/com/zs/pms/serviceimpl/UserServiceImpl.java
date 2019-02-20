package com.zs.pms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zs.pms.dao.UserDao;
import com.zs.pms.po.QueryUser;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.utils.Constants;
import com.zs.pms.utils.MD5;
import com.zscms.exception.AppException;
@Service
@Transactional //��Ҫ����ҵ����������
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao dao;

	public void hello() {
		// TODO Auto-generated method stub
		System.out.println("hello Spring");
	}

	public List<TPermission> queryByUid(int id) {
		// TODO Auto-generated method stub
		return dao.queryByUid(id);
	}

	public List<TPermission> genMenu(List<TPermission> pers) {
		// TODO Auto-generated method stub
		//����������
		List<TPermission> list=new ArrayList<TPermission>();
		//��������Ȩ���б�
		for(TPermission per:pers) {
			//�ҵ�һ���˵�
			if(per.getLev()==1) {
				//�ҵ�һ���˵��µĶ����˵�
				for(TPermission per2:pers) {
					if(per2.getPid()==per.getId()) {
						per.addChlid(per2);
					}
				}
				//�ӵ��¼�����
				list.add(per);
			}
		}
		
		return list;
	}

	public List<TUser> queryByCon(QueryUser query) {
		// TODO Auto-generated method stub
		
		return dao.queryByCon(query);
	
	}
	
	public void deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		dao.deleteByIds(ids);
	}

	@Override
	public void updateUser(TUser user) {
		// TODO Auto-generated method stub
		dao.updateUser(user);
	}

	@Override
	//�÷���ֻҪ���쳣�ͻع�����
	@Transactional(rollbackFor=Exception.class)
	public int insertUser(TUser user) throws AppException {
		//ģ��ҵ���쳣
		if ("admin".equals(user.getLoginname())) {
			throw new AppException(1003, "��¼������Ϊadmin");
		}
		MD5 md5=new MD5();
		user.setPassword(md5.getMD5ofStr(user.getPassword()));
		
		// TODO Auto-generated method stub
		dao.insertUser(user);
//		int a=1/0;//�����쳣
//		dao.insertUser(user);
		return user.getId();
	}

	@Override
	/**
	 * ��÷�ҳ��¼page
	 * ��ǰҳquery
	 * ��ѯ����
	 */
	public List<TUser> queryByPage(int page, QueryUser query) {
		// TODO Auto-generated method stub
		//ͨ����ǰҳ��������ʼ���ͽ�ֹ��
		//��ʼ����һ��ʼ
		int start=(page-1)*Constants.PAGECONT+1;
		//��ֹ��
		int end=page*Constants.PAGECONT;
		
		query.setStart(start);
		query.setEnd(end);
		
		return dao.queryByPage(query);
	}

	@Override
	/**
	 * ������ҳ��
	 */
	public int queryPageCont(QueryUser query) {
		// TODO Auto-generated method stub
		//ͨ��������������ҳ��
		int cont=dao.queryCount(query);
		//������
		if (cont%Constants.PAGECONT==0) {
			return cont/Constants.PAGECONT;
		}else {
			return cont/Constants.PAGECONT+1;
		}
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
		
	}

	@Override
	public TUser queryById(int id) {
		// TODO Auto-generated method stub
		return dao.queryById(id);
	}

	
	
	
}
