package com.example.gestion_appliances_v2.dao;


import com.example.gestion_appliances_v2.bean.ApplianceTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplianceTagDao extends JpaRepository<ApplianceTag,Long> {

    List<ApplianceTag> findByApplianceReference(String reference);

    int deleteByApplianceReference(String reference);

    List<ApplianceTag> findByApplianceId(Long id);

    int deleteByApplianceId(Long id);

    List<ApplianceTag> findByTagReference(String reference);

    int deleteByTagReference(String reference);

    List<ApplianceTag> findByTagId(Long id);

    int deleteByTagId(Long id);

}
