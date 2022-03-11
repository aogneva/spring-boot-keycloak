package ru.ogneva.library;

import org.keycloak.KeycloakSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LibraryController {

    private final HttpServletRequest request;

    LibraryController(HttpServletRequest request) {
        this.request = request;
    }

    @GetMapping("/")
    public String getDefault() { return "home";}

    @GetMapping("/home")
    public String getHome() { return "home";}

    @GetMapping(value = "/logout")
    public String logout() throws ServletException {
        request.logout();
        return "redirect:/";
    }

    @GetMapping(value="/books")
    public String getBooks(Model model) {
        configCommonAttributes(model);
        model.addAttribute("books", List.of("One", "Two", "Three"));
        return "books";
    }

    @GetMapping(value="/manager")
    public String getManager() {
//    public String getManager(Model model) {
//        configCommonAttributes(model);
//        model.addAttribute("books", List.of("Four", "Five", "Six", "Seven"));
        return "manager";
    }

    private KeycloakSecurityContext getKeycloakSecurityContext() {
        return (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
    }

    private void configCommonAttributes(Model model) {
        model.addAttribute("name", getKeycloakSecurityContext().getIdToken().getGivenName());
    }

}
