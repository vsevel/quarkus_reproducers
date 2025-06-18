package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.foobar.Bar;
import org.acme.foobar.Foo;
import org.acme.foobar.IGreetingServerResource;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Path("/hello")
public class GreetingResource {

    @Inject
    @RestClient
    IGreetingServerResource other;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/other")
    public String other() {
        List<Foo> list = List.of(new Foo("myname", "mydescription")).stream().toList();
        Bar bar = new Bar(list);
        other.bar(bar);
        return "Bar from server OK";
    }

    @POST
    @Path("/bar")
    public String bar(Bar bar) {
        return "OK received Bar " + bar;
    }
}
