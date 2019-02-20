package com.zs.pms.dao;

import java.util.List;

import com.zs.pms.po.QueryUser;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;

public interface UserDao {
	//�����û�id���Ȩ���б�
	public List<TPermission> queryByUid(int id);
	//����������ѯ
	public List<TUser> queryByCon(QueryUser query);
	//����ɾ��
	public void deleteByIds(int [] ids);
	//�޸�
	public void updateUser(TUser user);
	//����
	public int insertUser(TUser user);
	//��ҳ��ѯ
	public List<TUser> queryByPage(QueryUser query);
	//���������
	public int queryCount(QueryUser query);
	//ɾ��
	public void deleteById(int id);
	//�޸� ����������ȡ
	public TUser queryById(int id);
	
	

}
