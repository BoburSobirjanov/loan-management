package uz.com.brb.service;

import uz.com.brb.model.Loans;

import java.util.ArrayList;
import java.util.List;

public class LoanService {

    private final List<Loans> loans = new ArrayList<>();
    private  int idCounter = 1;

    public List<Loans> getAllLoans(){return loans;}

    public Loans getById(int id){
        return loans.stream().filter(loans1 -> loans1.getId()==id).findFirst().orElse(null);
    }

    public Loans create(Loans loan){
         loan.setId(idCounter++);
         loans.add(loan);
         return loan;
    }

    public void delete(int id){
        loans.removeIf(loans1 -> loans1.getId()==id);
    }

    public String update(int id, Loans loan){
        Loans loans1 = loans.stream().filter(loans2 -> loans2.getId()==id).findFirst().orElse(null);
        if (loans1!=null){
            loans1.setStatus(loan.getStatus());
            loans1.setAmount(loan.getAmount());
            loans1.setDueDate(loan.getDueDate());
            loans1.setClientId(loan.getClientId());
            loans1.setInterestRate(loan.getInterestRate());
            return "Updated loan with id: "+id;
        }
        return "Not found!";
    }
}
