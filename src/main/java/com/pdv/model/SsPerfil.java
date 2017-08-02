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
@Table(name = "ss_perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SsPerfil.findAll", query = "SELECT s FROM SsPerfil s")
    , @NamedQuery(name = "SsPerfil.findById", query = "SELECT s FROM SsPerfil s WHERE s.id = :id")
    , @NamedQuery(name = "SsPerfil.findByNombre", query = "SELECT s FROM SsPerfil s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SsPerfil.findByEstado", query = "SELECT s FROM SsPerfil s WHERE s.estado = :estado")})
public class SsPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Estado")
    private Integer estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerfil")
    private Collection<SsUsuario> ssUsuarioCollection;

    public SsPerfil() {
    }

    public SsPerfil(Integer id) {
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

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<SsUsuario> getSsUsuarioCollection() {
        return ssUsuarioCollection;
    }

    public void setSsUsuarioCollection(Collection<SsUsuario> ssUsuarioCollection) {
        this.ssUsuarioCollection = ssUsuarioCollection;
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
        if (!(object instanceof SsPerfil)) {
            return false;
        }
        SsPerfil other = (SsPerfil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "com.pdv.model.SsPerfil[ id=" + id + " ]";
        return this.nombre;
    }
    
}
