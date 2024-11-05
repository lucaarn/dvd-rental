package de.pdbm;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;

import java.time.LocalDateTime;

@RequestScoped
public class SearchService {
    @Timeout(100)
    @Fallback(fallbackMethod = "searchGoogle")
    public String searchDuckDuckGo() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://duckduckgo.com/?q=microprofile");
        System.out.println(LocalDateTime.now());
        String answer = target.request(MediaType.TEXT_HTML).get(String.class);
        System.out.println(LocalDateTime.now());
        return answer + "\n from DuckDuckGo";
    }

    public String searchGoogle() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://www.google.com/search?q=microprofile");
        System.out.println(LocalDateTime.now());
        String answer = target.request(MediaType.TEXT_HTML).get(String.class);
        System.out.println(LocalDateTime.now());
        return answer + "\n from Google";
    }
}
