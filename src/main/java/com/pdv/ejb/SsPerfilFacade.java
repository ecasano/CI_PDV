/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdv.ejb;

import com.pdv.model.SsPerfil;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ecasano
 */
@Stateless
public class SsPerfilFacade extends AbstractFacade<SsPerfil> {

    @PersistenceContext(unitName = "factoringPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SsPerfilFacade() {
        super(SsPerfil.class);
    }
    
}
