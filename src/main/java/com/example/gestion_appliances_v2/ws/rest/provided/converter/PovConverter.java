package com.example.gestion_appliances_v2.ws.rest.provided.converter;


import com.example.gestion_appliances_v2.bean.Pov;
import com.example.gestion_appliances_v2.service.util.DateUtil;
import com.example.gestion_appliances_v2.service.util.NumberUtil;
import com.example.gestion_appliances_v2.service.util.StringUtil;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.PovVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PovConverter extends AbstractConverter<Pov, PovVo> {

    @Autowired
    private ClientConverter clientConverter;

    @Autowired
    private ApplianceConverter applianceConverter;

    private Boolean client;

    private Boolean appliance;

    public PovConverter(){ init(true);}
    @Override
    public Pov toItem(PovVo vo) {
        if (vo == null) {
            return null;
        } else {
            Pov item = new Pov();
               if(StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
               if(StringUtil.isNotEmpty(vo.getLibelle()))
                item.setLibelle(vo.getLibelle());
               if(StringUtil.isNotEmpty(vo.getDescription()))
                item.setDescription(vo.getDescription());
               if(StringUtil.isNotEmpty(vo.getCompteManager()))
                item.setCompteManager(vo.getCompteManager());
               if(StringUtil.isNotEmpty(vo.getIngenieurCyberSecurity()))
                item.setIngenieurCyberSecurity(vo.getIngenieurCyberSecurity());
               if(StringUtil.isNotEmpty(vo.getAnalyseCyberSecurity()))
                item.setAnalyseCyberSecurity(vo.getAnalyseCyberSecurity());
               if(StringUtil.isNotEmpty(vo.getDateDebut()))
                item.setDateDebut(DateUtil.parse(vo.getDateDebut()));
               if(StringUtil.isNotEmpty(vo.getDateFin()))
                item.setDateFin(DateUtil.parse(vo.getDateFin()));
               if(vo.getArchive() != null)
                item.setArchive(vo.getArchive());
               if(StringUtil.isNotEmpty(vo.getDateArchivage()))
                item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));
               if(vo.getClientVo()!=null && this.client)
                item.setClient(clientConverter.toItem(vo.getClientVo()));
               if(vo.getApplianceVo()!=null && this.appliance)
                item.setAppliance(applianceConverter.toItem(vo.getApplianceVo()));

               return item;
        }
    }

    @Override
    public PovVo toVo(Pov item) {
        if (item == null) {
            return null;
        } else {
            PovVo vo = new PovVo();
                if(item.getId()!=null)
                vo.setId(NumberUtil.toString(item.getId()));

                if(StringUtil.isNotEmpty(item.getLibelle()))
                vo.setLibelle(item.getLibelle());

                if(StringUtil.isNotEmpty(item.getDescription()))
                vo.setLibelle(item.getDescription());

                if(StringUtil.isNotEmpty(item.getCompteManager()))
                vo.setCompteManager(item.getCompteManager());

                if(StringUtil.isNotEmpty(item.getIngenieurCyberSecurity()))
                vo.setLibelle(item.getIngenieurCyberSecurity());

                if(StringUtil.isNotEmpty(item.getAnalyseCyberSecurity()))
                vo.setLibelle(item.getAnalyseCyberSecurity());

                if(item.getDateDebut()!=null)
                vo.setDateDebut(DateUtil.formateDate(item.getDateDebut()));

                if(item.getDateFin()!=null)
                vo.setDateFin(DateUtil.formateDate(item.getDateFin()));

                if(item.getArchive()!=null)
                vo.setArchive(item.getArchive());
                if(item.getDateArchivage()!=null)
                vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));

                if(item.getClient()!=null && this.client) {
                vo.setClientVo(clientConverter.toVo(item.getClient()));
                }

                if(item.getAppliance()!=null && this.appliance) {
                vo.setApplianceVo(applianceConverter.toVo(item.getAppliance()));
                }
                return vo;
        }
    }

    public void init(Boolean value) {
        client = value;
        appliance = value;
    }

    public ClientConverter getClientConverter() {
        return clientConverter;
    }

    public void setClientConverter(ClientConverter clientConverter) {
        this.clientConverter = clientConverter;
    }

    public ApplianceConverter getApplianceConverter() {
        return applianceConverter;
    }

    public void setApplianceConverter(ApplianceConverter applianceConverter) {
        this.applianceConverter = applianceConverter;
    }

    public Boolean getClient() {
        return client;
    }

    public void setClient(Boolean client) {
        this.client = client;
    }

    public Boolean getAppliance() {
        return appliance;
    }

    public void setAppliance(Boolean appliance) {
        this.appliance = appliance;
    }
}
