package servletSample.jp.co.aforce.t.yo.dto;

public class UsersDto {
	// ユーザID
	private String userID;
	// パスワード
	private String password;
	//　ユーザ名
	private String userName;
	// 年齢
	private int age;
	
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	

}
