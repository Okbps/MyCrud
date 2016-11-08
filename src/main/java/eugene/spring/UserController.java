package eugene.spring;

import eugene.spring.model.User;
import eugene.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aspire on 05.11.2016.
 */
@Controller
public class UserController {
    private UserService userService;
    private int page = 1, recordsPerPage = 5;

    @Autowired(required=true)
    @Qualifier(value="userService")
    public void setUserService(UserService us){
        this.userService = us;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(WebRequest webRequest, Model model) {
        if(webRequest.getParameter("page") != null)
            page = Integer.parseInt(webRequest.getParameter("page"));

        List<User> users = userService.listUsers(webRequest.getParameter("name"));

        model.addAttribute("user", new User());
        model.addAttribute("listUsers", getUsersToDisplay(users));
        model.addAttribute("currentPage", page);
        model.addAttribute("noOfPages", Math.ceil(users.size()*1.0/recordsPerPage));

        return "user";
    }

    @RequestMapping(value= "/user/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User u){

        if(u.getId() == 0){
            this.userService.addUser(u);
        }else{
            this.userService.updateUser(u);
        }

        return "redirect:/users";

    }

//    @RequestMapping("/remove/{id}")
//    public String removeUser(@PathVariable("id") int id){
    @RequestMapping("/remove/")
    public String removeUser(WebRequest webRequest, Model model){
        int id = Integer.parseInt(webRequest.getParameter("id"));
        userService.removeUser(id);

        return "redirect:/users";
    }

//    @RequestMapping("/edit/{id}")
//    public String editUser(@PathVariable("id") int id, Model model){
    @RequestMapping("/edit/")
    public String editUser(WebRequest webRequest, Model model){
        int id = Integer.parseInt(webRequest.getParameter("id"));

        if(webRequest.getParameter("page") != null)
            page = Integer.parseInt(webRequest.getParameter("page"));

        List<User> users = userService.listUsers(webRequest.getParameter(null));

        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("listUsers", getUsersToDisplay(users));
        model.addAttribute("currentPage", page);
        model.addAttribute("noOfPages", Math.ceil(users.size()*1.0/recordsPerPage));

        return "user";
    }

    private List<User>getUsersToDisplay(List<User> users){
        List<User> usersToDisplay = new ArrayList<User>();

        if(users.size()>0) {
            int indStart = (page - 1) * recordsPerPage < users.size() ? (page - 1) * recordsPerPage : users.size() - 1;
            int indFinish = indStart + recordsPerPage <= users.size() ? indStart + recordsPerPage : users.size();
            usersToDisplay = users.subList(indStart, indFinish);
        }

        return usersToDisplay;
    }
}
