package com.dw.dwbackendtest.member.service;

import com.dw.dwbackendtest.common.exception.BusinessLogicException;
import com.dw.dwbackendtest.common.exception.ExceptionCode;
import com.dw.dwbackendtest.member.dto.MemberDto;
import com.dw.dwbackendtest.member.entity.MemberEntity;
import com.dw.dwbackendtest.member.mapper.MemberMapper;
import com.dw.dwbackendtest.member.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public MemberService(MemberRepository memberRepository,
                         MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    public MemberEntity createMember(MemberDto.Post memberPostDto) {
        MemberEntity member = memberMapper.memberPostDtoToMember(memberPostDto);
        verifyExistAccountName(member.getAccountName());

        return memberRepository.save(member);
    }

    public Page<MemberEntity> findMembers(int page, int size) {
        return memberRepository.findAll(PageRequest.of(page, size,
                Sort.by("createdAt").descending()));
    }

    @Transactional(readOnly = true)
    public MemberEntity findVerifiedMemberById(Long memberId) {
        Optional<MemberEntity> optionalMember = memberRepository.findById(memberId);
        return optionalMember.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }

    private void verifyExistAccountName(String AccountName) {
        Optional<MemberEntity> member = memberRepository.findByAccountName(AccountName);
        if (member.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
        }
    }
}
