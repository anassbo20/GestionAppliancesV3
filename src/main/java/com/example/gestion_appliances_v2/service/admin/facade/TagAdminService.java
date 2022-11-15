package com.example.gestion_appliances_v2.service.admin.facade;

import com.example.gestion_appliances_v2.bean.Tag;
import com.example.gestion_appliances_v2.service.core.facade.AbstractService;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.TagVo;

public interface TagAdminService extends AbstractService<Tag,Long, TagVo> {


    Tag findByReference(String reference);


    Tag findByIdOrReference(Tag tag);



    int deleteById(Long id);



    int deleteByReference(String reference);


    Tag findByLibelle(String libelle);


    int deleteByLibelle(String libelle);


    Tag archiver(Tag tag) ;


    Tag desarchiver(Tag tag);

}
