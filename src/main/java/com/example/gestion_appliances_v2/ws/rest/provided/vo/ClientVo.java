package com.example.gestion_appliances_v2.ws.rest.provided.vo;

import com.example.gestion_appliances_v2.bean.Client;

import java.util.List;

public class ClientVo {

    private String id;

    private String libelle;

    private Client.Secteur secteur;

    private String activite;

    private Boolean archive ;


    private List<ContactVo> contactVos;

    private String dateArchivage ;

            private String dateArchivageMax ;

            private String dateArchivageMin ;

    public ClientVo() {
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

    public Client.Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Client.Secteur secteur) {
        this.secteur = secteur;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
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

    public List<ContactVo> getContactVos() {
        return contactVos;
    }

    public void setContactVos(List<ContactVo> contactVos) {
        this.contactVos = contactVos;
    }
}
