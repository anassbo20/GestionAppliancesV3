package com.example.gestion_appliances_v2.service.chercheur.impl;

import com.example.gestion_appliances_v2.bean.Appliance;
import com.example.gestion_appliances_v2.bean.ApplianceTag;
import com.example.gestion_appliances_v2.bean.TypeAppliance;
import com.example.gestion_appliances_v2.dao.ApplianceDao;
import com.example.gestion_appliances_v2.service.chercheur.facade.ApplianceChercheurService;
import com.example.gestion_appliances_v2.service.chercheur.facade.ApplianceTagChercheurService;
import com.example.gestion_appliances_v2.service.chercheur.facade.TypeApplianceChercheurService;
import com.example.gestion_appliances_v2.service.core.facade.ArchivableService;
import com.example.gestion_appliances_v2.service.core.impl.AbstractServiceImpl;
import com.example.gestion_appliances_v2.service.util.ListUtil;
import com.example.gestion_appliances_v2.service.util.SearchUtil;
import com.example.gestion_appliances_v2.service.util.StringUtil;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.ApplianceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApplianceChercheurImpl extends AbstractServiceImpl<Appliance> implements ApplianceChercheurService {
    @Autowired
    private ApplianceDao applianceDao;
    @Autowired
    private TypeApplianceChercheurService typeApplianceChercheurService;
    @Autowired
    private ApplianceTagChercheurService applianceTagChercheurService;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ArchivableService<Appliance> archivableService;

    @Override
    public List<Appliance> findAll() {
        String query = "SELECT a FROM Appliance a where 1=1 ";
        query += " AND a.archive != true";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Appliance findById(Long id) {
        if (id == null) return null;
        return applianceDao.getOne(id);
    }

    @Override
    public Appliance findByIdWithAssociatedList(Long id) {
        Appliance appliance = findById(id);
        findAssociatedLists(appliance);
        return appliance;
    }

    @Override
    public int deleteById(Long id) {
        int res = 0;
        if (applianceDao.findById(id).isPresent()) {
            deleteAssociatedLists(id);
            applianceDao.deleteById(id);
            res = 1;
        }
        return res;
    }



    @Override
    public Appliance save(Appliance entity) {

        Appliance result =null;
        Appliance foundedAppliance = findByReference(entity.getReference());
        if(foundedAppliance == null){

            findTypeAppliance(foundedAppliance);

            Appliance savedAppliance = applianceDao.save(entity);

            result = savedAppliance;
        }

        return result;
    }


    @Override
    public Appliance findByDibd(String dbid) {
        if(dbid==null)  return null;
        return applianceDao.findByDbid(dbid);
    }

    @Override
    public Appliance findByReference(String ref) {
        if(ref==null)  return null;
        return applianceDao.findByReference(ref);
    }
    @Override
    public Appliance findByIdOrReference(Appliance appliance) {
        Appliance resultat = null;
        if (appliance != null) {
            if (StringUtil.isNotEmpty(appliance.getId())) {
                resultat = applianceDao.getOne(appliance.getId());
            } else if (StringUtil.isNotEmpty(appliance.getReference())) {
                resultat = applianceDao.findByReference(appliance.getReference());
            }
        }
        return resultat;
    }

    @Override
    public List<Appliance> findByTypeApplianceLibelle(String libelle) {
        if(libelle == null)  return null;
        return applianceDao.findByTypeApplianceLibelle(libelle);
    }

    @Override
    public List<Appliance> findByDisponibilite(boolean disp) {
        return applianceDao.findByDisponibilite(disp);
    }

    @Transactional
    @Override
    public int deleteByDibd(String dbid) {
        return applianceDao.deleteByDbid(dbid);
    }

    @Transactional
    @Override
    public int deleteByReference(String reference) {
        return applianceDao.deleteByReference(reference);
    }

    @Transactional
    @Override
    public int deleteByTypeApplianceLibelle(String libelle) {
        return applianceDao.deleteByTypeApplianceLibelle(libelle);
    }
    @Transactional
    @Override
    public int deleteByTypeApplianceId(Long id) {
        return applianceDao.deleteByTypeApplianceId(id);
    }

    @Transactional
    @Override
    public int delete(Appliance app) {
        if(app.getReference()==null) return -1;

        Appliance foundedAppliance = findByReference(app.getReference());
        if(foundedAppliance==null) return -1;
        applianceDao.delete(foundedAppliance);
        return 1;
    }

    @Override
    public List<Appliance> findByCriteria(ApplianceVo vo) {
        String query = "SELECT o FROM Appliance o where 1=1 ";

        query += SearchUtil.addConstraint( "o", "id","=",vo.getId());
        query += SearchUtil.addConstraint( "o", "reference","LIKE",vo.getReference());
        query += SearchUtil.addConstraint( "o", "libelle","LIKE",vo.getLibelle());
        query += SearchUtil.addConstraint( "o", "dbid","LIKE",vo.getDbid());
        query += SearchUtil.addConstraint( "o", "archive","=",vo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",vo.getDateArchivage());
        query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",vo.getDateArchivageMin(),vo.getDateArchivageMax());
        if(vo.getTypeApplianceVo()!=null){
            query += SearchUtil.addConstraint( "o", "typeAppliance.id","=",vo.getTypeApplianceVo().getId());
            query += SearchUtil.addConstraint( "o", "typeAppliance.libelle","LIKE",vo.getTypeApplianceVo().getLibelle());
        }

        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void delete(List<Appliance> list) {
        if(ListUtil.isNotEmpty(list)){
            list.forEach(e->applianceDao.delete(e));
        }
    }

    @Override
    public void update(List<Appliance> list) {
        if(ListUtil.isNotEmpty(list)){
            list.forEach(e->applianceDao.save(e));
        }
    }


    @Override
    public List<Appliance> save(List<Appliance> list) {
        List<Appliance> savedList = new ArrayList<>();
        if(list != null && ListUtil.isNotEmpty(list))
            for(Appliance appliance: list){
                savedList.add(save(appliance));
            }
        return savedList;
    }

    @Override
    public Appliance update(Appliance appliance) {
        Appliance foundedAppliance = findByIdOrReference(appliance);
        if (foundedAppliance == null) return null;
        else {
            archivableService.prepare(appliance);
            return applianceDao.save(appliance);
        }
    }

    private void findAssociatedLists(Appliance appliance) {
        if (appliance != null && appliance.getId() != null) {
            TypeAppliance typeAppliance = typeApplianceChercheurService.findByLibelle(appliance.getTypeAppliance().getLibelle());
            appliance.setTypeAppliance(typeAppliance);
            List<ApplianceTag> applianceTags = applianceTagChercheurService.findByApplianceId(appliance.getId());
            appliance.setApplianceTags(applianceTags);
        }
    }
    private void deleteAssociatedLists(Long id) {
        if (id != null) {
            applianceTagChercheurService.deleteByApplianceId(id);
        }
    }
    private void findTypeAppliance(Appliance appliance ) {
        if(appliance==null) return;
        TypeAppliance typeAppliance= typeApplianceChercheurService.findByLibelle(appliance.getTypeAppliance().getLibelle());
        appliance.setTypeAppliance(typeAppliance);
    }

}
