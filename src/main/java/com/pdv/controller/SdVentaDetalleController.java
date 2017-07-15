package com.pdv.controller;

import com.pdv.model.SdVentaDetalle;
import com.pdv.controller.util.JsfUtil;
import com.pdv.controller.util.JsfUtil.PersistAction;
import com.pdv.ejb.SdVentaDetalleFacade;

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

@Named("sdVentaDetalleController")
@SessionScoped
public class SdVentaDetalleController implements Serializable {

    @EJB
    private com.pdv.ejb.SdVentaDetalleFacade ejbFacade;
    private List<SdVentaDetalle> items = null;
    private SdVentaDetalle selected;

    public SdVentaDetalleController() {
    }

    public SdVentaDetalle getSelected() {
        return selected;
    }

    public void setSelected(SdVentaDetalle selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getSdVentaDetallePK().setIdVenta(selected.getSdVenta().getId());
    }

    protected void initializeEmbeddableKey() {
        selected.setSdVentaDetallePK(new com.pdv.model.SdVentaDetallePK());
    }

    private SdVentaDetalleFacade getFacade() {
        return ejbFacade;
    }

    public SdVentaDetalle prepareCreate() {
        selected = new SdVentaDetalle();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SdVentaDetalleCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SdVentaDetalleUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SdVentaDetalleDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SdVentaDetalle> getItems() {
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

    public SdVentaDetalle getSdVentaDetalle(com.pdv.model.SdVentaDetallePK id) {
        return getFacade().find(id);
    }

    public List<SdVentaDetalle> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SdVentaDetalle> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SdVentaDetalle.class)
    public static class SdVentaDetalleControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SdVentaDetalleController controller = (SdVentaDetalleController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "sdVentaDetalleController");
            return controller.getSdVentaDetalle(getKey(value));
        }

        com.pdv.model.SdVentaDetallePK getKey(String value) {
            com.pdv.model.SdVentaDetallePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.pdv.model.SdVentaDetallePK();
            key.setIdVenta(Integer.parseInt(values[0]));
            key.setIdItem(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.pdv.model.SdVentaDetallePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdVenta());
            sb.append(SEPARATOR);
            sb.append(value.getIdItem());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof SdVentaDetalle) {
                SdVentaDetalle o = (SdVentaDetalle) object;
                return getStringKey(o.getSdVentaDetallePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SdVentaDetalle.class.getName()});
                return null;
            }
        }

    }

}
