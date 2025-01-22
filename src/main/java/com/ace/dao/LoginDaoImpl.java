package com.ace.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ace.domain.Login;

@Repository
public class LoginDaoImpl implements LoginDao {

    @Autowired
    private SqlSession sqlSession;

  

    @Override
    public Login loginCheck(Login login) {
        return sqlSession.selectOne("login.loginCheck", login);
    }
}
