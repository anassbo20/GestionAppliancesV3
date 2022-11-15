package com.example.gestion_appliances_v2.dao;

import com.example.gestion_appliances_v2.bean.Appliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplianceDao extends JpaRepository<Appliance,Long> {
    Appliance findByDbid(String dbid);
    Appliance findByReference(String ref);
    List<Appliance> findByTypeApplianceLibelle(String libelle);
    List<Appliance> findByDisponibilite(boolean disp);
    int deleteByDbid(String dbid);
    int deleteByReference(String reference);
    int deleteByTypeApplianceLibelle(String libelle);
    int deleteByTypeApplianceId(Long id);
}
