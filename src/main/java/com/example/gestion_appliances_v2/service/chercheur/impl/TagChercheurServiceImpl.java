package com.example.gestion_appliances_v2.service.chercheur.impl;

import com.example.gestion_appliances_v2.bean.Tag;
import com.example.gestion_appliances_v2.dao.TagDao;
import com.example.gestion_appliances_v2.service.chercheur.facade.ApplianceTagChercheurService;
import com.example.gestion_appliances_v2.service.chercheur.facade.TagChercheurService;
import com.example.gestion_appliances_v2.service.core.facade.ArchivableService;
import com.example.gestion_appliances_v2.service.core.impl.AbstractServiceImpl;
import com.example.gestion_appliances_v2.service.util.ListUtil;
import com.example.gestion_appliances_v2.service.util.SearchUtil;
import com.example.gestion_appliances_v2.service.util.StringUtil;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.TagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class TagChercheurServiceImpl extends AbstractServiceImpl<Tag> implements TagChercheurService {
    @Autowired
    private TagDao tagDao;

    @Autowired
    private ArchivableService<Tag> archivableService;


    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ApplianceTagChercheurService applianceTagChercheurService;


    @Override
    public List<Tag> findAll(){
        String query = "SELECT o FROM Tag o where 1=1 ";
        query+= " AND o.archive != true";
        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public Tag findByReference(String reference){
        if( reference==null) return null;
        return tagDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
        return tagDao.deleteByReference(reference);
    }

    @Override
    public Tag findByLibelle(String libelle) {
        if( libelle==null) return null;
        return tagDao.findByLibelle(libelle);
    }

    @Override
    @Transactional
    public int deleteByLibelle(String libelle) {
        return tagDao.deleteByLibelle(libelle);
    }

    @Override
    public Tag findByIdOrReference(Tag tag){
        Tag resultat=null;
        if(tag != null){
            if(StringUtil.isNotEmpty(tag.getId())){
                resultat= tagDao.getOne(tag.getId());
            }else if(StringUtil.isNotEmpty(tag.getReference())) {
                resultat= tagDao.findByReference(tag.getReference());
            }
        }
        return resultat;
    }

    @Override
    public Tag findById(Long id){
        if(id==null) return null;
        return tagDao.getOne(id);
    }

    @Override
    public Tag findByIdWithAssociatedList(Long id){
        return findById(id);
    }


    @Transactional
    public int deleteById(Long id){
        int res=0;
        if(tagDao.findById(id).isPresent())  {
            deleteAssociatedLists(id);
            tagDao.deleteById(id);
            res = 1;
        }
        return res;
    }


    @Override
    public Tag update(Tag tag){
        Tag foundedTag = findById(tag.getId());
        if(foundedTag==null) return null;
        else{
            archivableService.prepare(tag);
            return  tagDao.save(tag);
        }
    }


    @Override
    public Tag save (Tag tag){
        Tag result =null;
        Tag foundedTag = findByReference(tag.getReference());
        if(foundedTag == null){


            Tag savedTag = tagDao.save(tag);

            result = savedTag;
        }

        return result;
    }

    @Override
    public List<Tag> save(List<Tag> tags){
        List<Tag> list = new ArrayList<>();
        for(Tag tag: tags){
            list.add(save(tag));
        }
        return list;
    }



    @Override
    @Transactional
    public int delete(Tag tag){
        if(tag.getReference()==null) return -1;

        Tag foundedTag = findByReference(tag.getReference());
        if(foundedTag==null) return -1;
        tagDao.delete(foundedTag);
        return 1;
    }


    public List<Tag> findByCriteria(TagVo tagVo){

        String query = "SELECT o FROM Tag o where 1=1 ";

        query += SearchUtil.addConstraint( "o", "id","=",tagVo.getId());
        query += SearchUtil.addConstraint( "o", "reference","LIKE",tagVo.getReference());
        query += SearchUtil.addConstraint( "o", "libelle","LIKE",tagVo.getLibelle());
        query += SearchUtil.addConstraint( "o", "archive","=",tagVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",tagVo.getDateArchivage());
        query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",tagVo.getDateArchivageMin(),tagVo.getDateArchivageMax());
        return entityManager.createQuery(query).getResultList();
    }


    @Override
    @Transactional
    public void delete(List<Tag> tags){
        if(ListUtil.isNotEmpty(tags)){
            tags.forEach(e->tagDao.delete(e));
        }
    }
    @Override
    public void update(List<Tag> tags){
        if(ListUtil.isNotEmpty(tags)){
            tags.forEach(e->tagDao.save(e));
        }
    }

    private void deleteAssociatedLists(Long id) {
        if (id != null) {
            applianceTagChercheurService.deleteByTagId(id);
        }
    }

}
