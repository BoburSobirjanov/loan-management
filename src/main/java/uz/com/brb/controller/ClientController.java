package uz.com.brb.controller;

import org.springframework.web.bind.annotation.*;
import uz.com.brb.model.Clients;
import uz.com.brb.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService = new ClientService();

    @PostMapping("/save")
    public String save(@RequestBody Clients clients){
        boolean save = clientService.save(clients);
        return save ? "Saved!" : "Wrong!";
    }

    @GetMapping("/{id}")
    public Clients getOne(@PathVariable int id){
        return clientService.getById(id);
    }

    @GetMapping
    public List<Clients> getAll(){return clientService.getAllClients();}

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        clientService.delete(id);
        return "Deleted!";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Clients clients){
        clientService.update(id, clients);
        return "Updated!";
    }

    @GetMapping("/email")
    public Clients getByEmail(@RequestParam String email){
        return clientService.getByEmail(email);
    }

    @GetMapping("/number")
    public Clients getByNumber(@RequestParam String number){
        return clientService.getByNumber(number);
    }
}