package com.example.gestion_appliances_v2.ws.rest.provided.facade.chercheur;



import com.example.gestion_appliances_v2.service.chercheur.facade.ApplianceTagChercheurService;
import com.example.gestion_appliances_v2.ws.rest.provided.converter.ApplianceTagConverter;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.ApplianceTagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/chercheur/appliance-tag")
public class ApplianceTagRestChercheur {

    @Autowired
    private ApplianceTagChercheurService applianceTagChercheurService;

    @Autowired
    private ApplianceTagConverter applianceTagConverter;

    @GetMapping("/appliance/reference/{reference}")
    public List<ApplianceTagVo> findByApplianceReference(@PathVariable String reference) {
        return applianceTagConverter.toVo(applianceTagChercheurService.findByApplianceReference(reference));
    }

    @DeleteMapping("/appliance/reference/{reference}")
    public int deleteByApplianceReference(@PathVariable String reference) {
        return applianceTagChercheurService.deleteByApplianceReference(reference);
    }
    @GetMapping("/appliance/id/{id}")
    public List<ApplianceTagVo> findByApplianceId(@PathVariable Long id) {
        return applianceTagConverter.toVo(applianceTagChercheurService.findByApplianceId(id));
    }
    @DeleteMapping("/appliance/id/{id}")
    public int deleteByApplianceId(@PathVariable Long id) {
        return applianceTagChercheurService.deleteByApplianceId(id);
    }

    @GetMapping("/tag/reference/{reference}")
    public List<ApplianceTagVo> findByTagReference(@PathVariable String reference) {
        return applianceTagConverter.toVo(applianceTagChercheurService.findByTagReference(reference));
    }
    @DeleteMapping("/tag/reference/{reference}")
    public int deleteByTagReference(@PathVariable String reference) {
        return applianceTagChercheurService.deleteByTagReference(reference);
    }
    @GetMapping("/tag/id/{id}")
    public List<ApplianceTagVo> findByTagId(@PathVariable Long id) {
        return applianceTagConverter.toVo(applianceTagChercheurService.findByTagId(id));
    }

    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return applianceTagChercheurService.deleteById(id);
    }

    @DeleteMapping("/tag/id/{id}")
    public int deleteByTagId(@PathVariable Long id) {
        return applianceTagChercheurService.deleteByTagId(id);
    }

    @GetMapping("/")
    public List<ApplianceTagVo> findAll() {
        return applianceTagConverter.toVo(applianceTagChercheurService.findAll());
    }
    @GetMapping("/id/{id}")
    public ApplianceTagVo findById(@PathVariable Long id) {
        return applianceTagConverter.toVo(applianceTagChercheurService.findById(id));
    }

    @GetMapping("/detail/id/{id}")
    public ApplianceTagVo findByIdWithAssociatedList(@PathVariable Long id) {
        return applianceTagConverter.toVo(applianceTagChercheurService.findByIdWithAssociatedList(id));
    }

    @PostMapping("/")
    public ApplianceTagVo save(@RequestBody ApplianceTagVo entity) {
        return applianceTagConverter.toVo(applianceTagChercheurService.save(applianceTagConverter.toItem(entity)));
    }

    @PostMapping("/save-list/")
    public List<ApplianceTagVo> save(@RequestBody List<ApplianceTagVo> list) {
        return applianceTagConverter.toVo(applianceTagChercheurService.save(applianceTagConverter.toItem(list)));
    }

    @PutMapping("/")
    public ApplianceTagVo update(@RequestBody ApplianceTagVo T) {
        return applianceTagConverter.toVo(applianceTagChercheurService.update(applianceTagConverter.toItem(T)));
    }

    @DeleteMapping("/")
    public int delete(@RequestBody ApplianceTagVo T) {
        return applianceTagChercheurService.delete(applianceTagConverter.toItem(T));
    }

    @GetMapping("/search/")
    public List<ApplianceTagVo> findByCriteria(@RequestBody ApplianceTagVo vo) {
        return applianceTagConverter.toVo(applianceTagChercheurService.findByCriteria(vo));
    }
    @DeleteMapping("/delete-list/")
    public void delete(@RequestBody List<ApplianceTagVo> list) {
        applianceTagChercheurService.delete(applianceTagConverter.toItem(list));
    }
    @PutMapping("/update-list/")
    public void update(@RequestBody List<ApplianceTagVo> list) {
        applianceTagChercheurService.update(applianceTagConverter.toItem(list));
    }
}
