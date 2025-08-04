package chapter21_mini_project;

import java.util.List;

public interface BookRepository {
    int insert(BookVo book);
    int update(BookVo book);
    int delete(String bid);
    BookVo search(String title);
    BookVo search(int bid);
    List<BookVo> listAll();
}
