package com.example.gestion_appliances_v2.service.admin.facade;

import com.example.gestion_appliances_v2.bean.TypePrestation;
import com.example.gestion_appliances_v2.service.core.facade.AbstractService;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.TypePrestationVo;

public interface TypePrestationAdminService extends AbstractService<TypePrestation,Long, TypePrestationVo> {

    TypePrestation findByLibelle(String libelle);

    int deleteByLibelle(String lib);

    TypePrestation findByIdOrLibelle(TypePrestation typePrestation);

    int deleteById(Long id);

    TypePrestation archiver(TypePrestation typePrestation) ;

    TypePrestation desarchiver(TypePrestation typePrestation);

}
