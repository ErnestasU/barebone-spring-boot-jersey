package spring.boot.jersey.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.boot.jersey.rest.model.Cat;
import spring.boot.jersey.route.CatRoute;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static spring.boot.jersey.route.RouteUtil.directUri;

@Path("cats")
@Api(value = "/api/cats", tags = "Cats API")
@Component
public class CatApi {

    @Autowired
    private ProducerTemplate producerTemplate;

    @GET
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "Such cat does not exist"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @ApiOperation(
            value = "",
            notes = "",
            response = Cat.class)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getCat(@PathParam("id") Long id) {
        return Response.ok(producerTemplate.requestBody(directUri(CatRoute.class, CatRoute.GET_CAT), id, Cat.class)).build();
    }
}
