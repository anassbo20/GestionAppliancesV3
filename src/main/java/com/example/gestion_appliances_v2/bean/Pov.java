package com.example.gestion_appliances_v2.bean;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pov")
public class Pov implements Archivable{
    @Id   @SequenceGenerator(name="pov_seq",sequenceName="pov_seq",
            allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pov_seq")
    @Column(name = "id")
    private Long id;
    @ManyToOne
    private Appliance appliance;
    @ManyToOne
    private Client client;
    @Column(unique=true)
    private String libelle;

    @OneToMany(mappedBy = "pov")
    private List<Sceance> sceances;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;
    private String compteManager;
    private String ingenieurCyberSecurity;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String analyseCyberSecurity;
    @Column(columnDefinition = "boolean default false")
    private Boolean archive = false;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateArchivage ;

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

    public Appliance getAppliance() {
        return appliance;
    }

    public void setAppliance(Appliance appliance) {
        this.appliance = appliance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompteManager() {
        return compteManager;
    }

    public void setCompteManager(String compteManager) {
        this.compteManager = compteManager;
    }

    public String getIngenieurCyberSecurity() {
        return ingenieurCyberSecurity;
    }

    public void setIngenieurCyberSecurity(String ingenieurCyberSecurity) {
        this.ingenieurCyberSecurity = ingenieurCyberSecurity;
    }

    public String getAnalyseCyberSecurity() {
        return analyseCyberSecurity;
    }

    public void setAnalyseCyberSecurity(String analyseCyberSecurity) {
        this.analyseCyberSecurity = analyseCyberSecurity;
    }

    public List<Sceance> getSceances() {
        return sceances;
    }

    public void setSceances(List<Sceance> sceances) {
        this.sceances = sceances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pov pov = (Pov) o;
        return id != null && id.equals(pov.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
