package com.ledzepplin.provider.user.mapper;

import com.ledzepplin.provider.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: Jingjiadong
 * @Description:
 * @Date: 7:24 PM 07/01/2018
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
