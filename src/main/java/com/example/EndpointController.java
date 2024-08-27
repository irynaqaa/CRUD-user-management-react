package com.example;

import java.util.logging.Logger;

public class EndpointController {
    private static final Logger LOGGER = Logger.getLogger(EndpointController.class.getName());

    public Response processRequest(Request request) {
        LOGGER.info("Processing request: " + request);
        // Business logic implementation
        String requestBody = request.getBody();
        String responseBody = processRequestBody(requestBody);
        return new Response(responseBody);
    }

    private String processRequestBody(String requestBody) {
        // Add your business logic to process the request body
        // For example, let's assume we need to convert the request body to uppercase
        return requestBody.toUpperCase();
    }
}