package repository;

import entity.Member;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMemberRepository implements MemberRepository{
    private List<Member> members = new ArrayList<>();
    // 다음에 추가될 id 생성 변수
    private int nextId = 1;

    @Override
    public boolean save(Member member) {
        // 신규 id를 member의 id에 넣는다.
        member.setId(nextId);
        nextId++;
        members.add(member);
        return true;
    }

    @Override
    public Member[] findAll() {
        // ArrayList 전체를 배열로 바꿔서 전달
        Member[] results = new Member[members.size()];
        for(int i=0; i < members.size(); i++){
            results[i] = members.get(i);
        }
        return results;
    }

    @Override
    public Member findById(int id) {
        // id와 일치하는 리스트 색인을 찾는다.
        int index = findIndex(id);
        if(index == -1) return null;
        return members.get(index);
    }

    private int findIndex(int id){
        for(int i = 0; i < members.size(); i++){
            if(members.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean update(Member member) {
        // member 안에 id가 있는지 확인
        int index = findIndex(member.getId());
        if(index == -1) return false;
        members.set(index, member);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        // 삭제할 id 존재 확인 -> 색인
        int index = findIndex(id);
        if(index==-1) return false;
        members.remove(index);
        return true;
    }
}
