/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.service;

import cafe.Handle;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Giorgio
 */
@Stateless
@Path("handle")
public class HandleFacadeREST extends AbstractFacade<Handle> {

    @PersistenceContext(unitName = "RESTCafePU")
    private EntityManager em;

    public HandleFacadeREST() {
        super(Handle.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Handle entity) {
        super.create(entity);
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Handle find(@PathParam("id") String id) {
        return super.find(id);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Handle> getItems(@QueryParam("order") int order) {
        return em.createNamedQuery("Handle.findByOrdernumber", Handle.class).setParameter("ordernumber", order).getResultList();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Handle> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
