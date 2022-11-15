package com.example.gestion_appliances_v2.dao;


import com.example.gestion_appliances_v2.bean.TypePrestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePrestationDao extends JpaRepository<TypePrestation,Long> {
    TypePrestation findByLibelle(String libelle);
    int deleteByLibelle(String lib);
}
