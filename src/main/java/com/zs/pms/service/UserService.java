package com.zs.pms.service;

import java.util.List;

import com.zs.pms.po.QueryUser;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zscms.exception.AppException;

public interface UserService {
	//���Է���
	public void hello();
	
	//�����û�id���Ȩ���б�
	public List<TPermission> queryByUid(int id);
	
	//����ԭ��Ȩ������˵�
	public List<TPermission> genMenu(List<TPermission> pers);
	
	//����������ѯ
	public List<TUser> queryByCon(QueryUser query);
	//����ɾ��
	public void deleteByIds(int[] ids);
	//�޸�
	public void updateUser(TUser user);
	//����
	public int insertUser(TUser user) throws AppException;
	//��ҳ��¼
	public List<TUser> queryByPage(int page,QueryUser query);
	//������ҳ��
	public int queryPageCont(QueryUser query);
	//ɾ��
	public void deleteById(int id);
	//���������޸�
	public TUser queryById(int id);
	
	
}
