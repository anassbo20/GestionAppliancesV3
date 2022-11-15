package com.example.gestion_appliances_v2.ws.rest.provided.converter;


import com.example.gestion_appliances_v2.bean.ApplianceTag;
import com.example.gestion_appliances_v2.service.util.NumberUtil;
import com.example.gestion_appliances_v2.service.util.StringUtil;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.ApplianceTagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplianceTagConverter extends AbstractConverter<ApplianceTag, ApplianceTagVo>{

        @Autowired
        private TagConverter tagConverter ;
        @Autowired
        private ApplianceConverter applianceConverter ;
    private Boolean appliance;
    private Boolean tag;

public ApplianceTagConverter(){
init(true);
}

@Override
public ApplianceTag toItem(ApplianceTagVo vo) {
if (vo == null) {
return null;
} else {
ApplianceTag item = new ApplianceTag();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getApplianceVo()!=null && this.appliance)
        item.setAppliance(applianceConverter.toItem(vo.getApplianceVo())) ;
    if(vo.getTagVo()!=null && this.tag)
        item.setTag(tagConverter.toItem(vo.getTagVo())) ;


return item;
}
}

@Override
public ApplianceTagVo toVo(ApplianceTag item) {
if (item == null) {
return null;
} else {
ApplianceTagVo vo = new ApplianceTagVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

    if(item.getAppliance()!=null && this.appliance) {
        vo.setApplianceVo(applianceConverter.toVo(item.getAppliance())) ;
    }
    if(item.getTag()!=null && this.tag) {
        vo.setTagVo(tagConverter.toVo(item.getTag())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    appliance = value;
    tag = value;
}


        public TagConverter getTagConverter(){
        return this.tagConverter;
        }
        public void setTagConverter(TagConverter tagConverter ){
        this.tagConverter = tagConverter;
        }
        public ApplianceConverter getApplianceConverter(){
        return this.applianceConverter;
        }
        public void setApplianceConverter(ApplianceConverter applianceConverter ){
        this.applianceConverter = applianceConverter;
        }

    public boolean  isAppliance(){
    return this.appliance;
    }
    public void  setAppliance(boolean appliance){
    this.appliance = appliance;
    }
    public boolean  isTag(){
    return this.tag;
    }
    public void  setTag(boolean tag){
    this.tag = tag;
    }






}
