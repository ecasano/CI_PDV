/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdv.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ecasano
 */
@Entity
@Table(name = "sd_venta_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SdVentaDetalle.findAll", query = "SELECT s FROM SdVentaDetalle s")
    , @NamedQuery(name = "SdVentaDetalle.findByIdVenta", query = "SELECT s FROM SdVentaDetalle s WHERE s.sdVentaDetallePK.idVenta = :idVenta")
    , @NamedQuery(name = "SdVentaDetalle.findByIdItem", query = "SELECT s FROM SdVentaDetalle s WHERE s.sdVentaDetallePK.idItem = :idItem")
    , @NamedQuery(name = "SdVentaDetalle.findByCantidad", query = "SELECT s FROM SdVentaDetalle s WHERE s.cantidad = :cantidad")
    , @NamedQuery(name = "SdVentaDetalle.findByMonto", query = "SELECT s FROM SdVentaDetalle s WHERE s.monto = :monto")})
public class SdVentaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SdVentaDetallePK sdVentaDetallePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Cantidad")
    private BigDecimal cantidad;
    @Column(name = "Monto")
    private BigDecimal monto;
    @JoinColumn(name = "IdProducto", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private SdProducto idProducto;
    @JoinColumn(name = "IdVenta", referencedColumnName = "Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SdVenta sdVenta;

    public SdVentaDetalle() {
    }

    public SdVentaDetalle(SdVentaDetallePK sdVentaDetallePK) {
        this.sdVentaDetallePK = sdVentaDetallePK;
    }

    public SdVentaDetalle(int idVenta, int idItem) {
        this.sdVentaDetallePK = new SdVentaDetallePK(idVenta, idItem);
    }

    public SdVentaDetallePK getSdVentaDetallePK() {
        return sdVentaDetallePK;
    }

    public void setSdVentaDetallePK(SdVentaDetallePK sdVentaDetallePK) {
        this.sdVentaDetallePK = sdVentaDetallePK;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public SdProducto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(SdProducto idProducto) {
        this.idProducto = idProducto;
    }

    public SdVenta getSdVenta() {
        return sdVenta;
    }

    public void setSdVenta(SdVenta sdVenta) {
        this.sdVenta = sdVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sdVentaDetallePK != null ? sdVentaDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SdVentaDetalle)) {
            return false;
        }
        SdVentaDetalle other = (SdVentaDetalle) object;
        if ((this.sdVentaDetallePK == null && other.sdVentaDetallePK != null) || (this.sdVentaDetallePK != null && !this.sdVentaDetallePK.equals(other.sdVentaDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pdv.model.SdVentaDetalle[ sdVentaDetallePK=" + sdVentaDetallePK + " ]";
    }
    
}
