package com.example.gestion_appliances_v2.ws.rest.provided.facade.admin;


import com.example.gestion_appliances_v2.service.admin.facade.TypePrestationAdminService;
import com.example.gestion_appliances_v2.ws.rest.provided.converter.TypePrestationConverter;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.TypePrestationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/type-prestation")
public class TypePrestationRestAdmin {

    @Autowired
    private TypePrestationAdminService typePrestationAdminService;

    @Autowired
    private TypePrestationConverter typePrestationConverter;

    @GetMapping("/libelle/{libelle}")
    public TypePrestationVo findByLibelle(@PathVariable String libelle) {
        return typePrestationConverter.toVo(typePrestationAdminService.findByLibelle(libelle));
    }
    @DeleteMapping("/libelle/{lib}")
    public int deleteByLibelle(@PathVariable String lib) {
        return typePrestationAdminService.deleteByLibelle(lib);
    }

    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return typePrestationAdminService.deleteById(id);
    }
    @PutMapping("/archiver")
    public TypePrestationVo archiver(@RequestBody TypePrestationVo typePrestation) {
        return typePrestationConverter.toVo(typePrestationAdminService.archiver(typePrestationConverter.toItem(typePrestation)));
    }
    @PutMapping("/desarchiver")
    public TypePrestationVo desarchiver(@RequestBody TypePrestationVo typePrestation) {
        return typePrestationConverter.toVo(typePrestationAdminService.desarchiver(typePrestationConverter.toItem(typePrestation)));
    }
    @GetMapping("/")
    public List<TypePrestationVo> findAll() {
        return typePrestationConverter.toVo(typePrestationAdminService.findAll());
    }
    @GetMapping("/id/{id}")
    public TypePrestationVo findById(@PathVariable Long id) {
        return typePrestationConverter.toVo(typePrestationAdminService.findById(id));
    }
    @GetMapping("/detail/id/{id}")
    public TypePrestationVo findByIdWithAssociatedList(@PathVariable Long id) {
        return typePrestationConverter.toVo(typePrestationAdminService.findByIdWithAssociatedList(id));
    }

    @PostMapping("/")
    public TypePrestationVo save(@RequestBody TypePrestationVo entity) {
        return typePrestationConverter.toVo(typePrestationAdminService.save(typePrestationConverter.toItem(entity)));
    }
    @PostMapping("/save-list")
    public List<TypePrestationVo> save(@RequestBody List<TypePrestationVo> list) {
        return typePrestationConverter.toVo(typePrestationAdminService.save(typePrestationConverter.toItem(list)));
    }
    @PutMapping("/")
    public TypePrestationVo update(@RequestBody TypePrestationVo T) {
        return typePrestationConverter.toVo(typePrestationAdminService.update(typePrestationConverter.toItem(T)));
    }
    @DeleteMapping("/")
    public int delete(@RequestBody TypePrestationVo T) {
        return typePrestationAdminService.delete(typePrestationConverter.toItem(T));
    }
    @PostMapping("/search")
    public List<TypePrestationVo> findByCriteria(@RequestBody TypePrestationVo vo) {
        return typePrestationConverter.toVo(typePrestationAdminService.findByCriteria(vo));
    }
    @DeleteMapping("/delete-list")
    public void delete(@RequestBody List<TypePrestationVo> list) {
        typePrestationAdminService.delete(typePrestationConverter.toItem(list));
    }
    @PutMapping("/update-list")
    public void update(@RequestBody List<TypePrestationVo> list) {
        typePrestationAdminService.update(typePrestationConverter.toItem(list));
    }
}
