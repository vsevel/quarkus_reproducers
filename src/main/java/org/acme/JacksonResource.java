package org.acme;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import tools.jackson.databind.ObjectMapper;

@Path("/jackson")
public class JacksonResource {

    @Inject
    ObjectMapper objectMapper;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String jackson() {
        try {
            String json = "{\"myname\":\"my name\",\"validity\":true}";
            JacksonPojo deserialized = objectMapper.readValue(json, JacksonPojo.class);
            Log.info("deser " + deserialized);
            return "OK";
        } catch (Exception e) {
            Log.error("unable to deserialize json", e);
            return "KO: " + e;
        }
    }
}
