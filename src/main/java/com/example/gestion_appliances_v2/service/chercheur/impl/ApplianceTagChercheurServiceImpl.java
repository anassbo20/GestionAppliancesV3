package com.example.gestion_appliances_v2.service.chercheur.impl;

import com.example.gestion_appliances_v2.bean.Appliance;
import com.example.gestion_appliances_v2.bean.ApplianceTag;
import com.example.gestion_appliances_v2.bean.Tag;
import com.example.gestion_appliances_v2.dao.ApplianceTagDao;
import com.example.gestion_appliances_v2.service.chercheur.facade.ApplianceChercheurService;
import com.example.gestion_appliances_v2.service.chercheur.facade.ApplianceTagChercheurService;
import com.example.gestion_appliances_v2.service.chercheur.facade.TagChercheurService;
import com.example.gestion_appliances_v2.service.core.impl.AbstractServiceImpl;
import com.example.gestion_appliances_v2.service.util.ListUtil;
import com.example.gestion_appliances_v2.service.util.SearchUtil;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.ApplianceTagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApplianceTagChercheurServiceImpl extends AbstractServiceImpl<ApplianceTag> implements ApplianceTagChercheurService {

    @Autowired
    private ApplianceTagDao applianceTagDao;
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ApplianceChercheurService applianceChercheurService;


    @Autowired
    private TagChercheurService tagChercheurService;

    @Override
    public List<ApplianceTag> findByApplianceReference(String reference) {
        if(reference == null) return null;
        return applianceTagDao.findByApplianceReference(reference);
    }

    @Transactional
    @Override
    public int deleteByApplianceReference(String reference) {
        return applianceTagDao.deleteByApplianceReference(reference);
    }

    @Override
    public List<ApplianceTag> findByApplianceId(Long id) {
        if(id == null) return null;
        return applianceTagDao.findByApplianceId(id);
    }
    @Transactional
    @Override
    public int deleteByApplianceId(Long id) {
        return applianceTagDao.deleteByApplianceId(id);
    }

    @Override
    public List<ApplianceTag> findByTagReference(String reference) {
        if(reference == null) return null;
        return applianceTagDao.findByTagReference(reference);
    }
    @Transactional
    @Override
    public int deleteByTagReference(String reference) {
        return applianceTagDao.deleteByTagReference(reference);
    }

    @Override
    public List<ApplianceTag> findByTagId(Long id) {
        return applianceTagDao.findByTagId(id);
    }

    @Override
    public List<ApplianceTag> findAll() {
        String query = "SELECT o FROM ApplianceTag o where 1=1 ";
        query += " AND o.archive != true";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public ApplianceTag findById(Long id) {
        if (id == null) return null;
        return applianceTagDao.getOne(id);
    }

    @Override
    public ApplianceTag findByIdWithAssociatedList(Long id) {
        ApplianceTag applianceTag = findById(id);
        findAssociatedLists(applianceTag);
        return applianceTag;
    }

    @Override
    public int deleteById(Long id) {
        int res = 0;
        if (applianceTagDao.findById(id).isPresent()) {
            applianceTagDao.deleteById(id);
            res = 1;
        }
        return res;
    }

    @Override
    public ApplianceTag save(ApplianceTag entity) {
        findAppliance(entity);
        findTag(entity);

        return applianceTagDao.save(entity);
    }

    @Override
    public List<ApplianceTag> save(List<ApplianceTag> list) {
        List<ApplianceTag> savedList = new ArrayList<>();
        if(list != null && ListUtil.isNotEmpty(list))
            for(ApplianceTag applianceTag: list){
                savedList.add(save(applianceTag));
            }
        return savedList;
    }

    @Override
    public ApplianceTag update(ApplianceTag T) {
        ApplianceTag foundedApplianceTag = findById(T.getId());
        if (foundedApplianceTag == null) return null;
        else {
            return applianceTagDao.save(T);
        }
    }

    @Override
    public int delete(ApplianceTag T) {
        if(T.getId()==null) return -1;
        ApplianceTag foundedApplianceTag = findById(T.getId());
        if(foundedApplianceTag==null) return -1;
        applianceTagDao.delete(foundedApplianceTag);
        return 1;
    }

    @Override
    public List<ApplianceTag> findByCriteria(ApplianceTagVo vo) {
        String query = "SELECT o FROM ApplianceTag o where 1=1 ";

        query += SearchUtil.addConstraint( "o", "id","=",vo.getId());
        if(vo.getApplianceVo()!=null){
            query += SearchUtil.addConstraint( "o", "appliance.id","=",vo.getApplianceVo().getId());
            query += SearchUtil.addConstraint( "o", "appliance.reference","LIKE",vo.getApplianceVo().getReference());
        }

        if(vo.getTagVo()!=null){
            query += SearchUtil.addConstraint( "o", "tag.id","=",vo.getTagVo().getId());
            query += SearchUtil.addConstraint( "o", "tag.reference","LIKE",vo.getTagVo().getReference());
        }

        return entityManager.createQuery(query).getResultList();

    }

    @Transactional
    @Override
    public void delete(List<ApplianceTag> list) {
        if(ListUtil.isNotEmpty(list)){
            list.forEach(e->applianceTagDao.delete(e));
        }
    }

    @Override
    public void update(List<ApplianceTag> list) {
        if(ListUtil.isNotEmpty(list)){
            list.forEach(e->applianceTagDao.save(e));
        }
    }

    @Transactional
    @Override
    public int deleteByTagId(Long id) {
        return applianceTagDao.deleteByTagId(id);
    }

    private void findAssociatedLists(ApplianceTag applianceTag) {
        if (applianceTag != null && applianceTag.getId() != null) {
            Appliance appliance = applianceChercheurService.findByIdOrReference(applianceTag.getAppliance());
            applianceTag.setAppliance(appliance);
            Tag tag =  tagChercheurService.findByIdOrReference(applianceTag.getTag());
            applianceTag.setTag(tag);
        }
    }

    private void findAppliance(ApplianceTag applianceTag){
        Appliance loadedAppliance =applianceChercheurService.findByIdOrReference(applianceTag.getAppliance());
        if(loadedAppliance==null ) {
            return;
        }
        applianceTag.setAppliance(loadedAppliance);
    }
    private void findTag(ApplianceTag applianceTag){
     Tag loadedTag =tagChercheurService.findByIdOrReference(applianceTag.getTag());

        if(loadedTag==null ) {
            return;
        }
        applianceTag.setTag(loadedTag);
    }
}