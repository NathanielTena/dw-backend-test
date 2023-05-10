package com.dw.dwbackendtest.junket.repository;

import com.dw.dwbackendtest.junket.entity.JunketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface JunketRepository extends JpaRepository<JunketEntity, Long> {
    Optional<JunketEntity> findByJunketCode(String junketCode);

}
