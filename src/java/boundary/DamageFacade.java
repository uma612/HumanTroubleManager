/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import boundry.AbstractFacade;
import entities.Damage;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Merca Skole
 */
@Stateless
public class DamageFacade extends AbstractFacade<Damage> {
    @PersistenceContext(unitName = "CarSharePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DamageFacade() {
        super(Damage.class);
    }
   
      
  
        
}
