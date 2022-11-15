package com.example.gestion_appliances_v2.ws.rest.provided.vo;

public class SceanceVo {

    private String id;

    private String dateSceance;

            private String dateSceanceMax;

            private String dateSceanceMin;

    private String resume;

    private String participants= new String() ;

    private PovVo povVo;

    private Boolean archive ;

    private String dateArchivage ;

            private String dateArchivageMax ;

            private String dateArchivageMin ;

    public SceanceVo() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateSceance() {
        return dateSceance;
    }

    public void setDateSceance(String dateSceance) {
        this.dateSceance = dateSceance;
    }

    public String getDateSceanceMax() {
        return dateSceanceMax;
    }

    public void setDateSceanceMax(String dateSceanceMax) {
        this.dateSceanceMax = dateSceanceMax;
    }

    public String getDateSceanceMin() {
        return dateSceanceMin;
    }

    public void setDateSceanceMin(String dateSceanceMin) {
        this.dateSceanceMin = dateSceanceMin;
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

    public PovVo getPovVo() {
        return povVo;
    }

    public void setPovVo(PovVo povVo) {
        this.povVo = povVo;
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
