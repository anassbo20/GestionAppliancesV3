package com.example.gestion_appliances_v2.service.admin.facade;

import com.example.gestion_appliances_v2.bean.Contact;
import com.example.gestion_appliances_v2.service.core.facade.AbstractService;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.ContactVo;

import java.util.List;

public interface ContactAdminService extends AbstractService<Contact,Long, ContactVo> {
    Contact findByTelephon(String telephon);
    int deleteByTelephone(String telephon);

    Contact findByIdOrTelephone(Contact contact);
    Contact findByEmail(String email);
    int deleteByEmail(String email);
    List<Contact> findByFonction(String fonction);
    int deleteByFonction(String fonction);
    List<Contact> findByClientLibelle(String libelle);
    int deleteByClientLibelle(String libelle);

    Contact archiver(Contact contact) ;

    Contact desarchiver(Contact contact);

}
