package com.pdv.controller;

import com.pdv.ejb.SsUsuarioFacade;
import com.pdv.model.SsUsuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author ecasano
 */

@Named //("IndexController")
@SessionScoped
public class IndexController implements Serializable {
    
     
    @EJB
    private SsUsuarioFacade EJBUsuario;
    //@Inject
    private SsUsuario usuario;
    
    @PostConstruct
    public void init(){
        usuario = new SsUsuario();
    }

    public SsUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(SsUsuario usuario) {
        this.usuario = usuario;
    }
    
    public String iniciarSesion(){
        SsUsuario user;
        String redireccion = null;
                
        try{
            //String clave = DigestUtils.md5Hex(usuario.getPWD_USUARIO());
            //usuario.setPWD_USUARIO(clave);
            System.out.println("entro 1");
            user = EJBUsuario.iniciarSesion(usuario);
            System.out.println("paso ");
            if(user!=null){
                System.out.println("entro 2");
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", user);
                redireccion = "/protegido/principal";
                //redireccion = "/protegido/principal?faces-redirect=true"; //con esta propiedad mostramos la ruta completa en la URL de las paginas xhtml
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso","Usuario o credenciales incorrectas!"));
            }
            
        }catch(Exception e){
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error!"));
            System.out.println(e.getMessage());
        }
        return redireccion;
    }
    
    public void verificarSesion(){
        try{
            FacesContext context = FacesContext.getCurrentInstance();
            SsUsuario user = (SsUsuario)context.getExternalContext().getSessionMap().get("usuario");
            
            if(user == null){
                context.getExternalContext().redirect("/permisos.xhtml");
            }
            
        }catch(Exception e){
            //log PARA GUARDAR REGOSTROS DE ERROR
        }
    }
    
     public void cerrarSesion(){
        
       FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    
    }
    
}

