package com.dw.dwbackendtest.member.repository;

import com.dw.dwbackendtest.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findByAccountName(String accountName);

}
