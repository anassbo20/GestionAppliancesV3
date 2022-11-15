package com.example.gestion_appliances_v2.ws.rest.provided.facade.manager;


import com.example.gestion_appliances_v2.service.admin.facade.TypeApplianceAdminService;
import com.example.gestion_appliances_v2.ws.rest.provided.converter.TypeApplianceConverter;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.TypeApplianceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/manager/type-appliance")
public class TypeApplianceRestManager {

    @Autowired
    private TypeApplianceAdminService typeApplianceAdminService;

    @Autowired
    private TypeApplianceConverter typeApplianceConverter;

    @GetMapping("/libelle/{libelle}")
    public TypeApplianceVo findByLibelle(@PathVariable String libelle) {
        return typeApplianceConverter.toVo(typeApplianceAdminService.findByLibelle(libelle));
    }
    @DeleteMapping("/libelle/{lib}")
    public int deleteByLibelle(@PathVariable String lib) {
        return typeApplianceAdminService.deleteByLibelle(lib);
    }

    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return typeApplianceAdminService.deleteById(id);
    }
    @PutMapping("/archiver")
    public TypeApplianceVo archiver(@RequestBody TypeApplianceVo typeAppliance) {
        return typeApplianceConverter.toVo(typeApplianceAdminService.archiver(typeApplianceConverter.toItem(typeAppliance)));
    }
    @PutMapping("/desarchiver")
    public TypeApplianceVo desarchiver(@RequestBody TypeApplianceVo typeAppliance) {
        return typeApplianceConverter.toVo(typeApplianceAdminService.desarchiver(typeApplianceConverter.toItem(typeAppliance)));
    }
    @GetMapping("/")
    public List<TypeApplianceVo> findAll() {
        return typeApplianceConverter.toVo(typeApplianceAdminService.findAll());
    }
    @GetMapping("/id/{id}")
    public TypeApplianceVo findById(@PathVariable Long id) {
        return typeApplianceConverter.toVo(typeApplianceAdminService.findById(id));
    }
    @GetMapping("/detail/id/{id}")
    public TypeApplianceVo findByIdWithAssociatedList(@PathVariable Long id) {
        return typeApplianceConverter.toVo(typeApplianceAdminService.findByIdWithAssociatedList(id));
    }

    @PostMapping("/")
    public TypeApplianceVo save(@RequestBody TypeApplianceVo entity) {
        return typeApplianceConverter.toVo(typeApplianceAdminService.save(typeApplianceConverter.toItem(entity)));
    }
    @PostMapping("/save-list")
    public List<TypeApplianceVo> save(@RequestBody List<TypeApplianceVo> list) {
        return typeApplianceConverter.toVo(typeApplianceAdminService.save(typeApplianceConverter.toItem(list)));
    }
    @PutMapping("/")
    public TypeApplianceVo update(@RequestBody TypeApplianceVo T) {
        return typeApplianceConverter.toVo(typeApplianceAdminService.update(typeApplianceConverter.toItem(T)));
    }
    @DeleteMapping("/")
    public int delete(@RequestBody TypeApplianceVo T) {
        return typeApplianceAdminService.delete(typeApplianceConverter.toItem(T));
    }
    @PostMapping("/search")
    public List<TypeApplianceVo> findByCriteria(@RequestBody TypeApplianceVo vo) {
        return typeApplianceConverter.toVo(typeApplianceAdminService.findByCriteria(vo));
    }
    @DeleteMapping("/delete-list")
    public void delete(@RequestBody List<TypeApplianceVo> list) {
        typeApplianceAdminService.delete(typeApplianceConverter.toItem(list));
    }
    @PutMapping("/update-list")
    public void update(@RequestBody List<TypeApplianceVo> list) {
        typeApplianceAdminService.update(typeApplianceConverter.toItem(list));
    }
}
