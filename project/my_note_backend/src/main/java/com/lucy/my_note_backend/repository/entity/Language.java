package com.lucy.my_note_backend.repository.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("language")
public class Language {

    private Long language_no;

    private String language_name;

    private Character is_custom;

    private String member_id;

    private Timestamp registered_date;

    @Override
    public String toString() {
        return "Language{" +
                "language_no=" + language_no +
                ", language_name='" + language_name + '\'' +
                ", is_custom=" + is_custom +
                ", member_id='" + member_id + '\'' +
                ", registered_date=" + registered_date +
                '}';
    }
}
