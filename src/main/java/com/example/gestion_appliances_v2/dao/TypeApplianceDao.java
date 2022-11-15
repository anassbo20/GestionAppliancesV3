package com.example.gestion_appliances_v2.dao;

import com.example.gestion_appliances_v2.bean.TypeAppliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeApplianceDao extends JpaRepository<TypeAppliance,Long> {

     TypeAppliance findByLibelle(String libelle);


     int deleteByLibelle(String lib);
}
