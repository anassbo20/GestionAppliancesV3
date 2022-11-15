package com.example.gestion_appliances_v2.service.core.facade;

import java.util.List;


public interface AbstractService<T,I,V>{

        List<T> findAll();

        T findById(I id);

        T findByIdWithAssociatedList(I id);

        int deleteById(I id);

        List<List<T>> getToBeSavedAndToBeDeleted(List<T> oldList, List<T> newList);


        T save(T entity);

        List<T> save(List<T> list);


        T update(T T);


        int delete(T T);


        List<T> findByCriteria(V vo);


        void delete(List<T> list);


        void update(List<T> list);

}
