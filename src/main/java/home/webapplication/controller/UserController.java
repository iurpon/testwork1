package home.webapplication.controller;

import home.webapplication.domain.User;
import home.webapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.SQLException;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**/@RequestMapping("/users")
    public String list(Model model)  throws SQLException {

        model.addAttribute("user", userService.getAllUsers());
        return "users";
    }


    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String addUser(@ModelAttribute("newUser") User newUser)   throws SQLException {
        return "adduser";
    }
    @RequestMapping(value = "/adduser",method = RequestMethod.POST)
    public String showNew(@ModelAttribute("newUser") User newUser)  throws SQLException {
        userService.addUser(newUser);
        return "redirect:/users";
    }


    @RequestMapping("/delete")
    public String deleteUser(@RequestParam("id") String id, Model model)  throws SQLException {
        model.addAttribute("user",userService.deleteUser(id));
        return "forward:/users";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateUser(@RequestParam("id") String id,Model model)   throws SQLException {
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "update";
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String showUpdate(@ModelAttribute("newUser") User newUser)   throws SQLException {
        userService.updateUser(newUser);

        return "redirect:/users";
    }
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@ModelAttribute("search") User newUser)   throws SQLException {

        return "search";
    }
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String showSearch(Model model,@ModelAttribute("searchUser") User searchUser)   throws SQLException {
            model.addAttribute("user",userService.search(searchUser));
        return "searchResult";
    }
}
