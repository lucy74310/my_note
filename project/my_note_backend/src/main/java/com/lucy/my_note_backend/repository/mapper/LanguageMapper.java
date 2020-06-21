package com.lucy.my_note_backend.repository.mapper;


import com.lucy.my_note_backend.repository.entity.Language;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LanguageMapper {

    public List<Language> findAll();
}
0