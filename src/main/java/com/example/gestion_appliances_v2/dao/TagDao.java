package com.example.gestion_appliances_v2.dao;


import com.example.gestion_appliances_v2.bean.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TagDao extends JpaRepository<Tag,Long> {




    Tag findByReference(String reference);

    int deleteByReference(String reference);

    Tag findByLibelle(String libelle);

    int deleteByLibelle(String libelle);



}
