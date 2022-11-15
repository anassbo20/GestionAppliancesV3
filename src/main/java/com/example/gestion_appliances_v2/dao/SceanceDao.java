package com.example.gestion_appliances_v2.dao;


import com.example.gestion_appliances_v2.bean.Sceance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SceanceDao extends JpaRepository<Sceance,Long> {

    List<Sceance> findByDateSceance(Date dateSc);

    int deleteByDateSceance(Date dateSc);

    List<Sceance> findByPovLibelle(String lib);

    int deleteByPovLibelle(String lib);

    List<Sceance> findByPovId(Long id);

    int deleteByPovId(Long id);
}
