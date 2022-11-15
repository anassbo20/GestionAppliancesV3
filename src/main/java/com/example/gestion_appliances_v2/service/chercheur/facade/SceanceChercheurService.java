package com.example.gestion_appliances_v2.service.chercheur.facade;

import com.example.gestion_appliances_v2.bean.Sceance;
import com.example.gestion_appliances_v2.service.core.facade.AbstractService;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.SceanceVo;

import java.util.Date;
import java.util.List;

public interface SceanceChercheurService extends AbstractService<Sceance,Long, SceanceVo> {

        List<Sceance> findByDateSceance(Date dateSc);

        int deleteByDateSceance(Date dateSc);

        List<Sceance> findByPovLibelle(String lib);

        int deleteByPovLibelle(String lib);



}
