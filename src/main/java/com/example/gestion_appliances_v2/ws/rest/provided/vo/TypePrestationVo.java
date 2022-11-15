package com.example.gestion_appliances_v2.ws.rest.provided.vo;

import java.util.List;

public class TypePrestationVo {

    private String id;

    private String libelle;

    List<SuiviVo> suiviVos;

    private Boolean archive ;

    private String dateArchivage ;

        private String dateArchivageMax ;

        private String dateArchivageMin ;

    public TypePrestationVo() {
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

    public List<SuiviVo> getSuiviVos() {
        return suiviVos;
    }

    public void setSuiviVos(List<SuiviVo> suiviVos) {
        this.suiviVos = suiviVos;
    }
}
