package com.example.gestion_appliances_v2.ws.rest.provided.converter;


import com.example.gestion_appliances_v2.bean.Appliance;
import com.example.gestion_appliances_v2.service.util.DateUtil;
import com.example.gestion_appliances_v2.service.util.ListUtil;
import com.example.gestion_appliances_v2.service.util.NumberUtil;
import com.example.gestion_appliances_v2.service.util.StringUtil;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.ApplianceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplianceConverter extends AbstractConverter<Appliance, ApplianceVo>{

  @Autowired
  private TypeApplianceConverter typeApplianceConverter;

  @Autowired
  private ApplianceTagConverter applianceTagConverter;
  private Boolean applianceTags;
  private Boolean typeAppliance;


public ApplianceConverter(){
init(true);
}

@Override
public Appliance toItem(ApplianceVo vo) {
if (vo == null) {
return null;
} else {
Appliance item = new Appliance();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getDbid()))
        item.setDbid(vo.getDbid());
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(vo.getDisponibilite() != null)
        item.setDisponibilite(vo.getDisponibilite());
        if(vo.getArchive() != null)
        item.setArchive(vo.getArchive());
        if(StringUtil.isNotEmpty(vo.getDateArchivage()))
        item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));
        if(vo.getTypeApplianceVo()!=null && this.typeAppliance)
        item.setTypeAppliance(typeApplianceConverter.toItem(vo.getTypeApplianceVo()));
        if(ListUtil.isNotEmpty(vo.getApplianceTagVos()) && this.applianceTags)
        item.setApplianceTags(applianceTagConverter.toItem(vo.getApplianceTagVos()));

return item;
}
}

@Override
public ApplianceVo toVo(Appliance item) {
if (item == null) {
return null;
} else {
ApplianceVo vo = new ApplianceVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getDbid()))
        vo.setDbid(item.getDbid());

        if(item.getDisponibilite()!=null)
        vo.setDisponibilite(item.getDisponibilite());

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(item.getArchive()!=null)
        vo.setArchive(item.getArchive());
        if(item.getDateArchivage()!=null)
        vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));
        if(item.getTypeAppliance()!=null && this.typeAppliance) {
        vo.setTypeApplianceVo(typeApplianceConverter.toVo(item.getTypeAppliance())) ;
        }
        
        if(ListUtil.isNotEmpty(item.getApplianceTags()) && this.applianceTags){
        applianceTagConverter.init(true);
        applianceTagConverter.setAppliance(false);
        vo.setApplianceTagVos(applianceTagConverter.toVo(item.getApplianceTags()));
         applianceTagConverter.setAppliance(true);
        }

return vo;
}
}

 public void init(Boolean value) {
                typeAppliance = value;
                applianceTags = value;
}

    public TypeApplianceConverter getTypeApplianceConverter() {
        return typeApplianceConverter;
    }

    public void setTypeApplianceConverter(TypeApplianceConverter typeApplianceConverter) {
        this.typeApplianceConverter = typeApplianceConverter;
    }

    public ApplianceTagConverter getApplianceTagConverter() {
        return applianceTagConverter;
    }

    public void setApplianceTagConverter(ApplianceTagConverter applianceTagConverter) {
        this.applianceTagConverter = applianceTagConverter;
    }

    public Boolean getApplianceTags() {
        return applianceTags;
    }

    public void setApplianceTags(Boolean applianceTags) {
        this.applianceTags = applianceTags;
    }

    public Boolean getTypeAppliance() {
        return typeAppliance;
    }

    public void setTypeAppliance(Boolean typeAppliance) {
        this.typeAppliance = typeAppliance;
    }
}
