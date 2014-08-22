package com.test.spring.ehcache.annotation;

public interface BookRepository {

    public Book getByIsbn(String isbn);

}
