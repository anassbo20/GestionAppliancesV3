package com.example.gestion_appliances_v2.service.chercheur.facade;


import com.example.gestion_appliances_v2.bean.Chercheur;
import com.example.gestion_appliances_v2.service.core.facade.AbstractService;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.ChercheurVo;

public interface ChercheurChercheurService extends AbstractService<Chercheur,Long, ChercheurVo> {

    Chercheur findByUsername(String username);


    Chercheur findByNumeroMatricule(String numeroMatricule);


    Chercheur findByIdOrNumeroMatricule(Chercheur chercheur);


    int deleteById(Long id);




   int deleteByNumeroMatricule(String numeroMatricule);





}
