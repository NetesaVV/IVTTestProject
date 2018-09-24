package web.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.core.domain.Client;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BaseController {

    private static List<Client> clients = new ArrayList<Client>();
    static {
        clients.add(new Client("admin", "admin", "Netesa V V", 'm'));
        clients.add(new Client("rogov_dv@ivt.su", "rogov_dv@ivt.su", "Rogov D V", 'm'));
    }

    // Инъетировать (inject) из application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;


    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = { "/ClientList" }, method = RequestMethod.GET)
    public String ClientList(Model model) {

        model.addAttribute("Clients", clients);

        return "ClientList";
    }

    @RequestMapping(value = { "/addClient" }, method = RequestMethod.GET)
    public String addClient(Model model) {

        Client Client = new Client();
        model.addAttribute("Client", Client);

        return "addClient";
    }

    @RequestMapping(value = { "/addClient" }, method = RequestMethod.POST)
    public String addClientSave(Model model, //
                                @ModelAttribute("Client") Client Client) {

        String login = Client.getLogin();
        String password = Client.getPassword();
        String fullName = Client.getFullName();
        Character sex = Client.getSex();

        if (login != null && login.length() > 0 //
                && password != null && password.length() > 0
                &&fullName != null && fullName.length() > 0
                && sex!=null && (sex.charValue()!='m'||sex.charValue()!='f')) {
            Client newClient = new Client(login, password, fullName, sex);
            clients.add(newClient);

            return "redirect:/ClientList";
        }
        String error = "First Name & Last Name is required!";
        model.addAttribute("errorMessage", error);
        return "addClient";
    }
}
