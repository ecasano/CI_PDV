/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdv.ejb;

import com.pdv.model.SdCliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ecasano
 */
@Stateless
public class SdClienteFacade extends AbstractFacade<SdCliente> {

    @PersistenceContext(unitName = "factoringPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SdClienteFacade() {
        super(SdCliente.class);
    }
    
}
