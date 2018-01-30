package project.zalando.deusto.resource;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import project.zalando.deusto.dao.UserDAO;
import project.zalando.deusto.vo.UserVO;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@Path("/user")
@Api(value = "user")
@Produces({ MediaType.APPLICATION_JSON })
public class UserResource {

	private static final ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");  

	private static final UserDAO userDAO = (UserDAO) context
			.getBean("userDAO");

	
	 @GET
	 @Produces({ MediaType.APPLICATION_JSON })
	 @Path("/{email}")
	 @Consumes({ MediaType.APPLICATION_JSON })
	  @ApiResponses(value = {
			  @ApiResponse(code = 500, message = "Error when connecting to server."),
	      @ApiResponse(code = 404, message = "No user found")})
	  @ApiOperation(value = "Returns a user.",
	      response = UserVO.class)
	  public UserVO getUser(@HeaderParam("email") String email, @HeaderParam("password") String password) {

	    return userDAO.findUser(email, password);
	  }


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insert")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Could't insert data")})
	@ApiOperation(value = "Insert users",
	response = Response.class)
	public Response insertUser(@ApiParam(required = true) UserVO userdata) {

		try {
			userDAO.insertUser(userdata);

			return Response.status(200).entity("OK").build();

		} catch (Exception e) {
			return Response.status(403).entity("Bad data supplied.").build();
		}

	}

	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "User not found")})
	@ApiOperation(value = "Delete users", response = Response.class)
	public Response dropUserByEmail(@ApiParam(required = true) String email) {
		try {
			userDAO.deleteUser(email);
			return Response.status(200).entity("OK").build();
		}catch (Exception e) {
			return Response.status(404).entity("No user found").build();
		}

	}

}
