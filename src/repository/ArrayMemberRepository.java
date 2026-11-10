package repository;

import entity.Member;

import java.util.ArrayList;
import java.util.List;

public class ArrayMemberRepository implements MemberRepository{
    // Member 담을 배열 10개 선언
    private Member[] members = new Member[10];
    // 현재 배열에 저장된 갯수
    private int count = 0;
    // 다음에 넣을 id 값 생성하기 - auto_increment
    private int nextId = 1;

    @Override
    public boolean save(Member member) {
        System.out.println(member);
        // 배열 갯수 10개 넘었는지 확인
        if(count == members.length){
            return false;
        }
        // id를 셋팅
        member.setId(nextId);
        nextId++;
        // count번째 저장
        members[count] = member;
        count++;

        // 잘 저장됐는지 찍어보기
        //for (Member x : members) {
       //     System.out.println(x);
        //}

        return true;
    }

    @Override
    public Member[] findAll() {
        //배열 안의 count 갯수만큼 배열 생성 후에 리턴
        //1. count 만큼의 빈 배열 생성
        Member[] result = new Member[count];


        //2. 옮겨 담고
        for (int i = 0; i<count; i++){
            result[i] = members[i];
        }

        //3. 리턴
        return result;
    }

    @Override
    public boolean findById(int id) {
        //전달받은 id가 members 배열에 있는지 확인
        //있으면 t, 없으면 f
        //1. 해당 id가 있는지 잇으면 해당 id 리턴하는
        //별도 메서드 생성.
        int findId = findByIndex(id);

        //리턴 값(findId) = -1 : false 그 외 true
        if (findId == -1){
            return false;
        }
        return true;
    }

    //내가 만드는 메서드
    //id가 존재하는 배열의 위치값 찾기
    //findByIndex라는 메서드 생성
    private int findByIndex(int id){
        //for 반복하면서 있으면 해당 index, 없으면 -1
        for (int i = 0; i<count; i++){
            if (members[i].getId()==id){
                return i; //찾는 인덱스 리턴
            }
        }
        return -1; //없으면 여기로 온다.
    }


    @Override
    public boolean update(Member member) {
        //id에 해당하는 색인 찾기 : 없으면 false
        int index = findByIndex(member.getId());

        if (index == -1){
            return false;
        }
        //해당 배열의 위치에 member 넣기.
        members[index] = member;
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        //삭제할 id로 인덱스를 찾기
        int index = findByIndex(id);
        if (index == -1){
            return false;
        }

        //해당 배열에 null 값 넣기
        members[index] = null;

        //앞으로 하나씩 당긴다.
        for (int i = index; i < count; i++){
            members[i] = members[i+1];
        }
        //맨 끝엔 null 값으로 채운다.
        members[count -1] = null;
        //count -1
        count --;
        return true;
    }
}
