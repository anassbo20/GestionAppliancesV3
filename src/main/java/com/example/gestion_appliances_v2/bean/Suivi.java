package com.example.gestion_appliances_v2.bean;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "suivi")
public class Suivi implements Archivable{
    @Id  @SequenceGenerator(name="suivi_seq",sequenceName="suivi_seq",
            allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "suivi_seq")
    @Column(name = "id")
    private Long id;
    @Column(columnDefinition = "boolean default false")
    private Boolean offreCommercial=false;
    private BigDecimal montant;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String compteRendu;
    @ManyToOne
    private Pov pov;
    @ManyToOne
    private TypePrestation typePrestation;
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

    public Boolean getOffreCommercial() {
        return offreCommercial;
    }

    public void setOffreCommercial(Boolean offreCommercial) {
        this.offreCommercial = offreCommercial;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public String getCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
    }

    public Pov getPov() {
        return pov;
    }

    public void setPov(Pov pov) {
        this.pov = pov;
    }

    public TypePrestation getTypePrestation() {
        return typePrestation;
    }

    public void setTypePrestation(TypePrestation typePrestation) {
        this.typePrestation = typePrestation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Suivi suivi = (Suivi) o;
        return id != null && id.equals(suivi.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
