import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.dao.UserDao2;
import com.zs.pms.po.QueryUser;
import com.zs.pms.service.UserService2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class TestUserService2 {
	@Autowired
	UserService2 us2;
	@Test
	public void testQuery() {
		QueryUser query=new QueryUser();
		query.setLoginname("");
		System.out.println(us2.queryByCon(query).size());
	}

}
