package org.acme.foobar;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8081/hello")
public interface IGreetingServerResource {

    @POST
    //    @Produces(MediaType.APPLICATION_JSON)
    //    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/bar")
    String bar(Bar bar);

}
