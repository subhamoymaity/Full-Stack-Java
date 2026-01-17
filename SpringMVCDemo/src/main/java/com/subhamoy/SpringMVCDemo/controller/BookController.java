package com.subhamoy.SpringMVCDemo.controller;

import com.subhamoy.SpringMVCDemo.dto.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

   private List<Book>bookList=new ArrayList<>();

@GetMapping("/books")
   public String getBooks(Model model){

//   Book book1 = new Book("Maity Book", "Subhamoy");
//   Book book2 = new Book("Das Book", "Rahul");
//   bookList.add(book1);
//   bookList.add(book2);

   // Sends the bookList to the html code
      model.addAttribute("books",bookList);

      return  "books";
   }
   @PostMapping("/add-book")
   public String addBook(@ModelAttribute Book book){
      System.out.println("post Mapping....");
      bookList.add(book);
      return "redirect:/books";
   }

   @GetMapping("/add-book")
   public String showAllBooks(Model model){
   System.out.println("Get Mapping....");
   model.addAttribute("book",new Book());
   return "add-book";
   }
}
