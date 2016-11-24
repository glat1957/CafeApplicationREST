/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Giorgio
 */
@Entity
@Table(name = "handle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Handle.findAll", query = "SELECT h FROM Handle h"),
    @NamedQuery(name = "Handle.findByIditem", query = "SELECT h FROM Handle h WHERE h.iditem = :iditem"),
    @NamedQuery(name = "Handle.findByProduct", query = "SELECT h FROM Handle h WHERE h.product = :product"),
    @NamedQuery(name = "Handle.findByProductname", query = "SELECT h FROM Handle h WHERE h.productname = :productname"),
    @NamedQuery(name = "Handle.findByProductcost", query = "SELECT h FROM Handle h WHERE h.productcost = :productcost"),
    @NamedQuery(name = "Handle.findByOrdernumber", query = "SELECT h FROM Handle h WHERE h.ordernumber = :ordernumber")})
public class Handle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Id
    @Column(name = "iditem")
    private int iditem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product")
    private int product;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "productname")
    private String productname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "productcost")
    private double productcost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ordernumber")
    private int ordernumber;

    public Handle() {
    }

    public int getIditem() {
        return iditem;
    }

    public void setIditem(int iditem) {
        this.iditem = iditem;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getProductcost() {
        return productcost;
    }

    public void setProductcost(double productcost) {
        this.productcost = productcost;
    }
    
    public int getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(int ordernumber) {
        this.ordernumber = ordernumber;
    }
    
}
