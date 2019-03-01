package com.dlmu.bbs.web;

import com.dlmu.bbs.domain.Section;
import com.dlmu.bbs.service.SectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/section")
public class SectionController {
    @Autowired
   private SectionServiceImpl sectionService;
    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public List<Section> getSectionList(){
        List <Section> sections=sectionService.getAllSection();
        return sections;
    }
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String PostSection(@ModelAttribute Section section){
        sectionService.addSection(section);
        return "Sucess!";
    }
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Section getSection(@ModelAttribute String id){
        return sectionService.findById(id);
    }
    @RequestMapping(value="/{id}", method= RequestMethod.PUT)
    public  String putSection(@ModelAttribute String id,@ModelAttribute Section section){
        Section section1=sectionService.findById(id);
        section1.setName(section.getName());
        section1.setImageUrl(section.getImageUrl());
        sectionService.updataSection(section1);
        return "Success!";
    }
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable String id){
            sectionService.removeById(id);
            return "Success!";
    }
}
