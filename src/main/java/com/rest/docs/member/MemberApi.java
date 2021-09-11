package com.rest.docs.member;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberApi {

    private final MemberRepository memberRepository;

    /**
     * 1. Member 단일 조회 -> 완료
     * 2. Member 생성 -> 완료
     * 3. Member 수정 -> 완료
     * 4. Member 페이징 조회 ->
     */

    @GetMapping("/{id}")
    public MemberResponse getMember(@PathVariable Long id) {
        return new MemberResponse(memberRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Notfound")));
    }

    @PostMapping
    public void createMember(@RequestBody @Valid MemberSignUpRequest dto) {
        memberRepository.save(dto.toEntity());
    }

    @PutMapping("/{id}")
    public void modify(
        @PathVariable Long id,
        @RequestBody @Valid MemberModificationRequest dto
    ) {
        final Member member = memberRepository.findById(id).get();
        member.modify(dto.getName());
        memberRepository.save(member);
    }

    @GetMapping
    public Page<MemberResponse> getMembers(
        @PageableDefault(sort = "id", direction = Direction.DESC) Pageable pageable
    ) {
        return memberRepository.findAll(pageable).map(MemberResponse::new);
    }
}
