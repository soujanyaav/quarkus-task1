package org.soujanya4013.test;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    private static Map<Long, Book> books = new HashMap<>();
    private static AtomicLong idCounter = new AtomicLong();

    // Book POJO
    public static class Book {
        public Long id;
        public String title;
        public String author;

        public Book() {} // Default constructor for JSON-B

        public Book(Long id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }
    }

    @POST
    public Response createBook(Book book) {
        long id = idCounter.incrementAndGet();
        book.id = id;
        books.put(id, book);
        return Response.status(Response.Status.CREATED).entity(book).build();
    }

    @GET
    @Path("/{id}")
    public Response getBook(@PathParam("id") Long id) {
        Book book = books.get(id);
        if (book == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(book).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateBook(@PathParam("id") Long id, Book updatedBook) {
        Book existing = books.get(id);
        if (existing == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        updatedBook.id = id;
        books.put(id, updatedBook);
        return Response.ok(updatedBook).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBook(@PathParam("id") Long id) {
        Book removed = books.remove(id);
        if (removed == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().build();
    }
}
