package mk.ukim.finki.wp.lab1.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab1.model.BookReservation;
import mk.ukim.finki.wp.lab1.service.BookReservationService;
import mk.ukim.finki.wp.lab1.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet(name="bookDetailsServlet", urlPatterns = "/details")
public class BookDetailsServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final BookReservationService bookReservationService;
    private final BookService bookService;

    public BookDetailsServlet(SpringTemplateEngine springTemplateEngine, BookReservationService bookReservationService, BookService bookService) {
        this.springTemplateEngine = springTemplateEngine;
        this.bookReservationService = bookReservationService;
        this.bookService = bookService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);

        String title = req.getParameter("title");
        List<BookReservation> bookReservationList =bookReservationService.getBookReservationsByTitle(title);
        context.setVariable("bookReservationList", bookReservationList);
        springTemplateEngine.process("listBookReservations.html", context, resp.getWriter());
    }
}
