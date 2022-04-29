package com.caster.user.repository;

import com.caster.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author caster
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
