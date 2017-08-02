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
@Table(name = "sd_correlativo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SdCorrelativo.findAll", query = "SELECT s FROM SdCorrelativo s")
    , @NamedQuery(name = "SdCorrelativo.findById", query = "SELECT s FROM SdCorrelativo s WHERE s.id = :id")
    , @NamedQuery(name = "SdCorrelativo.findBySerieInicial", query = "SELECT s FROM SdCorrelativo s WHERE s.serieInicial = :serieInicial")
    , @NamedQuery(name = "SdCorrelativo.findByNumeroInicial", query = "SELECT s FROM SdCorrelativo s WHERE s.numeroInicial = :numeroInicial")
    , @NamedQuery(name = "SdCorrelativo.findBySerieFinal", query = "SELECT s FROM SdCorrelativo s WHERE s.serieFinal = :serieFinal")
    , @NamedQuery(name = "SdCorrelativo.findByNumeroFinal", query = "SELECT s FROM SdCorrelativo s WHERE s.numeroFinal = :numeroFinal")
    , @NamedQuery(name = "SdCorrelativo.findByFecha", query = "SELECT s FROM SdCorrelativo s WHERE s.fecha = :fecha")
    , @NamedQuery(name = "SdCorrelativo.findByEstado", query = "SELECT s FROM SdCorrelativo s WHERE s.estado = :estado")
    , @NamedQuery(name = "SdCorrelativo.findByFechaRegistro", query = "SELECT s FROM SdCorrelativo s WHERE s.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "SdCorrelativo.findByUsuarioRegistro", query = "SELECT s FROM SdCorrelativo s WHERE s.usuarioRegistro = :usuarioRegistro")
    , @NamedQuery(name = "SdCorrelativo.findByFechaActualizacion", query = "SELECT s FROM SdCorrelativo s WHERE s.fechaActualizacion = :fechaActualizacion")
    , @NamedQuery(name = "SdCorrelativo.findByUsuarioActualizacion", query = "SELECT s FROM SdCorrelativo s WHERE s.usuarioActualizacion = :usuarioActualizacion")})
public class SdCorrelativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "SerieInicial")
    private String serieInicial;
    @Size(max = 45)
    @Column(name = "NumeroInicial")
    private String numeroInicial;
    @Size(max = 45)
    @Column(name = "SerieFinal")
    private String serieFinal;
    @Size(max = 45)
    @Column(name = "NumeroFinal")
    private String numeroFinal;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha = new Date();
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
    @JoinColumn(name = "IdPuntoVenta", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private SdPuntoVenta idPuntoVenta;
    @JoinColumn(name = "IdTipoDocumento", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private SdTipoDocumento idTipoDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCorrelativo")
    private Collection<SdVenta> sdVentaCollection;

    public SdCorrelativo() {
    }

    public SdCorrelativo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerieInicial() {
        return serieInicial;
    }

    public void setSerieInicial(String serieInicial) {
        this.serieInicial = serieInicial;
    }

    public String getNumeroInicial() {
        return numeroInicial;
    }

    public void setNumeroInicial(String numeroInicial) {
        this.numeroInicial = numeroInicial;
    }

    public String getSerieFinal() {
        return serieFinal;
    }

    public void setSerieFinal(String serieFinal) {
        this.serieFinal = serieFinal;
    }

    public String getNumeroFinal() {
        return numeroFinal;
    }

    public void setNumeroFinal(String numeroFinal) {
        this.numeroFinal = numeroFinal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public SdPuntoVenta getIdPuntoVenta() {
        return idPuntoVenta;
    }

    public void setIdPuntoVenta(SdPuntoVenta idPuntoVenta) {
        this.idPuntoVenta = idPuntoVenta;
    }

    public SdTipoDocumento getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(SdTipoDocumento idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
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
        if (!(object instanceof SdCorrelativo)) {
            return false;
        }
        SdCorrelativo other = (SdCorrelativo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pdv.model.SdCorrelativo[ id=" + id + " ]";
    }
    
}
