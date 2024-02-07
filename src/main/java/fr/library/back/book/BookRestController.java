package fr.library.back.book;

import fr.library.back.LibraryRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookRestController implements LibraryRestController<BookDto> {

    @Autowired
    protected BookService bookService;

    /**
     * Read - Get all books
     * @return - An Iterable object of Book full filled
     */
    @GetMapping("/books")
    public ResponseEntity<Iterable<BookDto>> getAll() {
        List<BookDto> allBooks = new ArrayList<>();
        try {
            allBooks = bookService.getBooks();
        }catch (Exception e){
            return new ResponseEntity<Iterable<BookDto>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<BookDto>>(allBooks, HttpStatus.OK);
    }



    @DeleteMapping("/remove-books")
    public ResponseEntity<Void> deleteAll() {
        try {
            List<BookDto> allBooksDto = bookService.getBooks();
            bookService.deleteAllBooks(allBooksDto);
        }catch (Exception e){
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<BookDto> update(BookDto element) {
        return null;
    }

    @Override
    public ResponseEntity<BookDto> create(BookDto element) {
        return null;
    }

}
