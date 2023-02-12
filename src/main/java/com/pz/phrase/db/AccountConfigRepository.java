package com.pz.phrase.db;

import com.pz.phrase.model.entity.AccountConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountConfigRepository extends JpaRepository<AccountConfig, Integer> {
    AccountConfig findByCode(String code);
}
