package com.smart.api.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class DiscoveryResource {

    @GET
    public Map<String, Object> getApiInfo() {
        Map<String, Object> response = new HashMap<>();
        Map<String, String> links = new HashMap<>();

        links.put("rooms", "/api/v1/rooms");
        links.put("sensors", "/api/v1/sensors");

        response.put("name", "Smart Campus API");
        response.put("version", "v1");
        response.put("contact", "admin@smartcampus.com");
        response.put("links", links);

        return response;
    }
}