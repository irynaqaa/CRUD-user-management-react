package com.example;

import java.util.logging.Logger;

public class EndpointController {
    private static final Logger LOGGER = Logger.getLogger(EndpointController.class.getName());

    public Response processRequest(Request request) {
        // Process the request using the business logic.
        try {
            // Simulate business logic processing
            Thread.sleep(1000);
            String result = "Processed request: " + request.getData();
            LOGGER.info(result);
            return new Response(result);
        } catch (InterruptedException e) {
            LOGGER.severe("Error processing request: " + e.getMessage());
            return new ErrorResponse("Failed to process request");
        }
    }
}

class Request {
    private String data;

    public Request(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}

class Response {
    private String result;

    public Response(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}

class ErrorResponse extends Response {
    public ErrorResponse(String error) {
        super(error);
    }
}