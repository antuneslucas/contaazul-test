package br.com.contaazul.resource;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.contaazul.domain.Robot;
import br.com.contaazul.service.RobotNavigator;

@Path("/mars")
public class MarsResource {

    private static final Logger LOG = LoggerFactory.getLogger(MarsResource.class);

    @Inject private RobotNavigator robotNavigator;

    @POST
    @Path("/{commands}")
    @Produces("text/plain")
    public Response moveRobot(@PathParam("commands") String commands) {
        LOG.debug("Commands received: {}", commands);
        try {
            Robot robot = robotNavigator.navigate(new Robot(), commands);

            return Response.status(200).entity(robot.toString()).build();

        } catch (Exception e) {
            LOG.error("Something went wrong trying to navigate with robot", e);
            return Response.status(400).entity("400 Bad Request").build();
        }
    }

}
