package com.jda.preps.repositories;

import com.jda.preps.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}