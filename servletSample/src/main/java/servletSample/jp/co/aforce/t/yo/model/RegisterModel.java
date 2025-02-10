package servletSample.jp.co.aforce.t.yo.model;

import servletSample.jp.co.aforce.t.yo.dao.RegisterDao;
import servletSample.jp.co.aforce.t.yo.dto.UsersDto;

public class RegisterModel {
	public boolean newRegister(UsersDto user) {
		RegisterDao dao = new RegisterDao();
		boolean isSuccess = dao.insertUser(user);
		
		return isSuccess;
	}
}
