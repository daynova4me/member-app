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
        return null;
    }

    public Member getMember(int id) {
        return null;
    }

    public boolean updateMember(int id, String name, String phone) {
        return true;
    }

    public boolean deleteMember(int id) {
        return true;
    }
}
