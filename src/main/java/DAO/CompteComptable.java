/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Benjamin
 */
@Entity
@Table(name = "compte_comptable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompteComptable.findAll", query = "SELECT c FROM CompteComptable c"),
    @NamedQuery(name = "CompteComptable.findById", query = "SELECT c FROM CompteComptable c WHERE c.id = :id"),
    @NamedQuery(name = "CompteComptable.findByCode", query = "SELECT c FROM CompteComptable c WHERE c.code = :code"),
    @NamedQuery(name = "CompteComptable.findByCompteDefault", query = "SELECT c FROM CompteComptable c WHERE c.compteDefault = :compteDefault"),
    @NamedQuery(name = "CompteComptable.findByDateCreation", query = "SELECT c FROM CompteComptable c WHERE c.dateCreation = :dateCreation"),
    @NamedQuery(name = "CompteComptable.findByDateMaj", query = "SELECT c FROM CompteComptable c WHERE c.dateMaj = :dateMaj"),
    @NamedQuery(name = "CompteComptable.findByDateSuppression", query = "SELECT c FROM CompteComptable c WHERE c.dateSuppression = :dateSuppression"),
    @NamedQuery(name = "CompteComptable.findByLibelle", query = "SELECT c FROM CompteComptable c WHERE c.libelle = :libelle"),
    @NamedQuery(name = "CompteComptable.findBySupprime", query = "SELECT c FROM CompteComptable c WHERE c.supprime = :supprime"),
    @NamedQuery(name = "CompteComptable.findByTypeCompte", query = "SELECT c FROM CompteComptable c WHERE c.typeCompte = :typeCompte"),
    @NamedQuery(name = "CompteComptable.findByCodeComptableGeneral", query = "SELECT c FROM CompteComptable c WHERE c.codeComptableGeneral = :codeComptableGeneral")})
public class CompteComptable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "compteDefault")
    private boolean compteDefault;
    @Column(name = "dateCreation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "dateMaj")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMaj;
    @Column(name = "dateSuppression")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSuppression;
    @Size(max = 255)
    @Column(name = "libelle")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "supprime")
    private boolean supprime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "typeCompte")
    private int typeCompte;
    @Size(max = 255)
    @Column(name = "codeComptableGeneral")
    private String codeComptableGeneral;
    @OneToMany(mappedBy = "idCompteComptable", fetch = FetchType.LAZY)
    private Collection<Prestations> prestationsCollection;
    @JoinColumn(name = "idSoc", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Soc idSoc;

    public CompteComptable() {
    }

    public CompteComptable(Long id) {
        this.id = id;
    }

    public CompteComptable(Long id, boolean compteDefault, boolean supprime, int typeCompte) {
        this.id = id;
        this.compteDefault = compteDefault;
        this.supprime = supprime;
        this.typeCompte = typeCompte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean getCompteDefault() {
        return compteDefault;
    }

    public void setCompteDefault(boolean compteDefault) {
        this.compteDefault = compteDefault;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateMaj() {
        return dateMaj;
    }

    public void setDateMaj(Date dateMaj) {
        this.dateMaj = dateMaj;
    }

    public Date getDateSuppression() {
        return dateSuppression;
    }

    public void setDateSuppression(Date dateSuppression) {
        this.dateSuppression = dateSuppression;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public boolean getSupprime() {
        return supprime;
    }

    public void setSupprime(boolean supprime) {
        this.supprime = supprime;
    }

    public int getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(int typeCompte) {
        this.typeCompte = typeCompte;
    }

    public String getCodeComptableGeneral() {
        return codeComptableGeneral;
    }

    public void setCodeComptableGeneral(String codeComptableGeneral) {
        this.codeComptableGeneral = codeComptableGeneral;
    }

    @XmlTransient
    public Collection<Prestations> getPrestationsCollection() {
        return prestationsCollection;
    }

    public void setPrestationsCollection(Collection<Prestations> prestationsCollection) {
        this.prestationsCollection = prestationsCollection;
    }

    public Soc getIdSoc() {
        return idSoc;
    }

    public void setIdSoc(Soc idSoc) {
        this.idSoc = idSoc;
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
        if (!(object instanceof CompteComptable)) {
            return false;
        }
        CompteComptable other = (CompteComptable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.CompteComptable[ id=" + id + " ]";
    }
    
}
