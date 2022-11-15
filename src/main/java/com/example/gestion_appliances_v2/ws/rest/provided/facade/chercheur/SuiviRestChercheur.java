package com.example.gestion_appliances_v2.ws.rest.provided.facade.chercheur;


import com.example.gestion_appliances_v2.service.chercheur.facade.SuiviChercheurService;
import com.example.gestion_appliances_v2.ws.rest.provided.converter.SuiviConverter;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.SuiviVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/chercheur/suivi")
public class SuiviRestChercheur {

    @Autowired
    private SuiviChercheurService suiviChercheurService;

    @Autowired
    private SuiviConverter suiviConverter;

    @GetMapping("/offre-commercial/{offre}")
    public List<SuiviVo> findByOffreCommercialIs(@PathVariable Boolean offre) {
        return suiviConverter.toVo(suiviChercheurService.findByOffreCommercialIs(offre));
    }

    @DeleteMapping("/offre-commercial/{off}")
    public int deleteByOffreCommercialIs(@PathVariable Boolean off) {
        return suiviChercheurService.deleteByOffreCommercialIs(off);
    }
    @GetMapping("/montant-greater-than/{mont}")
    public List<SuiviVo> findByMontantGreaterThan(@PathVariable BigDecimal mont) {
        return suiviConverter.toVo(suiviChercheurService.findByMontantGreaterThan(mont));
    }
    @GetMapping("/pov/id/{id}")
    public List<SuiviVo> findByPovId(@PathVariable Long id) {
        return suiviConverter.toVo(suiviChercheurService.findByPovId(id));
    }
    @GetMapping("/pov/libelle/{libelle}")
    public List<SuiviVo> findByPovLibelle(@PathVariable String libelle) {
        return suiviConverter.toVo(suiviChercheurService.findByPovLibelle(libelle));
    }
    @DeleteMapping("/pov/id/{id}")
    public int deleteByPovId(@PathVariable Long id) {
        return suiviChercheurService.deleteByPovId(id);
    }
    @DeleteMapping("/pov/libelle/{libelle}")
    public int deleteByPovLibelle(@PathVariable String libelle) {
        return suiviChercheurService.deleteByPovLibelle(libelle);
    }
    @GetMapping("/type-prestation/id/{id}")
    public List<SuiviVo> findByTypePrestationId(@PathVariable Long id) {
        return suiviConverter.toVo(suiviChercheurService.findByTypePrestationId(id));
    }
    @GetMapping("/type-prestation/libelle/{libelle}")
    public List<SuiviVo> findByTypePrestationLibelle(@PathVariable String lib) {
        return suiviConverter.toVo(suiviChercheurService.findByTypePrestationLibelle(lib));
    }
    @DeleteMapping("/type-prestation/id/{id}")
    public int deleteByTypePrestationId(@PathVariable Long id) {
        return suiviChercheurService.deleteByTypePrestationId(id);
    }
    @DeleteMapping("/type-prestation/libelle/{libelle}")
    public int deleteByTypePrestationLibelle(@PathVariable String lib) {
        return suiviChercheurService.deleteByTypePrestationLibelle(lib);
    }
    @GetMapping("/")
    public List<SuiviVo> findAll() {
        return suiviConverter.toVo(suiviChercheurService.findAll());
    }
    @GetMapping("/id/{id}")
    public SuiviVo findById(@PathVariable Long id) {
        return suiviConverter.toVo(suiviChercheurService.findById(id));
    }
    @GetMapping("/detail/id/{id}")
    public SuiviVo findByIdWithAssociatedList(@PathVariable Long id) {
        return suiviConverter.toVo(suiviChercheurService.findByIdWithAssociatedList(id));
    }
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return suiviChercheurService.deleteById(id);
    }

    @PostMapping("/")
    public SuiviVo save(@RequestBody SuiviVo entity) {
        return suiviConverter.toVo(suiviChercheurService.save(suiviConverter.toItem(entity)));
    }
    @PostMapping("/save-list/")
    public List<SuiviVo> save(@RequestBody List<SuiviVo> list) {
        return suiviConverter.toVo(suiviChercheurService.save(suiviConverter.toItem(list)));
    }
    @PutMapping("/")
    public SuiviVo update(@RequestBody SuiviVo T) {
        return suiviConverter.toVo(suiviChercheurService.update(suiviConverter.toItem(T)));
    }
    @DeleteMapping("/")
    public int delete(@RequestBody SuiviVo T) {
        return suiviChercheurService.delete(suiviConverter.toItem(T));
    }
    @GetMapping("/search/")
    public List<SuiviVo> findByCriteria(@RequestBody SuiviVo vo) {
        return suiviConverter.toVo(suiviChercheurService.findByCriteria(vo));
    }
    @DeleteMapping("/delete-list/")
    public void delete(@RequestBody List<SuiviVo> list) {
        suiviChercheurService.delete(suiviConverter.toItem(list));
    }
    @PutMapping("/update-list/")
    public void update(@RequestBody List<SuiviVo> list) {
        suiviChercheurService.update(suiviConverter.toItem(list));
    }
}
