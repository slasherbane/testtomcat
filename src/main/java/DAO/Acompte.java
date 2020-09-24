/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Benjamin
 */
@Entity
@Table(name = "acompte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acompte.findAll", query = "SELECT a FROM Acompte a"),
    @NamedQuery(name = "Acompte.findById", query = "SELECT a FROM Acompte a WHERE a.id = :id"),
    @NamedQuery(name = "Acompte.findByDateCreation", query = "SELECT a FROM Acompte a WHERE a.dateCreation = :dateCreation"),
    @NamedQuery(name = "Acompte.findByDateDemande", query = "SELECT a FROM Acompte a WHERE a.dateDemande = :dateDemande"),
    @NamedQuery(name = "Acompte.findByDateMaj", query = "SELECT a FROM Acompte a WHERE a.dateMaj = :dateMaj"),
    @NamedQuery(name = "Acompte.findByMontantAccorde", query = "SELECT a FROM Acompte a WHERE a.montantAccorde = :montantAccorde"),
    @NamedQuery(name = "Acompte.findByMontantDemande", query = "SELECT a FROM Acompte a WHERE a.montantDemande = :montantDemande"),
    @NamedQuery(name = "Acompte.findByType", query = "SELECT a FROM Acompte a WHERE a.type = :type"),
    @NamedQuery(name = "Acompte.findByDateSuppression", query = "SELECT a FROM Acompte a WHERE a.dateSuppression = :dateSuppression"),
    @NamedQuery(name = "Acompte.findBySupprime", query = "SELECT a FROM Acompte a WHERE a.supprime = :supprime"),
    @NamedQuery(name = "Acompte.findByModeReglement", query = "SELECT a FROM Acompte a WHERE a.modeReglement = :modeReglement")})
public class Acompte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "dateCreation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "dateDemande")
    @Temporal(TemporalType.DATE)
    private Date dateDemande;
    @Column(name = "dateMaj")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMaj;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montantAccorde")
    private Double montantAccorde;
    @Column(name = "montantDemande")
    private Double montantDemande;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    private int type;
    @Column(name = "dateSuppression")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSuppression;
    @Basic(optional = false)
    @NotNull
    @Column(name = "supprime")
    private boolean supprime;
    @Column(name = "modeReglement")
    private Integer modeReglement;
    @JoinColumn(name = "idSalarie", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Candidatsalarie idSalarie;
    @JoinColumn(name = "idSoc", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Soc idSoc;
    @JoinColumn(name = "idValideur", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User idValideur;

    public Acompte() {
    }

    public Acompte(Long id) {
        this.id = id;
    }

    public Acompte(Long id, int type, boolean supprime) {
        this.id = id;
        this.type = type;
        this.supprime = supprime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public Date getDateMaj() {
        return dateMaj;
    }

    public void setDateMaj(Date dateMaj) {
        this.dateMaj = dateMaj;
    }

    public Double getMontantAccorde() {
        return montantAccorde;
    }

    public void setMontantAccorde(Double montantAccorde) {
        this.montantAccorde = montantAccorde;
    }

    public Double getMontantDemande() {
        return montantDemande;
    }

    public void setMontantDemande(Double montantDemande) {
        this.montantDemande = montantDemande;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getDateSuppression() {
        return dateSuppression;
    }

    public void setDateSuppression(Date dateSuppression) {
        this.dateSuppression = dateSuppression;
    }

    public boolean getSupprime() {
        return supprime;
    }

    public void setSupprime(boolean supprime) {
        this.supprime = supprime;
    }

    public Integer getModeReglement() {
        return modeReglement;
    }

    public void setModeReglement(Integer modeReglement) {
        this.modeReglement = modeReglement;
    }

    public Candidatsalarie getIdSalarie() {
        return idSalarie;
    }

    public void setIdSalarie(Candidatsalarie idSalarie) {
        this.idSalarie = idSalarie;
    }

    public Soc getIdSoc() {
        return idSoc;
    }

    public void setIdSoc(Soc idSoc) {
        this.idSoc = idSoc;
    }

    public User getIdValideur() {
        return idValideur;
    }

    public void setIdValideur(User idValideur) {
        this.idValideur = idValideur;
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
        if (!(object instanceof Acompte)) {
            return false;
        }
        Acompte other = (Acompte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Acompte[ id=" + id + " ]";
    }
    
}
