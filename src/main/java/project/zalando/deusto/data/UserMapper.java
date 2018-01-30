package project.zalando.deusto.data;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import project.zalando.deusto.vo.UserVO;

public interface UserMapper {

	@Select("SELECT USERNAME, EMAIL, PASSWORD FROM USER WHERE email = #{email} AND password = #{password}")
	UserVO getUser(@Param("email") String email, @Param("password") String password);

	void addUser(UserVO user);
	void dropUser(String email);
}