package de.pdbm;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/config")
public class ConfigTests {
    @Inject
    @ConfigProperty(name = "my.config.variable", defaultValue = "some value")
    private String myConfigVariable;

    @GET
    public String getConfigValue() {
        return "Config-Wert: " + myConfigVariable;
    }
}
