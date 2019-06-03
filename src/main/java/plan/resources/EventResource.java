package plan.resources;

import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import plan.api.Event;
import plan.db.EventDAO;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path ("events")
@Produces (MediaType.APPLICATION_JSON)
public class EventResource {
    private EventDAO eventDAO;

    // Initialize the EventDAO object in constructor
    public EventResource(EventDAO eventDAO)
    {
        this.eventDAO = eventDAO;
    }

    @GET
    @UnitOfWork
    @Path("{id}")
    public Optional<Event> getById(@PathParam("id") LongParam id) {
        return eventDAO.findById(id.get());
    }

    @POST
    @UnitOfWork
    public void create(Event event) {
        eventDAO.save(event);
    }

    @PUT

}
