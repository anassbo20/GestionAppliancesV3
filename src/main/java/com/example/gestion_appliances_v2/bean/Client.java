package com.example.gestion_appliances_v2.bean;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "client")
public class Client implements Archivable{
    @Id  @SequenceGenerator(name="client_seq",sequenceName="client_seq",
            allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "client_seq")
    @Column(name = "id")
    private Long id;
    @Column(unique=true)
    private String libelle;
    private Secteur secteur;
    private String activite;

   // @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    //private List<Contact> contacts;
    @Column(columnDefinition = "boolean default false")
    private Boolean archive = false;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateArchivage ;

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public Date getDateArchivage() {
        return dateArchivage;
    }

    public void setDateArchivage(Date dateArchivage) {
        this.dateArchivage = dateArchivage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = Secteur.valueOf(secteur);
    }

    public String getActivite() {
        return activite;
    }

   /* public List<Contact> getContacts() {
        return contacts;
    }*/

    /*public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }*/

    public void setActivite(String activite) {
        this.activite = activite;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id != null && id.equals(client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public enum Secteur{
        publique("pub"),privé("pr");
        private String abreviation;

        private Secteur(String abreviation) {
            this.abreviation = abreviation;
        }

        public String getAbreviation() {
            return  this.abreviation ;
        }
    }

}
