/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdv.ejb;

import com.pdv.model.SdVentaDetalle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ecasano
 */
@Stateless
public class SdVentaDetalleFacade extends AbstractFacade<SdVentaDetalle> {

    @PersistenceContext(unitName = "factoringPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SdVentaDetalleFacade() {
        super(SdVentaDetalle.class);
    }
    
}
