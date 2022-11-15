package com.example.gestion_appliances_v2.service.chercheur.impl;


import com.example.gestion_appliances_v2.bean.TypeAppliance;
import com.example.gestion_appliances_v2.dao.TypeApplianceDao;
import com.example.gestion_appliances_v2.service.chercheur.facade.ApplianceChercheurService;
import com.example.gestion_appliances_v2.service.chercheur.facade.TypeApplianceChercheurService;
import com.example.gestion_appliances_v2.service.core.facade.ArchivableService;
import com.example.gestion_appliances_v2.service.core.impl.AbstractServiceImpl;
import com.example.gestion_appliances_v2.service.util.ListUtil;
import com.example.gestion_appliances_v2.service.util.SearchUtil;
import com.example.gestion_appliances_v2.service.util.StringUtil;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.TypeApplianceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class TypeApplianceChercheurServiceImpl extends AbstractServiceImpl<TypeAppliance> implements TypeApplianceChercheurService {
    @Autowired
    private TypeApplianceDao typeApplianceDao;
    @Autowired
    private ApplianceChercheurService applianceChercheurService;
    @Autowired
    private ArchivableService<TypeAppliance> archivableService;
    @Autowired
    private EntityManager entityManager;

    @Override
    public TypeAppliance findByLibelle(String libelle) {
        if(libelle == null)  return null;
        return typeApplianceDao.findByLibelle(libelle);
    }

    @Override
    public int deleteByLibelle(String lib) {
        return typeApplianceDao.deleteByLibelle(lib);
    }

    @Override
    public TypeAppliance findByIdOrLibelle(TypeAppliance typeAppliance) {
        TypeAppliance resultat = null;
        if (typeAppliance != null) {
            if (StringUtil.isNotEmpty(typeAppliance.getId())) {
                resultat = typeApplianceDao.getOne(typeAppliance.getId());
            } else if (StringUtil.isNotEmpty(typeAppliance.getLibelle())) {
                resultat = typeApplianceDao.findByLibelle(typeAppliance.getLibelle());
            }
        }
        return resultat;
    }

    @Override
    public List<TypeAppliance> findAll() {
        String query = "SELECT o FROM TypeAppliance o where 1=1 ";
        query += " AND o.archive != true";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public TypeAppliance findById(Long id) {
        if(id==null) return null;
        return typeApplianceDao.getOne(id);
    }

    @Override
    public TypeAppliance findByIdWithAssociatedList(Long id) {
        return findById(id);
    }

    @Override
    public int deleteById(Long id) {
        int res = 0;
        if (typeApplianceDao.findById(id).isPresent()) {
            deleteAssociatedLists(id);
            typeApplianceDao.deleteById(id);
            res = 1;
        }
        return res;
    }

    @Override
    public TypeAppliance save(TypeAppliance entity) {
        TypeAppliance result =null;
        TypeAppliance foundedTypeAppliance = findByLibelle(entity.getLibelle());
        if(foundedTypeAppliance == null){

            TypeAppliance savedTypeAppliance = typeApplianceDao.save(entity);

            result = savedTypeAppliance;
        }

        return result;
    }

    @Override
    public List<TypeAppliance> save(List<TypeAppliance> list) {
        List<TypeAppliance> savedList = new ArrayList<>();
        if(list != null && ListUtil.isNotEmpty(list))
            for(TypeAppliance typeAppliance: list){
                savedList.add(save(typeAppliance));
            }
        return savedList;
    }

    @Override
    public TypeAppliance update(TypeAppliance T) {
        TypeAppliance foundedTypeAppliance = findByIdOrLibelle(T);
        if (foundedTypeAppliance == null) return null;
        else {
            archivableService.prepare(T);
            return typeApplianceDao.save(T);
        }
    }

    @Override
    public int delete(TypeAppliance T) {
        if(T.getLibelle()==null) return -1;

        TypeAppliance foundedTypeAppliance = findByLibelle(T.getLibelle());
        if(foundedTypeAppliance==null) return -1;
        typeApplianceDao.delete(foundedTypeAppliance);
        return 1;
    }

    @Override
    public List<TypeAppliance> findByCriteria(TypeApplianceVo vo) {
        String query = "SELECT o FROM TypeAppliance o where 1=1 ";

        query += SearchUtil.addConstraint( "o", "id","=",vo.getId());
        query += SearchUtil.addConstraint( "o", "libelle","LIKE",vo.getLibelle());
        query += SearchUtil.addConstraint( "o", "archive","=",vo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",vo.getDateArchivage());
        query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",vo.getDateArchivageMin(),vo.getDateArchivageMax());

        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void delete(List<TypeAppliance> list) {
        if(ListUtil.isNotEmpty(list)){
            list.forEach(e->typeApplianceDao.delete(e));
        }
    }

    @Override
    public void update(List<TypeAppliance> list) {
        if(ListUtil.isNotEmpty(list)){
            list.forEach(e->typeApplianceDao.save(e));
        }
    }

    private void deleteAssociatedLists(Long id) {
        if (id != null) {
            applianceChercheurService.deleteByTypeApplianceId(id);
        }
    }
}
