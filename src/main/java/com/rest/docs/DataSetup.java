package com.rest.docs;

import com.rest.docs.member.Member;
import com.rest.docs.member.MemberRepository;
import com.rest.docs.member.MemberStatus;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataSetup implements ApplicationRunner {

    private final MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) {
        final List<Member> members = new ArrayList<>();

        members.add(new Member("yun@bbb.com", "yun", MemberStatus.BAN));
        members.add(new Member("jin@bbb.com", "jin", MemberStatus.NORMAL));
        members.add(new Member("han@bbb.com", "han", MemberStatus.NORMAL));
        members.add(new Member("jo@bbb.com", "jo", MemberStatus.LOCK));

        memberRepository.saveAll(members);
    }
}
