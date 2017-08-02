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
@Table(name = "sd_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SdCliente.findAll", query = "SELECT s FROM SdCliente s")
    , @NamedQuery(name = "SdCliente.findById", query = "SELECT s FROM SdCliente s WHERE s.id = :id")
    , @NamedQuery(name = "SdCliente.findByTipoDocumento", query = "SELECT s FROM SdCliente s WHERE s.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "SdCliente.findByNroDocumento", query = "SELECT s FROM SdCliente s WHERE s.nroDocumento = :nroDocumento")
    , @NamedQuery(name = "SdCliente.findByNombre", query = "SELECT s FROM SdCliente s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SdCliente.findByDireccion", query = "SELECT s FROM SdCliente s WHERE s.direccion = :direccion")
    , @NamedQuery(name = "SdCliente.findByCorreo", query = "SELECT s FROM SdCliente s WHERE s.correo = :correo")
    , @NamedQuery(name = "SdCliente.findByTelefono", query = "SELECT s FROM SdCliente s WHERE s.telefono = :telefono")
    , @NamedQuery(name = "SdCliente.findByContacto", query = "SELECT s FROM SdCliente s WHERE s.contacto = :contacto")
    , @NamedQuery(name = "SdCliente.findByEstado", query = "SELECT s FROM SdCliente s WHERE s.estado = :estado")
    , @NamedQuery(name = "SdCliente.findByFechaRegistro", query = "SELECT s FROM SdCliente s WHERE s.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "SdCliente.findByUsuarioRegistro", query = "SELECT s FROM SdCliente s WHERE s.usuarioRegistro = :usuarioRegistro")
    , @NamedQuery(name = "SdCliente.findByFechaActualizacion", query = "SELECT s FROM SdCliente s WHERE s.fechaActualizacion = :fechaActualizacion")
    , @NamedQuery(name = "SdCliente.findByUsuarioActualizacion", query = "SELECT s FROM SdCliente s WHERE s.usuarioActualizacion = :usuarioActualizacion")})
public class SdCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "TipoDocumento")
    private String tipoDocumento;
    @Size(max = 45)
    @Column(name = "NroDocumento")
    private String nroDocumento;
    @Size(max = 255)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "Direccion")
    private String direccion;
    @Size(max = 255)
    @Column(name = "Correo")
    private String correo;
    @Size(max = 45)
    @Column(name = "Telefono")
    private String telefono;
    @Size(max = 255)
    @Column(name = "Contacto")
    private String contacto;
    @Column(name = "Estado")
    private Integer estado;
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
    @JoinColumn(name = "IdUbigeo", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private SsUbiego idUbigeo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<SdVenta> sdVentaCollection;

    public SdCliente() {
    }

    public SdCliente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
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

    public SsUbiego getIdUbigeo() {
        return idUbigeo;
    }

    public void setIdUbigeo(SsUbiego idUbigeo) {
        this.idUbigeo = idUbigeo;
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
        if (!(object instanceof SdCliente)) {
            return false;
        }
        SdCliente other = (SdCliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "com.pdv.model.SdCliente[ id=" + id + " ]";
        return this.nombre;
    }
    
}
