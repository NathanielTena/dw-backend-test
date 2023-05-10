package com.dw.dwbackendtest.member.controller;

import com.dw.dwbackendtest.common.dto.MultiResponseDto;
import com.dw.dwbackendtest.common.dto.SingleResponseDto;
import com.dw.dwbackendtest.member.dto.MemberDto;
import com.dw.dwbackendtest.member.entity.MemberEntity;
import com.dw.dwbackendtest.member.mapper.MemberMapper;
import com.dw.dwbackendtest.member.service.MemberService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper memberMapper;

    public MemberController(MemberService memberService,
                            MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post memberPostDto) {
        MemberEntity createdMember = memberService.createMember(memberPostDto);
        MemberDto.Response response = memberMapper.memberToMemberResponse(createdMember);
        return new ResponseEntity<>(
                new SingleResponseDto<>(response),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity getMembers(@Positive @RequestParam int page,
                                     @Positive @RequestParam int size) {
        Page<MemberEntity> pageMembers = memberService.findMembers(page - 1, size);
        List<MemberEntity> members = pageMembers.getContent();
        return new ResponseEntity<>(
                new MultiResponseDto<>(memberMapper.membersToMembersResponse(members), pageMembers),
                HttpStatus.OK
        );
    }

    @GetMapping("/{memberId}")
    public ResponseEntity getMember(@PathVariable("memberId") Long memberId) {
        return new ResponseEntity<>(
            new SingleResponseDto<>(memberService.findVerifiedMemberById(memberId)),
            HttpStatus.OK
        );
    }

}
