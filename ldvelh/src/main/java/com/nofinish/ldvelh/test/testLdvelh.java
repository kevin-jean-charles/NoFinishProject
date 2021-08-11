package com.nofinish.ldvelh.test;
import com.nofinish.ldvelh.controller.BookController;
import com.nofinish.ldvelh.controller.UserController;
import com.nofinish.ldvelh.model.Book;
import com.nofinish.ldvelh.model.User;
import com.nofinish.ldvelh.service.BookService;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.assertThat;


public class testLdvelh {

    private static final String NEW_TASK = "New task";


    @Mock
    BookService bookService;

    @InjectMocks
    BookController bookController;
    UserController userController;

    Book newBook;
    User user;

    @Before("")


    public void setup() {

        user= new User("alicia", "alicia@mail.com", "aliciaderradji");

       newBook = new Book(1L, "title", "resume");

        initMocks(this);

        when(userController.addUserInBook(1L, newBook)).thenReturn(user);

       /* when(bookService.createOrUpdateBook(any(Book.class))).thenReturn(newBook);

        when(bookService.findAllBooks()).thenReturn(new ArrayList<Book>());*/
    }

    @Test
    public void should_add_a_book_and_return_him() {

        User user = userController.user(1L);

        user.getBookList().get()

        Book book = bookController.createBook(1L, "title", "resume");
        /**
         * This method is the same as in TodoTest.java. Simply here,
         * in addition to checking that the object is not zero, we will check its value!
         */
        assertThat(book.getTitle()).(user.getBookList().get(1));
    }

    @Test
    public void should_get_all_todo_and_return_them() {
        List<Book> book = bookController();
        assertThat(book).isNotNull();
    }


    /**
     * Some useful methods:
     * isNotNull (): Checks that the object is not null
     * isEqualTo (value): Check that the return is equal to the value
     * hasSize (size): Check that the return to a size of size
     * contains (value, index): Checks that the return contains the value value at the index index.
     */
}

}
