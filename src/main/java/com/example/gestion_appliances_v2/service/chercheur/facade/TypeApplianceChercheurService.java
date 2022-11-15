package com.example.gestion_appliances_v2.service.chercheur.facade;


import com.example.gestion_appliances_v2.bean.TypeAppliance;
import com.example.gestion_appliances_v2.service.core.facade.AbstractService;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.TypeApplianceVo;

public interface TypeApplianceChercheurService extends AbstractService<TypeAppliance,Long, TypeApplianceVo> {

    TypeAppliance findByLibelle(String libelle);
    int deleteByLibelle(String lib);

    TypeAppliance findByIdOrLibelle(TypeAppliance typeAppliance);

    int deleteById(Long id);


}
