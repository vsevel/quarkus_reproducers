package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @GET
    @Path("/jaxb")
    @Produces(MediaType.TEXT_PLAIN)
    public String jaxb() throws JAXBException {
        JAXBContext ctx = JAXBContext.newInstance("org.acme");
        return ctx.toString();
    }
}
