package com.example.gestion_appliances_v2.ws.rest.provided.facade.admin;


import com.example.gestion_appliances_v2.service.admin.facade.ContactAdminService;
import com.example.gestion_appliances_v2.ws.rest.provided.converter.ContactConverter;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.ContactVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/contact")
public class ContactRestAdmin {

    @Autowired
    private ContactAdminService contactAdminService;

    @Autowired
    private ContactConverter contactConverter;

    @GetMapping("/telephon/{telephon}")
    public ContactVo findByTelephon(@PathVariable String telephon) {
        return contactConverter.toVo(contactAdminService.findByTelephon(telephon));
    }
    @DeleteMapping("/telephon/{telephon}")
    public int deleteByTelephone(@PathVariable String telephon) {
        return contactAdminService.deleteByTelephone(telephon);
    }

    @GetMapping("/email/{email}")
    public ContactVo findByEmail(@PathVariable String email) {
        return contactConverter.toVo(contactAdminService.findByEmail(email));
    }
    @DeleteMapping("/email/{email}")
    public int deleteByEmail(@PathVariable String email) {
        return contactAdminService.deleteByEmail(email);
    }
    @GetMapping("/fonction/{fonction}")
    public List<ContactVo> findByFonction(@PathVariable String fonction) {
        return contactConverter.toVo(contactAdminService.findByFonction(fonction));
    }
    @DeleteMapping("/fonction/{fonction}")
    public int deleteByFonction(@PathVariable String fonction) {
        return contactAdminService.deleteByFonction(fonction);
    }
    @GetMapping("/client/libelle/{libelle}")
    public List<ContactVo> findByClientLibelle(@PathVariable String libelle) {
        return contactConverter.toVo(contactAdminService.findByClientLibelle(libelle));
    }
    @DeleteMapping("/client/libelle/{libelle}")
    public int deleteByClientLibelle(@PathVariable String libelle) {
        return contactAdminService.deleteByClientLibelle(libelle);
    }
    @PutMapping("/archiver")
    public ContactVo archiver(@RequestBody ContactVo contact) {
        return contactConverter.toVo(contactAdminService.archiver(contactConverter.toItem(contact)));
    }
    @PutMapping("/desarchiver")
    public ContactVo desarchiver(@RequestBody ContactVo contact) {
        return contactConverter.toVo(contactAdminService.desarchiver(contactConverter.toItem(contact)));
    }
    @GetMapping("/")
    public List<ContactVo> findAll() {
        return contactConverter.toVo(contactAdminService.findAll());
    }
    @GetMapping("/id/{id}")
    public ContactVo findById(@PathVariable Long id) {
        return contactConverter.toVo(contactAdminService.findById(id));
    }
    @GetMapping("/detail/id/{id}")
    public ContactVo findByIdWithAssociatedList(@PathVariable Long id) {
        return contactConverter.toVo(contactAdminService.findByIdWithAssociatedList(id));
    }
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return contactAdminService.deleteById(id);
    }

    @PostMapping("/")
    public ContactVo save(@RequestBody ContactVo entity) {
        return contactConverter.toVo(contactAdminService.save(contactConverter.toItem(entity)));
    }
    @PostMapping("/save-list")
    public List<ContactVo> save(@RequestBody List<ContactVo> list) {
        return contactConverter.toVo(contactAdminService.save(contactConverter.toItem(list)));
    }
    @PutMapping("/")
    public ContactVo update(@RequestBody ContactVo T) {
        return contactConverter.toVo(contactAdminService.update(contactConverter.toItem(T)));
    }


    @DeleteMapping("/")
    public int delete(@RequestBody ContactVo T) {
        return contactAdminService.delete(contactConverter.toItem(T));
    }
    @PostMapping("/search")
    public List<ContactVo> findByCriteria(@RequestBody ContactVo vo) {
        return contactConverter.toVo(contactAdminService.findByCriteria(vo));
    }
    @DeleteMapping("/delete-list")
    public void delete(@RequestBody List<ContactVo> list) {
        contactAdminService.delete(contactConverter.toItem(list));
    }
    @PutMapping("/update-list")
    public void update(@RequestBody List<ContactVo> list) {
        contactAdminService.update(contactConverter.toItem(list));
    }
}
