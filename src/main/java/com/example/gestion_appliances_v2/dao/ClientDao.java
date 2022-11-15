package com.example.gestion_appliances_v2.dao;


import com.example.gestion_appliances_v2.bean.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDao extends JpaRepository<Client,Long> {
    Client findByLibelle(String libelle);
    List<Client> findByActivite(String activite);
    List<Client> findBySecteur(Client.Secteur secteur);
    int deleteByLibelle(String libelle);
    int deleteBySecteur(String secteur);
    int deleteByActivite(String activite);
}
