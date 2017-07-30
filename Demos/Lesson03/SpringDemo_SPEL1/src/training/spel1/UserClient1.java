package training.spel1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserClient1 {

	public static void main(String args[]) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("userbean.xml");
		UserBean user = (UserBean) ctx.getBean("u");
		//user.setUsername("Chennai");
		System.out.println(user.getUserId());
		System.out.println(user.getUsername());	
		System.out.println(user.getPassword());
	}
}
