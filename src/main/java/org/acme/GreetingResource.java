package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.persistence.EntityManager;

import org.jboss.logging.Logger;


@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
@Path("/")
public class GreetingResource {

    
    private static final Logger LOGGER = Logger.getLogger(GreetingResource.class.getName());

    @Inject
    EntityManager entityManager;

    @GET
    @Path("fruits")
    public User[] getDefault() {
        return get();
    }

    @GET
    @Path("{tenant}/fruits")
    public User[] getTenant() {
        return get();
    }

    private User[] get() {
        return entityManager.createNamedQuery("Users.findAll", User.class)
                .getResultList().toArray(new User[0]);
    }

    @GET
    @Path("fruits/{id}")
    public User getSingleDefault(Integer id) {
        return findById(id);
    }
    @GET
    @Path("{tenant}/fruits/{id}")
    public User getSingleTenant(Integer id) {
        return findById(id);
    }

    private User findById(Integer id) {
        User entity = entityManager.find(User.class, id);
        if (entity == null) {
            throw new WebApplicationException("Fruit with id of " + id + " does not exist.", 404);
        }
        return entity;
    }
}