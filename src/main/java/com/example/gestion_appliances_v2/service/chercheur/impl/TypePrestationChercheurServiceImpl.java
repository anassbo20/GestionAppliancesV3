package com.example.gestion_appliances_v2.service.chercheur.impl;


import com.example.gestion_appliances_v2.bean.TypePrestation;
import com.example.gestion_appliances_v2.dao.TypePrestationDao;
import com.example.gestion_appliances_v2.service.chercheur.facade.SuiviChercheurService;
import com.example.gestion_appliances_v2.service.chercheur.facade.TypePrestationChercheurService;
import com.example.gestion_appliances_v2.service.core.facade.ArchivableService;
import com.example.gestion_appliances_v2.service.core.impl.AbstractServiceImpl;
import com.example.gestion_appliances_v2.service.util.ListUtil;
import com.example.gestion_appliances_v2.service.util.SearchUtil;
import com.example.gestion_appliances_v2.service.util.StringUtil;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.TypePrestationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class TypePrestationChercheurServiceImpl extends AbstractServiceImpl<TypePrestation> implements TypePrestationChercheurService {
    @Autowired
    private TypePrestationDao typePrestationDao;
    @Autowired
    private SuiviChercheurService suiviChercheurService;
    @Autowired
    private ArchivableService<TypePrestation> archivableService;
    @Autowired
    private EntityManager entityManager;

    @Override
    public TypePrestation findByLibelle(String libelle) {
        if(libelle == null)  return null;
        return typePrestationDao.findByLibelle(libelle);
    }

    @Override
    public int deleteByLibelle(String lib) {
        return typePrestationDao.deleteByLibelle(lib);
    }

    @Override
    public TypePrestation findByIdOrLibelle(TypePrestation typePrestation) {
        TypePrestation resultat = null;
        if (typePrestation != null) {
            if (StringUtil.isNotEmpty(typePrestation.getId())) {
                resultat = typePrestationDao.getOne(typePrestation.getId());
            } else if (StringUtil.isNotEmpty(typePrestation.getLibelle())) {
                resultat = typePrestationDao.findByLibelle(typePrestation.getLibelle());
            }
        }
        return resultat;
    }

    @Override
    public List<TypePrestation> findAll() {
        String query = "SELECT o FROM TypePrestation o where 1=1 ";
        query += " AND o.archive != true";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public TypePrestation findById(Long id) {
        if(id==null) return null;
        return typePrestationDao.getOne(id);
    }

    @Override
    public TypePrestation findByIdWithAssociatedList(Long id) {
        return findById(id);
    }

    @Override
    public int deleteById(Long id) {
        int res = 0;
        if (typePrestationDao.findById(id).isPresent()) {
            deleteAssociatedLists(id);
            typePrestationDao.deleteById(id);
            res = 1;
        }
        return res;
    }

    @Override
    public TypePrestation save(TypePrestation entity) {
        TypePrestation result =null;
        TypePrestation foundedTypePrestation = findByLibelle(entity.getLibelle());
        if(foundedTypePrestation == null){

            TypePrestation savedTypePrestation = typePrestationDao.save(entity);

            result = savedTypePrestation;
        }

        return result;
    }

    @Override
    public List<TypePrestation> save(List<TypePrestation> list) {
        List<TypePrestation> savedList = new ArrayList<>();
        if(list != null && ListUtil.isNotEmpty(list))
            for(TypePrestation typePrestation: list){
                savedList.add(save(typePrestation));
            }
        return savedList;
    }

    @Override
    public TypePrestation update(TypePrestation T) {
        TypePrestation foundedTypePrestation = findByIdOrLibelle(T);
        if (foundedTypePrestation == null) return null;
        else {
            archivableService.prepare(T);
            return typePrestationDao.save(T);
        }
    }

    @Override
    public int delete(TypePrestation T) {
        if(T.getLibelle()==null) return -1;

        TypePrestation foundedTypePrestation = findByLibelle(T.getLibelle());
        if(foundedTypePrestation==null) return -1;
        typePrestationDao.delete(foundedTypePrestation);
        return 1;
    }

    @Override
    public List<TypePrestation> findByCriteria(TypePrestationVo vo) {
        String query = "SELECT o FROM TypePrestation o where 1=1 ";

        query += SearchUtil.addConstraint( "o", "id","=",vo.getId());
        query += SearchUtil.addConstraint( "o", "libelle","LIKE",vo.getLibelle());
        query += SearchUtil.addConstraint( "o", "archive","=",vo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",vo.getDateArchivage());
        query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",vo.getDateArchivageMin(),vo.getDateArchivageMax());

        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void delete(List<TypePrestation> list) {
        if(ListUtil.isNotEmpty(list)){
            list.forEach(e->typePrestationDao.delete(e));
        }
    }

    @Override
    public void update(List<TypePrestation> list) {
        if(ListUtil.isNotEmpty(list)){
            list.forEach(e->typePrestationDao.save(e));
        }
    }

    private void deleteAssociatedLists(Long id) {
        if (id != null) {
            TypePrestation typePrestation= findById(id);
            suiviChercheurService.deleteByTypePrestationId(id);
        }
    }
}
