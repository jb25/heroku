package project.zalando.deusto.impl;

import project.zalando.deusto.dao.UserDAO;
import project.zalando.deusto.data.UserMapper;
import project.zalando.deusto.vo.UserVO;

public class UserDAOImpl implements UserDAO {

	private UserMapper userMapper;

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public UserVO  findUser(String email, String password) {
		return userMapper.getUser(email, password);
	}

	public void insertUser(UserVO user) {
		 userMapper.addUser(user);

	}

	public void deleteUser(String email) {
		userMapper.dropUser(email);
	}

}
