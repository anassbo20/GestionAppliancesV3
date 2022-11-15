package com.example.gestion_appliances_v2.ws.rest.provided.facade.admin;


import com.example.gestion_appliances_v2.service.admin.facade.SceanceAdminService;
import com.example.gestion_appliances_v2.ws.rest.provided.converter.SceanceConverter;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.SceanceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/admin/sceance")
public class SceanceRestAdmin {

    @Autowired
    private SceanceAdminService sceanceAdminService;

    @Autowired
    private SceanceConverter sceanceConverter;

    @GetMapping("/date-sceance/{dateSc}")
    public List<SceanceVo> findByDateSceance(@PathVariable Date dateSc) {
        return sceanceConverter.toVo(sceanceAdminService.findByDateSceance(dateSc));
    }
    @DeleteMapping("/date-sceance/{dateSc}")
    public int deleteByDateSceance(@PathVariable Date dateSc) {
        return sceanceAdminService.deleteByDateSceance(dateSc);
    }
    @GetMapping("/libelle/{lib}")
    public List<SceanceVo> findByPovLibelle(@PathVariable String lib) {
        return sceanceConverter.toVo(sceanceAdminService.findByPovLibelle(lib));
    }
    @DeleteMapping("/libelle/{lib}")
    public int deleteByPovLibelle(@PathVariable String lib) {
        return sceanceAdminService.deleteByPovLibelle(lib);
    }
    @PutMapping("/archiver")
    public SceanceVo archiver(@RequestBody SceanceVo sceance) {
        return sceanceConverter.toVo(sceanceAdminService.archiver(sceanceConverter.toItem(sceance)));
    }
    @PutMapping("/desarchiver")
    public SceanceVo desarchiver(@RequestBody SceanceVo sceance) {
        return sceanceConverter.toVo(sceanceAdminService.desarchiver(sceanceConverter.toItem(sceance)));
    }
    @GetMapping("/")
    public List<SceanceVo> findAll() {
        return sceanceConverter.toVo(sceanceAdminService.findAll());
    }
    @GetMapping("/id/{id}")
    public SceanceVo findById(@PathVariable Long id) {
        return sceanceConverter.toVo(sceanceAdminService.findById(id));
    }
    @GetMapping("/detail/id/{id}")
    public SceanceVo findByIdWithAssociatedList(@PathVariable Long id) {
        return sceanceConverter.toVo(sceanceAdminService.findByIdWithAssociatedList(id));
    }
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return sceanceAdminService.deleteById(id);
    }

    @PostMapping("/")
    public SceanceVo save(@RequestBody SceanceVo entity) {
        return sceanceConverter.toVo(sceanceAdminService.save(sceanceConverter.toItem(entity)));
    }
    @PostMapping("/save-list")
    public List<SceanceVo> save(@RequestBody List<SceanceVo> list) {
        return sceanceConverter.toVo(sceanceAdminService.save(sceanceConverter.toItem(list)));
    }
    @PutMapping("/")
    public SceanceVo update(@RequestBody SceanceVo T) {
        return sceanceConverter.toVo(sceanceAdminService.update(sceanceConverter.toItem(T)));
    }
    @DeleteMapping("/")
    public int delete(@RequestBody SceanceVo T) {
        return sceanceAdminService.delete(sceanceConverter.toItem(T));
    }
    @PostMapping("/search")
    public List<SceanceVo> findByCriteria(@RequestBody SceanceVo vo) {
        return sceanceConverter.toVo(sceanceAdminService.findByCriteria(vo));
    }
    @DeleteMapping("/delete-list")
    public void delete(@RequestBody List<SceanceVo> list) {
        sceanceAdminService.delete(sceanceConverter.toItem(list));
    }
    @PutMapping("/update-list")
    public void update(@RequestBody List<SceanceVo> list) {
        sceanceAdminService.update(sceanceConverter.toItem(list));
    }
}
