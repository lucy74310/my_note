package com.lucy.my_note_backend.repository.entity;

import java.sql.Timestamp;

public class Language {

    private Long language_no;

    private String language_name;

    private Character is_custom;

    private String member_id;

    private Timestamp registered_date;

    public Long getLanguage_no() {
        return language_no;
    }

    public String getLanguage_name() {
        return language_name;
    }

    public Character getIs_custom() {
        return is_custom;
    }

    public String getMember_id() {
        return member_id;
    }

    public Timestamp getRegistered_date() {
        return registered_date;
    }

    public void setLanguage_no(Long language_no) {
        this.language_no = language_no;
    }

    public void setLanguage_name(String language_name) {
        this.language_name = language_name;
    }

    public void setIs_custom(Character is_custom) {
        this.is_custom = is_custom;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public void setRegistered_date(Timestamp registered_date) {
        this.registered_date = registered_date;
    }

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
