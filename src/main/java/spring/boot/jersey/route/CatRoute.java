package spring.boot.jersey.route;

import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

import static spring.boot.jersey.route.RouteUtil.direct;

@Component
public class CatRoute extends SpringRouteBuilder {

    public static final String GET_CAT = "GetCat";

    @Override
    public void configure() throws Exception {
        direct(this, GET_CAT).routeId(GET_CAT)
                                  .log("Getting cat by id ${body}")
                                  .bean("catService", "getCat");

    }
}
