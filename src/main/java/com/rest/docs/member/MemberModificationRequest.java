package com.rest.docs.member;

import javax.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class MemberModificationRequest {

    @NotEmpty
    private String name;
}
