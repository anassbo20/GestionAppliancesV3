package com.example.gestion_appliances_v2.service.core.facade;


import com.example.gestion_appliances_v2.bean.Archivable;

public interface ArchivableService<T extends Archivable>{


    int prepare(T object) ;


    int prepareArchivage(T object);


    int prepareDesarchivage(T object);



    }
