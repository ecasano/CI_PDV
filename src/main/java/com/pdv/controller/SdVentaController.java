package com.pdv.controller;

import com.pdv.model.SdVenta;
import com.pdv.controller.util.JsfUtil;
import com.pdv.controller.util.JsfUtil.PersistAction;
import com.pdv.ejb.SdVentaFacade;
import com.pdv.model.SdVentaDetalle;
import com.pdv.model.SdVentaDetallePK;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.AjaxBehaviorEvent;

@Named("sdVentaController")
@SessionScoped
public class SdVentaController implements Serializable {

    @EJB
    private com.pdv.ejb.SdVentaFacade ejbFacade;
    private List<SdVenta> items = null;
    private SdVenta selected;
    
    //variables del Detalle de la Venta
    private SdVentaDetalle detalle_item; 
    private List<SdVentaDetalle> detalle_items;

    //INICIO: Metodos del Detalle de la Venta
    @PostConstruct
    public void init() {
        detalle_item = new SdVentaDetalle();
        SdVentaDetallePK sdVentaDetallePK = new SdVentaDetallePK();
        sdVentaDetallePK.setIdItem(1);
        detalle_item.setSdVentaDetallePK(sdVentaDetallePK);
        
        detalle_items = new ArrayList<SdVentaDetalle>();
        
    }
    
    public void createNewDetalleItem() {
                    
        if(detalle_items.contains(detalle_item)) {
            FacesMessage msg = new FacesMessage("Dublicated", "This book has already been added");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } 
        else {
            detalle_items.add(detalle_item);
            detalle_item = new SdVentaDetalle();
        }
    }
    
    public String reinitDetalleItem() {
        detalle_item = new SdVentaDetalle();
        //DetalleItem PK
        SdVentaDetallePK sdVentaDetallePK = new SdVentaDetallePK();
        sdVentaDetallePK.setIdItem(detalle_items.size()+1);
        //sdVentaDetallePK.setIdVenta(selected.getId());
        detalle_item.setSdVentaDetallePK(sdVentaDetallePK);
        
        //BigDecimal cantidad = detalle_item.getCantidad();
        //BigDecimal precio = detalle_item.getPrecio();
        //BigDecimal importe = precio.multiply(cantidad);
        
        //detalle_item.setImporte(importe);
                
        return null;
    }
    
    public void handleImporteChange(){
        BigDecimal cantidad = detalle_item.getCantidad();
        BigDecimal precio = detalle_item.getPrecio();
        BigDecimal importe = precio.multiply(cantidad);
        detalle_item.setImporte(importe);
    }
    
    public void handlePrecioChange(AjaxBehaviorEvent event){
        if(detalle_item.getIdProducto() != null)
            System.out.println(detalle_item.getIdProducto().getPrecio());
        else
            System.out.println(detalle_item.getIdProducto() + "");
    }
    public SdVentaDetalle getDetalleItem() {
        return detalle_item;
    }
 
    public List<SdVentaDetalle> getDetalleItems() {
        return detalle_items;
    }
    
    //FIN: Metodos del Detalle de la Venta
    

    public SdVentaController() {
        //detalle_item = new SdVentaDetalle();
        //detalle_items = new ArrayList<SdVentaDetalle>();
        
    }

    public SdVenta getSelected() {
        return selected;
    }

    public void setSelected(SdVenta selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SdVentaFacade getFacade() {
        return ejbFacade;
    }

    public SdVenta prepareCreate() {
        selected = new SdVenta();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SdVentaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SdVentaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SdVentaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SdVenta> getItems() {
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

    public SdVenta getSdVenta(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<SdVenta> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SdVenta> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SdVenta.class)
    public static class SdVentaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SdVentaController controller = (SdVentaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "sdVentaController");
            return controller.getSdVenta(getKey(value));
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
            if (object instanceof SdVenta) {
                SdVenta o = (SdVenta) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SdVenta.class.getName()});
                return null;
            }
        }

    }

}
