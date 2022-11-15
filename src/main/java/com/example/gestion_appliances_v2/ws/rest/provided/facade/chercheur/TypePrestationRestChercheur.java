package com.example.gestion_appliances_v2.ws.rest.provided.facade.chercheur;


import com.example.gestion_appliances_v2.service.chercheur.facade.TypePrestationChercheurService;
import com.example.gestion_appliances_v2.ws.rest.provided.converter.TypePrestationConverter;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.TypePrestationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/chercheur/type-prestation")
public class TypePrestationRestChercheur {

    @Autowired
    private TypePrestationChercheurService typePrestationChercheurService;

    @Autowired
    private TypePrestationConverter typePrestationConverter;

    @GetMapping("/libelle/{libelle}")
    public TypePrestationVo findByLibelle(@PathVariable String libelle) {
        return typePrestationConverter.toVo(typePrestationChercheurService.findByLibelle(libelle));
    }
    @DeleteMapping("/libelle/{lib}")
    public int deleteByLibelle(@PathVariable String lib) {
        return typePrestationChercheurService.deleteByLibelle(lib);
    }

    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return typePrestationChercheurService.deleteById(id);
    }
    
    @GetMapping("/")
    public List<TypePrestationVo> findAll() {
        return typePrestationConverter.toVo(typePrestationChercheurService.findAll());
    }
    @GetMapping("/id/{id}")
    public TypePrestationVo findById(@PathVariable Long id) {
        return typePrestationConverter.toVo(typePrestationChercheurService.findById(id));
    }
    @GetMapping("/detail/id/{id}")
    public TypePrestationVo findByIdWithAssociatedList(@PathVariable Long id) {
        return typePrestationConverter.toVo(typePrestationChercheurService.findByIdWithAssociatedList(id));
    }

    @PostMapping("/")
    public TypePrestationVo save(@RequestBody TypePrestationVo entity) {
        return typePrestationConverter.toVo(typePrestationChercheurService.save(typePrestationConverter.toItem(entity)));
    }
    @PostMapping("/save-list/")
    public List<TypePrestationVo> save(@RequestBody List<TypePrestationVo> list) {
        return typePrestationConverter.toVo(typePrestationChercheurService.save(typePrestationConverter.toItem(list)));
    }
    @PutMapping("/")
    public TypePrestationVo update(@RequestBody TypePrestationVo T) {
        return typePrestationConverter.toVo(typePrestationChercheurService.update(typePrestationConverter.toItem(T)));
    }
    @DeleteMapping("/")
    public int delete(@RequestBody TypePrestationVo T) {
        return typePrestationChercheurService.delete(typePrestationConverter.toItem(T));
    }
    @GetMapping("/search/")
    public List<TypePrestationVo> findByCriteria(@RequestBody TypePrestationVo vo) {
        return typePrestationConverter.toVo(typePrestationChercheurService.findByCriteria(vo));
    }
    @DeleteMapping("/delete-list/")
    public void delete(@RequestBody List<TypePrestationVo> list) {
        typePrestationChercheurService.delete(typePrestationConverter.toItem(list));
    }
    @PutMapping("/update-list/")
    public void update(@RequestBody List<TypePrestationVo> list) {
        typePrestationChercheurService.update(typePrestationConverter.toItem(list));
    }
}
