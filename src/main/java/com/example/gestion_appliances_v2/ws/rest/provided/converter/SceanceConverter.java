package com.example.gestion_appliances_v2.ws.rest.provided.converter;


import com.example.gestion_appliances_v2.bean.Sceance;
import com.example.gestion_appliances_v2.service.util.DateUtil;
import com.example.gestion_appliances_v2.service.util.NumberUtil;
import com.example.gestion_appliances_v2.service.util.StringUtil;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.SceanceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SceanceConverter extends AbstractConverter<Sceance, SceanceVo> {

    @Autowired
    private PovConverter povConverter;

    private Boolean pov;
    public SceanceConverter() {
        init(true);
    }

    @Override
    public Sceance toItem(SceanceVo vo) {
        if (vo == null) {
            return null;
        } else {
            Sceance item = new Sceance();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getResume()))
                item.setResume(vo.getResume());
            if (StringUtil.isNotEmpty(vo.getParticipants()))
                item.setParticipants(vo.getParticipants());
            if(StringUtil.isNotEmpty(vo.getDateSceance()))
                item.setDateSceance(DateUtil.parse(vo.getDateSceance()));
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
        public SceanceVo toVo (Sceance item) {
            if (item == null) {
                return null;
            } else {
                SceanceVo vo = new SceanceVo();
                    if(item.getId()!=null)
                    vo.setId(NumberUtil.toString(item.getId()));

                    if(StringUtil.isNotEmpty(item.getResume()))
                    vo.setResume(item.getResume());

                    if(StringUtil.isNotEmpty(item.getParticipants()))
                    vo.setParticipants(item.getParticipants());

                    if(item.getDateSceance()!=null)
                    vo.setDateSceance(DateUtil.formateDate(item.getDateSceance()));

                    if(item.getPov()!=null && this.pov) {
                    vo.setPovVo(povConverter.toVo(item.getPov()));

                    if(item.getArchive()!=null)
                    vo.setArchive(item.getArchive());
                    if(item.getDateArchivage()!=null)
                    vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));
                    }
                return vo;
            }
        }
        public void init (Boolean value){
              pov = value;
        }

    public PovConverter getPovConverter() {
        return povConverter;
    }

    public void setPovConverter(PovConverter povConverter) {
        this.povConverter = povConverter;
    }

    public Boolean getPov() {
        return pov;
    }

    public void setPov(Boolean pov) {
        this.pov = pov;
    }
}

