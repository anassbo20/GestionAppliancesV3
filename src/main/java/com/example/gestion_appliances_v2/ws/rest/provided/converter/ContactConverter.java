package com.example.gestion_appliances_v2.ws.rest.provided.converter;


import com.example.gestion_appliances_v2.bean.Contact;
import com.example.gestion_appliances_v2.service.util.DateUtil;
import com.example.gestion_appliances_v2.service.util.NumberUtil;
import com.example.gestion_appliances_v2.service.util.StringUtil;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.ContactVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactConverter extends AbstractConverter<Contact, ContactVo> {

    @Autowired
    private ClientConverter clientConverter;

    private Boolean client;
    public ContactConverter() {
        init(true);
    }

    @Override
    public Contact toItem(ContactVo vo) {
        if (vo == null) {
            return null;
        } else {
            Contact item = new Contact();
                if(StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
                if(StringUtil.isNotEmpty(vo.getNom()))
                item.setNom(vo.getNom());
                if(StringUtil.isNotEmpty(vo.getPrenom()))
                item.setPrenom(vo.getPrenom());
                if(StringUtil.isNotEmpty(vo.getTelephone()))
                item.setTelephone(vo.getTelephone());
                if(StringUtil.isNotEmpty(vo.getFonction()))
                item.setFonction(vo.getFonction());
                if(StringUtil.isNotEmpty(vo.getEmail()))
                item.setEmail(vo.getEmail());
                if(vo.getClientVo()!=null && this.client)
                item.setClient(clientConverter.toItem(vo.getClientVo()));
                if(vo.getArchive() != null)
                item.setArchive(vo.getArchive());
                if(StringUtil.isNotEmpty(vo.getDateArchivage()))
                item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));
                return item;
        }
    }

    @Override
    public ContactVo toVo(Contact item) {
        if (item == null) {
            return null;
        } else {
            ContactVo vo = new ContactVo();
                if(item.getId()!=null)
                vo.setId(NumberUtil.toString(item.getId()));

                if(StringUtil.isNotEmpty(item.getNom()))
                vo.setNom(item.getNom());

                if(StringUtil.isNotEmpty(item.getPrenom()))
                vo.setPrenom(item.getPrenom());

                if(StringUtil.isNotEmpty(item.getTelephone()))
                vo.setTelephone(item.getTelephone());

                if(StringUtil.isNotEmpty(item.getFonction()))
                vo.setFonction(item.getFonction());

                if(StringUtil.isNotEmpty(item.getEmail()))
                vo.setEmail(item.getEmail());

                if(item.getClient()!=null && this.client) {
                vo.setClientVo(clientConverter.toVo(item.getClient()));
                }

                if(item.getArchive()!=null)
                vo.setArchive(item.getArchive());
                if(item.getDateArchivage()!=null)
                vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));

                return vo;
        }
    }


    public void init(Boolean value) {
        client = value;
    }

    public ClientConverter getClientConverter() {
        return clientConverter;
    }

    public void setClientConverter(ClientConverter clientConverter) {
        this.clientConverter = clientConverter;
    }

    public Boolean getClient() {
        return client;
    }

    public void setClient(Boolean client) {
        this.client = client;
    }
}
