package com.example.gestion_appliances_v2.service.admin.facade;

import com.example.gestion_appliances_v2.bean.Pov;
import com.example.gestion_appliances_v2.service.core.facade.AbstractService;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.PovVo;

import java.util.List;

public interface PovAdminService extends AbstractService<Pov,Long, PovVo> {

    Pov findByLibelle(String libelle);

    Pov findByIdOrLibelle(Pov pov);

    int deleteById(Long id);

    int deleteByLibelle(String libelle);

    List<Pov> findByClientLibelle(String lib);

    int deleteByClientLibelle(String lib);

    List<Pov> findByApplianceReference(String ref);

    int deleteByApplianceReference(String ref);


    Pov archiver(Pov pov) ;

    Pov desarchiver(Pov pov);


}
