package photozaruvaj.photozaruvaj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import photozaruvaj.photozaruvaj.models.User;
import photozaruvaj.photozaruvaj.repositories.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping(value = {"/", "/home", "/index", "/welcome"})
    public String getIndex(Model model) {

        model.addAttribute("user", new User());

        return "templates/index.html";

    }

    private User maybeCurrUser;


    @PostMapping(value = "/index")
    public String postLogin(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        if (userRepository.checkPassword(user)) {
            User u2 = userRepository.getUserByUsername(user.getUsername());
            maybeCurrUser = u2;

        }
        return "redirect:/Home";
    }

}
