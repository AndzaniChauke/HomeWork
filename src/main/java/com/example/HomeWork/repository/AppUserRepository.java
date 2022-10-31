package com.example.HomeWork.repository;

import com.example.HomeWork.model.AppUser;
import com.example.HomeWork.model.constant.AppUserRole;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<AppUser,Long> {

    Optional<AppUser> findByEmail(String email);


    @Cacheable("appUser")
    @Query(value="SELECT u FROM AppUser u WHERE u.appUserRole=?1")
    List<AppUser> findUserRoles(AppUserRole appUserRole);
}
