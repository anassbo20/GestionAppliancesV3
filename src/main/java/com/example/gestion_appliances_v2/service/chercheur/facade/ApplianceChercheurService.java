package com.example.gestion_appliances_v2.service.chercheur.facade;
import com.example.gestion_appliances_v2.bean.Appliance;
import com.example.gestion_appliances_v2.service.core.facade.AbstractService;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.ApplianceVo;

import java.util.List;

public interface ApplianceChercheurService extends AbstractService<Appliance,Long, ApplianceVo> {



    Appliance findByDibd(String dbid);


    Appliance findByReference(String ref);

    public Appliance findByIdOrReference(Appliance appliance);


    List<Appliance> findByTypeApplianceLibelle(String libelle);


    List<Appliance> findByDisponibilite(boolean disp);

    int deleteById(Long id);

    int deleteByDibd(String dbid);


    int deleteByReference(String reference);


    int deleteByTypeApplianceLibelle(String libelle);


    int deleteByTypeApplianceId(Long id);


}
