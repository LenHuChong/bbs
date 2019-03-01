package com.dlmu.bbs.service;

import com.dlmu.bbs.domain.Section;
import com.dlmu.bbs.domain.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SectionServiceImpl implements SectionService {
    @Autowired
    SectionRepository sectionService;
    @Override
    public List<Section> getAllSection() {
        return sectionService.findAll();
    }

    @Override
    public Section findById(String id) {
        return sectionService.findById(id).get();
    }

    @Override
    public void updataSection(Section section) {
        sectionService.save(section);
    }

    @Override
    public void addSection(Section section) {
        sectionService.save(section);
    }

    @Override
    public void removeById(String id) {
        sectionService.deleteById(id);
    }
}
