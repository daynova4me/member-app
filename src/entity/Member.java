package entity;
// 일반적으로 entity 패키지 이름은
// DB의 테이블과 1 : 1로 연결된 개념이다.
public class Member {
    private int id;
    private String name;
    private String phone;
    // 생성자(모든 필드를 갖는)
    public Member(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
    // 이름과 전화번호만 받아서 생성하는 용도 - 생성자
    // 기존 생성자 재활용
    public Member(String name, String phone) {
        this(0, name, phone);
    }


    // Getter / Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // toString

    @Override
    public String toString() {
        return id + ". " + name + " / " + phone;
    }
}
