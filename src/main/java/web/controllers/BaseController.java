package web.controllers;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.core.domain.Client;
import ru.core.domain.ClientForm;
import ru.core.services.ClientService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BaseController {

    @Autowired
    private ClientService clientService;

    private static List<Client> clients = new ArrayList<>();
    private static Boolean isIndextFirstVisit=false;


    // Инъетировать (inject) из application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;


    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        if(!isIndextFirstVisit) {
            clientService.createClient("admin", "admin", "Netesa V V", 'm');
            clientService.createClient("rogov_dv@ivt.su", "rogov_dv@ivt.su", "Rogov D V", 'm');
            isIndextFirstVisit=true;
        }

        clients = clientService.getAll();
        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = { "/clientList" }, method = RequestMethod.GET)
    public String ClientList(Model model) {

        model.addAttribute("clients", clients);

        return "ClientList";
    }

    @RequestMapping(value = { "/addClient" }, method = RequestMethod.GET)
    public String addClient(Model model) {

        ClientForm clientForm = new ClientForm();
        model.addAttribute("clientForm", clientForm);

        return "addClient";
    }

    @RequestMapping(value = { "/addClient" }, method = RequestMethod.POST)
    public String addClientSave(Model model, //
                                @ModelAttribute("clientForm") ClientForm clientForm) {

        String login = clientForm.getLogin();
        String password = clientForm.getPassword();
        String fullName = clientForm.getFullName();
        Character sex = clientForm.getSex();
        if (login != null && login.length() > 0 //
                && password != null && password.length() > 0
                &&fullName != null && fullName.length() > 0
                && sex!=null && (sex.charValue()=='m'||sex.charValue()=='f')) {
            //Client newClient = new Client(login, password, fullName, sex);
            //clients.add(newClient);
            clients.add(clientService.createClient(login, password, fullName, sex));

            return "redirect:/clientList";
        }
        String error = "All fields are required, sex m or f!";
        model.addAttribute("errorMessage", error);
        return "addClient";
    }
}
