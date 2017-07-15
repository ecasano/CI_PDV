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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ss_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SsUsuario.findAll", query = "SELECT s FROM SsUsuario s")
    , @NamedQuery(name = "SsUsuario.findById", query = "SELECT s FROM SsUsuario s WHERE s.id = :id")
    , @NamedQuery(name = "SsUsuario.findByUsuario", query = "SELECT s FROM SsUsuario s WHERE s.usuario = :usuario")
    , @NamedQuery(name = "SsUsuario.findByContrasena", query = "SELECT s FROM SsUsuario s WHERE s.contrasena = :contrasena")
    , @NamedQuery(name = "SsUsuario.findByNombre", query = "SELECT s FROM SsUsuario s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SsUsuario.findByCorreo", query = "SELECT s FROM SsUsuario s WHERE s.correo = :correo")
    , @NamedQuery(name = "SsUsuario.findByEstado", query = "SELECT s FROM SsUsuario s WHERE s.estado = :estado")})
public class SsUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "Usuario")
    private String usuario;
    @Size(max = 45)
    @Column(name = "Contrasena")
    private String contrasena;
    @Size(max = 255)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "Correo")
    private String correo;
    @Column(name = "Estado")
    private Integer estado;
    @JoinColumn(name = "IdPerfil", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private SsPerfil idPerfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<SdVenta> sdVentaCollection;

    public SsUsuario() {
    }

    public SsUsuario(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public SsPerfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(SsPerfil idPerfil) {
        this.idPerfil = idPerfil;
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
        if (!(object instanceof SsUsuario)) {
            return false;
        }
        SsUsuario other = (SsUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pdv.model.SsUsuario[ id=" + id + " ]";
    }
    
}
