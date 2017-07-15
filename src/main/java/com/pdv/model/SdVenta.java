/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdv.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "sd_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SdVenta.findAll", query = "SELECT s FROM SdVenta s")
    , @NamedQuery(name = "SdVenta.findById", query = "SELECT s FROM SdVenta s WHERE s.id = :id")
    , @NamedQuery(name = "SdVenta.findBySerieDocumento", query = "SELECT s FROM SdVenta s WHERE s.serieDocumento = :serieDocumento")
    , @NamedQuery(name = "SdVenta.findByNumeroDocumento", query = "SELECT s FROM SdVenta s WHERE s.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "SdVenta.findByFechaDocumento", query = "SELECT s FROM SdVenta s WHERE s.fechaDocumento = :fechaDocumento")
    , @NamedQuery(name = "SdVenta.findByFechaVencimientoDocumento", query = "SELECT s FROM SdVenta s WHERE s.fechaVencimientoDocumento = :fechaVencimientoDocumento")
    , @NamedQuery(name = "SdVenta.findByTipoDocumentoCliente", query = "SELECT s FROM SdVenta s WHERE s.tipoDocumentoCliente = :tipoDocumentoCliente")
    , @NamedQuery(name = "SdVenta.findByNroDocumentoCliente", query = "SELECT s FROM SdVenta s WHERE s.nroDocumentoCliente = :nroDocumentoCliente")
    , @NamedQuery(name = "SdVenta.findByNombreCliente", query = "SELECT s FROM SdVenta s WHERE s.nombreCliente = :nombreCliente")
    , @NamedQuery(name = "SdVenta.findByDireccionCliente", query = "SELECT s FROM SdVenta s WHERE s.direccionCliente = :direccionCliente")
    , @NamedQuery(name = "SdVenta.findByEstado", query = "SELECT s FROM SdVenta s WHERE s.estado = :estado")
    , @NamedQuery(name = "SdVenta.findBySubtotal", query = "SELECT s FROM SdVenta s WHERE s.subtotal = :subtotal")
    , @NamedQuery(name = "SdVenta.findByIgv", query = "SELECT s FROM SdVenta s WHERE s.igv = :igv")
    , @NamedQuery(name = "SdVenta.findByTotal", query = "SELECT s FROM SdVenta s WHERE s.total = :total")
    , @NamedQuery(name = "SdVenta.findByFechaAnulacion", query = "SELECT s FROM SdVenta s WHERE s.fechaAnulacion = :fechaAnulacion")
    , @NamedQuery(name = "SdVenta.findByUsuarioAnulacion", query = "SELECT s FROM SdVenta s WHERE s.usuarioAnulacion = :usuarioAnulacion")
    , @NamedQuery(name = "SdVenta.findByFechaRegistro", query = "SELECT s FROM SdVenta s WHERE s.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "SdVenta.findByUsuarioRegistro", query = "SELECT s FROM SdVenta s WHERE s.usuarioRegistro = :usuarioRegistro")
    , @NamedQuery(name = "SdVenta.findByTipoTarjeta", query = "SELECT s FROM SdVenta s WHERE s.tipoTarjeta = :tipoTarjeta")
    , @NamedQuery(name = "SdVenta.findByNroTarjeta", query = "SELECT s FROM SdVenta s WHERE s.nroTarjeta = :nroTarjeta")
    , @NamedQuery(name = "SdVenta.findByFechaVencimientoTarjeta", query = "SELECT s FROM SdVenta s WHERE s.fechaVencimientoTarjeta = :fechaVencimientoTarjeta")
    , @NamedQuery(name = "SdVenta.findByTitularTarjeta", query = "SELECT s FROM SdVenta s WHERE s.titularTarjeta = :titularTarjeta")
    , @NamedQuery(name = "SdVenta.findByTipoCambio", query = "SELECT s FROM SdVenta s WHERE s.tipoCambio = :tipoCambio")})
