package com.example.gestion_appliances_v2.service.admin.impl;

import com.example.gestion_appliances_v2.bean.Client;
import com.example.gestion_appliances_v2.bean.Contact;
import com.example.gestion_appliances_v2.dao.ContactDao;
import com.example.gestion_appliances_v2.service.admin.facade.ClientAdminService;
import com.example.gestion_appliances_v2.service.admin.facade.ContactAdminService;
import com.example.gestion_appliances_v2.service.core.facade.ArchivableService;
import com.example.gestion_appliances_v2.service.core.impl.AbstractServiceImpl;
import com.example.gestion_appliances_v2.service.util.ListUtil;
import com.example.gestion_appliances_v2.service.util.SearchUtil;
import com.example.gestion_appliances_v2.service.util.StringUtil;
import com.example.gestion_appliances_v2.ws.rest.provided.converter.ContactConverter;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.ContactVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContactAdminServiceImpl extends AbstractServiceImpl<Contact> implements ContactAdminService {

    @Autowired
    private ContactDao contactDao;

    @Autowired
    ContactConverter contactConverter;
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ClientAdminService clientAdminService;

    @Autowired
    private ArchivableService<Contact> archivableService;


    @Override
    public Contact findByTelephon(String telephon) {
        if(telephon==null) return null;
        return contactDao.findByTelephone(telephon);
    }
    @Transactional
    @Override
    public int deleteByTelephone(String telephon) {
        return contactDao.deleteByTelephone(telephon);
    }

    @Override
    public Contact findByIdOrTelephone(Contact contact) {
        Contact resultat = null;
        if (contact != null) {
            if (StringUtil.isNotEmpty(contact.getId())) {
                resultat = contactDao.getOne(contact.getId());
            } else if (StringUtil.isNotEmpty(contact.getTelephone())) {
                resultat = contactDao.findByTelephone(contact.getTelephone());
            }
        }
        return resultat;
    }

    @Override
    public Contact findByEmail(String email) {
        if(email == null) return null;
        return contactDao.findByEmail(email);
    }
    @Transactional
    @Override
    public int deleteByEmail(String email) {
        return contactDao.deleteByEmail(email);
    }

    @Override
    public List<Contact> findByFonction(String fonction) {
        if(fonction == null) return null;
        return contactDao.findByFonction(fonction);
    }

    @Transactional
    @Override
    public int deleteByFonction(String fonction) {
        return contactDao.deleteByFonction(fonction);
    }

    @Override
    public List<Contact> findByClientLibelle(String libelle) {
        if(libelle == null) return null;
        return contactDao.findByClientLibelle(libelle);
    }

    @Override
    public int deleteByClientLibelle(String libelle) {
        return contactDao.deleteByClientLibelle(libelle);
    }

    @Override
    public Contact archiver(Contact contact) {
        if (contact.getArchive() == null) {
            contact.setArchive(false);
        }
        contact.setArchive(true);
        contact.setDateArchivage(new Date());
        contactDao.save(contact);
        return contact;
    }

    @Override
    public Contact desarchiver(Contact contact) {
        if (contact.getArchive() == null) {
            contact.setArchive(false);
        }
        contact.setArchive(false);
        contact.setDateArchivage(null);
        contactDao.save(contact);
        return contact;
    }

    @Override
    public List<Contact> findAll() {
        String query = "SELECT a FROM Contact a where 1=1 ";
        query += " AND a.archive != true";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Contact findById(Long id) {
        if (id == null) return null;
        return contactDao.getOne(id);
    }

    @Override
    public Contact findByIdWithAssociatedList(Long id) {
        Contact contact= findById(id);
        findClient(contact);
        return contact;
    }
    @Transactional
    @Override
    public int deleteById(Long id) {
        int res = 0;
        if (contactDao.findById(id).isPresent()) {
            contactDao.deleteById(id);
            res = 1;
        }
        return res;
    }

    @Override
    public Contact save(Contact entity) {

        Contact result =null;
        Contact foundedContact = findByTelephon(entity.getTelephone());
        if(foundedContact == null){

            Client client = clientAdminService.findByIdOrLibelle(entity.getClient());
            entity.setClient(client);
            Contact savedContact = contactDao.save(entity);

            result = savedContact;
        }

        return result;
    }

    @Override
    public List<Contact> save(List<Contact> list) {
        List<Contact> savedList = new ArrayList<>();
        if(list != null && ListUtil.isNotEmpty(list))
            for(Contact contact: list){
                savedList.add(save(contact));
            }
        return savedList;
    }

    @Override
    public Contact update(Contact T) {
        Contact foundedContact = findByIdOrTelephone(T);
        if (foundedContact == null) return null;
        else {
            archivableService.prepare(T);
            return contactDao.save(T);
        }

    }
    @Transactional
    @Override
    public int delete(Contact T) {
        if(T.getTelephone()==null) return -1;

        Contact foundedContact = findByTelephon(T.getTelephone());
        if(foundedContact==null) return -1;
        contactDao.delete(foundedContact);
        return 1;
    }

    @Override
    public List<Contact> findByCriteria(ContactVo vo) {
        String query = "SELECT o FROM Contact o where 1=1 ";

        query += SearchUtil.addConstraint( "o", "id","=",vo.getId());
        query += SearchUtil.addConstraint( "o", "nom","LIKE",vo.getNom());
        query += SearchUtil.addConstraint( "o", "prenom","LIKE",vo.getPrenom());
        query += SearchUtil.addConstraint( "o", "fonction","LIKE",vo.getFonction());
        query += SearchUtil.addConstraint( "o", "telephon","LIKE",vo.getTelephone());
        query += SearchUtil.addConstraint( "o", "email","LIKE",vo.getEmail());
        query += SearchUtil.addConstraint( "o", "archive","=",vo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",vo.getDateArchivage());
        query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",vo.getDateArchivageMin(),vo.getDateArchivageMax());
        if(vo.getClientVo()!=null){
            query += SearchUtil.addConstraint( "o", "client.id","=",vo.getClientVo().getId());
            query += SearchUtil.addConstraint( "o", "client.libelle","LIKE",vo.getClientVo().getLibelle());
        }

        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void delete(List<Contact> list) {
        if(ListUtil.isNotEmpty(list)){
            list.forEach(e->contactDao.delete(e));
        }
    }

    @Override
    public void update(List<Contact> list) {
        if(ListUtil.isNotEmpty(list)){
            list.forEach(e->contactDao.save(e));
        }
    }
    private void findClient(Contact contact){
         if(contact != null && contact.getId() != null){
             Client client = clientAdminService.findByIdOrLibelle(contact.getClient());
             contact.setClient(client);
         }
    }
}
