/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdv.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sd_tipo_cambio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SdTipoCambio.findAll", query = "SELECT s FROM SdTipoCambio s")
    , @NamedQuery(name = "SdTipoCambio.findById", query = "SELECT s FROM SdTipoCambio s WHERE s.sdTipoCambioPK.id = :id")
    , @NamedQuery(name = "SdTipoCambio.findByFecha", query = "SELECT s FROM SdTipoCambio s WHERE s.sdTipoCambioPK.fecha = :fecha")
    , @NamedQuery(name = "SdTipoCambio.findByTc", query = "SELECT s FROM SdTipoCambio s WHERE s.tc = :tc")
    , @NamedQuery(name = "SdTipoCambio.findByEstado", query = "SELECT s FROM SdTipoCambio s WHERE s.estado = :estado")
    , @NamedQuery(name = "SdTipoCambio.findByUsuarioRegistro", query = "SELECT s FROM SdTipoCambio s WHERE s.usuarioRegistro = :usuarioRegistro")
    , @NamedQuery(name = "SdTipoCambio.findByFechaRegistro", query = "SELECT s FROM SdTipoCambio s WHERE s.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "SdTipoCambio.findByUsuarioActualizacion", query = "SELECT s FROM SdTipoCambio s WHERE s.usuarioActualizacion = :usuarioActualizacion")
    , @NamedQuery(name = "SdTipoCambio.findByFechaActualizacion", query = "SELECT s FROM SdTipoCambio s WHERE s.fechaActualizacion = :fechaActualizacion")})
public class SdTipoCambio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected SdTipoCambioPK sdTipoCambioPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TC")
    private BigDecimal tc;
    @Column(name = "Estado")
    private Integer estado;
    @Size(max = 45)
    @Column(name = "UsuarioRegistro")
    private String usuarioRegistro;
    @Column(name = "FechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 45)
    @Column(name = "UsuarioActualizacion")
    private String usuarioActualizacion;
    @Column(name = "FechaActualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @JoinColumn(name = "IdMoneda", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private SdMoneda idMoneda;

    public SdTipoCambio() {
    }

    public SdTipoCambio(SdTipoCambioPK sdTipoCambioPK) {
        this.sdTipoCambioPK = sdTipoCambioPK;
    }

    public SdTipoCambio(int id, Date fecha) {
        this.sdTipoCambioPK = new SdTipoCambioPK(id, fecha);
    }

    public SdTipoCambioPK getSdTipoCambioPK() {
        return sdTipoCambioPK;
    }

    public void setSdTipoCambioPK(SdTipoCambioPK sdTipoCambioPK) {
        this.sdTipoCambioPK = sdTipoCambioPK;
    }

    public BigDecimal getTc() {
        return tc;
    }

    public void setTc(BigDecimal tc) {
        this.tc = tc;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getUsuarioActualizacion() {
        return usuarioActualizacion;
    }

    public void setUsuarioActualizacion(String usuarioActualizacion) {
        this.usuarioActualizacion = usuarioActualizacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public SdMoneda getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(SdMoneda idMoneda) {
        this.idMoneda = idMoneda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sdTipoCambioPK != null ? sdTipoCambioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SdTipoCambio)) {
            return false;
        }
        SdTipoCambio other = (SdTipoCambio) object;
        if ((this.sdTipoCambioPK == null && other.sdTipoCambioPK != null) || (this.sdTipoCambioPK != null && !this.sdTipoCambioPK.equals(other.sdTipoCambioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pdv.model.SdTipoCambio[ sdTipoCambioPK=" + sdTipoCambioPK + " ]";
    }
    
}
