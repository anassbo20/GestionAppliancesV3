package com.example.gestion_appliances_v2.ws.rest.provided.converter;


import com.example.gestion_appliances_v2.bean.Tag;
import com.example.gestion_appliances_v2.service.util.DateUtil;
import com.example.gestion_appliances_v2.service.util.NumberUtil;
import com.example.gestion_appliances_v2.service.util.StringUtil;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.TagVo;
import org.springframework.stereotype.Component;

@Component
public class TagConverter extends AbstractConverter<Tag, TagVo>{


public TagConverter(){
init(true);
}

@Override
public Tag toItem(TagVo vo) {
if (vo == null) {
return null;
} else {
Tag item = new Tag();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
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
public TagVo toVo(Tag item) {
if (item == null) {
return null;
} else {
TagVo vo = new TagVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

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
}













}
