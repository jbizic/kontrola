package org.RestBack.RestBack;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.RestBack.bean.Employee;
import org.RestBack.hibernate.EmployeeDAO;

/**
 * @author Jovan
 *
 */
@Path("myresource")
public class MyResource {

	@POST
	public Response save(@FormParam("name") String name, @FormParam("jobDescription") String jd,
			@FormParam("monthSalary") String ms, @FormParam("parent") String parent) throws URISyntaxException {
		Employee parentEmp = EmployeeDAO.getEmpByName(parent);
		if (name.equals(null)) {
			return Response.noContent().build();
		} else {
			Employee em = new Employee();
			em.setName(name);
			em.setJobDescription(jd);
			em.setMonthSalary(Double.parseDouble(ms));
			em.setParentId(parentEmp != null ? parentEmp.getId() : null);
			if (EmployeeDAO.saveUser(em)) {
				URI location = new URI("http://localhost:8080/hierarchy/second.jsp");
				return Response.temporaryRedirect(location).build();
			} else {
				return Response.accepted().build();
			}
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getEmp")
	public Response getAllEployees() {
		HashMap<String, Object> json = null;
		try {
			return Response.ok().entity(EmployeeDAO.getUsers()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.ok().entity(json).build();
		}
	}
}
