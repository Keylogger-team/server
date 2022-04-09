package org.gs.exceptions;

import javax.ws.rs.core.Response;

public class KeyloggerException extends RuntimeException{
    public Response.Status response = Response.Status.INTERNAL_SERVER_ERROR;

    public KeyloggerException(String message){
        super(message);
    }
}
