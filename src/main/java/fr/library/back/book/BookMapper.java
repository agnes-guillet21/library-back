package fr.library.back.book;

public class BookMapper {

    private BookMapper(){};

    public static BookDto map(BookEntity bookEntity) {
        BookDto bookDto = new BookDto();
        bookDto.setId(bookEntity.getId());
        bookDto.setTitle(bookEntity.getTitle());
        bookDto.setDescription(bookEntity.getDescription());
        bookDto.setAuthor(bookEntity.getAuthor());

        return bookDto;
    }

    public static BookEntity map(BookDto bookDto){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(bookDto.getId());
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setDescription(bookDto.getDescription());
        bookEntity.setAuthor(bookDto.getAuthor());

        return bookEntity;
    }

}
