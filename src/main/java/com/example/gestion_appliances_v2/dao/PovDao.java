package com.example.gestion_appliances_v2.dao;


import com.example.gestion_appliances_v2.bean.Pov;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PovDao extends JpaRepository<Pov,Long> {

    Pov findByLibelle(String libelle);

    int deleteByLibelle(String libelle);
    List<Pov> findByClientLibelle(String lib);
    int deleteByClientLibelle(String lib);
    List<Pov> findByApplianceReference(String ref);
    int deleteByApplianceReference(String ref);

}
