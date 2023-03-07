package com.waxes27.pitchIT.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface UserRepository extends JpaRepository<IUser, Long> {


    Optional<IUser> findByEmail(String email);


    Optional<IUser> findByUserName(String username);
}