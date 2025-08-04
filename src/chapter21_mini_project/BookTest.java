package chapter21_mini_project;

public class BookTest {

	public static void main(String[] args) {
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
		MemberVo mvo = new MemberVo();
		dao.select();

	}

}
