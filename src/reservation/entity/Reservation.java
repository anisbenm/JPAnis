/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Administrateur
 */
@Entity
public class Reservation implements Serializable {

    public enum EtatReservation{// EN RELATION AVEC DIAGRAME D ETAT
    NON_VALIDEE,
    VALIDEE,
    TERMINEE,
    ANNULEE
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    ////////////////
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
    ////////////////
    @ManyToOne
    @JoinColumn(name ="id_chambre" )
    private Chambre chambre;
    ///////////////
 @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeureReservation;
           
    @Enumerated(EnumType.STRING)
    private EtatReservation etat;
    
    public Long getId() {
        return id;
    }
    
   
    
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "reservation.entity.ReservationEntity[ id=" + id + " ]";
    }
    
}
