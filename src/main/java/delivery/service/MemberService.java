package delivery.service;

import delivery.dto.Address;
import delivery.domain.Member;
import delivery.dto.RoleType;
import delivery.repository.MemberRepository;

public class MemberService {
    private static final MemberRepository memberRepository = new MemberRepository();

    public void createMember(String id, String name, Address address, RoleType roleType){
        Member member = new Member();
        member.setId(id);
        member.setName(name);
        member.setAddress(address);
        member.setRoleType(roleType);
        memberRepository.create(member);
        System.out.println("member created : " + member.toString());
    }
    public Member findMember(String id){
        return memberRepository.findById(id);
    }
    public void updateMember(Member member){
        Member findMember = memberRepository.findById(member.getId());
        findMember.setName(member.getName());
        findMember.setOrders(member.getOrders());
        findMember.setAddress(member.getAddress());
        findMember.setRoleType(member.getRoleType());

        System.out.println("member updated : " + findMember.toString());
    }

    public void deleteMember(Member member){
        String deletedId = member.getId();
        memberRepository.delete(member);
        System.out.println("user " + deletedId + " deleted");
    }
}
