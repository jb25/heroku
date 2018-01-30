package project.zalando.deusto.dao;

import project.zalando.deusto.vo.UserVO;

public interface UserDAO {

	UserVO findUser(String email, String password);
	void insertUser(UserVO user);	
	void deleteUser(String email);
	
}
