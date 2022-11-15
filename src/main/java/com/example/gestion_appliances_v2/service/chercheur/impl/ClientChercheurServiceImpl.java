package com.example.gestion_appliances_v2.service.chercheur.impl;

import com.example.gestion_appliances_v2.bean.Client;
import com.example.gestion_appliances_v2.dao.ClientDao;
import com.example.gestion_appliances_v2.service.chercheur.facade.ClientChercheurService;
import com.example.gestion_appliances_v2.service.core.facade.ArchivableService;
import com.example.gestion_appliances_v2.service.core.impl.AbstractServiceImpl;
import com.example.gestion_appliances_v2.service.util.ListUtil;
import com.example.gestion_appliances_v2.service.util.SearchUtil;
import com.example.gestion_appliances_v2.service.util.StringUtil;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.ClientVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientChercheurServiceImpl extends AbstractServiceImpl<Client> implements ClientChercheurService {
    @Autowired
    private ClientDao clientDao;

    @Autowired
    private ArchivableService<Client> archivableService;


    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Client> findAll(){
        String query = "SELECT o FROM Client o where 1=1 ";
        query+= " AND o.archive != true";
        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public Client findByLibelle(String libelle){
        if( libelle==null) return null;
        return clientDao.findByLibelle(libelle);
    }

    @Override
    @Transactional
    public int deleteByLibelle(String  libelle) {
        return clientDao.deleteByLibelle(libelle);
    }

    @Override
    @Transactional
    public int deleteBySecteur(String secteur) {
        return clientDao.deleteBySecteur(secteur);
    }

    @Override
    @Transactional
    public int deleteByActivite(String activite) {
        return clientDao.deleteByActivite(activite);
    }

    @Override
    public Client findByIdOrLibelle(Client client){
        Client resultat=null;
        if(client != null){
            if(StringUtil.isNotEmpty(client.getId())){
                resultat= clientDao.getOne(client.getId());
            }else if(StringUtil.isNotEmpty(client.getLibelle())) {
                resultat= clientDao.findByLibelle(client.getLibelle());
            }
        }
        return resultat;
    }

    @Override
    public List<Client> findByActivite(String activite) {
        if(activite == null) return null;
        return clientDao.findByActivite(activite);
    }

    @Override
    public List<Client> findBySecteur(Client.Secteur secteur) {
        if(secteur == null) return null;
        return clientDao.findBySecteur(secteur);
    }

    @Override
    public Client findById(Long id){
        if(id==null) return null;
        return clientDao.getOne(id);
    }

    @Override
    public Client findByIdWithAssociatedList(Long id){
        return findById(id);
    }


    @Transactional
    public int deleteById(Long id){
        int res=0;
        if(clientDao.findById(id).isPresent())  {
            clientDao.deleteById(id);
            res = 1;
        }
        return res;
    }


    @Override
    public Client update(Client client){
        Client foundedClient = findById(client.getId());
        if(foundedClient==null) return null;
        else{
            archivableService.prepare(client);
            return  clientDao.save(client);
        }
    }


    @Override
    public Client save (Client client){
        Client result =null;
        Client foundedClient = findByLibelle(client.getLibelle());
        if(foundedClient == null){



            Client savedClient = clientDao.save(client);

            result = savedClient;
        }

        return result;
    }

    @Override
    public List<Client> save(List<Client> clients){
        List<Client> list = new ArrayList<>();
        for(Client client: clients){
            list.add(save(client));
        }
        return list;
    }



    @Override
    @Transactional
    public int delete(Client client){
        if(client.getLibelle()==null) return -1;

        Client foundedClient = findByLibelle(client.getLibelle());
        if(foundedClient==null) return -1;
        clientDao.delete(foundedClient);
        return 1;
    }


    public List<Client> findByCriteria(ClientVo clientVo){

        String query = "SELECT o FROM Client o where 1=1 ";

        query += SearchUtil.addConstraint( "o", "id","=",clientVo.getId());
        query += SearchUtil.addConstraint( "o", "libelle","LIKE",clientVo.getLibelle());
        query += SearchUtil.addConstraint( "o", "secteur","LIKE",clientVo.getSecteur());
        query += SearchUtil.addConstraint( "o", "activite","LIKE",clientVo.getActivite());
        query += SearchUtil.addConstraint( "o", "archive","=",clientVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",clientVo.getDateArchivage());
        query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",clientVo.getDateArchivageMin(),clientVo.getDateArchivageMax());
        return entityManager.createQuery(query).getResultList();
    }


    @Override
    @Transactional
    public void delete(List<Client> clients){
        if(ListUtil.isNotEmpty(clients)){
            clients.forEach(e->clientDao.delete(e));
        }
    }
    @Override
    public void update(List<Client> clients){
        if(ListUtil.isNotEmpty(clients)){
            clients.forEach(e->clientDao.save(e));
        }
    }


}
