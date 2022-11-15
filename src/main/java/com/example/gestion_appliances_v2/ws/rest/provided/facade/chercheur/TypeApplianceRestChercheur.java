package com.example.gestion_appliances_v2.ws.rest.provided.facade.chercheur;



import com.example.gestion_appliances_v2.service.chercheur.facade.TypeApplianceChercheurService;
import com.example.gestion_appliances_v2.ws.rest.provided.converter.TypeApplianceConverter;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.TypeApplianceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/chercheur/type-appliance")
public class TypeApplianceRestChercheur {

    @Autowired
    private TypeApplianceChercheurService typeApplianceChercheurService;

    @Autowired
    private TypeApplianceConverter typeApplianceConverter;

    @GetMapping("/libelle/{libelle}")
    public TypeApplianceVo findByLibelle(@PathVariable String libelle) {
        return typeApplianceConverter.toVo(typeApplianceChercheurService.findByLibelle(libelle));
    }
    @DeleteMapping("/libelle/{lib}")
    public int deleteByLibelle(@PathVariable String lib) {
        return typeApplianceChercheurService.deleteByLibelle(lib);
    }

    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return typeApplianceChercheurService.deleteById(id);
    }

    @GetMapping("/")
    public List<TypeApplianceVo> findAll() {
        return typeApplianceConverter.toVo(typeApplianceChercheurService.findAll());
    }
    @GetMapping("/id/{id}")
    public TypeApplianceVo findById(@PathVariable Long id) {
        return typeApplianceConverter.toVo(typeApplianceChercheurService.findById(id));
    }
    @GetMapping("/detail/id/{id}")
    public TypeApplianceVo findByIdWithAssociatedList(@PathVariable Long id) {
        return typeApplianceConverter.toVo(typeApplianceChercheurService.findByIdWithAssociatedList(id));
    }

    @PostMapping("/")
    public TypeApplianceVo save(@RequestBody TypeApplianceVo entity) {
        return typeApplianceConverter.toVo(typeApplianceChercheurService.save(typeApplianceConverter.toItem(entity)));
    }
    @PostMapping("/save-list/")
    public List<TypeApplianceVo> save(@RequestBody List<TypeApplianceVo> list) {
        return typeApplianceConverter.toVo(typeApplianceChercheurService.save(typeApplianceConverter.toItem(list)));
    }
    @PutMapping("/")
    public TypeApplianceVo update(@RequestBody TypeApplianceVo T) {
        return typeApplianceConverter.toVo(typeApplianceChercheurService.update(typeApplianceConverter.toItem(T)));
    }
    @DeleteMapping("/")
    public int delete(@RequestBody TypeApplianceVo T) {
        return typeApplianceChercheurService.delete(typeApplianceConverter.toItem(T));
    }
    @GetMapping("/search/")
    public List<TypeApplianceVo> findByCriteria(@RequestBody TypeApplianceVo vo) {
        return typeApplianceConverter.toVo(typeApplianceChercheurService.findByCriteria(vo));
    }
    @DeleteMapping("/delete-list/")
    public void delete(@RequestBody List<TypeApplianceVo> list) {
        typeApplianceChercheurService.delete(typeApplianceConverter.toItem(list));
    }
    @PutMapping("/update-list/")
    public void update(@RequestBody List<TypeApplianceVo> list) {
        typeApplianceChercheurService.update(typeApplianceConverter.toItem(list));
    }
}
