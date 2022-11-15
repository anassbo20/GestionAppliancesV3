package com.example.gestion_appliances_v2.ws.rest.provided.facade.chercheur;


import com.example.gestion_appliances_v2.service.chercheur.facade.PovChercheurService;
import com.example.gestion_appliances_v2.ws.rest.provided.converter.PovConverter;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.PovVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/chercheur/pov")
public class PovRestChercheur {

    @Autowired
    private PovChercheurService povChercheurService;

    @Autowired
    private PovConverter povConverter;

    @GetMapping("/libelle/{libelle}")
    public PovVo findByLibelle(@PathVariable String libelle) {
        return povConverter.toVo(povChercheurService.findByLibelle(libelle));
    }

    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return povChercheurService.deleteById(id);
    }
    @DeleteMapping("/libelle/{libelle}")
    public int deleteByLibelle(@PathVariable String libelle) {
        return povChercheurService.deleteByLibelle(libelle);
    }
    @GetMapping("/client/libelle/{libelle}")
    public List<PovVo> findByClientLibelle(@PathVariable String lib) {
        return povConverter.toVo(povChercheurService.findByClientLibelle(lib));
    }
    @DeleteMapping("/client/libelle/{libelle}")
    public int deleteByClientLibelle(@PathVariable String lib) {
        return povChercheurService.deleteByClientLibelle(lib);
    }
    @GetMapping("/appliance/reference/{ref}")
    public List<PovVo> findByApplianceReference(@PathVariable String ref) {
        return povConverter.toVo(povChercheurService.findByApplianceReference(ref));
    }
    @DeleteMapping("/appliance/reference/{ref}")
    public int deleteByApplianceReference(@PathVariable String ref) {
        return povChercheurService.deleteByApplianceReference(ref);
    }

    @GetMapping("/")
    public List<PovVo> findAll() {
        return povConverter.toVo(povChercheurService.findAll());
    }
    @GetMapping("/id/{id}")
    public PovVo findById(@PathVariable Long id) {
        return povConverter.toVo(povChercheurService.findById(id));
    }
    @GetMapping("/detail/id/{id}")
    public PovVo findByIdWithAssociatedList(@PathVariable Long id) {
        return povConverter.toVo(povChercheurService.findByIdWithAssociatedList(id));
    }

    @PostMapping("/")
    public PovVo save(@RequestBody PovVo entity) {
        return povConverter.toVo(povChercheurService.save(povConverter.toItem(entity)));
    }
    @PostMapping("/save-list/")
    public List<PovVo> save(@RequestBody List<PovVo> list) {
        return povConverter.toVo(povChercheurService.save(povConverter.toItem(list)));
    }
    @PutMapping("/")
    public PovVo update(@RequestBody PovVo T) {
        return povConverter.toVo(povChercheurService.update(povConverter.toItem(T)));
    }
    @DeleteMapping("/")
    public int delete(@RequestBody PovVo T) {
        return povChercheurService.delete(povConverter.toItem(T));
    }
    @GetMapping("/search/")
    public List<PovVo> findByCriteria(@RequestBody PovVo vo) {
        return povConverter.toVo(povChercheurService.findByCriteria(vo));
    }
    @DeleteMapping("/delete-list/")
    public void delete(@RequestBody List<PovVo> list) {
        povChercheurService.delete(povConverter.toItem(list));
    }
    @PutMapping("/update-list/")
    public void update(@RequestBody List<PovVo> list) {
        povChercheurService.update(povConverter.toItem(list));
    }
}
