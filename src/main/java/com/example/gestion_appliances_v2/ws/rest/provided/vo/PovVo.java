package com.example.gestion_appliances_v2.ws.rest.provided.vo;

public class PovVo {

    private String id;

    private ApplianceVo applianceVo;

    private ClientVo clientVo;

    private String libelle;

    private String dateDebut;

            private String dateDebutMax;

            private String dateDebutMin;

    private String dateFin;

            private String dateFinMax;

            private String dateFinMin;

    private String description;

    private String compteManager;

    private String ingenieurCyberSecurity;

    private String analyseCyberSecurity;

    private Boolean archive ;

    private String dateArchivage ;

            private String dateArchivageMax ;

            private String dateArchivageMin ;

    public PovVo() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ApplianceVo getApplianceVo() {
        return applianceVo;
    }

    public void setApplianceVo(ApplianceVo applianceVo) {
        this.applianceVo = applianceVo;
    }

    public ClientVo getClientVo() {
        return clientVo;
    }

    public void setClientVo(ClientVo clientVo) {
        this.clientVo = clientVo;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateDebutMax() {
        return dateDebutMax;
    }

    public void setDateDebutMax(String dateDebutMax) {
        this.dateDebutMax = dateDebutMax;
    }

    public String getDateDebutMin() {
        return dateDebutMin;
    }

    public void setDateDebutMin(String dateDebutMin) {
        this.dateDebutMin = dateDebutMin;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getDateFinMax() {
        return dateFinMax;
    }

    public void setDateFinMax(String dateFinMax) {
        this.dateFinMax = dateFinMax;
    }

    public String getDateFinMin() {
        return dateFinMin;
    }

    public void setDateFinMin(String dateFinMin) {
        this.dateFinMin = dateFinMin;
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
}
