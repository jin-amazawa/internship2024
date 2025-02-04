package servletSample.jp.co.aforce.t.yo.model;

import servletSample.jp.co.aforce.t.yo.dao.UsersDao;
import servletSample.jp.co.aforce.t.yo.dto.UsersDto;

public class SigninModel {
	public UsersDto checkExistsUser(String id, String password) {
		UsersDao dao = new UsersDao();
		UsersDto result = dao.selectByIdAndPassword(id, password);
		
		return result;
		
	}
}
