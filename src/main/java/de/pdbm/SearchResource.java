package de.pdbm;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.Random;

@Path("search")
public class SearchResource {
    @Inject
    SearchService searchService;

    @GET
    public String search() {
        return searchService.searchDuckDuckGo();
    }

    @GET
    @Path("random")
    @Retry(maxRetries = 4, delay = 1000)
    public Response retry() {
        System.out.println("entered retry");
        if (new Random().nextInt(4) == 0) {
            return Response.ok("top").build();
        } else {
            throw new RuntimeException("flop");
        }
    }
}
