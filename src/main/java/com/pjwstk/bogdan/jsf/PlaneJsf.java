
package com.pjwstk.bogdan.jsf;

import com.pjwstk.bogdan.domain.Plane;
import com.pjwstk.bogdan.ejb.PlaneEjb;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class PlaneJsf implements Serializable {
    
    private ListDataModel<Plane> planes = new ListDataModel<Plane>();
    private Plane plane;
    
    @Inject
    private PlaneEjb planeEjb; 
    
    public ListDataModel<Plane> getPlanes() {
        planes.setWrappedData(planeEjb.getPlanes());
        return planes;
    }

    public Plane getPlane() {
        if(plane == null){ plane = new Plane(); }
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }
    
    public String show() {
        plane = planes.getRowData();
        return "show";
    }
    
    public String add() {
        return "add";
    }
    
    public String edit() {
        plane = planes.getRowData();
        return "edit";
    }
    
    public String delete() {
        plane = planes.getRowData();
        planeEjb.delete(plane);
        return "all";
    }
    
    public String merge() {
        planeEjb.merge(plane);
        return "all";
    }
}
