package com.example.gestion_appliances_v2.service.admin.facade;

import com.example.gestion_appliances_v2.bean.ApplianceTag;
import com.example.gestion_appliances_v2.service.core.facade.AbstractService;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.ApplianceTagVo;

import java.util.List;

public interface ApplianceTagAdminService extends AbstractService<ApplianceTag,Long, ApplianceTagVo> {

    List<ApplianceTag> findByApplianceReference(String reference);

    int deleteByApplianceReference(String reference);

    List<ApplianceTag> findByApplianceId(Long id);

    int deleteByApplianceId(Long id);

    List<ApplianceTag> findByTagReference(String reference);

    int deleteByTagReference(String reference);

    List<ApplianceTag> findByTagId(Long id);

    int deleteById(Long id);

    int deleteByTagId(Long id);


}
