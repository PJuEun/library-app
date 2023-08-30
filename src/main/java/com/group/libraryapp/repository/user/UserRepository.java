package com.group.libraryapp.repository.user;

import com.group.libraryapp.dto.user.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//@Repository
public class UserRepository { // DB관련
    /*private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public List<Integer> findUser(long id) {
//    // 1. 존재하는 유저를 확인, 없는 경우에는 예외를 던지도록 해서.. 그 유저는 없는데~
//        String readSql = "SELECT * FROM user WHERE id = ?";
//    // RowMapper - 조회 결과를 우리가 원하는 객체로 변환하는 기능
//    // 익명 클래스
//        return jdbcTemplate.query(readSql, new RowMapper<Integer>() {
//            @Override
//            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
//                return 0;
//            }
//        }, id);
//    }
//
//    public void updateUser(String name, long id) {
//    // 2. 유저가 있다~ update SQL을 DB에 날려서 실제 유저를 업데이트
//        String sql = "UPDATE user SET name = ? WHERE id = ?";
//        jdbcTemplate.update(sql, name, id);
//    }


    public List<UserResponse> getUsers() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, new RowMapper<UserResponse>() {
            @Override
            public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                return new UserResponse(id, name, age);
            }
        });
    }

    public void saveUser(String name, Integer age) {
        String sql = "INSERT INTO user (name, age) VALUES (?, ?)";
        jdbcTemplate.update(sql, name, age);
    }
    public boolean isUserNotExist(long id) {
        String readSql = "SELECT * FROM user WHERE id = ?";
        return jdbcTemplate.query(readSql, new RowMapper<UserResponse>() {
            @Override
            public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                return new UserResponse(id, name, age);
            }
        }, id).isEmpty();
    }

    public void updateUser(String name, long id) {
        String sql = "UPDATE user SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, name, id);
    }

    public void deleteUser(String name) {
        String sql = "DELETE FROM user WHERE name = ?";
        jdbcTemplate.update(sql, name);
    }*/

}
