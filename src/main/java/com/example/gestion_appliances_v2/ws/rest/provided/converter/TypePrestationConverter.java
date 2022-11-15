package com.example.gestion_appliances_v2.ws.rest.provided.converter;


import com.example.gestion_appliances_v2.bean.TypePrestation;
import com.example.gestion_appliances_v2.service.util.DateUtil;
import com.example.gestion_appliances_v2.service.util.NumberUtil;
import com.example.gestion_appliances_v2.service.util.StringUtil;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.TypePrestationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TypePrestationConverter extends AbstractConverter<TypePrestation, TypePrestationVo> {

    @Autowired
    private SuiviConverter suiviConverter;
    
    private Boolean suivis;
    
    public TypePrestationConverter() {
        init(true);
    }

    @Override
    public TypePrestation toItem(TypePrestationVo vo) {
        if (vo == null) {
            return null;
        } else {
             TypePrestation item = new TypePrestation();
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
    public TypePrestationVo toVo(TypePrestation item) {
        if (item == null) {
            return null;
        } else {
            TypePrestationVo vo = new TypePrestationVo();
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
    public void init(Boolean value) { suivis = value;}

    public SuiviConverter getSuiviConverter() {
        return suiviConverter;
    }

    public void setSuiviConverter(SuiviConverter suiviConverter) {
        this.suiviConverter = suiviConverter;
    }

    public Boolean getSuivis() {
        return suivis;
    }

    public void setSuivis(Boolean suivis) {
        this.suivis = suivis;
    }
}
