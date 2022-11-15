package com.example.gestion_appliances_v2.bean;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "appliance")
public class   Appliance implements Archivable{
    @Id  @SequenceGenerator(name="appliance_seq",sequenceName="appliance_seq",
            allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "appliance_seq")
    @Column(name = "id")
    private Long id;
    @Column(unique=true)
    private String libelle;
    @Column(unique=true)
    private String dbid;
    @Column(columnDefinition = "boolean default false")
    private Boolean disponibilite=false;
    @Column(unique=true)
    private String reference;
    @ManyToOne
    private TypeAppliance typeAppliance;

    @OneToMany(mappedBy = "appliance")
    private List<ApplianceTag> applianceTags;

    @Column(columnDefinition = "boolean default false")
    private Boolean archive = false;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateArchivage ;


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

    public String getDbid() {
        return dbid;
    }

    public void setDbid(String dbid) {
        this.dbid = dbid;
    }

    public Boolean getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(Boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public TypeAppliance getTypeAppliance() {
        return typeAppliance;
    }

    public void setTypeAppliance(TypeAppliance typeAppliance) {
        this.typeAppliance = typeAppliance;
    }

    public List<ApplianceTag> getApplianceTags() {
        return applianceTags;
    }

    public void setApplianceTags(List<ApplianceTag> applianceTags) {
        this.applianceTags = applianceTags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appliance appliance = (Appliance) o;
        return id != null && id.equals(appliance.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public Boolean getArchive() {
        return this.archive;
    }

    @Override
    public void setArchive(Boolean archive) {
        this.archive=archive;
    }

    @Override
    public Date getDateArchivage() {
        return this.dateArchivage;
    }

    @Override
    public void setDateArchivage(Date dateArchivage) {
        this.dateArchivage=dateArchivage;
    }
}
