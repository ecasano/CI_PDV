/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdv.ejb;

import com.pdv.model.SsUsuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ecasano
 */
@Stateless
public class SsUsuarioFacade extends AbstractFacade<SsUsuario> {

    @PersistenceContext(unitName = "factoringPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SsUsuarioFacade() {
        super(SsUsuario.class);
    }
    
    public SsUsuario iniciarSesion(SsUsuario user){
        SsUsuario usuario = null;
        String consulta;
        try{
            consulta = "SELECT u FROM SsUsuario u WHERE u.usuario = ?1 and u.contrasena = ?2";;
            Query query = em.createQuery(consulta);
            query.setParameter(1, user.getUsuario());
            query.setParameter(2, user.getContrasena());
            
            List<SsUsuario> lista = query.getResultList();

            if(!lista.isEmpty()){
                usuario = lista.get(0);
            }
        }catch(Exception e){
            throw e;
        }
        
        return usuario;
    }
    
}
