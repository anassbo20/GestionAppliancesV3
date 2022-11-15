package com.example.gestion_appliances_v2.ws.rest.provided.converter;


import com.example.gestion_appliances_v2.bean.Suivi;
import com.example.gestion_appliances_v2.service.util.DateUtil;
import com.example.gestion_appliances_v2.service.util.NumberUtil;
import com.example.gestion_appliances_v2.service.util.StringUtil;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.SuiviVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SuiviConverter extends AbstractConverter<Suivi, SuiviVo> {


    @Autowired
    private TypePrestationConverter typePrestationConverter;

    @Autowired
    private PovConverter povConverter;

    private Boolean typePrestation;
    private Boolean pov;
    public SuiviConverter() {
        init(true);
    }

    @Override
    public Suivi toItem(SuiviVo vo) {
        if (vo == null) {
            return null;
        } else {
            Suivi item = new Suivi();
                if(StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
                if(StringUtil.isNotEmpty(vo.getCompteRendu()))
                item.setCompteRendu(vo.getCompteRendu());
                if(vo.getOffreCommercial() != null)
                item.setOffreCommercial(vo.getOffreCommercial());
                if(StringUtil.isNotEmpty(vo.getMontant()))
                item.setMontant(NumberUtil.toBigDecimal(vo.getMontant()));
                if(vo.getTypePrestationVo()!=null && this.typePrestation)
                item.setTypePrestation(typePrestationConverter.toItem(vo.getTypePrestationVo()));
                if(vo.getPovVo()!=null && this.pov)
                item.setPov(povConverter.toItem(vo.getPovVo()));
                if(vo.getArchive() != null)
                item.setArchive(vo.getArchive());
                if(StringUtil.isNotEmpty(vo.getDateArchivage()))
                item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));

                return item;
        }
    }

    @Override
    public SuiviVo toVo(Suivi item) {
        if (item == null) {
            return null;
        } else {
           SuiviVo vo = new SuiviVo();
                if(item.getId()!=null)
                vo.setId(NumberUtil.toString(item.getId()));

                if(item.getOffreCommercial()!=null)
                vo.setOffreCommercial(item.getOffreCommercial());

                if(item.getMontant()!=null)
                vo.setMontant(NumberUtil.toString(item.getMontant()));

                if(StringUtil.isNotEmpty(item.getCompteRendu()))
                vo.setCompteRendu(item.getCompteRendu());

                if(item.getPov()!=null && this.pov) {
                vo.setPovVo(povConverter.toVo(item.getPov()));
                }
                if(item.getTypePrestation()!=null && this.typePrestation) {
                vo.setTypePrestationVo(typePrestationConverter.toVo(item.getTypePrestation()));
                }
                if(item.getArchive()!=null)
                vo.setArchive(item.getArchive());
                if(item.getDateArchivage()!=null)
                vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));

                return vo;
        }
    }
    public void init(Boolean value) {
        pov = value;
        typePrestation = value;
    }

    public TypePrestationConverter getTypePrestationConverter() {
        return typePrestationConverter;
    }

    public void setTypePrestationConverter(TypePrestationConverter typePrestationConverter) {
        this.typePrestationConverter = typePrestationConverter;
    }

    public PovConverter getPovConverter() {
        return povConverter;
    }

    public void setPovConverter(PovConverter povConverter) {
        this.povConverter = povConverter;
    }

    public Boolean getTypePrestation() {
        return typePrestation;
    }

    public void setTypePrestation(Boolean typePrestation) {
        this.typePrestation = typePrestation;
    }

    public Boolean getPov() {
        return pov;
    }

    public void setPov(Boolean pov) {
        this.pov = pov;
    }
}
