package com.test.spring.ehcache.annotation;

import org.springframework.cache.annotation.Cacheable;

public class SimpleBookRepository implements BookRepository {

	/*
	 * Question:
	 * If configure cache first, How to dynamic create a cache? 
	 */
    @Override
    @Cacheable("books")//configure cache first
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = (long) (5000L);
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
