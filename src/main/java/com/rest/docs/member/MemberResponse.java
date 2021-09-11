package com.rest.docs.member;

import lombok.Getter;

@Getter
public class MemberResponse {
    private final Long id;
    private final String email;
    private final String name;


    public MemberResponse(final Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.name = member.getName();
    }
}
