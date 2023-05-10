package com.dw.dwbackendtest.Login.service;

import com.dw.dwbackendtest.Login.dto.LoginDto;
import com.dw.dwbackendtest.common.exception.ExceptionCode;
import com.dw.dwbackendtest.member.entity.MemberEntity;
import com.dw.dwbackendtest.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class LoginService {
    private final MemberRepository memberRepository;

    public LoginService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public String Login(LoginDto.Post loginDto){
        Optional<MemberEntity> optionalMember =  memberRepository.findByAccountName(loginDto.getAccountName());

        if (optionalMember.isEmpty()) {
            return "invalid";
        }
        MemberEntity foundMember = optionalMember.orElseThrow();
        if (!loginDto.getPassword().equals(foundMember.getPassword())) {
            return "invalid";
        }
        return "vaild";
    }
}
