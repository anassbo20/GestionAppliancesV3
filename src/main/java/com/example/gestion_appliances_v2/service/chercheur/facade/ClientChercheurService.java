package com.example.gestion_appliances_v2.service.chercheur.facade;

import com.example.gestion_appliances_v2.bean.Client;
import com.example.gestion_appliances_v2.service.core.facade.AbstractService;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.ClientVo;

import java.util.List;

public interface ClientChercheurService extends AbstractService<Client,Long, ClientVo> {
    Client findByLibelle(String libelle);


    Client findByIdOrLibelle(Client client);

    List<Client> findByActivite(String activite);

    List<Client> findBySecteur(Client.Secteur secteur);

    int deleteById(Long id);

    int deleteByLibelle(String libelle);

    int deleteBySecteur(String secteur);

    int deleteByActivite(String activite);



}
