package com.example.gestion_appliances_v2.ws.rest.provided.facade.chercheur;



import com.example.gestion_appliances_v2.service.chercheur.facade.SceanceChercheurService;
import com.example.gestion_appliances_v2.ws.rest.provided.converter.SceanceConverter;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.SceanceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/chercheur/sceance")
public class SceanceRestChercheur {

    @Autowired
    private SceanceChercheurService sceanceChercheurService;

    @Autowired
    private SceanceConverter sceanceConverter;

    @GetMapping("/date-sceance/{dateSc}")
    public List<SceanceVo> findByDateSceance(@PathVariable Date dateSc) {
        return sceanceConverter.toVo(sceanceChercheurService.findByDateSceance(dateSc));
    }
    @DeleteMapping("/date-sceance/{dateSc}")
    public int deleteByDateSceance(@PathVariable Date dateSc) {
        return sceanceChercheurService.deleteByDateSceance(dateSc);
    }
    @GetMapping("/libelle/{lib}")
    public List<SceanceVo> findByPovLibelle(@PathVariable String lib) {
        return sceanceConverter.toVo(sceanceChercheurService.findByPovLibelle(lib));
    }
    @DeleteMapping("/libelle/{lib}")
    public int deleteByPovLibelle(@PathVariable String lib) {
        return sceanceChercheurService.deleteByPovLibelle(lib);
    }

    @GetMapping("/")
    public List<SceanceVo> findAll() {
        return sceanceConverter.toVo(sceanceChercheurService.findAll());
    }
    @GetMapping("/id/{id}")
    public SceanceVo findById(@PathVariable Long id) {
        return sceanceConverter.toVo(sceanceChercheurService.findById(id));
    }
    @GetMapping("/detail/id/{id}")
    public SceanceVo findByIdWithAssociatedList(@PathVariable Long id) {
        return sceanceConverter.toVo(sceanceChercheurService.findByIdWithAssociatedList(id));
    }
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return sceanceChercheurService.deleteById(id);
    }

    @PostMapping("/")
    public SceanceVo save(@RequestBody SceanceVo entity) {
        return sceanceConverter.toVo(sceanceChercheurService.save(sceanceConverter.toItem(entity)));
    }
    @PostMapping("/save-list/")
    public List<SceanceVo> save(@RequestBody List<SceanceVo> list) {
        return sceanceConverter.toVo(sceanceChercheurService.save(sceanceConverter.toItem(list)));
    }
    @PutMapping("/")
    public SceanceVo update(@RequestBody SceanceVo T) {
        return sceanceConverter.toVo(sceanceChercheurService.update(sceanceConverter.toItem(T)));
    }
    @DeleteMapping("/")
    public int delete(@RequestBody SceanceVo T) {
        return sceanceChercheurService.delete(sceanceConverter.toItem(T));
    }
    @GetMapping("/search/")
    public List<SceanceVo> findByCriteria(@RequestBody SceanceVo vo) {
        return sceanceConverter.toVo(sceanceChercheurService.findByCriteria(vo));
    }
    @DeleteMapping("/delete-list/")
    public void delete(@RequestBody List<SceanceVo> list) {
        sceanceChercheurService.delete(sceanceConverter.toItem(list));
    }
    @PutMapping("/update-list/")
    public void update(@RequestBody List<SceanceVo> list) {
        sceanceChercheurService.update(sceanceConverter.toItem(list));
    }
}
