package pojo;

/**
 * <ul>
 * 用户实体类
 * </ul>
 * <li>userName:用户姓名</li>
 * <li>password:密码</li>
 *
 */
public class User {

	private String userName;
	
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
