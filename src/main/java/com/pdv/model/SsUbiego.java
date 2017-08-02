/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdv.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ecasano
 */
@Entity
@Table(name = "ss_ubiego")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SsUbiego.findAll", query = "SELECT s FROM SsUbiego s")
    , @NamedQuery(name = "SsUbiego.findById", query = "SELECT s FROM SsUbiego s WHERE s.id = :id")
    , @NamedQuery(name = "SsUbiego.findByDepartamento", query = "SELECT s FROM SsUbiego s WHERE s.departamento = :departamento")
    , @NamedQuery(name = "SsUbiego.findByProvincia", query = "SELECT s FROM SsUbiego s WHERE s.provincia = :provincia")
    , @NamedQuery(name = "SsUbiego.findByDistrito", query = "SELECT s FROM SsUbiego s WHERE s.distrito = :distrito")})
public class SsUbiego implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "Id")
    private String id;
    @Size(max = 45)
    @Column(name = "Departamento")
    private String departamento;
    @Size(max = 45)
    @Column(name = "Provincia")
    private String provincia;
    @Size(max = 45)
    @Column(name = "Distrito")
    private String distrito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUbiego")
    private Collection<SdPuntoVenta> sdPuntoVentaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUbigeo")
    private Collection<SdCliente> sdClienteCollection;

    public SsUbiego() {
    }

    public SsUbiego(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    @XmlTransient
    public Collection<SdPuntoVenta> getSdPuntoVentaCollection() {
        return sdPuntoVentaCollection;
    }

    public void setSdPuntoVentaCollection(Collection<SdPuntoVenta> sdPuntoVentaCollection) {
        this.sdPuntoVentaCollection = sdPuntoVentaCollection;
    }

    @XmlTransient
    public Collection<SdCliente> getSdClienteCollection() {
        return sdClienteCollection;
    }

    public void setSdClienteCollection(Collection<SdCliente> sdClienteCollection) {
        this.sdClienteCollection = sdClienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SsUbiego)) {
            return false;
        }
        SsUbiego other = (SsUbiego) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "com.pdv.model.SsUbiego[ id=" + id + " ]";
        return this.id;
    }
    
}
