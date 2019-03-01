package com.dlmu.bbs.service;

import com.dlmu.bbs.domain.Section;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SectionService {
    List<Section> getAllSection();
    Section findById (String id);
    void updataSection(Section section);
    void addSection(Section section);
    void removeById(String id);

}
