package com.dw.dwbackendtest.member.mapper;

import com.dw.dwbackendtest.member.dto.MemberDto;
import com.dw.dwbackendtest.member.entity.MemberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {
    MemberEntity memberPostDtoToMember(MemberDto.Post memberPostDto);

    MemberDto.Response memberToMemberResponse(MemberEntity member);

    List<MemberDto.Response> membersToMembersResponse(List<MemberEntity> members);
}
