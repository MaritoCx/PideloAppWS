/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author maritocx
 */
@Entity
@Table(name = "Especialidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especialidad.findAll", query = "SELECT e FROM Especialidad e")
    , @NamedQuery(name = "Especialidad.findByIdEsp", query = "SELECT e FROM Especialidad e WHERE e.idEsp = :idEsp")
    , @NamedQuery(name = "Especialidad.findByEspecialidad", query = "SELECT e FROM Especialidad e WHERE e.especialidad = :especialidad")
    , @NamedQuery(name = "Especialidad.findByPrecio", query = "SELECT e FROM Especialidad e WHERE e.precio = :precio")
    , @NamedQuery(name = "Especialidad.findByEstado", query = "SELECT e FROM Especialidad e WHERE e.estado = :estado")})
public class Especialidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEsp")
    private Integer idEsp;
    @Size(max = 50)
    @Column(name = "especialidad")
    private String especialidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Double precio;
    @Column(name = "estado")
    private Double estado;
    @OneToMany(mappedBy = "idEsp")
    private List<Producto> productoList;

    public Especialidad() {
    }

    public Especialidad(Integer idEsp) {
        this.idEsp = idEsp;
    }

    public Integer getIdEsp() {
        return idEsp;
    }

    public void setIdEsp(Integer idEsp) {
        this.idEsp = idEsp;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getEstado() {
        return estado;
    }

    public void setEstado(Double estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEsp != null ? idEsp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especialidad)) {
            return false;
        }
        Especialidad other = (Especialidad) object;
        if ((this.idEsp == null && other.idEsp != null) || (this.idEsp != null && !this.idEsp.equals(other.idEsp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Especialidad[ idEsp=" + idEsp + " ]";
    }
    
}
