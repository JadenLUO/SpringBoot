package com.acxiom.springboot.boot001.dao;

import com.acxiom.springboot.boot001.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloDao extends JpaRepository {

    public User findByUserId(Integer userId);

}
