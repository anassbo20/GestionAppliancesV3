package com.example.gestion_appliances_v2.ws.rest.provided.facade.manager;


import com.example.gestion_appliances_v2.bean.Client;
import com.example.gestion_appliances_v2.service.admin.facade.ClientAdminService;
import com.example.gestion_appliances_v2.ws.rest.provided.converter.ClientConverter;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.ClientVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/manager/client")
public class ClientRestManager {

    @Autowired
    private ClientAdminService clientAdminService;

    @Autowired
    private ClientConverter clientConverter;

    @GetMapping("/libelle/{libelle}")
    public ClientVo findByLibelle(@PathVariable String libelle) {
        return clientConverter.toVo(clientAdminService.findByLibelle(libelle));
    }

    @GetMapping("/activite/{activite}")
    public List<ClientVo> findByActivite(@PathVariable String activite) {
        return clientConverter.toVo(clientAdminService.findByActivite(activite));
    }
    @GetMapping("/secteur/{secteur}")
    public List<ClientVo> findBySecteur(@PathVariable Client.Secteur secteur) {
        return clientConverter.toVo(clientAdminService.findBySecteur(secteur));
    }
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return clientAdminService.deleteById(id);
    }
    @DeleteMapping("/libelle/{libelle}")
    public int deleteByLibelle(@PathVariable String libelle) {
        return clientAdminService.deleteByLibelle(libelle);
    }
    @DeleteMapping("/secteur/{secteur}")
    public int deleteBySecteur(@PathVariable String secteur) {
        return clientAdminService.deleteBySecteur(secteur);
    }
    @DeleteMapping("/activite/{activite}")
    public int deleteByActivite(@PathVariable String activite) {
        return clientAdminService.deleteByActivite(activite);
    }
    @PutMapping("/archiver")
    public ClientVo archiver(@RequestBody ClientVo client) {
        return clientConverter.toVo(clientAdminService.archiver(clientConverter.toItem(client)));
    }
    @PutMapping("/desarchiver")
    public ClientVo desarchiver(@RequestBody ClientVo client) {
        return clientConverter.toVo(clientAdminService.desarchiver(clientConverter.toItem(client)));
    }
    @GetMapping("/")
    public List<ClientVo> findAll() {
        return clientConverter.toVo(clientAdminService.findAll());
    }
    @GetMapping("/id/{id}")
    public ClientVo findById(@PathVariable Long id) {
        return clientConverter.toVo(clientAdminService.findById(id));
    }
    @GetMapping("/detail/id/{id}")
    public ClientVo findByIdWithAssociatedList(@PathVariable Long id) {
        return clientConverter.toVo(clientAdminService.findByIdWithAssociatedList(id));
    }
    @PostMapping("/")
    public ClientVo save(@RequestBody ClientVo entity) {
        return clientConverter.toVo(clientAdminService.save(clientConverter.toItem(entity)));
    }
    @PostMapping("/save-list")
    public List<ClientVo> save(@RequestBody List<ClientVo> list) {
        return clientConverter.toVo(clientAdminService.save(clientConverter.toItem(list)));
    }
    @PutMapping("/")
    public ClientVo update(@RequestBody ClientVo T) {
        return clientConverter.toVo(clientAdminService.update(clientConverter.toItem(T)));
    }
    @DeleteMapping("/")
    public int delete(@RequestBody ClientVo T) {
        return clientAdminService.delete(clientConverter.toItem(T));
    }
    @PostMapping("/search")
    public List<ClientVo> findByCriteria(@RequestBody ClientVo vo) {
        return clientConverter.toVo(clientAdminService.findByCriteria(vo));
    }
    @DeleteMapping("/delete-list")
    public void delete(@RequestBody List<ClientVo> list) {
        clientAdminService.delete(clientConverter.toItem(list));
    }
    @PutMapping("/update-list")
    public void update(@RequestBody List<ClientVo> list) {
        clientAdminService.update(clientConverter.toItem(list));
    }
}
