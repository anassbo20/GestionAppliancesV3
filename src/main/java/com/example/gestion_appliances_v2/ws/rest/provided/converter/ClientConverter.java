package com.example.gestion_appliances_v2.ws.rest.provided.converter;


import com.example.gestion_appliances_v2.bean.Client;
import com.example.gestion_appliances_v2.service.util.DateUtil;
import com.example.gestion_appliances_v2.service.util.NumberUtil;
import com.example.gestion_appliances_v2.service.util.StringUtil;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.ClientVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter extends AbstractConverter<Client, ClientVo> {

    @Autowired
    private ContactConverter contactConverter;

    private Boolean contacts;

    public ClientConverter() {
        init(true);
    }

    @Override
    public Client toItem(ClientVo vo) {
        if (vo == null) {
            return null;
        } else {
            Client item = new Client();
                if(StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
                if(StringUtil.isNotEmpty(vo.getLibelle()))
                item.setLibelle(vo.getLibelle());
                if(StringUtil.isNotEmpty(vo.getSecteur()))
                item.setSecteur(vo.getSecteur());
                if(StringUtil.isNotEmpty(vo.getActivite()))
                item.setActivite(vo.getActivite());
                if(vo.getArchive() != null)
                item.setArchive(vo.getArchive());
                if(StringUtil.isNotEmpty(vo.getDateArchivage()))
                item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));

                return item;
        }
    }

    @Override
    public ClientVo toVo(Client item) {
        if (item == null) {
            return null;
        } else {
            ClientVo vo = new ClientVo();
                if(item.getId()!=null)
                vo.setId(NumberUtil.toString(item.getId()));
                if(StringUtil.isNotEmpty(item.getLibelle()))
                vo.setLibelle(item.getLibelle());
                if(StringUtil.isNotEmpty(item.getSecteur()))
                vo.setSecteur(item.getSecteur());
                if(StringUtil.isNotEmpty(item.getActivite()))
                vo.setActivite(item.getActivite());
                if(item.getArchive()!=null)
                vo.setArchive(item.getArchive());
                if(item.getDateArchivage()!=null)
                vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));

            return vo;
        }

    }

    public void init(Boolean value) {
          contacts = value;
    }

    public ContactConverter getContactConverter() {
        return contactConverter;
    }

    public void setContactConverter(ContactConverter contactConverter) {
        this.contactConverter = contactConverter;
    }

    public Boolean getContacts() {
        return contacts;
    }

    public void setContacts(Boolean contacts) {
        this.contacts = contacts;
    }
}
