package fr.library.back;

import org.springframework.http.ResponseEntity;

public interface LibraryRestController<T> {

    ResponseEntity<Iterable<T>> getAll();

    ResponseEntity<T> update(T element);

    ResponseEntity<Void> deleteAll();

    ResponseEntity<T> create(T element);
}
