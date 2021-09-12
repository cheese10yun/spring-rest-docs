package com.rest.docs.member;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Getter;

@Getter
public class MemberModificationRequest {

    @NotEmpty
    @Size(max = 10)
    private String name;
}
