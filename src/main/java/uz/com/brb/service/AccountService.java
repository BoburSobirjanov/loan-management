package uz.com.brb.service;

import uz.com.brb.model.Accounts;

import java.util.ArrayList;
import java.util.List;

public class AccountService {

    private final List<Accounts> accountsList = new ArrayList<>();
    private int idCounter = 1;

    public List<Accounts> getAllAccountsList() {
        return accountsList;
    }

    public Accounts getOne(int id) {
        return accountsList.stream().filter(accounts -> accounts.getId() == id).findFirst().orElse(null);
    }

    public Accounts save(Accounts accounts) {
        accounts.setId(idCounter++);
        accountsList.add(accounts);
        return accounts;
    }

    public void delete(int id) {
        accountsList.removeIf(accounts -> accounts.getId() == id);
    }

    public String update(int id, Accounts accounts){
        Accounts accounts1 = getOne(id);
        if (accounts1!=null){
            accounts1.setAccountType(accounts.getAccountType());
            accounts1.setBalance(accounts.getBalance());
            accounts1.setClientId(accounts.getClientId());
            accounts1.setInterestRate(accounts.getInterestRate());
            return "Updated!";
        }
        return "Wrong!";
    }

    public List<Accounts> getByClientId(int clientId){
        return accountsList.stream().filter(accounts -> accounts.getClientId()==clientId).toList();
    }

    public List<Accounts> getByAccountType(String type){
        return accountsList.stream().filter(accounts -> accounts.getAccountType().equals(type.toUpperCase())).toList();
    }
}
