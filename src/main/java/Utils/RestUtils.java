package Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class RestUtils implements Filter {

    private static final Logger logger = LogManager.getLogger(RestUtils.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {
        // Adding a custom header
        requestSpec.header("Accept", "application/json");

        // Logging the request details
        logger.info("Request Method: " + requestSpec.getMethod());
        logger.info("Request URI: " + requestSpec.getURI());
        logger.info("Request Headers: " + requestSpec.getHeaders());
        logger.info("Request Body: " + requestSpec.getBody());

        // Proceed to the next filter in the chain
        Response response = ctx.next(requestSpec, responseSpec);

        // Logging the response details
        logger.info("Response Status: " + response.getStatusCode());
        logger.info("Response Body: " + response.getBody().asString());

        return response; // Return the response
    }
}
