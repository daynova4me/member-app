package service;

import entity.Member;
import repository.MemberRepository;

public class MemberService {
    // 리포지토리 구현한 애 이지만 부모를 갖고 시작
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean addMember(String name, String phone) {
        System.out.println("[MemberService.addMember]");
        // 이름과 서비스가 비었는지 확인
        if(name.isBlank() || phone.isBlank()){
            return false;
        }

        // 서비스는 이름과 전화번호를 갖고 Member 객체 생성
        Member member = new Member(name, phone);
        // 출력해보기
        System.out.println(member);

        // 리포한테 야.. 저장해... 요청
        boolean result = memberRepository.save(member);
        return result;
    }

    public Member[] getMembers() {
        return memberRepository.findAll();
    }

    public Member getMember(int id) {
        return memberRepository.findById(id);
    }

    public boolean updateMember(int id, String name, String phone) {
        //전달받은 id로 기존 멤버 검색
        Member member = memberRepository.findById(id);
        //member가 null인지 확인
        if (member == null) return false;
        //name, phone 값으로 수정
        //조건: 기존 값을 수정하지 않으면 비어있는 상태로 name, phone 전송.
        //-> 비어있으면 건드리지 마.
        if (! name.isBlank()) member.setName(name);
        if (! phone.isBlank()) member.setPhone(phone);
        member.setName(name);
        member.setPhone(phone);
        //리포에 있는 update 수행
        return memberRepository.update(member);
    }

    public boolean deleteMember(int id) {
        return memberRepository.deleteById(id);
    }
}
