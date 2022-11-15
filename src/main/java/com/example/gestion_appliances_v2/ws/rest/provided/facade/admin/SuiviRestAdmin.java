package com.example.gestion_appliances_v2.ws.rest.provided.facade.admin;


import com.example.gestion_appliances_v2.service.admin.facade.SuiviAdminService;
import com.example.gestion_appliances_v2.ws.rest.provided.converter.SuiviConverter;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.SuiviVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/admin/suivi")
public class SuiviRestAdmin {

    @Autowired
    private SuiviAdminService suiviAdminService;

    @Autowired
    private SuiviConverter suiviConverter;

    @GetMapping("/offre-commercial/{offre}")
    public List<SuiviVo> findByOffreCommercialIs(@PathVariable Boolean offre) {
        return suiviConverter.toVo(suiviAdminService.findByOffreCommercialIs(offre));
    }

    @DeleteMapping("/offre-commercial/{off}")
    public int deleteByOffreCommercialIs(@PathVariable Boolean off) {
        return suiviAdminService.deleteByOffreCommercialIs(off);
    }
    @GetMapping("/montant-greater-than/{mont}")
    public List<SuiviVo> findByMontantGreaterThan(@PathVariable BigDecimal mont) {
        return suiviConverter.toVo(suiviAdminService.findByMontantGreaterThan(mont));
    }
    @GetMapping("/pov/id/{id}")
    public List<SuiviVo> findByPovId(@PathVariable Long id) {
        return suiviConverter.toVo(suiviAdminService.findByPovId(id));
    }
    @GetMapping("/pov/libelle/{libelle}")
    public List<SuiviVo> findByPovLibelle(@PathVariable String libelle) {
        return suiviConverter.toVo(suiviAdminService.findByPovLibelle(libelle));
    }
    @DeleteMapping("/pov/id/{id}")
    public int deleteByPovId(@PathVariable Long id) {
        return suiviAdminService.deleteByPovId(id);
    }
    @DeleteMapping("/pov/libelle/{libelle}")
    public int deleteByPovLibelle(@PathVariable String libelle) {
        return suiviAdminService.deleteByPovLibelle(libelle);
    }
    @GetMapping("/type-prestation/id/{id}")
    public List<SuiviVo> findByTypePrestationId(@PathVariable Long id) {
        return suiviConverter.toVo(suiviAdminService.findByTypePrestationId(id));
    }
    @GetMapping("/type-prestation/libelle/{libelle}")
    public List<SuiviVo> findByTypePrestationLibelle(@PathVariable String lib) {
        return suiviConverter.toVo(suiviAdminService.findByTypePrestationLibelle(lib));
    }
    @DeleteMapping("/type-prestation/id/{id}")
    public int deleteByTypePrestationId(@PathVariable Long id) {
        return suiviAdminService.deleteByTypePrestationId(id);
    }
    @DeleteMapping("/type-prestation/libelle/{libelle}")
    public int deleteByTypePrestationLibelle(@PathVariable String lib) {
        return suiviAdminService.deleteByTypePrestationLibelle(lib);
    }
    @GetMapping("/")
    public List<SuiviVo> findAll() {
        return suiviConverter.toVo(suiviAdminService.findAll());
    }
    @GetMapping("/id/{id}")
    public SuiviVo findById(@PathVariable Long id) {
        return suiviConverter.toVo(suiviAdminService.findById(id));
    }
    @GetMapping("/detail/id/{id}")
    public SuiviVo findByIdWithAssociatedList(@PathVariable Long id) {
        return suiviConverter.toVo(suiviAdminService.findByIdWithAssociatedList(id));
    }
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return suiviAdminService.deleteById(id);
    }

    @PostMapping("/")
    public SuiviVo save(@RequestBody SuiviVo entity) {
        return suiviConverter.toVo(suiviAdminService.save(suiviConverter.toItem(entity)));
    }
    @PostMapping("/save-list")
    public List<SuiviVo> save(@RequestBody List<SuiviVo> list) {
        return suiviConverter.toVo(suiviAdminService.save(suiviConverter.toItem(list)));
    }
    @PutMapping("/")
    public SuiviVo update(@RequestBody SuiviVo T) {
        return suiviConverter.toVo(suiviAdminService.update(suiviConverter.toItem(T)));
    }
    @DeleteMapping("/")
    public int delete(@RequestBody SuiviVo T) {
        return suiviAdminService.delete(suiviConverter.toItem(T));
    }
    @PostMapping("/search")
    public List<SuiviVo> findByCriteria(@RequestBody SuiviVo vo) {
        return suiviConverter.toVo(suiviAdminService.findByCriteria(vo));
    }
    @DeleteMapping("/delete-list")
    public void delete(@RequestBody List<SuiviVo> list) {
        suiviAdminService.delete(suiviConverter.toItem(list));
    }
    @PutMapping("/update-list")
    public void update(@RequestBody List<SuiviVo> list) {
        suiviAdminService.update(suiviConverter.toItem(list));
    }
}
