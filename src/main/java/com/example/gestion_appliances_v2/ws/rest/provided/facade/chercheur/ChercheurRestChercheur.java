package com.example.gestion_appliances_v2.ws.rest.provided.facade.chercheur;


import com.example.gestion_appliances_v2.bean.Chercheur;
import com.example.gestion_appliances_v2.service.chercheur.facade.ChercheurChercheurService;
import com.example.gestion_appliances_v2.ws.rest.provided.converter.ChercheurConverter;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.ChercheurVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/chercheur/chercheur")
public class ChercheurRestChercheur {

@Autowired
private ChercheurChercheurService chercheurService;

@Autowired
private ChercheurConverter chercheurConverter;



            @PutMapping("/")
            public ChercheurVo update(@RequestBody  ChercheurVo  chercheurVo){
            Chercheur chercheur = chercheurConverter.toItem(chercheurVo);
            chercheur = chercheurService.update(chercheur);
            return chercheurConverter.toVo(chercheur);
            }


    @GetMapping("/")
    public List<ChercheurVo> findAll(){
        return chercheurConverter.toVo(chercheurService.findAll());
    }


    @GetMapping("/detail/id/{id}")
    public ChercheurVo findByIdWithAssociatedList(@PathVariable Long id){
    return chercheurConverter.toVo(chercheurService.findByIdWithAssociatedList(id));
    }

    @PostMapping("/search")
    public List<ChercheurVo> findByCriteria(@RequestBody ChercheurVo chercheurVo){
        return chercheurConverter.toVo(chercheurService.findByCriteria(chercheurVo));
        }

            @GetMapping("/id/{id}")
            public ChercheurVo findById(@PathVariable Long id){
            return chercheurConverter.toVo(chercheurService.findById(id));
            }

            @PostMapping("/")
            public ChercheurVo save(@RequestBody ChercheurVo chercheurVo){
            Chercheur chercheur = chercheurConverter.toItem(chercheurVo);
            chercheur = chercheurService.save(chercheur);
            return chercheurConverter.toVo(chercheur);
            }

            @DeleteMapping("/")
            public int delete(@RequestBody ChercheurVo chercheurVo){
            Chercheur chercheur = chercheurConverter.toItem(chercheurVo);
            return chercheurService.delete(chercheur);
            }

            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return chercheurService.deleteById(id);
            }


            }
