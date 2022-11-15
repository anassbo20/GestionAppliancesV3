package com.example.gestion_appliances_v2.dao;


import com.example.gestion_appliances_v2.bean.Suivi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SuiviDao extends JpaRepository<Suivi,Long> {
    List<Suivi>  findByOffreCommercialIs(boolean offre);
    int deleteByOffreCommercialIs(boolean off);
    List<Suivi>  findByMontantGreaterThan(BigDecimal mont);

    List<Suivi> findByPovLibelle(String libelle);

    int deleteByPovLibelle(String libelle);

    List<Suivi> findByTypePrestationLibelle(String lib);

    int deleteByTypePrestationLibelle(String lib);

    List<Suivi> findByPovId(Long id);

    int deleteByPovId(Long id);

    List<Suivi> findByTypePrestationId(Long id);

    int deleteByTypePrestationId(Long id);
}
