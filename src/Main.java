import console.MemberConsole;
import repository.ArrayMemberRepository;
import repository.MemberRepository;
import service.MemberService;

public class Main {
    static void main(String[] args) {
        // 리포부모 만들고
        MemberRepository repository = new ArrayMemberRepository();
        // 리포를 서비스에 넣고
        MemberService service = new MemberService(repository);
        // 서비스를 콘솔에 넣고
        MemberConsole console = new MemberConsole(service);
        // 콘솔의 run 호출 -> 시작
        console.run();
    }
}
