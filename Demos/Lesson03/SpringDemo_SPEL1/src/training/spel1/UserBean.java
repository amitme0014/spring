package training.spel1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("user")
public class UserBean {
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Value("#{userprops.userid}")
	private int userId;
	@Value("#{userprops.username}")
	//@Value("majrul")
	private String username;
	
	@Value("#{userprops.password}")
	//@Value("majrul123")
	private String password;
		
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
