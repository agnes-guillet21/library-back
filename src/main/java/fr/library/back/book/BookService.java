package fr.library.back.book;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookService {

    private BookDao bookDao;

    /**
     * Construct
     * @param bookDao
     */
    public BookService(BookDao bookDao) {
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

    /**
     * @param bookDtos
     */
    public void deleteAllBooks(List<BookDto> bookDtos){
        List<BookEntity> bookEntities = new ArrayList<>();
        for (BookDto bookDto : bookDtos) {
            bookEntities.remove(BookMapper.map(bookDto));
        }
    }

    /**
     * @param bookDto
     * @return BookDto : object for front
     */
    public BookDto createBook(BookDto bookDto) {
        BookEntity bookEntity = bookDao.save(BookMapper.map(bookDto));
        return BookMapper.map(bookEntity);
    }

//    public BookDto updateBook(BookDto bookDto){
//        return  BookMapper.map(bookEntity);
//    }
}
