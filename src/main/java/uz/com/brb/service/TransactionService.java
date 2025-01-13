package uz.com.brb.service;

import uz.com.brb.model.Transactions;

import java.util.ArrayList;
import java.util.List;

public class TransactionService {

    private final List<Transactions> transactionsList = new ArrayList<>();
    private int idCounter = 1;

    public List<Transactions> getAll(){return transactionsList;}

    public Transactions getOne(int id){
        return transactionsList.stream().filter(transactions -> transactions.getId()==id).findFirst().orElse(null);
    }

    public Transactions save(Transactions transactions){
        transactions.setId(idCounter++);
        transactionsList.add(transactions);
        return transactions;
    }

    public void delete(int id){
        transactionsList.removeIf(transactions -> transactions.getId()==id);
    }

    public String update(int id, Transactions transactions){
        Transactions transaction = getOne(id);

        if (transaction!=null){
            transaction.setTransactionType(transactions.getTransactionType());
            transaction.setAmount(transactions.getAmount());
            transaction.setAccountId(transactions.getAccountId());
            return "Updated!";
        }
        return "Wrong!";
    }
}
