package com.lucy.my_note_backend.repository.mapper;

import com.lucy.my_note_backend.repository.entity.Language;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NoteMapper {

    @Select("SELECT * FROM t_note WHERE member_id = {#memberId}")
    List<Language> findNoteByMemberId(String memberId);

}
