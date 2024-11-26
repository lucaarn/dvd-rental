package de.pdbm.customer;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.logging.Logger;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
    @Inject
    CustomerService customerService;

    @Context
    UriInfo uriInfo;

    @GET
    public Response getAllCustomers(@QueryParam("start") int start, @QueryParam("amount") int amount) {
        return Response.ok(customerService.getAllCustomers(start, amount)).build();
    }

    @GET
    @Path("{id}")
    @Operation(description = "Find customer by Id")
    @APIResponse(
            responseCode = "200",
            description = "Customer with requested Id",
            content = @Content(schema = @Schema(name = "Customer", implementation = Customer.class))
    )
    @APIResponse(
            responseCode = "404",
            description = "Customer not found",
            content = @Content(schema = @Schema(name = "Customer", implementation = Customer.class))
    )
    public Response getCustomer(@PathParam("id") Integer id) {
        Customer customer = customerService.getCustomer(id);
        if (customer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(customer).build();
        }
    }

    @POST
    public Response createCustomer(Customer customer) {
        customerService.saveCustomer(customer);
        Link link = Link.fromUri(uriInfo.getPath() + "/" + customer.getId()).build();
        return Response.created(link.getUri()).build();
    }

    @PUT
    @Path("{id}")
    public Response putCustomer(@PathParam("id") Integer id, Customer customer) {
        boolean updated = customerService.putCustomer(id, customer);
        if (!updated) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.noContent().build();
        }
    }

    @PATCH
    @Path("{id}")
    public Response patchCustomer(@PathParam("id") Integer id, Customer customer) {
        boolean updated = customerService.patchCustomer(id, customer);
        if (!updated) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.noContent().build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteCustomer(@PathParam("id") Integer id) {
        boolean deleted = customerService.deleteCustomer(id);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.noContent().build();
        }
    }

    @PostConstruct
    public void init() {
        Logger.getLogger(CustomerService.class.getCanonicalName()).info("created customer");
    }
}
