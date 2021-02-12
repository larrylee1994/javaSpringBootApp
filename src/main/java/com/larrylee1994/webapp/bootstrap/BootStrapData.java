package com.larrylee1994.webapp.bootstrap;

import com.larrylee1994.webapp.domain.Author;
import com.larrylee1994.webapp.domain.Book;
import com.larrylee1994.webapp.domain.Publisher;
import com.larrylee1994.webapp.domain.repositories.AuthorRepository;
import com.larrylee1994.webapp.domain.repositories.BookRepository;
import com.larrylee1994.webapp.domain.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Publisher waterworks = new Publisher();
        waterworks.setName("Work waters");
        waterworks.setCity("st peter");
        waterworks.setState("FL");

        publisherRepository.save(waterworks);
        System.out.println("Publisher count: " + publisherRepository.count());


        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("domain driven design", "123321");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE", "3321132");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        waterworks.getBooks().add(ddd);
        ddd.setPublisher(waterworks);

        authorRepository.save(rod);

        noEJB.setPublisher(waterworks);
        waterworks.getBooks().add(noEJB);
        bookRepository.save(noEJB);
        publisherRepository.save(waterworks);



        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println(waterworks.getName() + " number of books: " + waterworks.getBooks().size());

    }
}
