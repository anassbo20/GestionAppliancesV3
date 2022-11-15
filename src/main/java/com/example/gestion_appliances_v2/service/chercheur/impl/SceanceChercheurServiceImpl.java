package com.example.gestion_appliances_v2.service.chercheur.impl;

import com.example.gestion_appliances_v2.bean.Pov;
import com.example.gestion_appliances_v2.bean.Sceance;
import com.example.gestion_appliances_v2.dao.SceanceDao;
import com.example.gestion_appliances_v2.service.chercheur.facade.PovChercheurService;
import com.example.gestion_appliances_v2.service.chercheur.facade.SceanceChercheurService;
import com.example.gestion_appliances_v2.service.core.facade.ArchivableService;
import com.example.gestion_appliances_v2.service.core.impl.AbstractServiceImpl;
import com.example.gestion_appliances_v2.service.util.ListUtil;
import com.example.gestion_appliances_v2.service.util.SearchUtil;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.SceanceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SceanceChercheurServiceImpl extends AbstractServiceImpl<Sceance> implements SceanceChercheurService {

    @Autowired
    private SceanceDao sceanceDao;

    @Autowired
    private PovChercheurService povChercheurService;

    @Autowired
    private ArchivableService archivableService;
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Sceance> findByDateSceance(Date dateSc) {
        if(dateSc == null) return null;
        return sceanceDao.findByDateSceance(dateSc);
    }

    @Override
    @Transactional
    public int deleteByDateSceance(Date dateSc) {
        return sceanceDao.deleteByDateSceance(dateSc);
    }

    @Override
    public List<Sceance> findByPovLibelle(String lib) {
        if(lib == null) return null;
        return sceanceDao.findByPovLibelle(lib);
    }

    @Override
    @Transactional
    public int deleteByPovLibelle(String lib) {
        return sceanceDao.deleteByPovLibelle(lib);
    }


    @Override
    public List<Sceance> findAll() {
        String query = "SELECT a FROM Sceance a where 1=1 ";
        query += " AND a.archive != true";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Sceance findById(Long id) {
        if (id == null) return null;
        return sceanceDao.getOne(id);
    }

    @Override
    public Sceance findByIdWithAssociatedList(Long id) {
        Sceance sceance = findById(id);
        findAssociatedLists(sceance);
        return sceance;
    }

    private void findAssociatedLists(Sceance sceance) {
        if (sceance != null && sceance.getId() != null){
            Pov pov=povChercheurService.findByIdOrLibelle(sceance.getPov());
            sceance.setPov(pov);
        }
    }

    @Override
    public int deleteById(Long id) {
        int res = 0;
        if (sceanceDao.findById(id).isPresent()) {
            sceanceDao.deleteById(id);
            res = 1;
        }
        return res;
    }

    @Override
    public Sceance save(Sceance entity) {
        Sceance result =null;
        Sceance foundedSceance = findById(entity.getId());
        if(foundedSceance == null){

            Pov pov=povChercheurService.findByIdOrLibelle(entity.getPov());
            entity.setPov(pov);

            Sceance savedSceance = sceanceDao.save(entity);

            result = savedSceance;
        }

        return result;
    }

    @Override
    public List<Sceance> save(List<Sceance> list) {
        List<Sceance> savedList = new ArrayList<>();
        if(list != null && ListUtil.isNotEmpty(list))
            for(Sceance sceance: list){
                savedList.add(save(sceance));
            }
        return savedList;
    }

    @Override
    public Sceance update(Sceance T) {
        Sceance foundedSceance = findById(T.getId());
        if (foundedSceance == null) return null;
        else {
            archivableService.prepare(T);
            return sceanceDao.save(T);
        }
    }

    @Override
    public int delete(Sceance T) {
        if(T.getId()==null) return -1;

        Sceance foundedSceance = findById(T.getId());
        if(foundedSceance==null) return -1;
        sceanceDao.delete(foundedSceance);
        return 1;
    }

    @Override
    public List<Sceance> findByCriteria(SceanceVo vo) {
        String query = "SELECT o FROM Sceance o where 1=1 ";

        query += SearchUtil.addConstraint( "o", "id","=",vo.getId());
        query += SearchUtil.addConstraint( "o", "resume","LIKE",vo.getResume());
        query += SearchUtil.addConstraint( "o", "archive","=",vo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",vo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateSceance","=",vo.getDateSceance());
        query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",vo.getDateArchivageMin(),vo.getDateArchivageMax());
        query += SearchUtil.addConstraintMinMaxDate("o","dateSceance",vo.getDateSceanceMin(),vo.getDateSceanceMax());
        if(vo.getPovVo()!=null){
            query += SearchUtil.addConstraint( "o", "pov.id","=",vo.getPovVo().getId());
            query += SearchUtil.addConstraint( "o", "pov.libelle","LIKE",vo.getPovVo().getLibelle());
        }

        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void delete(List<Sceance> list) {
        if(ListUtil.isNotEmpty(list)){
            list.forEach(e->sceanceDao.delete(e));
        }
    }

    @Override
    public void update(List<Sceance> list) {
        if(ListUtil.isNotEmpty(list)){
            list.forEach(e->sceanceDao.save(e));
        }
    }
}
