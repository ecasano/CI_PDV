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
 * @author ecasano
 */
@Entity
@Table(name = "sd_tipo_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SdTipoDocumento.findAll", query = "SELECT s FROM SdTipoDocumento s")
    , @NamedQuery(name = "SdTipoDocumento.findById", query = "SELECT s FROM SdTipoDocumento s WHERE s.id = :id")
    , @NamedQuery(name = "SdTipoDocumento.findByCodigoSUNAT", query = "SELECT s FROM SdTipoDocumento s WHERE s.codigoSUNAT = :codigoSUNAT")
    , @NamedQuery(name = "SdTipoDocumento.findByDescripcion", query = "SELECT s FROM SdTipoDocumento s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "SdTipoDocumento.findByEstado", query = "SELECT s FROM SdTipoDocumento s WHERE s.estado = :estado")})
public class SdTipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "CodigoSUNAT")
    private String codigoSUNAT;
    @Size(max = 255)
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Estado")
    private Integer estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDocumento")
    private Collection<SdVenta> sdVentaCollection;

    public SdTipoDocumento() {
    }

    public SdTipoDocumento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoSUNAT() {
        return codigoSUNAT;
    }

    public void setCodigoSUNAT(String codigoSUNAT) {
        this.codigoSUNAT = codigoSUNAT;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<SdVenta> getSdVentaCollection() {
        return sdVentaCollection;
    }

    public void setSdVentaCollection(Collection<SdVenta> sdVentaCollection) {
        this.sdVentaCollection = sdVentaCollection;
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
        if (!(object instanceof SdTipoDocumento)) {
            return false;
        }
        SdTipoDocumento other = (SdTipoDocumento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pdv.model.SdTipoDocumento[ id=" + id + " ]";
    }
    
}
