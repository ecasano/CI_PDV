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
@Table(name = "sd_moneda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SdMoneda.findAll", query = "SELECT s FROM SdMoneda s")
    , @NamedQuery(name = "SdMoneda.findById", query = "SELECT s FROM SdMoneda s WHERE s.id = :id")
    , @NamedQuery(name = "SdMoneda.findByNombre", query = "SELECT s FROM SdMoneda s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SdMoneda.findBySimbolo", query = "SELECT s FROM SdMoneda s WHERE s.simbolo = :simbolo")
    , @NamedQuery(name = "SdMoneda.findByAbreviatura", query = "SELECT s FROM SdMoneda s WHERE s.abreviatura = :abreviatura")
    , @NamedQuery(name = "SdMoneda.findByEstado", query = "SELECT s FROM SdMoneda s WHERE s.estado = :estado")})
public class SdMoneda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "Simbolo")
    private String simbolo;
    @Size(max = 45)
    @Column(name = "Abreviatura")
    private String abreviatura;
    @Column(name = "Estado")
    private Integer estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMoneda")
    private Collection<SdTipoCambio> sdTipoCambioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMoneda")
    private Collection<SdVenta> sdVentaCollection;

    public SdMoneda() {
    }

    public SdMoneda(Integer id) {
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

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<SdTipoCambio> getSdTipoCambioCollection() {
        return sdTipoCambioCollection;
    }

    public void setSdTipoCambioCollection(Collection<SdTipoCambio> sdTipoCambioCollection) {
        this.sdTipoCambioCollection = sdTipoCambioCollection;
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
        if (!(object instanceof SdMoneda)) {
            return false;
        }
        SdMoneda other = (SdMoneda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "com.pdv.model.SdMoneda[ id=" + id + " ]";
        return this.nombre;
    }
    
}
