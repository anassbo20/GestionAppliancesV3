package com.example.gestion_appliances_v2.ws.rest.provided.facade.chercheur;


import com.example.gestion_appliances_v2.bean.Client;
import com.example.gestion_appliances_v2.service.chercheur.facade.ClientChercheurService;
import com.example.gestion_appliances_v2.ws.rest.provided.converter.ClientConverter;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.ClientVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/chercheur/client")
public class ClientRestChercheur {

    @Autowired
    private ClientChercheurService clientChercheurService;

    @Autowired
    private ClientConverter clientConverter;

    @GetMapping("/libelle/{libelle}")
    public ClientVo findByLibelle(@PathVariable String libelle) {
        return clientConverter.toVo(clientChercheurService.findByLibelle(libelle));
    }

    @GetMapping("/activite/{activite}")
    public List<ClientVo> findByActivite(@PathVariable String activite) {
        return clientConverter.toVo(clientChercheurService.findByActivite(activite));
    }
    @GetMapping("/secteur/{secteur}")
    public List<ClientVo> findBySecteur(@PathVariable Client.Secteur secteur) {
        return clientConverter.toVo(clientChercheurService.findBySecteur(secteur));
    }
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return clientChercheurService.deleteById(id);
    }
    @DeleteMapping("/libelle/{libelle}")
    public int deleteByLibelle(@PathVariable String libelle) {
        return clientChercheurService.deleteByLibelle(libelle);
    }
    @DeleteMapping("/secteur/{secteur}")
    public int deleteBySecteur(@PathVariable String secteur) {
        return clientChercheurService.deleteBySecteur(secteur);
    }
    @DeleteMapping("/activite/{activite}")
    public int deleteByActivite(@PathVariable String activite) {
        return clientChercheurService.deleteByActivite(activite);
    }

    @GetMapping("/")
    public List<ClientVo> findAll() {
        return clientConverter.toVo(clientChercheurService.findAll());
    }
    @GetMapping("/id/{id}")
    public ClientVo findById(@PathVariable Long id) {
        return clientConverter.toVo(clientChercheurService.findById(id));
    }
    @GetMapping("/detail/id/{id}")
    public ClientVo findByIdWithAssociatedList(@PathVariable Long id) {
        return clientConverter.toVo(clientChercheurService.findByIdWithAssociatedList(id));
    }
    @PostMapping("/")
    public ClientVo save(@RequestBody ClientVo entity) {
        return clientConverter.toVo(clientChercheurService.save(clientConverter.toItem(entity)));
    }
    @PostMapping("/save-list/")
    public List<ClientVo> save(@RequestBody List<ClientVo> list) {
        return clientConverter.toVo(clientChercheurService.save(clientConverter.toItem(list)));
    }
    @PutMapping("/")
    public ClientVo update(@RequestBody ClientVo T) {
        return clientConverter.toVo(clientChercheurService.update(clientConverter.toItem(T)));
    }
    @DeleteMapping("/")
    public int delete(@RequestBody ClientVo T) {
        return clientChercheurService.delete(clientConverter.toItem(T));
    }
    @GetMapping("/search/")
    public List<ClientVo> findByCriteria(@RequestBody ClientVo vo) {
        return clientConverter.toVo(clientChercheurService.findByCriteria(vo));
    }
    @DeleteMapping("/delete-list/")
    public void delete(@RequestBody List<ClientVo> list) {
        clientChercheurService.delete(clientConverter.toItem(list));
    }
    @PutMapping("/update-list/")
    public void update(@RequestBody List<ClientVo> list) {
        clientChercheurService.update(clientConverter.toItem(list));
    }
}
