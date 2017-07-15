/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdv.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ecasano
 */
@Entity
@Table(name = "sd_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SdProducto.findAll", query = "SELECT s FROM SdProducto s")
    , @NamedQuery(name = "SdProducto.findById", query = "SELECT s FROM SdProducto s WHERE s.id = :id")
    , @NamedQuery(name = "SdProducto.findByCodigo", query = "SELECT s FROM SdProducto s WHERE s.codigo = :codigo")
    , @NamedQuery(name = "SdProducto.findByNombre", query = "SELECT s FROM SdProducto s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SdProducto.findByFechaRegistro", query = "SELECT s FROM SdProducto s WHERE s.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "SdProducto.findByUsuarioRegistro", query = "SELECT s FROM SdProducto s WHERE s.usuarioRegistro = :usuarioRegistro")
    , @NamedQuery(name = "SdProducto.findByFechaActualizacion", query = "SELECT s FROM SdProducto s WHERE s.fechaActualizacion = :fechaActualizacion")
    , @NamedQuery(name = "SdProducto.findByUsuarioActualizacion", query = "SELECT s FROM SdProducto s WHERE s.usuarioActualizacion = :usuarioActualizacion")
    , @NamedQuery(name = "SdProducto.findByEstado", query = "SELECT s FROM SdProducto s WHERE s.estado = :estado")})
public class SdProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "Codigo")
    private String codigo;
    @Size(max = 255)
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "FechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 45)
    @Column(name = "UsuarioRegistro")
    private String usuarioRegistro;
    @Column(name = "FechaActualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Size(max = 45)
    @Column(name = "UsuarioActualizacion")
    private String usuarioActualizacion;
    @Column(name = "Estado")
    private Integer estado;
    @JoinColumn(name = "IdCategoria", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private SdCategoria idCategoria;
    @JoinColumn(name = "IdUnidad", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private SdUnidad idUnidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private Collection<SdVentaDetalle> sdVentaDetalleCollection;

    public SdProducto() {
    }

    public SdProducto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getUsuarioActualizacion() {
        return usuarioActualizacion;
    }

    public void setUsuarioActualizacion(String usuarioActualizacion) {
        this.usuarioActualizacion = usuarioActualizacion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public SdCategoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(SdCategoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public SdUnidad getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(SdUnidad idUnidad) {
        this.idUnidad = idUnidad;
    }

    @XmlTransient
    public Collection<SdVentaDetalle> getSdVentaDetalleCollection() {
        return sdVentaDetalleCollection;
    }

    public void setSdVentaDetalleCollection(Collection<SdVentaDetalle> sdVentaDetalleCollection) {
        this.sdVentaDetalleCollection = sdVentaDetalleCollection;
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
        if (!(object instanceof SdProducto)) {
            return false;
        }
        SdProducto other = (SdProducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pdv.model.SdProducto[ id=" + id + " ]";
    }
    
}
