/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.service;

import cafe.Invoice;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Giorgio
 */
@Stateless
@Path("invoice")
public class InvoiceFacadeREST extends AbstractFacade<Invoice> {

    @PersistenceContext(unitName = "RESTCafePU")
    private EntityManager em;

    public InvoiceFacadeREST() {
        super(Invoice.class);
    }
    
    @POST
    @Consumes({"application/json"})
    public String createOrder(Invoice entity) {
        super.create(entity);
        em.flush();
        return entity.getIdorder().toString();
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Invoice entity) {
        super.edit(entity);
        em.flush();
        System.out.println("Confirmed");
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Invoice find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
