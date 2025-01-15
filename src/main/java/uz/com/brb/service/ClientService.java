package uz.com.brb.service;

import uz.com.brb.model.Clients;

import java.util.ArrayList;
import java.util.List;

public class ClientService {

    private final List<Clients> clients = new ArrayList<>();

    private int idCounter = 1;

    public List<Clients> getAllClients(){return clients;}

    public Clients getById(int id){
        return clients.stream().filter(clients1 -> clients1.getId()==id).findFirst().orElse(null);
    }

    public boolean save(Clients client1){
        for (Clients client: clients) {
            if (client.getEmail().equals(client1.getEmail()) || client.getNumber().equals(client1.getNumber())){
                return false;
            }
        }
        client1.setId(idCounter++);
        clients.add(client1);
        return true;
    }

    public void delete(int id){
        clients.removeIf(clients1 -> clients1.getId()==id);
    }

    public String update(int id, Clients client){
        Clients clients1 = getById(id);
        if (clients1!=null){
            clients1.setNumber(client.getNumber());
            clients1.setEmail(client.getEmail());
            clients1.setName(client.getName());
            clients1.setUserId(client.getUserId());
            return "Updated!";
        }
        return "Wrong!";
    }

    public Clients getByEmail(String email){
        return clients.stream().filter(client -> client.getEmail().equals(email)).findFirst().orElse(null);
    }

    public Clients getByNumber(String number){
        return clients.stream().filter(client -> client.getNumber().equals(number)).findFirst().orElse(null);
    }
}
