package project.zalando.deusto.test;


import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import project.zalando.deusto.dao.UserDAO;
import project.zalando.deusto.vo.UserVO;


@WebService
public class Test {

	@WebMethod
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		

		// Inserción de un usuario			
		UserVO user = new UserVO();

		userDAO.deleteUser("anabrime@opendeusto.es");
		System.out.println("Usuario eliminado con exito.");	

		user.setEmail("anabrime@opendeusto.es");
		user.setPassword("hola");
		user.setUsername("adios");
		userDAO.insertUser(user);
		System.out.println("Usuario creado con exito.");	


		/*if(userDAO.findUser("anabrime@opendeusto.es") !=  null){

			System.out.println("Usuario: ");
			UserVO userAna = userDAO.findUser("anabrime@opendeusto.es");
			System.out.println("Email: " + userAna.getEmail());
			System.out.println("Username: " + userAna.getUsername());
			System.out.println("Password: " + userAna.getPassword());
		}else{ 
			System.out.println("No hay ningún usuario con ese email");
		}*/

		




	}	
}
