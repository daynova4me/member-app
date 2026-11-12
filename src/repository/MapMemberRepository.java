package repository;

import entity.Member;

import java.util.HashMap;
import java.util.Map;

public class MapMemberRepository implements MemberRepository{
    // 사용할 Map 자료구조 선언
    private Map<Integer, Member> members = new HashMap<>();
    // 자동증가를 위한 변수, 맵의 key로도 사용할 예정 == member의 id와도 일치함.
    private int nextId = 1;


    @Override
    public boolean save(Member member) {
        member.setId(nextId);
        nextId++;
        members.put(member.getId(), member);
        return true;
    }

    @Override
    public Member[] findAll() {
        //map 전체 순회하면서 배열에 담아 리턴
        Member[] results = new Member[members.size()];
        //맵은 for(int i =0) 구조가 안 됨.
        //-> 수동으로 인덱스 조정해줘야 함.
        int index = 0;
        for (Member member : members.values()){
            results[index] = member;
            index++;
        }
        return results;
    }

    @Override
    public Member findById(int id) {
        return members.get(id);
    }

    @Override
    public boolean update(Member member) {
        // 키(id)가 있는지 확인하고 있으면 업데이트
        //키 찾는 메서드
        if (! members.containsKey(member.getId()))return false;
        members.put(member.getId(), member);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        //삭제할 키가 있는지 먼저 확인
        if (! members.containsKey(id)) return  false;
        members.remove(id);
        return true;
    }
}
