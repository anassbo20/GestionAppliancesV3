package com.example.gestion_appliances_v2.ws.rest.provided.vo;


import java.util.List;

public class ApplianceVo {

    private String id;

    private String libelle;

    private String dbid;

    private Boolean disponibilite;

    private String reference;

    private TypeApplianceVo typeApplianceVo;

    private List<ApplianceTagVo> applianceTagVos;

    private Boolean archive ;

    private String dateArchivage ;

            private String dateArchivageMax ;

            private String dateArchivageMin ;

    public ApplianceVo() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public TypeApplianceVo getTypeApplianceVo() {
        return typeApplianceVo;
    }

    public void setTypeApplianceVo(TypeApplianceVo typeApplianceVo) {
        this.typeApplianceVo = typeApplianceVo;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public String getDateArchivage() {
        return dateArchivage;
    }

    public void setDateArchivage(String dateArchivage) {
        this.dateArchivage = dateArchivage;
    }

    public String getDateArchivageMax() {
        return dateArchivageMax;
    }

    public void setDateArchivageMax(String dateArchivageMax) {
        this.dateArchivageMax = dateArchivageMax;
    }

    public String getDateArchivageMin() {
        return dateArchivageMin;
    }

    public void setDateArchivageMin(String dateArchivageMin) {
        this.dateArchivageMin = dateArchivageMin;
    }

    public List<ApplianceTagVo> getApplianceTagVos() {
        return applianceTagVos;
    }

    public void setApplianceTagVos(List<ApplianceTagVo> applianceTagVos) {
        this.applianceTagVos = applianceTagVos;
    }
}
