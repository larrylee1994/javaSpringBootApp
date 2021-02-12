package com.larrylee1994.webapp.domain.repositories;

import com.larrylee1994.webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
