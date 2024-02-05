package fr.library.back.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookRestController {

    @Autowired
    protected BookServiceImpl bookService;

    /**
     * Read - Get all books
     * @return - An Iterable object of Book full filled
     */
    @GetMapping("/books")
    public Iterable<BookDto> getBooks() {
        return bookService.getBooks();
    }

    @DeleteMapping("/remove-books")
    public ResponseEntity<Void> deletAllBooks() {
        try {
            List<BookDto> allBooksDto = bookService.getBooks();
            bookService.deleteAllBooks(allBooksDto);
        }catch (Exception e){
            //throw renvoie l exeption tel que  au front pas ouf!
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR); //renvoie une erreur 500
        }
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);//reponse http Point rest propre on renvoie un no content (signifie : pas de body ds la reponse)
    }
}
