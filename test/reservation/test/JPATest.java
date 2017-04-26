/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;
import reservation.entity.Chambre;

/**
 *
 * @author Administrateur
 */
public class JPATest {
    @Test
    public void TestJPA() {
        EntityManager em= Persistence.createEntityManagerFactory("PU").createEntityManager();
        Chambre c= new Chambre();
        c.setNom("Suite royale");
        c.setPrix(20000.);
        c.setDescription("c pas chere pour Samba");
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }
    
}
