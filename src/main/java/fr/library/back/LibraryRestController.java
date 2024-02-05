package fr.library.back;

import org.springframework.http.ResponseEntity;

public interface LibraryRestController<T> {

    ResponseEntity<Iterable<T>> getAll();

    ResponseEntity<T> update(T element);

    ResponseEntity<Void> deleteAll();

    ResponseEntity<T> create(T element); // t element => le parametre type + nom  // <T> type du retour attendu
}
