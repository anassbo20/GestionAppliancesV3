package com.example.gestion_appliances_v2.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Sceance")
public class Sceance implements Archivable{
    @Id
    @SequenceGenerator(name="sceance_seq",sequenceName="sceance_seq",
            allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sceance_seq")
    @Column(name = "id")
    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateSceance;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String resume;

    private String participants= new String() ;
    @ManyToOne
    private Pov pov;
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

    public Date getDateSceance() {
        return dateSceance;
    }

    public void setDateSceance(Date dateSceance) {
        this.dateSceance = dateSceance;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public Pov getPov() {
        return pov;
    }

    public void setPov(Pov pov) {
        this.pov = pov;
    }

    @Override
    public Boolean getArchive() {
        return archive;
    }

    @Override
    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    @Override
    public Date getDateArchivage() {
        return dateArchivage;
    }

    @Override
    public void setDateArchivage(Date dateArchivage) {
        this.dateArchivage = dateArchivage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sceance sceance = (Sceance) o;
        return id != null && id.equals(sceance.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
