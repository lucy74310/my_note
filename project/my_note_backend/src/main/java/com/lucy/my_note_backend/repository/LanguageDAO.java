package com.lucy.my_note_backend.repository;

import com.lucy.my_note_backend.entity.Language;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LanguageDAO {

    @Autowired
    private SqlSession sqlSession;

    public List<Language> selectLanguagesAll() {
        return sqlSession.selectList("findAllLanguages");
    }

    public Language selectLanguage(String languageName) {
        return sqlSession.selectOne("findLanguageByName", languageName);
    }

    public int addLanguage(Language language) {
        return sqlSession.insert("addLanguage", language);
    }

    public int updateLanguage(Language language) {
        return sqlSession.update("updateLanguage", language);
    }

    public int deleteLanguage(Language language) {
        return sqlSession.delete("deleteLanguage", language);
    }
}
