package com.example.gestion_appliances_v2.ws.rest.provided.facade.chercheur;


import com.example.gestion_appliances_v2.service.chercheur.facade.ContactChercheurService;
import com.example.gestion_appliances_v2.ws.rest.provided.converter.ContactConverter;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.ContactVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/chercheur/contact")
public class ContactRestChercheur {

    @Autowired
    private ContactChercheurService contactChercheurService;

    @Autowired
    private ContactConverter contactConverter;

    @GetMapping("/telephon/{telephon}")
    public ContactVo findByTelephon(@PathVariable String telephon) {
        return contactConverter.toVo(contactChercheurService.findByTelephon(telephon));
    }
    @DeleteMapping("/telephon/{telephon}")
    public int deleteByTelephone(@PathVariable String telephon) {
        return contactChercheurService.deleteByTelephone(telephon);
    }

    @GetMapping("/email/{email}")
    public ContactVo findByEmail(@PathVariable String email) {
        return contactConverter.toVo(contactChercheurService.findByEmail(email));
    }
    @DeleteMapping("/email/{email}")
    public int deleteByEmail(@PathVariable String email) {
        return contactChercheurService.deleteByEmail(email);
    }
    @GetMapping("/fonction/{fonction}")
    public List<ContactVo> findByFonction(@PathVariable String fonction) {
        return contactConverter.toVo(contactChercheurService.findByFonction(fonction));
    }
    @DeleteMapping("/fonction/{fonction}")
    public int deleteByFonction(@PathVariable String fonction) {
        return contactChercheurService.deleteByFonction(fonction);
    }
    @GetMapping("/client/libelle/{libelle}")
    public List<ContactVo> findByClientLibelle(@PathVariable String libelle) {
        return contactConverter.toVo(contactChercheurService.findByClientLibelle(libelle));
    }
    @DeleteMapping("/client/libelle/{libelle}")
    public int deleteByClientLibelle(@PathVariable String libelle) {
        return contactChercheurService.deleteByClientLibelle(libelle);
    }

    @GetMapping("/")
    public List<ContactVo> findAll() {
        return contactConverter.toVo(contactChercheurService.findAll());
    }
    @GetMapping("/id/{id}")
    public ContactVo findById(@PathVariable Long id) {
        return contactConverter.toVo(contactChercheurService.findById(id));
    }
    @GetMapping("/detail/id/{id}")
    public ContactVo findByIdWithAssociatedList(@PathVariable Long id) {
        return contactConverter.toVo(contactChercheurService.findByIdWithAssociatedList(id));
    }
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return contactChercheurService.deleteById(id);
    }

    @PostMapping("/")
    public ContactVo save(@RequestBody ContactVo entity) {
        return contactConverter.toVo(contactChercheurService.save(contactConverter.toItem(entity)));
    }
    @PostMapping("/save-list/")
    public List<ContactVo> save(@RequestBody List<ContactVo> list) {
        return contactConverter.toVo(contactChercheurService.save(contactConverter.toItem(list)));
    }
    @PutMapping("/")
    public ContactVo update(@RequestBody ContactVo T) {
        return contactConverter.toVo(contactChercheurService.update(contactConverter.toItem(T)));
    }
    @DeleteMapping("/")
    public int delete(@RequestBody ContactVo T) {
        return contactChercheurService.delete(contactConverter.toItem(T));
    }
    @GetMapping("/search/")
    public List<ContactVo> findByCriteria(@RequestBody ContactVo vo) {
        return contactConverter.toVo(contactChercheurService.findByCriteria(vo));
    }
    @DeleteMapping("/delete-list/")
    public void delete(@RequestBody List<ContactVo> list) {
        contactChercheurService.delete(contactConverter.toItem(list));
    }
    @PutMapping("/update-list/")
    public void update(@RequestBody List<ContactVo> list) {
        contactChercheurService.update(contactConverter.toItem(list));
    }
}
