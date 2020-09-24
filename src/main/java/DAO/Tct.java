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
@Table(name = "tct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tct.findAll", query = "SELECT t FROM Tct t"),
    @NamedQuery(name = "Tct.findById", query = "SELECT t FROM Tct t WHERE t.id = :id"),
    @NamedQuery(name = "Tct.findByCode", query = "SELECT t FROM Tct t WHERE t.code = :code"),
    @NamedQuery(name = "Tct.findByCs", query = "SELECT t FROM Tct t WHERE t.cs = :cs"),
    @NamedQuery(name = "Tct.findByDateCreation", query = "SELECT t FROM Tct t WHERE t.dateCreation = :dateCreation"),
    @NamedQuery(name = "Tct.findByDateMaj", query = "SELECT t FROM Tct t WHERE t.dateMaj = :dateMaj"),
    @NamedQuery(name = "Tct.findByDateSuppression", query = "SELECT t FROM Tct t WHERE t.dateSuppression = :dateSuppression"),
    @NamedQuery(name = "Tct.findByDd", query = "SELECT t FROM Tct t WHERE t.dd = :dd"),
    @NamedQuery(name = "Tct.findByLibelle", query = "SELECT t FROM Tct t WHERE t.libelle = :libelle"),
    @NamedQuery(name = "Tct.findBySupprime", query = "SELECT t FROM Tct t WHERE t.supprime = :supprime"),
    @NamedQuery(name = "Tct.findByMensuel", query = "SELECT t FROM Tct t WHERE t.mensuel = :mensuel"),
    @NamedQuery(name = "Tct.findByTypeDuree", query = "SELECT t FROM Tct t WHERE t.typeDuree = :typeDuree")})
public class Tct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "code")
    private String code;
    @Column(name = "cs")
    private Integer cs;
    @Column(name = "dateCreation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "dateMaj")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMaj;
    @Column(name = "dateSuppression")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSuppression;
    @Column(name = "dd")
    private Boolean dd;
    @Size(max = 255)
    @Column(name = "libelle")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "supprime")
    private boolean supprime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mensuel")
    private boolean mensuel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "typeDuree")
    private int typeDuree;
    @OneToMany(mappedBy = "idTypeContrat", fetch = FetchType.LAZY)
    private Collection<TavCt> tavCtCollection;
    @OneToMany(mappedBy = "idTct", fetch = FetchType.LAZY)
    private Collection<ModeleGed> modeleGedCollection;
    @JoinColumn(name = "idSoc", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Soc idSoc;

    public Tct() {
    }

    public Tct(Long id) {
        this.id = id;
    }

    public Tct(Long id, boolean supprime, boolean mensuel, int typeDuree) {
        this.id = id;
        this.supprime = supprime;
        this.mensuel = mensuel;
        this.typeDuree = typeDuree;
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

    public Integer getCs() {
        return cs;
    }

    public void setCs(Integer cs) {
        this.cs = cs;
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

    public Boolean getDd() {
        return dd;
    }

    public void setDd(Boolean dd) {
        this.dd = dd;
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

    public boolean getMensuel() {
        return mensuel;
    }

    public void setMensuel(boolean mensuel) {
        this.mensuel = mensuel;
    }

    public int getTypeDuree() {
        return typeDuree;
    }

    public void setTypeDuree(int typeDuree) {
        this.typeDuree = typeDuree;
    }

    @XmlTransient
    public Collection<TavCt> getTavCtCollection() {
        return tavCtCollection;
    }

    public void setTavCtCollection(Collection<TavCt> tavCtCollection) {
        this.tavCtCollection = tavCtCollection;
    }

    @XmlTransient
    public Collection<ModeleGed> getModeleGedCollection() {
        return modeleGedCollection;
    }

    public void setModeleGedCollection(Collection<ModeleGed> modeleGedCollection) {
        this.modeleGedCollection = modeleGedCollection;
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
        if (!(object instanceof Tct)) {
            return false;
        }
        Tct other = (Tct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Tct[ id=" + id + " ]";
    }
    
}
