package com.example.gestion_appliances_v2.ws.rest.provided.vo;

public class ApplianceTagVo {

    private String id;

    private ApplianceVo applianceVo;

    private TagVo tagVo;

    public ApplianceTagVo() {
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

    public TagVo getTagVo() {
        return tagVo;
    }

    public void setTagVo(TagVo tagVo) {
        this.tagVo = tagVo;
    }
}
