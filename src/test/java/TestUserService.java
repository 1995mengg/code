import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.po.QueryUser;
import com.zs.pms.po.TDep;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class TestUserService {
	@Autowired
	UserService us;
	
	public void testHello() {
		us.hello();
	}
	
	public void testlogin() {
		for(TPermission per:us.queryByUid(3084)) {
			System.out.println(per.getPname());
		}
	}
	
	public void testlogin1() {
		List<TPermission> list1=us.queryByUid(3084);
		for(TPermission per:list1) {
			System.out.println(per.getPname());
		}
		System.out.println("------------------------");
		for(TPermission per1:us.genMenu(list1)) {
			//一级权限
			System.out.println(per1.getPname());
			for(TPermission per2:per1.getChildren()){
				System.out.println("----"+per2.getPname());
			}
		}
	}
	
	public void testQuery() {
		//创建查询对象
		QueryUser query=new QueryUser();
		query.setLoginname("lvbu");
		query.setPassword("1234");
		System.out.println(us.queryByCon(query).size());
	}
	
	
	
	public void testDelete() {
		int[] ids={1008,1009,1010};
		us.deleteByIds(ids);
	}
	
	public void testupdate() {
		
		TUser user=new TUser();
		user.setId(3084);
		user.setEnable(-1);
		user.setUpdator(3086);
		user.setUpdatime(new java.util.Date());
		us.updateUser(user);
		
	}
	@Test
	public void testinsert() {
		TUser user=new TUser();
		
		user.setLoginname("请问过后啊啊");
		user.setPassword("1234");
		user.setSex("女");
		user.setRealname("主程序额");
		TDep dep=new TDep();
		dep.setId(4);
		user.setDept(dep);
		user.setEmail("3242dr@3456.com");
		user.setBirthday(new java.util.Date());
		user.setIsenabled(1);
		user.setPic("ksdad");
		user.setCreator(3086);
		user.setCreatime(new java.util.Date());
		
	}
	
	public void testQuery1() {
		//创建查询对象
		QueryUser query=new QueryUser();
		for(TUser user:us.queryByPage(1, query)) {
			System.out.println(user.getId()+"-"+user.getLoginname());
		}
		System.out.println("共"+us.queryPageCont(query)+"页");
		
	}
}
