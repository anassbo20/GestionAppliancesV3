package com.example.gestion_appliances_v2.service.chercheur.impl;


import com.example.gestion_appliances_v2.bean.Pov;
import com.example.gestion_appliances_v2.bean.Suivi;
import com.example.gestion_appliances_v2.bean.TypePrestation;
import com.example.gestion_appliances_v2.dao.SuiviDao;
import com.example.gestion_appliances_v2.dao.TypePrestationDao;
import com.example.gestion_appliances_v2.service.chercheur.facade.PovChercheurService;
import com.example.gestion_appliances_v2.service.chercheur.facade.SuiviChercheurService;
import com.example.gestion_appliances_v2.service.chercheur.facade.TypePrestationChercheurService;
import com.example.gestion_appliances_v2.service.core.facade.ArchivableService;
import com.example.gestion_appliances_v2.service.core.impl.AbstractServiceImpl;
import com.example.gestion_appliances_v2.service.util.ListUtil;
import com.example.gestion_appliances_v2.service.util.SearchUtil;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.SuiviVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class SuiviChercheurServiceImpl extends AbstractServiceImpl<Suivi> implements SuiviChercheurService {

    @Autowired
    private SuiviDao suiviDao;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PovChercheurService povChercheurService;

    @Autowired
    private TypePrestationChercheurService typePrestationChercheurService;

    @Autowired
    private ArchivableService<Suivi> archivableService;

    @Autowired
    private TypePrestationDao typePrestationDao;

    @Override
    public List<Suivi> findByOffreCommercialIs(boolean offre) {
        return suiviDao.findByOffreCommercialIs(offre);
    }

    @Override
    public int deleteByOffreCommercialIs(boolean off) {
        return suiviDao.deleteByOffreCommercialIs(off);
    }

    @Override
    public List<Suivi> findByMontantGreaterThan(BigDecimal mont) {
        if(mont == null) return null;
        return suiviDao.findByMontantGreaterThan(mont);
    }

    @Override
    public List<Suivi> findByPovId(Long id) {
        if(id == null) return null;
        return suiviDao.findByPovId(id);
    }

    @Override
    public List<Suivi> findByPovLibelle(String libelle) {
        if(libelle == null) return null;
        return suiviDao.findByPovLibelle(libelle);
    }

    @Transactional
    @Override
    public int deleteByPovId(Long id) {
        return suiviDao.deleteByPovId(id);
    }

    @Transactional
    @Override
    public int deleteByPovLibelle(String libelle) {
        return suiviDao.deleteByPovLibelle(libelle);
    }

    @Override
    public List<Suivi> findByTypePrestationId(Long id) {
        if(id == null) return null;
        return suiviDao.findByTypePrestationId(id);
    }

    @Override
    public List<Suivi> findByTypePrestationLibelle(String lib) {
        if(lib == null) return null;
        return suiviDao.findByTypePrestationLibelle(lib);
    }

    @Transactional
    @Override
    public int deleteByTypePrestationId(Long id) {
        return suiviDao.deleteByTypePrestationId(id);
    }

    @Transactional
    @Override
    public int deleteByTypePrestationLibelle(String lib) {
        return suiviDao.deleteByTypePrestationLibelle(lib);
    }

    @Override
    public List<Suivi> findAll() {
        String query = "SELECT a FROM Suivi a where 1=1 ";
        query += " AND a.archive != true";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Suivi findById(Long id) {
        if (id == null) return null;
        return suiviDao.getOne(id);
    }

    @Override
    public Suivi findByIdWithAssociatedList(Long id) {
        Suivi suivi = findById(id);
        findAssociatedLists(suivi);
        return suivi;
    }

    @Override
    @Transactional
    public int deleteById(Long id) {
        int res = 0;
        if (suiviDao.findById(id).isPresent()) {
            suiviDao.deleteById(id);
            res = 1;
        }
        return res;
    }

    @Override
    public Suivi save(Suivi entity) {
        Suivi result =null;
        Suivi foundedSuivi = findById(entity.getId());
        if(foundedSuivi == null){

            Pov pov = povChercheurService.findByLibelle(entity.getPov().getLibelle());
            entity.setPov(pov);
            TypePrestation typePrestation = typePrestationDao.findByLibelle(entity.getTypePrestation().getLibelle());
            entity.setTypePrestation(typePrestation);

            Suivi savedSuivi = suiviDao.save(entity);

            result = savedSuivi;
        }

        return result;
    }

    @Override
    public List<Suivi> save(List<Suivi> list) {
        List<Suivi> savedList = new ArrayList<>();
        if(list != null && ListUtil.isNotEmpty(list))
            for(Suivi suivi: list){
                savedList.add(save(suivi));
            }
        return savedList;
    }

    @Override
    public Suivi update(Suivi T) {
        Suivi foundedSuivi = findById(T.getId());
        if (foundedSuivi == null) return null;
        else {
            archivableService.prepare(T);
            return suiviDao.save(T);
        }
    }

    @Override
    @Transactional
    public int delete(Suivi T) {
        if(T.getId()==null) return -1;

        Suivi foundedSuivi = findById(T.getId());
        if(foundedSuivi==null) return -1;
        suiviDao.delete(foundedSuivi);
        return 1;
    }

    @Override
    public List<Suivi> findByCriteria(SuiviVo vo) {
        String query = "SELECT o FROM Suivi o where 1=1 ";

        query += SearchUtil.addConstraint( "o", "id","=",vo.getId());
        query += SearchUtil.addConstraint( "o", "offreCommercial","=",vo.getOffreCommercial());
        query += SearchUtil.addConstraint( "o", "compteRendu","LIKE",vo.getCompteRendu());
        query += SearchUtil.addConstraintMinMax( "o", "montant",vo.getMontantMin(),vo.getMontantMax());
        query += SearchUtil.addConstraint( "o", "archive","=",vo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",vo.getDateArchivage());
        query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",vo.getDateArchivageMin(),vo.getDateArchivageMax());
        if(vo.getTypePrestationVo()!=null){
            query += SearchUtil.addConstraint( "o", "typePrestation.id","=",vo.getTypePrestationVo().getId());
            query += SearchUtil.addConstraint( "o", "typePrestation.libelle","LIKE",vo.getTypePrestationVo().getLibelle());
        }
        if(vo.getPovVo()!=null){
            query += SearchUtil.addConstraint( "o", "pov.id","=",vo.getPovVo().getId());
            query += SearchUtil.addConstraint( "o", "pov.libelle","LIKE",vo.getPovVo().getLibelle());
        }

        return entityManager.createQuery(query).getResultList();

    }

    @Override
    @Transactional
    public void delete(List<Suivi> list) {
        if(ListUtil.isNotEmpty(list)){
            list.forEach(e->suiviDao.delete(e));
        }
    }

    @Override
    public void update(List<Suivi> list) {
        if(ListUtil.isNotEmpty(list)){
            list.forEach(e->suiviDao.save(e));
        }
    }

    private void findAssociatedLists(Suivi suivi) {
        if (suivi != null && suivi.getId() != null) {
            Pov pov = povChercheurService.findByLibelle(suivi.getPov().getLibelle());
            suivi.setPov(pov);
            TypePrestation typePrestation = typePrestationDao.findByLibelle(suivi.getTypePrestation().getLibelle());
            suivi.setTypePrestation(typePrestation);

        }
    }
}
