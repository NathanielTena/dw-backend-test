package com.dw.dwbackendtest.junket.entity;

import com.dw.dwbackendtest.common.audit.Auditable;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity(name = "JUNKET")
public class JunketEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long junketId;
    @Column(length = 10)
    private String junketCode;
    @Column(length = 20)
    private String junketName;

}
