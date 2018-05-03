/**
 * 
 */
package org.RestBack.test;

import static org.junit.Assert.assertNotEquals;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import junit.framework.TestCase;

/**
 * @author Jovan
 *
 */
public class MyResourceTestGet extends TestCase {

    Client cl;
    @Before
    public void setUp() {
        cl = ClientBuilder.newClient();
    } 
    @Test
    public void testGetAllEployees() throws IOException { 
        JsonNode resJson = null; 
        try { 
            WebTarget wt = cl.target("http://localhost:8080/RestBack/webapi/myresource/getEmp");
            String res = wt.request().get().readEntity(String.class);
            resJson = new ObjectMapper().readTree(res);
        } catch(Exception ex){
            fail("whatever happened here");
        } 
        assertNotEquals(resJson, null); 
        /* Is json an array */
        assertTrue(resJson.isArray()); 
        /* If array has members, then, check if members are structurally valid */
        ArrayNode arr = (ArrayNode)resJson;
        for(JsonNode node : arr){
            assertTrue(node.has("id"));
            assertTrue(node.has("name"));
            assertTrue(node.has("jobDescription"));
            assertTrue(node.has("monthSalary"));
        } 
        System.out.println(resJson); 
    } 
}
