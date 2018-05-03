/**
 * 
 */
package org.RestBack.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.net.URISyntaxException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Jovan
 *
 */
public class MyResourceTestPost {
    Client cl;
    @Before
    public void setUp() {
        cl = ClientBuilder.newClient();
    } 
	@Test
	public void testPost() throws URISyntaxException {
		Form form = null;
		WebTarget wt = null;
        try { 
            wt = cl.target("http://localhost:8080/RestBack/webapi/myresource");
    		form = new Form();
    		form.param("name", "gile");
    		form.param("jobDescription", "prof");
    		form.param("monthSalary", "123");
    		wt.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));
        } catch(Exception ex){
            fail("whatever happened here");
        } 
        assertNotEquals(wt, null); 
		
	}

}
