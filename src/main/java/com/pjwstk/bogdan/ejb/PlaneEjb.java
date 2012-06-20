
package com.pjwstk.bogdan.ejb;

import com.pjwstk.bogdan.domain.Plane;
import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
@Named
public class PlaneEjb {

    @PersistenceContext(unitName = "com.pjwstk.bogdan_bogdan_war_1.0.0-SNAPSHOTPU")
    private EntityManager em;
    
    public List<Plane> getPlanes() {
        return em.createQuery("select p from Plane p").getResultList();
    }
    
    public void delete(Plane plane) {
        plane = em.merge(plane);
        em.remove(plane);
    }
 
    public void merge(Plane plane) {
        em.merge(plane);
    }
   
}