public class SdVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "SerieDocumento")
    private String serieDocumento;
    @Size(max = 45)
    @Column(name = "NumeroDocumento")
    private String numeroDocumento;
    @Column(name = "FechaDocumento")
    @Temporal(TemporalType.DATE)
    private Date fechaDocumento;
    @Column(name = "FechaVencimientoDocumento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimientoDocumento;
    @Size(max = 45)
    @Column(name = "TipoDocumentoCliente")
    private String tipoDocumentoCliente;
    @Size(max = 45)
    @Column(name = "NroDocumentoCliente")
    private String nroDocumentoCliente;
    @Size(max = 255)
    @Column(name = "NombreCliente")
    private String nombreCliente;
    @Size(max = 255)
    @Column(name = "DireccionCliente")
    private String direccionCliente;
    @Column(name = "Estado")
    private Integer estado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Subtotal")
    private BigDecimal subtotal;
    @Column(name = "IGV")
    private BigDecimal igv;
    @Column(name = "Total")
    private BigDecimal total;
    @Column(name = "FechaAnulacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAnulacion;
    @Size(max = 45)
    @Column(name = "UsuarioAnulacion")
    private String usuarioAnulacion;
    @Column(name = "FechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 45)
    @Column(name = "UsuarioRegistro")
    private String usuarioRegistro;
    @Size(max = 45)
    @Column(name = "TipoTarjeta")
    private String tipoTarjeta;
    @Size(max = 45)
    @Column(name = "NroTarjeta")
    private String nroTarjeta;
    @Size(max = 6)
    @Column(name = "FechaVencimientoTarjeta")
    private String fechaVencimientoTarjeta;
    @Size(max = 255)
    @Column(name = "TitularTarjeta")
    private String titularTarjeta;
    @Column(name = "TipoCambio")
    private BigDecimal tipoCambio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sdVenta")
    private Collection<SdVentaDetalle> sdVentaDetalleCollection;
    @JoinColumn(name = "IdFormaPago", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private SdFormaPago idFormaPago;
    @JoinColumn(name = "IdMoneda", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private SdMoneda idMoneda;
    @JoinColumn(name = "IdPuntoVenta", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private SdPuntoVenta idPuntoVenta;
    @JoinColumn(name = "IdTipoDocumento", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private SdTipoDocumento idTipoDocumento;
    @JoinColumn(name = "IdUsuario", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private SsUsuario idUsuario;

    public SdVenta() {
    }

    public SdVenta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerieDocumento() {
        return serieDocumento;
    }

    public void setSerieDocumento(String serieDocumento) {
        this.serieDocumento = serieDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public Date getFechaVencimientoDocumento() {
        return fechaVencimientoDocumento;
    }

    public void setFechaVencimientoDocumento(Date fechaVencimientoDocumento) {
        this.fechaVencimientoDocumento = fechaVencimientoDocumento;
    }

    public String getTipoDocumentoCliente() {
        return tipoDocumentoCliente;
    }

    public void setTipoDocumentoCliente(String tipoDocumentoCliente) {
        this.tipoDocumentoCliente = tipoDocumentoCliente;
    }

    public String getNroDocumentoCliente() {
        return nroDocumentoCliente;
    }

    public void setNroDocumentoCliente(String nroDocumentoCliente) {
        this.nroDocumentoCliente = nroDocumentoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getIgv() {
        return igv;
    }

    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public String getUsuarioAnulacion() {
        return usuarioAnulacion;
    }

    public void setUsuarioAnulacion(String usuarioAnulacion) {
        this.usuarioAnulacion = usuarioAnulacion;
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

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(String nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public String getFechaVencimientoTarjeta() {
        return fechaVencimientoTarjeta;
    }

    public void setFechaVencimientoTarjeta(String fechaVencimientoTarjeta) {
        this.fechaVencimientoTarjeta = fechaVencimientoTarjeta;
    }

    public String getTitularTarjeta() {
        return titularTarjeta;
    }

    public void setTitularTarjeta(String titularTarjeta) {
        this.titularTarjeta = titularTarjeta;
    }

    public BigDecimal getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(BigDecimal tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    @XmlTransient
    public Collection<SdVentaDetalle> getSdVentaDetalleCollection() {
        return sdVentaDetalleCollection;
    }

    public void setSdVentaDetalleCollection(Collection<SdVentaDetalle> sdVentaDetalleCollection) {
        this.sdVentaDetalleCollection = sdVentaDetalleCollection;
    }

    public SdFormaPago getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(SdFormaPago idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public SdMoneda getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(SdMoneda idMoneda) {
        this.idMoneda = idMoneda;
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

    public SsUsuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(SsUsuario idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof SdVenta)) {
            return false;
        }
        SdVenta other = (SdVenta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pdv.model.SdVenta[ id=" + id + " ]";
    }
    
}
