package fr.library.back.book;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookServiceImpl {

    private BookDao bookDao;

    //    Privilegier un construct plutot qu autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    /**
     * get bookDto object
     * use mapper class
     */
    public List<BookDto> getBooks() {
        List<BookDto> bookDtos = new ArrayList<>();
        List<BookEntity> bookEntities = bookDao.findAll();
        for (BookEntity bookEntity : bookEntities) {
            bookDtos.add(BookMapper.map(bookEntity));
        }
        return bookDtos;
    }

    public void deleteAllBooks(List<BookDto> bookDtos){
        List<BookEntity> bookEntities = new ArrayList<>();
        for (BookDto bookDto : bookDtos) {
            bookEntities.remove(BookMapper.map(bookDto));
        }
    }
}
