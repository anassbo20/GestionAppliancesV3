package com.example.gestion_appliances_v2.ws.rest.provided.facade.chercheur;
import com.example.gestion_appliances_v2.service.chercheur.facade.ApplianceChercheurService;
import com.example.gestion_appliances_v2.ws.rest.provided.converter.ApplianceConverter;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.ApplianceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/chercheur/appliance")
public class ApplianceRestChercheur {

    @Autowired
    private ApplianceChercheurService applianceChercheurService;

    @Autowired
    private ApplianceConverter applianceConverter;

    @GetMapping("/dbid/{dbid}")
    public ApplianceVo findByDibd(@PathVariable String dbid) {
        return applianceConverter.toVo(applianceChercheurService.findByDibd(dbid));
    }
    @GetMapping("/reference/{ref}")
    public ApplianceVo findByReference(@PathVariable String ref) {
       return applianceConverter.toVo(applianceChercheurService.findByReference(ref));
    }


    @GetMapping("/libelle/{libelle}")
    public List<ApplianceVo> findByTypeApplianceLibelle(@PathVariable String libelle) {
        return applianceConverter.toVo(applianceChercheurService.findByTypeApplianceLibelle(libelle));
    }
    @GetMapping("/disponibilite/{disp}")
    public List<ApplianceVo> findByDisponibilite(@PathVariable boolean disp) {
        return applianceConverter.toVo(applianceChercheurService.findByDisponibilite(disp));
    }
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return applianceChercheurService.deleteById(id);
    }
    @DeleteMapping("/dbid/{dbid}")
    public int deleteByDibd(@PathVariable String dbid) {
        return applianceChercheurService.deleteByDibd(dbid);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return applianceChercheurService.deleteByReference(reference);
    }
    @DeleteMapping("/type-appliance/libelle/{libelle}")
    public int deleteByTypeApplianceLibelle(@PathVariable String libelle) {
        return applianceChercheurService.deleteByTypeApplianceLibelle(libelle);
    }
    @DeleteMapping("/type-appliance/id/{id}")
    public int deleteByTypeApplianceId(@PathVariable Long id) {
        return applianceChercheurService.deleteByTypeApplianceId(id);
    }

    @GetMapping("/")
    public List<ApplianceVo> findAll() {
        return applianceConverter.toVo(applianceChercheurService.findAll());
    }
    @GetMapping("/id/{id}")
    public ApplianceVo findById(@PathVariable Long id) {
        return applianceConverter.toVo(applianceChercheurService.findById(id));
    }
    @GetMapping("/detail/id/{id}")
    public ApplianceVo findByIdWithAssociatedList(@PathVariable Long id) {
        return applianceConverter.toVo(applianceChercheurService.findByIdWithAssociatedList(id));
    }

    @PostMapping("/")
    public ApplianceVo save(@RequestBody ApplianceVo entity) {
        return applianceConverter.toVo(applianceChercheurService.save(applianceConverter.toItem(entity)));
    }

    @PutMapping("/")
    public ApplianceVo update(@RequestBody ApplianceVo T) {
        return applianceConverter.toVo(applianceChercheurService.update(applianceConverter.toItem(T)));
    }
    @DeleteMapping("/")
    public int delete(@RequestBody ApplianceVo T) {
        return applianceChercheurService.delete(applianceConverter.toItem(T));
    }
    @GetMapping("/search/")
    public List<ApplianceVo> findByCriteria(@PathVariable ApplianceVo vo) {
        return applianceConverter.toVo(applianceChercheurService.findByCriteria(vo));
    }

}
