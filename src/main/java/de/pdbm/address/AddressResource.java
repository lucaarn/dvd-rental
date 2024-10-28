package de.pdbm.address;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/addresses")
@Produces(MediaType.APPLICATION_JSON)
public class AddressResource {
    @Inject
    AddressService addressService;

    @GET
    public Response getAllAddresses(@QueryParam("start") int start, @QueryParam("amount") int amount) {
        return Response.ok(addressService.getAllAddresses(start, amount)).build();
    }

    @GET
    @Path("{id}")
    public Response getAddress(@PathParam("id") Integer id) {
        Address address = addressService.getAddress(id);
        if (address == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(address).build();
        }
    }
}
