package com.example.gestion_appliances_v2.ws.rest.provided.facade.admin;


import com.example.gestion_appliances_v2.service.admin.facade.ApplianceTagAdminService;
import com.example.gestion_appliances_v2.ws.rest.provided.converter.ApplianceTagConverter;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.ApplianceTagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/appliance-tag")
public class ApplianceTagRestAdmin {

    @Autowired
    private ApplianceTagAdminService applianceTagAdminService;

    @Autowired
    private ApplianceTagConverter applianceTagConverter;

    @GetMapping("/appliance/reference/{reference}")
    public List<ApplianceTagVo> findByApplianceReference(@PathVariable String reference) {
        return applianceTagConverter.toVo(applianceTagAdminService.findByApplianceReference(reference));
    }

    @DeleteMapping("/appliance/reference/{reference}")
    public int deleteByApplianceReference(@PathVariable String reference) {
        return applianceTagAdminService.deleteByApplianceReference(reference);
    }
    @GetMapping("/appliance/id/{id}")
    public List<ApplianceTagVo> findByApplianceId(@PathVariable Long id) {
        return applianceTagConverter.toVo(applianceTagAdminService.findByApplianceId(id));
    }
    @DeleteMapping("/appliance/id/{id}")
    public int deleteByApplianceId(@PathVariable Long id) {
        return applianceTagAdminService.deleteByApplianceId(id);
    }

    @GetMapping("/tag/reference/{reference}")
    public List<ApplianceTagVo> findByTagReference(@PathVariable String reference) {
        return applianceTagConverter.toVo(applianceTagAdminService.findByTagReference(reference));
    }
    @DeleteMapping("/tag/reference/{reference}")
    public int deleteByTagReference(@PathVariable String reference) {
        return applianceTagAdminService.deleteByTagReference(reference);
    }
    @GetMapping("/tag/id/{id}")
    public List<ApplianceTagVo> findByTagId(@PathVariable Long id) {
        return applianceTagConverter.toVo(applianceTagAdminService.findByTagId(id));
    }

    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return applianceTagAdminService.deleteById(id);
    }

    @DeleteMapping("/tag/id/{id}")
    public int deleteByTagId(@PathVariable Long id) {
        return applianceTagAdminService.deleteByTagId(id);
    }

    @GetMapping("/")
    public List<ApplianceTagVo> findAll() {
        return applianceTagConverter.toVo(applianceTagAdminService.findAll());
    }
    @GetMapping("/id/{id}")
    public ApplianceTagVo findById(@PathVariable Long id) {
        return applianceTagConverter.toVo(applianceTagAdminService.findById(id));
    }

    @GetMapping("/detail/id/{id}")
    public ApplianceTagVo findByIdWithAssociatedList(@PathVariable Long id) {
        return applianceTagConverter.toVo(applianceTagAdminService.findByIdWithAssociatedList(id));
    }

    @PostMapping("/")
    public ApplianceTagVo save(@RequestBody ApplianceTagVo entity) {
        return applianceTagConverter.toVo(applianceTagAdminService.save(applianceTagConverter.toItem(entity)));
    }

    @PostMapping("/save-list")
    public List<ApplianceTagVo> save(@RequestBody List<ApplianceTagVo> list) {
        return applianceTagConverter.toVo(applianceTagAdminService.save(applianceTagConverter.toItem(list)));
    }

    @PutMapping("/")
    public ApplianceTagVo update(@RequestBody ApplianceTagVo T) {
        return applianceTagConverter.toVo(applianceTagAdminService.update(applianceTagConverter.toItem(T)));
    }

    @DeleteMapping("/")
    public int delete(@RequestBody ApplianceTagVo T) {
        return applianceTagAdminService.delete(applianceTagConverter.toItem(T));
    }

    @PostMapping("/search")
    public List<ApplianceTagVo> findByCriteria(@RequestBody ApplianceTagVo vo) {
        return applianceTagConverter.toVo(applianceTagAdminService.findByCriteria(vo));
    }
    @DeleteMapping("/delete-list")
    public void delete(@RequestBody List<ApplianceTagVo> list) {
        applianceTagAdminService.delete(applianceTagConverter.toItem(list));
    }
    @PutMapping("/update-list")
    public void update(@RequestBody List<ApplianceTagVo> list) {
        applianceTagAdminService.update(applianceTagConverter.toItem(list));
    }
}
