package org.acme;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
@JsonIgnoreProperties(ignoreUnknown = true)
public class JacksonPojo {

    @JsonProperty("myname")
    private String name;
    private boolean validity;

    public String getName() {
        return name;
    }

    public boolean isValidity() {
        return validity;
    }

    // uncommenting this setter fixes the issue in native mode
//    public void setValidity(boolean validity) {
//        this.validity = validity;
//    }

    @Override
    public String toString() {
        return "JacksonPojo{" +
                "name='" + name + '\'' +
                ", validity=" + validity +
                '}';
    }
}
