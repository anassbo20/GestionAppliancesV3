package com.example.gestion_appliances_v2.ws.rest.provided.vo;

public class SuiviVo {

    private String id;

    private Boolean offreCommercial;

    private String montant;

        private String montantMax;

        private String montantMin;

    private String compteRendu;

    private PovVo povVo;

    private TypePrestationVo typePrestationVo;

    private Boolean archive ;

    private String dateArchivage ;

        private String dateArchivageMax ;

        private String dateArchivageMin ;

    public SuiviVo() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getOffreCommercial() {
        return offreCommercial;
    }

    public void setOffreCommercial(Boolean offreCommercial) {
        this.offreCommercial = offreCommercial;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getMontantMax() {
        return montantMax;
    }

    public void setMontantMax(String montantMax) {
        this.montantMax = montantMax;
    }

    public String getMontantMin() {
        return montantMin;
    }

    public void setMontantMin(String montantMin) {
        this.montantMin = montantMin;
    }

    public String getCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
    }

    public PovVo getPovVo() {
        return povVo;
    }

    public void setPovVo(PovVo povVo) {
        this.povVo = povVo;
    }

    public TypePrestationVo getTypePrestationVo() {
        return typePrestationVo;
    }

    public void setTypePrestationVo(TypePrestationVo typePrestationVo) {
        this.typePrestationVo = typePrestationVo;
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
