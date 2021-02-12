package com.larrylee1994.webapp.domain.repositories;

import com.larrylee1994.webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
