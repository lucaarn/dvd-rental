package de.pdbm;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Einfache OpenAPI-Übung",
                contact = @Contact(name = "luca", email = "test@test.de"),
                version = "1.0"
        )
)
@ApplicationPath("api")
public class RestConfig extends Application {
}
