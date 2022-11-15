package com.example.gestion_appliances_v2.dao;

import com.example.gestion_appliances_v2.bean.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactDao extends JpaRepository<Contact,Long> {
      Contact findByTelephone(String telephon);
      int deleteByTelephone(String telephon);
      Contact findByEmail(String email);
      int deleteByEmail(String email);
      List<Contact> findByFonction(String fonction);
      int deleteByFonction(String fonction);
      List<Contact> findByClientLibelle(String libelle);
      int deleteByClientLibelle(String libelle);

}
