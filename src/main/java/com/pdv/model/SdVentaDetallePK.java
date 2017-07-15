/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdv.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ecasano
 */
@Embeddable
public class SdVentaDetallePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IdVenta")
    private int idVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdItem")
    private int idItem;

    public SdVentaDetallePK() {
    }

    public SdVentaDetallePK(int idVenta, int idItem) {
        this.idVenta = idVenta;
        this.idItem = idItem;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idVenta;
        hash += (int) idItem;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SdVentaDetallePK)) {
            return false;
        }
        SdVentaDetallePK other = (SdVentaDetallePK) object;
        if (this.idVenta != other.idVenta) {
            return false;
        }
        if (this.idItem != other.idItem) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pdv.model.SdVentaDetallePK[ idVenta=" + idVenta + ", idItem=" + idItem + " ]";
    }
    
}
