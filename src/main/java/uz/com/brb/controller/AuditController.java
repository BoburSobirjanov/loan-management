package uz.com.brb.controller;

import org.springframework.web.bind.annotation.*;
import uz.com.brb.model.Audits;
import uz.com.brb.service.AuditService;

import java.util.List;

@RestController
@RequestMapping("/audits")
public class AuditController {

    private final AuditService auditService = new AuditService();

    @PostMapping("/save")
    public Audits save(@RequestBody Audits audits){
        return auditService.save(audits);
    }

    @GetMapping("/{id}")
    public Audits getOne(@PathVariable int id){return auditService.getOne(id);}

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        auditService.delete(id);
        return "Deleted!";
    }

    @GetMapping
    public List<Audits> getAll(){return auditService.getAllAudits();}

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Audits audits){
        auditService.update(id, audits);
        return "Updated!";
    }
}
