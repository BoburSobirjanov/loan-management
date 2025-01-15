package uz.com.brb.service;

import uz.com.brb.model.Audits;

import java.util.ArrayList;
import java.util.List;

public class AuditService {

    private final List<Audits> auditsList = new ArrayList<>();

    private int idCounter = 1;

    public List<Audits> getAllAudits() {
        return auditsList;
    }

    public Audits getOne(int id) {
        return auditsList.stream().filter(audits -> audits.getId() == id).findFirst().orElse(null);
    }

    public Audits save(Audits audits){
        audits.setId(idCounter++);
        auditsList.add(audits);
        return audits;
    }

    public void delete(int id){
        auditsList.removeIf(audits -> audits.getId()==id);
    }

    public String update(int id, Audits audits){
        Audits audits1 = getOne(id);
        if (audits1!=null){
            audits1.setAction(audits.getAction());
            audits1.setManagerId(audits.getManagerId());
            return "Updated!";
        }
        return "Wrong!";
    }

    public List<Audits> getByManagerId(int managerId){
        return auditsList.stream().filter(audits -> audits.getManagerId()==managerId).toList();
    }
}
