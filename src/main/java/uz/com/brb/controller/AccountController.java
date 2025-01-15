package uz.com.brb.controller;

import org.springframework.web.bind.annotation.*;
import uz.com.brb.model.Accounts;
import uz.com.brb.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService = new AccountService();

    @PostMapping("/save")
    public Accounts save(@RequestBody Accounts accounts){
        return accountService.save(accounts);
    }

    @GetMapping("/{id}")
    public Accounts getOne(@PathVariable int id){return accountService.getOne(id);}

    @GetMapping
    public List<Accounts> getAll(){return accountService.getAllAccountsList();}

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        accountService.delete(id);
        return "Deleted!";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Accounts accounts){
        accountService.update(id, accounts);
        return "Updated!";
    }

    @GetMapping("/client-id/{id}")
    public List<Accounts> getByClientId(@PathVariable int id){
        return accountService.getByClientId(id);
    }

    @GetMapping("/type")
    public List<Accounts> getByType(@RequestParam String type){
        return accountService.getByAccountType(type);
    }
}