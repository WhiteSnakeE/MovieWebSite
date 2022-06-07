package com.vladkharchenko.coursework.spring.mycoursework.controller;

import com.vladkharchenko.coursework.spring.mycoursework.dao.AuthorRep;
import com.vladkharchenko.coursework.spring.mycoursework.dao.CompanyRep;
import com.vladkharchenko.coursework.spring.mycoursework.dao.GenreRep;
import com.vladkharchenko.coursework.spring.mycoursework.dao.MoviesRepository;
import com.vladkharchenko.coursework.spring.mycoursework.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("/admin")
public class MyAdminController {
    @Autowired
    public MoviesRepository moviesRepository;
    @Autowired
    public AuthorRep authorRep;
    @Autowired
    public CompanyRep companyRep;
    @Autowired
    public GenreRep genreRep;

    @GetMapping("/index")
    public String registration() {

        return "admin/admin-main-page";
    }
    @GetMapping("/addMovie")
    public String addMovie(Model model) {
        Movie movie = new Movie();
        List<Genre> genres = genreRep.findAll();
        model.addAttribute("NewMovie",movie);
        model.addAttribute("Genres",genres);
        return "admin/add-movie";
    }
    @PostMapping("/addMovie")
    public String createMovie(Movie movie, @RequestParam List<Genre> genres) {
        List<Genre> genreList = genreRep.findAll();
        moviesRepository.save(movie);
        return "admin/admin-main-page";
    }
    @GetMapping("/allMovies")
    public String allMovies(Model model) {
        List<Movie> movie = moviesRepository.findAll();
        model.addAttribute("AllMovies",movie);
        return "admin/admin-all-movies";
    }

    @GetMapping("/allMovies/{id}")
    public String updateMovie(@PathVariable int id, Model model) {
        Movie movie = moviesRepository.getById(id);
        model.addAttribute("MoviesInfo",movie);
        return "admin/admin-movie-update";
    }
    @PostMapping("/allMovies/{id}")
    public String saveMovie(@PathVariable int id,@ModelAttribute Movie movie1) {
        Movie movie = moviesRepository.getById(id);
        System.out.println(movie.getId_movies());
        movie.setAuthor(movie1.getAuthor());
        movie.setMovie_name(movie1.getMovie_name());
        movie.setMovies_price(movie1.getMovies_price());
        movie.setCompany(movie1.getCompany());
        movie.setReleaseData(movie1.getReleaseData());
        movie.setReview(movie1.getReview());
        moviesRepository.save(movie);
        return "admin/admin-main-page";
    }
    @PostMapping("/allMovies/{id}/delete")
    public String deleteMovie(@PathVariable int id) {
        Movie movie = moviesRepository.getById(id);
        moviesRepository.delete(movie);
        return "redirect:/admin/allMovies";
    }

    @GetMapping("/addAuthor")
    public String addAuthor(Model model) {
        Author author = new Author();
        model.addAttribute("NewAuthor",author);
        return "admin/add-author";
    }
    @PostMapping("/addAuthor")
    public String createAuthor(Author author) {
        authorRep.save(author);
        return "admin/admin-main-page";
    }

    @GetMapping("/allAuthors")
    public String allAuthors(Model model) {
        List<Author> authors = authorRep.findAll();
        model.addAttribute("AllAuthors",authors);
        return "admin/admin-all-authors";
    }
    @GetMapping("/allAuthors/{id}")
    public String updateAuthor(@PathVariable int id, Model model) {
        Author author = authorRep.getById(id);
        model.addAttribute("AllAuthors",author);
        return "admin/admin-author-update";
    }
    @PostMapping("/allAuthors/{id}")
    public String saveAuthor(@PathVariable int id,@ModelAttribute Author author1) {
        Author author = authorRep.getById(id);
        author.setAuthorName(author1.getAuthorName());
        author.setAuthorSurName(author1.getAuthorSurName());
        authorRep.save(author);
        return "redirect:/admin/allAuthors";
    }
    @PostMapping("/allAuthors/{id}/delete")
    public String deleteAuthors(@PathVariable int id) {
        Author author = authorRep.getById(id);
        authorRep.delete(author);
        return "redirect:/admin/allAuthors";
    }
    @GetMapping("/allCompanies")
    public String allCompany(Model model) {
        List<Company> companies = companyRep.findAll();
        model.addAttribute("AllCompanies",companies);
        return "admin/admin-all-companies";
    }
    @GetMapping("/addCompany")
    public String addCompany(Model model) {
        Company company = new Company();
        model.addAttribute("NewCompany",company);
        return "admin/add-company";
    }
    @PostMapping("/addCompany")
    public String createCompany(Company company) {
        companyRep.save(company);
        return "admin/admin-main-page";
    }
    @GetMapping("/allCompanies/{id}")
    public String updateCompany(@PathVariable int id, Model model) {
        Company company = companyRep.getById(id);
        model.addAttribute("UpdateCompany",company);
        return "admin/admin-company-update";
    }
    @PostMapping("/allCompanies/{id}")
    public String saveCompany(@PathVariable int id,@ModelAttribute Company company1) {
        Company company = companyRep.getById(id);
        company.setCompanyName(company1.getCompanyName());
        company.setYearOfFoundation(company1.getYearOfFoundation());
        company.setCountry(company1.getCountry());
        companyRep.save(company);
        return "redirect:/admin/allCompanies";
    }
    @PostMapping("/allCompanies/{id}/delete")
    public String deleteCompanies(@PathVariable int id) {
        Company company = companyRep.getById(id);
        companyRep.delete(company);
        return "redirect:/admin/allCompanies";
    }
    @GetMapping("/allGenres")
    public String allGenres(Model model) {
        List<Genre> genres = genreRep.findAll();
        model.addAttribute("AllGenres",genres);
        return "admin/admin-all-genres";
    }
    @GetMapping("/addGenre")
    public String addGenre(Model model) {
        Genre genre = new Genre();
        model.addAttribute("NewGenre",genre);
        return "admin/add-genre";
    }
    @PostMapping("/addGenre")
    public String createGenre(Genre genre) {
        genreRep.save(genre);
        return "admin/admin-main-page";
    }

    @PostMapping("/allGenres/{id}/delete")
    public String deleteGenre(@PathVariable int id) {
        Genre genre = genreRep.getReferenceById(id);
        genreRep.delete(genre);
        return "redirect:/admin/allGenres";
    }
}
