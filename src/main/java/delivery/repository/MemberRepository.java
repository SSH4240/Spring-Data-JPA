package delivery.repository;

import delivery.domain.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private static final List<Member> members = new ArrayList<>();

    public Member create(Member member){
        members.add(member);
        return member;
    }
    public List<Member> findAll(){
        return members;
    }
    public Member findById(String memberId){
        for (Member member : members){
            if (member.getId().equals(memberId))
                return member;
        }
        return null;
    }
    public void delete(Member member){
        members.remove(member);
    }
}
