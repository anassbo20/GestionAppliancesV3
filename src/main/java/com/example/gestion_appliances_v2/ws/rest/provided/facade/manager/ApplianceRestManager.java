package com.example.gestion_appliances_v2.ws.rest.provided.facade.manager;


import com.example.gestion_appliances_v2.service.admin.facade.ApplianceAdminService;
import com.example.gestion_appliances_v2.ws.rest.provided.converter.ApplianceConverter;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.ApplianceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


@RestController
@RequestMapping("api/manager/appliance")
public class ApplianceRestManager {

    @Autowired
    private ApplianceAdminService applianceAdminService;

    @Autowired
    private ApplianceConverter applianceConverter;

    @GetMapping("/dbid/{dbid}")
    public ApplianceVo findByDibd(@PathVariable String dbid) {
        return applianceConverter.toVo(applianceAdminService.findByDibd(dbid));
    }
    @GetMapping("/reference/{ref}")
    public ApplianceVo findByReference(@PathVariable String ref) {
       return applianceConverter.toVo(applianceAdminService.findByReference(ref));
    }


    @GetMapping("/libelle/{libelle}")
    public List<ApplianceVo> findByTypeApplianceLibelle(@PathVariable String libelle) {
        return applianceConverter.toVo(applianceAdminService.findByTypeApplianceLibelle(libelle));
    }
    @GetMapping("/disponibilite/{disp}")
    public List<ApplianceVo> findByDisponibilite(@PathVariable boolean disp) {
        return applianceConverter.toVo(applianceAdminService.findByDisponibilite(disp));
    }
    @Transactional
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return applianceAdminService.deleteById(id);
    }
    @Transactional
    @DeleteMapping("/dbid/{dbid}")
    public int deleteByDibd(@PathVariable String dbid) {
        return applianceAdminService.deleteByDibd(dbid);
    }
    @Transactional
    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return applianceAdminService.deleteByReference(reference);
    }
    @Transactional
    @DeleteMapping("/type-appliance/libelle/{libelle}")
    public int deleteByTypeApplianceLibelle(@PathVariable String libelle) {
        return applianceAdminService.deleteByTypeApplianceLibelle(libelle);
    }
    @Transactional
    @DeleteMapping("/type-appliance/id/{id}")
    public int deleteByTypeApplianceId(@PathVariable Long id) {
        return applianceAdminService.deleteByTypeApplianceId(id);
    }
    @PutMapping("/archiver")
    public ApplianceVo archiver(@RequestBody ApplianceVo applianceVo) {
        return applianceConverter.toVo(applianceAdminService.archiver(applianceConverter.toItem(applianceVo)));
    }
    @PutMapping("/desarchiver")
    public ApplianceVo desarchiver(@RequestBody ApplianceVo applianceVo) {
        return applianceConverter.toVo(applianceAdminService.desarchiver(applianceConverter.toItem(applianceVo)));
    }
    @GetMapping("/")
    public List<ApplianceVo> findAll() {
        return applianceConverter.toVo(applianceAdminService.findAll());
    }
    @GetMapping("/id/{id}")
    public ApplianceVo findById(@PathVariable Long id) {
        return applianceConverter.toVo(applianceAdminService.findById(id));
    }
    @GetMapping("/detail/id/{id}")
    public ApplianceVo findByIdWithAssociatedList(@PathVariable Long id) {
        return applianceConverter.toVo(applianceAdminService.findByIdWithAssociatedList(id));
    }

    @PostMapping("/")
    public ApplianceVo save(@RequestBody ApplianceVo entity) {
        return applianceConverter.toVo(applianceAdminService.save(applianceConverter.toItem(entity)));
    }

    @PutMapping("/")
    public ApplianceVo update(@RequestBody ApplianceVo T) {
        return applianceConverter.toVo(applianceAdminService.update(applianceConverter.toItem(T)));
    }
    @Transactional
    @DeleteMapping("/")
    public int delete(@RequestBody ApplianceVo T) {
        return applianceAdminService.delete(applianceConverter.toItem(T));
    }
    @PostMapping("/search")
    public List<ApplianceVo> findByCriteria(@RequestBody ApplianceVo vo) {
        return applianceConverter.toVo(applianceAdminService.findByCriteria(vo));
    }

}
