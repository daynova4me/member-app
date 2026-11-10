package repository;

import entity.Member;

// 모든 CRUD 구현의 뼈대를 갖는 클래스
public interface MemberRepository {
    // 저장
    // 내가 멤버를 줄테니 저장은 너가 알아서 하고
    // 결과(true/false)만 리턴해
    boolean save(Member member);
    // 전체 읽어서 멤버 객체 배열로 리턴
    Member[] findAll();

    // 특정 아이디를 찾는 기능
    // id 받아서 있으면 true, 없으면 false
    boolean findById(int id);
    // 수정
    // 수정할 멤버를 받아서 수정처리
    // 수정 후 성공 : true, 실패 : false
    boolean update(Member member);

    // 삭제
    boolean deleteById(int id);
}
