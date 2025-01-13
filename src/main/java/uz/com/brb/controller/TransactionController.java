package uz.com.brb.controller;

import org.springframework.web.bind.annotation.*;
import uz.com.brb.model.Transactions;
import uz.com.brb.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService = new TransactionService();

    @PostMapping("/save")
    public Transactions save(@RequestBody Transactions transactions){
        return transactionService.save(transactions);
    }

    @GetMapping("/{id}")
    public Transactions getOne(@PathVariable int id){
        return transactionService.getOne(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
       transactionService.delete(id);
       return "Deleted!";
    }

    @PutMapping("/{id}")
    public String updated(@PathVariable int id, @RequestBody Transactions transactions){
        transactionService.update(id, transactions);
        return "Updated!";
    }

    @GetMapping
    public List<Transactions> getAll(){return transactionService.getAll();}
}
