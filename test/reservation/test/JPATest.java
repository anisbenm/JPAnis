/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;
import reservation.entity.Adresse;
import reservation.entity.Chambre;
import reservation.entity.Hotel;

/**
 *
 * @author Administrateur
 */
public class JPATest {

    @Test
    public void ajouterChambre() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Chambre c = new Chambre();
        c.setNom("Suite royale");
        c.setPrix(20000.);
        c.setDescription("c pas chere pour Samba");
        

        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }

    @Test
    public void ajouterHotel() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Adresse a = new Adresse("toffah", "Djerba", "Tunisia", 4175);
        Hotel h = new Hotel("toumana club", a);

        em.getTransaction().begin();
        em.persist(h);
        em.getTransaction().commit();
    }

    // recuperer une chambre
//    @Test
    public void recupChambreId() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Chambre ch = em.find(Chambre.class, 1L);////////////attention LLLLLLLL sinon erreur
        System.out.println(String.format("nom chambre : %s prix chambre : %9.2f hotel : %s", ch.getNom(), ch.getPrix(), ch.getHotel().getNom()));
    }

    @Test
    public void recupHotel() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Hotel h = em.find(Hotel.class, 2L);
        List<Chambre> chambres=h.getChambres();
        for(Chambre c:chambres){System.out.println(c.getNom());}
    }
}
