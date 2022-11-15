package com.example.gestion_appliances_v2.ws.rest.provided.facade.manager;


import com.example.gestion_appliances_v2.bean.Tag;
import com.example.gestion_appliances_v2.service.admin.facade.TagAdminService;
import com.example.gestion_appliances_v2.ws.rest.provided.converter.TagConverter;
import com.example.gestion_appliances_v2.ws.rest.provided.vo.TagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/manager/tag")
public class TagRestManager {

@Autowired
private TagAdminService tagService;

@Autowired
private TagConverter tagConverter;


            @PutMapping("/")
            public TagVo update(@RequestBody  TagVo  tagVo){
            Tag tag = tagConverter.toItem(tagVo);
            tag = tagService.update(tag);
            return tagConverter.toVo(tag);
            }

    @GetMapping("/")
    public List<TagVo> findAll(){
        return tagConverter.toVo(tagService.findAll());
    }

    @GetMapping("/detail/id/{id}")
    public TagVo findByIdWithAssociatedList(@PathVariable Long id){
    return tagConverter.toVo(tagService.findByIdWithAssociatedList(id));
    }

    @PostMapping("/search")
    public List<TagVo> findByCriteria(@RequestBody TagVo tagVo){
        return tagConverter.toVo(tagService.findByCriteria(tagVo));
        }

            @GetMapping("/id/{id}")
            public TagVo findById(@PathVariable Long id){
            return tagConverter.toVo(tagService.findById(id));
            }

            @PostMapping("/")
            public TagVo save(@RequestBody TagVo tagVo){
            Tag tag = tagConverter.toItem(tagVo);
            tag = tagService.save(tag);
            return tagConverter.toVo(tag);
            }

            @DeleteMapping("/")
            public int delete(@RequestBody TagVo tagVo){
            Tag tag = tagConverter.toItem(tagVo);
            return tagService.delete(tag);
            }

            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return tagService.deleteById(id);
            }


            @PutMapping("/archiver")
            public TagVo archiver(@RequestBody TagVo tagVo){
                Tag tag = tagService.archiver(tagConverter.toItem(tagVo));
                return tagConverter.toVo(tag);
                }

            @PutMapping("/desarchiver")
            public TagVo desarchiver(@RequestBody TagVo tagVo){
                Tag tag = tagService.desarchiver(tagConverter.toItem(tagVo));
                return tagConverter.toVo(tag);}
            }
