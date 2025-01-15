package uz.com.brb.controller;

import org.springframework.web.bind.annotation.*;
import uz.com.brb.model.Loans;
import uz.com.brb.service.LoanService;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoansController {

    private final LoanService loanService = new LoanService();

    @PostMapping("/save")
    public Loans save(@RequestBody Loans loans){
        return loanService.create(loans);
    }

    @GetMapping("/{id}")
    public Loans getOne(@PathVariable int id){
        return loanService.getById(id);
    }

    @GetMapping
    public List<Loans> getAll(){return loanService.getAllLoans();}

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        loanService.delete(id);
        return "Deleted!";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Loans loans){
        loanService.update(id, loans);
        return "Updated!";
    }

    @GetMapping("/status")
    public List<Loans> getByStatus(@RequestParam String status){
        return loanService.getByStatus(status);
    }

    @GetMapping("/client-id/{clId}")
    public List<Loans> getByClientId(@PathVariable int clId){
        return loanService.getByClientId(clId);
    }
}