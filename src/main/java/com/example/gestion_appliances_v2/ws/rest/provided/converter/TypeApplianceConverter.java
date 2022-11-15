package com.example.gestion_appliances_v2.ws.rest.provided.converter;


import com.example.gestion_appliances_v2.bean.TypeAppliance;
import com.example.gestion_appliances_v2.service.util.DateUtil;
import com.example.gestion_appliances_v2.service.util.NumberUtil;
import com.example.gestion_appliances_v2.service.util.StringUtil;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.TypeApplianceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TypeApplianceConverter extends AbstractConverter<TypeAppliance, TypeApplianceVo> {

    @Autowired
    private ApplianceConverter applianceConverter;

    private Boolean appliances;


    public TypeApplianceConverter() {
        init(true);
    }

    @Override
    public TypeAppliance toItem(TypeApplianceVo vo) {
        if (vo == null) {
            return null;
        } else {
            TypeAppliance item = new TypeAppliance();
            if(StringUtil.isNotEmpty(vo.getId()))
            item.setId(NumberUtil.toLong(vo.getId()));
            if(StringUtil.isNotEmpty(vo.getLibelle()))
            item.setLibelle(vo.getLibelle());
            if(vo.getArchive() != null)
            item.setArchive(vo.getArchive());
            if(StringUtil.isNotEmpty(vo.getDateArchivage()))
            item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));

            return item;
        }
        }

    @Override
    public TypeApplianceVo toVo(TypeAppliance item) {
        if (item == null) {
            return null;
        } else {
            TypeApplianceVo vo = new TypeApplianceVo();
                if(item.getId()!=null)
                vo.setId(NumberUtil.toString(item.getId()));

                if(StringUtil.isNotEmpty(item.getLibelle()))
                vo.setLibelle(item.getLibelle());



            if(item.getArchive()!=null)
                vo.setArchive(item.getArchive());
            if(item.getDateArchivage()!=null)
                vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));

            return vo;
        }
    }

    public void init(Boolean value) {
            appliances = value;
    }

    public ApplianceConverter getApplianceConverter() {
        return applianceConverter;
    }

    public void setApplianceConverter(ApplianceConverter applianceConverter) {
        this.applianceConverter = applianceConverter;
    }

    public Boolean getAppliances() {
        return appliances;
    }

    public void setAppliances(Boolean appliances) {
        this.appliances = appliances;
    }
}
