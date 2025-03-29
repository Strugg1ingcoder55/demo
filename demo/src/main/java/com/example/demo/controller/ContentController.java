package com.example.demo.controller;

import com.example.demo.dto.BookDto;
import com.example.demo.entities.MyBook;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class ContentController {

    @Autowired
    private MyBookService myBookService;

    /**
     * Maps the home page.
     *
     * @return the view name for the home page
     */
    @GetMapping("/")
    public String home() {
        return "home";
    }

    /**
     * Maps the home alias page.
     *
     * @return the view name for the home page
     */
    @GetMapping("/home")
    public String homeAlias() {
        return "home";
    }

    /**
     * Maps the login page.
     *
     * @return the view name for the login page
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Maps the admin home page.
     *
     * @return the view name for the admin home page
     */



    @GetMapping("/admin/home")
    public String adminHome() {
        return "adminhome";


    }

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/adminuser")
    public String adminUser(){

        // var users = userRepository.findByUsername(Sort.by(Sort.Direction.DESC, "username"));
        
            return "adminuser";
}
    /**
     * Maps the user home page.
     *
     * @return the view name for the user home page
     */
    @GetMapping("/user/home")
    public String userHome() {
        return "userhome";
    }

    @PostMapping
    public MyBook addBook(MyBook book) {
        return myBookService.saveBook(book);
    }

    @GetMapping("/books")
    public String showAllBooks(Model model) {
        List<MyBook> books = myBookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/adminbooks")
    public String getAllBooks(Model model) {
        List<MyBook> books = myBookService.getAllBooks();
        model.addAttribute("adminbooks", books);
        return "adminbooks";
    }


    @GetMapping("/addbook")
    public String addBook(Model model){
        BookDto bookDto = new BookDto();
        model.addAttribute("bookdto", bookDto);
        return "addbook";
    }

}