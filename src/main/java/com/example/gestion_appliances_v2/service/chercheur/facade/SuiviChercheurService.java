package com.example.gestion_appliances_v2.service.chercheur.facade;

import com.example.gestion_appliances_v2.bean.Suivi;
import com.example.gestion_appliances_v2.service.core.facade.AbstractService;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.SuiviVo;

import java.math.BigDecimal;
import java.util.List;

public interface SuiviChercheurService extends AbstractService<Suivi,Long, SuiviVo> {

    List<Suivi> findByOffreCommercialIs(boolean offre);

    int deleteByOffreCommercialIs(boolean off);

    List<Suivi>  findByMontantGreaterThan(BigDecimal mont);

    List<Suivi>  findByPovId(Long id);

    List<Suivi> findByPovLibelle(String libelle);

    int deleteByPovId(Long id);

    int deleteByPovLibelle(String libelle);

    List<Suivi> findByTypePrestationId(Long id);

    int deleteByTypePrestationId(Long id);

    List<Suivi> findByTypePrestationLibelle(String lib);

    int deleteByTypePrestationLibelle(String lib);

}
