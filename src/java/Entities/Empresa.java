/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author maritocx
 */
@Entity
@Table(name = "Empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")
    , @NamedQuery(name = "Empresa.findByIdEmp", query = "SELECT e FROM Empresa e WHERE e.idEmp = :idEmp")
    , @NamedQuery(name = "Empresa.findByNombre", query = "SELECT e FROM Empresa e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Empresa.findByRepresentante", query = "SELECT e FROM Empresa e WHERE e.representante = :representante")
    , @NamedQuery(name = "Empresa.findByEmail", query = "SELECT e FROM Empresa e WHERE e.email = :email")
    , @NamedQuery(name = "Empresa.findByHoraI", query = "SELECT e FROM Empresa e WHERE e.horaI = :horaI")
    , @NamedQuery(name = "Empresa.findByHoraF", query = "SELECT e FROM Empresa e WHERE e.horaF = :horaF")
    , @NamedQuery(name = "Empresa.findByIdDep", query = "SELECT e FROM Empresa e WHERE e.idDep = :idDep")
    , @NamedQuery(name = "Empresa.findByImg", query = "SELECT e FROM Empresa e WHERE e.img = :img")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEmp")
    private Integer idEmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "representante")
    private String representante;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaI")
    @Temporal(TemporalType.TIME)
    private Date horaI;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaF")
    @Temporal(TemporalType.TIME)
    private Date horaF;
    @Column(name = "idDep")
    private Integer idDep;
    @Size(max = 300)
    @Column(name = "img")
    private String img;
    @JoinColumn(name = "idTipo", referencedColumnName = "idTipo")
    @ManyToOne(optional = false)
    private Tipo idTipo;
    @JoinColumn(name = "idUsu", referencedColumnName = "idUs")
    @ManyToOne
    private Usuario idUsu;
    @OneToMany(mappedBy = "idEmp")
    private List<Producto> productoList;

    public Empresa() {
    }

    public Empresa(Integer idEmp) {
        this.idEmp = idEmp;
    }

    public Empresa(Integer idEmp, String nombre, String representante, Date horaI, Date horaF) {
        this.idEmp = idEmp;
        this.nombre = nombre;
        this.representante = representante;
        this.horaI = horaI;
        this.horaF = horaF;
    }

    public Integer getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Integer idEmp) {
        this.idEmp = idEmp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHoraI() {
        return horaI;
    }

    public void setHoraI(Date horaI) {
        this.horaI = horaI;
    }

    public Date getHoraF() {
        return horaF;
    }

    public void setHoraF(Date horaF) {
        this.horaF = horaF;
    }

    public Integer getIdDep() {
        return idDep;
    }

    public void setIdDep(Integer idDep) {
        this.idDep = idDep;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Tipo getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Tipo idTipo) {
        this.idTipo = idTipo;
    }

    public Usuario getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Usuario idUsu) {
        this.idUsu = idUsu;
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
        hash += (idEmp != null ? idEmp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idEmp == null && other.idEmp != null) || (this.idEmp != null && !this.idEmp.equals(other.idEmp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Empresa[ idEmp=" + idEmp + " ]";
    }
    
}
