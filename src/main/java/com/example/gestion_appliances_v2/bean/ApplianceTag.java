package com.example.gestion_appliances_v2.bean;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "appliance_tag")
public class ApplianceTag {
    @Id
    @SequenceGenerator(name = "appliance_tag_seq", sequenceName = "appliance_tag_seq", allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appliance_tag_seq")
    @Column(name = "id")
    private Long id;
    @ManyToOne
    private Appliance appliance;
    @ManyToOne
    private Tag tag;

    public ApplianceTag() {
        super();
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

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplianceTag applianceTag = (ApplianceTag) o;
        return id != null && id.equals(applianceTag.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
