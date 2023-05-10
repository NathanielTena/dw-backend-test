package com.dw.dwbackendtest.member.entity;

import com.dw.dwbackendtest.common.audit.Auditable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name="MEMBER")
public class MemberEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 15, nullable = false, unique = true)
    private String accountName;

    @Column(length = 150, nullable = false)
    private String password;

    @Column(length = 15, nullable = false)
    private String name;

    @Column(length = 15)
    private String phone;

    @Column(length = 20, nullable = false)
    private String email;

    @Column(length = 15)
    private String employeeCode;

}
