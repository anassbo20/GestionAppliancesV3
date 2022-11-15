package com.example.gestion_appliances_v2.ws.rest.provided.facade.manager;


import com.example.gestion_appliances_v2.service.admin.facade.PovAdminService;
import com.example.gestion_appliances_v2.ws.rest.provided.converter.PovConverter;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.PovVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/manager/pov")
public class PovRestManager {

    @Autowired
    private PovAdminService povAdminService;

    @Autowired
    private PovConverter povConverter;

    @GetMapping("/libelle/{libelle}")
    public PovVo findByLibelle(@PathVariable String libelle) {
        return povConverter.toVo(povAdminService.findByLibelle(libelle));
    }

    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return povAdminService.deleteById(id);
    }
    @DeleteMapping("/libelle/{libelle}")
    public int deleteByLibelle(@PathVariable String libelle) {
        return povAdminService.deleteByLibelle(libelle);
    }
    @GetMapping("/client/libelle/{libelle}")
    public List<PovVo> findByClientLibelle(@PathVariable String lib) {
        return povConverter.toVo(povAdminService.findByClientLibelle(lib));
    }
    @DeleteMapping("/client/libelle/{libelle}")
    public int deleteByClientLibelle(@PathVariable String lib) {
        return povAdminService.deleteByClientLibelle(lib);
    }
    @GetMapping("/appliance/reference/{ref}")
    public List<PovVo> findByApplianceReference(@PathVariable String ref) {
        return povConverter.toVo(povAdminService.findByApplianceReference(ref));
    }
    @DeleteMapping("/appliance/reference/{ref}")
    public int deleteByApplianceReference(@PathVariable String ref) {
        return povAdminService.deleteByApplianceReference(ref);
    }
    @PutMapping("/archiver")
    public PovVo archiver(@RequestBody PovVo pov) {
        return povConverter.toVo(povAdminService.archiver(povConverter.toItem(pov)));
    }
    @PutMapping("/desarchiver")
    public PovVo desarchiver(@RequestBody PovVo pov) {
        return povConverter.toVo(povAdminService.desarchiver(povConverter.toItem(pov)));
    }
    @GetMapping("/")
    public List<PovVo> findAll() {
        return povConverter.toVo(povAdminService.findAll());
    }
    @GetMapping("/id/{id}")
    public PovVo findById(@PathVariable Long id) {
        return povConverter.toVo(povAdminService.findById(id));
    }
    @GetMapping("/detail/id/{id}")
    public PovVo findByIdWithAssociatedList(@PathVariable Long id) {
        return povConverter.toVo(povAdminService.findByIdWithAssociatedList(id));
    }

    @PostMapping("/")
    public PovVo save(@RequestBody PovVo entity) {
        return povConverter.toVo(povAdminService.save(povConverter.toItem(entity)));
    }
    @PostMapping("/save-list")
    public List<PovVo> save(@RequestBody List<PovVo> list) {
        return povConverter.toVo(povAdminService.save(povConverter.toItem(list)));
    }
    @PutMapping("/")
    public PovVo update(@RequestBody PovVo T) {
        return povConverter.toVo(povAdminService.update(povConverter.toItem(T)));
    }
    @DeleteMapping("/")
    public int delete(@RequestBody PovVo T) {
        return povAdminService.delete(povConverter.toItem(T));
    }
    @PostMapping("/search")
    public List<PovVo> findByCriteria(@RequestBody PovVo vo) {
        return povConverter.toVo(povAdminService.findByCriteria(vo));
    }
    @DeleteMapping("/delete-list")
    public void delete(@RequestBody List<PovVo> list) {
        povAdminService.delete(povConverter.toItem(list));
    }
    @PutMapping("/update-list")
    public void update(@RequestBody List<PovVo> list) {
        povAdminService.update(povConverter.toItem(list));
    }
}
