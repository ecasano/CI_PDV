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
@Table(name = "sd_unidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SdUnidad.findAll", query = "SELECT s FROM SdUnidad s")
    , @NamedQuery(name = "SdUnidad.findById", query = "SELECT s FROM SdUnidad s WHERE s.id = :id")
    , @NamedQuery(name = "SdUnidad.findByNombre", query = "SELECT s FROM SdUnidad s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SdUnidad.findByDescripcion", query = "SELECT s FROM SdUnidad s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "SdUnidad.findByEstado", query = "SELECT s FROM SdUnidad s WHERE s.estado = :estado")})
public class SdUnidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Estado")
    private Integer estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidad")
    private Collection<SdProducto> sdProductoCollection;

    public SdUnidad() {
    }

    public SdUnidad(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public Collection<SdProducto> getSdProductoCollection() {
        return sdProductoCollection;
    }

    public void setSdProductoCollection(Collection<SdProducto> sdProductoCollection) {
        this.sdProductoCollection = sdProductoCollection;
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
        if (!(object instanceof SdUnidad)) {
            return false;
        }
        SdUnidad other = (SdUnidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pdv.model.SdUnidad[ id=" + id + " ]";
    }
    
}
