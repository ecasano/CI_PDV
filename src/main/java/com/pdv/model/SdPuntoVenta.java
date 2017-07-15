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
@Table(name = "sd_punto_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SdPuntoVenta.findAll", query = "SELECT s FROM SdPuntoVenta s")
    , @NamedQuery(name = "SdPuntoVenta.findById", query = "SELECT s FROM SdPuntoVenta s WHERE s.id = :id")
    , @NamedQuery(name = "SdPuntoVenta.findByCodigo", query = "SELECT s FROM SdPuntoVenta s WHERE s.codigo = :codigo")
    , @NamedQuery(name = "SdPuntoVenta.findByDescripcion", query = "SELECT s FROM SdPuntoVenta s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "SdPuntoVenta.findByDireccion", query = "SELECT s FROM SdPuntoVenta s WHERE s.direccion = :direccion")
    , @NamedQuery(name = "SdPuntoVenta.findByUbigeo", query = "SELECT s FROM SdPuntoVenta s WHERE s.ubigeo = :ubigeo")
    , @NamedQuery(name = "SdPuntoVenta.findByIdEmpresa", query = "SELECT s FROM SdPuntoVenta s WHERE s.idEmpresa = :idEmpresa")
    , @NamedQuery(name = "SdPuntoVenta.findByFechaRegistro", query = "SELECT s FROM SdPuntoVenta s WHERE s.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "SdPuntoVenta.findByUsuarioRegistro", query = "SELECT s FROM SdPuntoVenta s WHERE s.usuarioRegistro = :usuarioRegistro")
    , @NamedQuery(name = "SdPuntoVenta.findByEstado", query = "SELECT s FROM SdPuntoVenta s WHERE s.estado = :estado")})
public class SdPuntoVenta implements Serializable {

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
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 255)
    @Column(name = "Direccion")
    private String direccion;
    @Size(max = 6)
    @Column(name = "Ubigeo")
    private String ubigeo;
    @Column(name = "IdEmpresa")
    private Integer idEmpresa;
    @Column(name = "FechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 45)
    @Column(name = "UsuarioRegistro")
    private String usuarioRegistro;
    @Column(name = "Estado")
    private Integer estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPuntoVenta")
    private Collection<SdVenta> sdVentaCollection;

    public SdPuntoVenta() {
    }

    public SdPuntoVenta(Integer id) {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
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
        if (!(object instanceof SdPuntoVenta)) {
            return false;
        }
        SdPuntoVenta other = (SdPuntoVenta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pdv.model.SdPuntoVenta[ id=" + id + " ]";
    }
    
}
