package com.pdv.controller;

import com.pdv.model.SdPuntoVenta;
import com.pdv.controller.util.JsfUtil;
import com.pdv.controller.util.JsfUtil.PersistAction;
import com.pdv.ejb.SdPuntoVentaFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("sdPuntoVentaController")
@SessionScoped
public class SdPuntoVentaController implements Serializable {

    @EJB
    private com.pdv.ejb.SdPuntoVentaFacade ejbFacade;
    private List<SdPuntoVenta> items = null;
    private SdPuntoVenta selected;

    public SdPuntoVentaController() {
    }

    public SdPuntoVenta getSelected() {
        return selected;
    }

    public void setSelected(SdPuntoVenta selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SdPuntoVentaFacade getFacade() {
        return ejbFacade;
    }

    public SdPuntoVenta prepareCreate() {
        selected = new SdPuntoVenta();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SdPuntoVentaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SdPuntoVentaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SdPuntoVentaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SdPuntoVenta> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public SdPuntoVenta getSdPuntoVenta(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<SdPuntoVenta> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SdPuntoVenta> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SdPuntoVenta.class)
    public static class SdPuntoVentaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SdPuntoVentaController controller = (SdPuntoVentaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "sdPuntoVentaController");
            return controller.getSdPuntoVenta(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof SdPuntoVenta) {
                SdPuntoVenta o = (SdPuntoVenta) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SdPuntoVenta.class.getName()});
                return null;
            }
        }

    }

}
