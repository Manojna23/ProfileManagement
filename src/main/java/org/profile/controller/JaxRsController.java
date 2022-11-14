package org.profile.controller;

import io.swagger.annotations.Api;
import org.profile.model.Profile;
import org.profile.service.ProfileManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Path("/path")
public class JaxRsController {

    @Autowired
    ProfileManagementService profileManagementService;

    @GET
    public String getString() {
        return "Hello World from Jax-RS!";
    }

    @GET
    @Path("/{type}")
    public String getHello(@PathParam("type") String type) {
        return type;
    }

    @GET
    @Path("/profiles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profile> getProfiles() {
//        return Response.ok(profileManagementService.getAllProfiles()).build();
        return profileManagementService.getAllProfiles();
    }

    @POST
    @Path("/profiles")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addProfile(Profile profile) {
        return profileManagementService.addProfile(profile);
    }

    @PUT
    @Path("/profiles/{profileId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateProfile(@PathParam("profileId") int profileId, String designation) {
        return Response.ok(profileManagementService.updateProfile(profileId, designation)).build();
    }
}
