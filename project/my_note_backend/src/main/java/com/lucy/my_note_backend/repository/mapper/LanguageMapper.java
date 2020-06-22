package com.lucy.my_note_backend.repository.mapper;


import com.lucy.my_note_backend.repository.entity.Language;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LanguageMapper {

    @Select("SELECT * FROM t_language;")
    List<Language> findAllLanguages();

    @Select("SELECT * FROM t_language WHERE language_name = #{languageName}")
    Language findLanguageByName(String languageName);

    @Insert("INSERT INTO t_language (language_name, is_custom, member_id) " +
            "VALUES ( #{language_name}, #{is_custom}, #{member_id} ) ;")
    int addLanguage(Language language);

    @SelectKey(statement = "SELECT identity('t_language')", keyProperty = "language_no", before = false, resultType = long.class)
    @Update("UPDATE t_language SET language_name = #{language_name}, updated_date = now() " +
            "WHERE language_no = #{language_no} and is_custom = 'T' AND member_id = #{member_id}; ")
    long updateLanguage(Language language);


}
