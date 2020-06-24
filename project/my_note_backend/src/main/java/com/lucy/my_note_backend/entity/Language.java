package com.lucy.my_note_backend.entity;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("language")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Language {

    @NonNull
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
