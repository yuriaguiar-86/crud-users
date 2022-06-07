package br.com.imepac.crud.controllers;

import br.com.imepac.crud.entities.UserEntity;
import br.com.imepac.crud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("users")
    public String index(Model model) {
        model.addAttribute("list", repository.findAll());
        return "users/index";
    }

    @GetMapping("users/add")
    public String add(@ModelAttribute("user") UserEntity user) {
        return "users/form";
    }

    @GetMapping("users/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) throws IllegalAccessException {
        Optional<UserEntity> user = repository.findById(id);

        if(user.isEmpty()) {
            throw new IllegalAccessException("Usuário inválido");
        }

        model.addAttribute("user", user.get());
        return "users/form";
    }

    @PostMapping("users/save")
    public String save(@ModelAttribute("user") UserEntity user) {
        repository.save(user);
        return "redirect:/users";
    }

    @GetMapping("users/delete/{id}")
    public String delete(@PathVariable("id") long id) throws IllegalAccessException {
        Optional<UserEntity> user = repository.findById(id);

        if(user.isEmpty()) {
            throw new IllegalAccessException("Usuário inválido");
        }

        repository.delete(user.get());
        return "redirect:/users";
    }
}
