package com.example.gestion_appliances_v2.dao;



import com.example.gestion_appliances_v2.bean.Chercheur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChercheurDao extends JpaRepository<Chercheur,Long> {

    Chercheur findByUsername(String username);



    Chercheur findByNumeroMatricule(String numeroMatricule);

    int deleteByNumeroMatricule(String numeroMatricule);



}
