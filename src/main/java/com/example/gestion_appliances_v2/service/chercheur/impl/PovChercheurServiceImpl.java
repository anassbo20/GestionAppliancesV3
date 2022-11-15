package com.example.gestion_appliances_v2.service.chercheur.impl;

import com.example.gestion_appliances_v2.bean.Appliance;
import com.example.gestion_appliances_v2.bean.Client;
import com.example.gestion_appliances_v2.bean.Pov;
import com.example.gestion_appliances_v2.dao.PovDao;
import com.example.gestion_appliances_v2.service.chercheur.facade.ApplianceChercheurService;
import com.example.gestion_appliances_v2.service.chercheur.facade.ClientChercheurService;
import com.example.gestion_appliances_v2.service.chercheur.facade.PovChercheurService;
import com.example.gestion_appliances_v2.service.core.facade.ArchivableService;
import com.example.gestion_appliances_v2.service.core.impl.AbstractServiceImpl;
import com.example.gestion_appliances_v2.service.util.ListUtil;
import com.example.gestion_appliances_v2.service.util.SearchUtil;
import com.example.gestion_appliances_v2.service.util.StringUtil;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.PovVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class PovChercheurServiceImpl extends AbstractServiceImpl<Pov> implements PovChercheurService {

    @Autowired
    private PovDao povDao;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ApplianceChercheurService applianceChercheurService;
    @Autowired
    private ArchivableService<Pov> archivableService;

    @Autowired
    private ClientChercheurService clientChercheurService;
    @Override
    public Pov findByLibelle(String libelle) {
        if(libelle == null) return null;
        return povDao.findByLibelle(libelle);
    }

    @Override
    public Pov findByIdOrLibelle(Pov pov) {
        Pov resultat = null;
        if (pov != null) {
            if (StringUtil.isNotEmpty(pov.getId())) {
                resultat = povDao.getOne(pov.getId());
            } else if (StringUtil.isNotEmpty(pov.getLibelle())) {
                resultat = povDao.findByLibelle(pov.getLibelle());
            }
        }
        return resultat;
    }

    @Override
    public List<Pov> findAll() {
        String query = "SELECT a FROM Pov a where 1=1 ";
        query += " AND a.archive != true";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Pov findById(Long id) {
        if (id == null) return null;
        return povDao.getOne(id);
    }

    @Override
    public Pov findByIdWithAssociatedList(Long id) {
        Pov pov = findById(id);
        findAssociatedLists(pov);
        return pov;
    }

    @Transactional
    @Override
    public int deleteById(Long id) {
        int res = 0;
        if (povDao.findById(id).isPresent()) {
            povDao.deleteById(id);
            res = 1;
        }
        return res;
    }

    @Override
    public Pov save(Pov entity) {
        Pov result =null;
        Pov foundedPov = findByIdOrLibelle(entity);
        if(foundedPov == null){

            Appliance appliance = applianceChercheurService.findByIdOrReference(entity.getAppliance());
            entity.setAppliance(appliance);
            Client client = clientChercheurService.findByIdOrLibelle(entity.getClient());
            entity.setClient(client);

            Pov savedPov = povDao.save(entity);

            result = savedPov;
        }

        return result;
    }

    @Override
    public List<Pov> save(List<Pov> list) {
        List<Pov> savedList = new ArrayList<>();
        if(list != null && ListUtil.isNotEmpty(list))
            for(Pov pov: list){
                savedList.add(save(pov));
            }
        return savedList;
    }

    @Override
    public Pov update(Pov T) {
        Pov foundedPov = findByIdOrLibelle(T);
        if (foundedPov == null) return null;
        else {
            archivableService.prepare(T);
            return povDao.save(T);
        }
    }

    @Override
    public int delete(Pov T) {
        if(T.getLibelle()==null) return -1;

        Pov foundedPov = findByLibelle(T.getLibelle());
        if(foundedPov==null) return -1;
        povDao.delete(foundedPov);
        return 1;
    }

    @Override
    public List<Pov> findByCriteria(PovVo vo) {
        String query = "SELECT o FROM Pov o where 1=1 ";

        query += SearchUtil.addConstraint( "o", "id","=",vo.getId());
        query += SearchUtil.addConstraint( "o", "libelle","LIKE",vo.getLibelle());
        query += SearchUtil.addConstraint( "o", "description","LIKE",vo.getDescription());
        query += SearchUtil.addConstraint( "o", "compteManager","LIKE",vo.getCompteManager());
        query += SearchUtil.addConstraint( "o", "ingenieurCyberSecurity","LIKE",vo.getIngenieurCyberSecurity());
        query += SearchUtil.addConstraint( "o", "analyseCyberSecurity","LIKE",vo.getAnalyseCyberSecurity());
        query += SearchUtil.addConstraint( "o", "archive","=",vo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",vo.getDateArchivage());
        query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",vo.getDateArchivageMin(),vo.getDateArchivageMax());
        query += SearchUtil.addConstraintDate( "o", "dateDebut","=",vo.getDateDebut());
        query += SearchUtil.addConstraintMinMaxDate( "o", "dateDebut",vo.getDateDebutMin(),vo.getDateDebutMax());
        query += SearchUtil.addConstraintDate( "o", "dateFin","=",vo.getDateFin());
        query += SearchUtil.addConstraintMinMaxDate( "o", "dateFin",vo.getDateFinMin(),vo.getDateFinMax());
        if(vo.getApplianceVo()!=null){
            query += SearchUtil.addConstraint( "o", "appliance.id","=",vo.getApplianceVo().getId());
            query += SearchUtil.addConstraint( "o", "appliance.libelle","LIKE",vo.getApplianceVo().getLibelle());
        }
        if(vo.getClientVo()!=null){
            query += SearchUtil.addConstraint( "o", "client.id","=",vo.getClientVo().getId());
            query += SearchUtil.addConstraint( "o", "client.libelle","LIKE",vo.getClientVo().getLibelle());
        }

        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void delete(List<Pov> list) {
        if(ListUtil.isNotEmpty(list)){
            list.forEach(e->povDao.delete(e));
        }
    }

    @Override
    public void update(List<Pov> list) {
        if(ListUtil.isNotEmpty(list)){
            list.forEach(e->povDao.save(e));
        }
    }

    @Transactional
    @Override
    public int deleteByLibelle(String libelle) {
        return povDao.deleteByLibelle(libelle);
    }

    @Override
    public List<Pov> findByClientLibelle(String lib) {
        if(lib == null) return null;
        return povDao.findByClientLibelle(lib);
    }
    @Transactional
    @Override
    public int deleteByClientLibelle(String lib) {
        return povDao.deleteByClientLibelle(lib);
    }

    @Override
    public List<Pov> findByApplianceReference(String ref) {
        if(ref == null) return null;
        return povDao.findByApplianceReference(ref);
    }

    @Transactional
    @Override
    public int deleteByApplianceReference(String ref) {
        return povDao.deleteByApplianceReference(ref);
    }

    private void findAssociatedLists(Pov pov) {
        if (pov != null && pov.getId() != null) {
            Appliance appliance = applianceChercheurService.findByIdOrReference(pov.getAppliance());
            pov.setAppliance(appliance);
            Client client = clientChercheurService.findByIdOrLibelle(pov.getClient());
            pov.setClient(client);
        }
    }

}
