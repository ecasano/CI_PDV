/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdv.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ecasano
 */
@Entity
@Table(name = "sd_empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SdEmpresa.findAll", query = "SELECT s FROM SdEmpresa s")
    , @NamedQuery(name = "SdEmpresa.findById", query = "SELECT s FROM SdEmpresa s WHERE s.id = :id")
    , @NamedQuery(name = "SdEmpresa.findByRuc", query = "SELECT s FROM SdEmpresa s WHERE s.ruc = :ruc")
    , @NamedQuery(name = "SdEmpresa.findByRazonSocial", query = "SELECT s FROM SdEmpresa s WHERE s.razonSocial = :razonSocial")
    , @NamedQuery(name = "SdEmpresa.findByDireccion", query = "SELECT s FROM SdEmpresa s WHERE s.direccion = :direccion")
    , @NamedQuery(name = "SdEmpresa.findByTelefono", query = "SELECT s FROM SdEmpresa s WHERE s.telefono = :telefono")
    , @NamedQuery(name = "SdEmpresa.findByContacto", query = "SELECT s FROM SdEmpresa s WHERE s.contacto = :contacto")
    , @NamedQuery(name = "SdEmpresa.findByCorreo", query = "SELECT s FROM SdEmpresa s WHERE s.correo = :correo")
    , @NamedQuery(name = "SdEmpresa.findByFechaRegistro", query = "SELECT s FROM SdEmpresa s WHERE s.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "SdEmpresa.findByUsuarioRegistro", query = "SELECT s FROM SdEmpresa s WHERE s.usuarioRegistro = :usuarioRegistro")
    , @NamedQuery(name = "SdEmpresa.findByEstado", query = "SELECT s FROM SdEmpresa s WHERE s.estado = :estado")})
public class SdEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 11)
    @Column(name = "RUC")
    private String ruc;
    @Size(max = 255)
    @Column(name = "RazonSocial")
    private String razonSocial;
    @Size(max = 255)
    @Column(name = "Direccion")
    private String direccion;
    @Size(max = 45)
    @Column(name = "Telefono")
    private String telefono;
    @Size(max = 255)
    @Column(name = "Contacto")
    private String contacto;
    @Size(max = 255)
    @Column(name = "Correo")
    private String correo;
    @Column(name = "FechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 45)
    @Column(name = "UsuarioRegistro")
    private String usuarioRegistro;
    @Column(name = "Estado")
    private Integer estado;

    public SdEmpresa() {
    }

    public SdEmpresa(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SdEmpresa)) {
            return false;
        }
        SdEmpresa other = (SdEmpresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pdv.model.SdEmpresa[ id=" + id + " ]";
    }
    
}
