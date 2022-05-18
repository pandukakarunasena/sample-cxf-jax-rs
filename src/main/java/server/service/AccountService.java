package server.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import server.obj.Account;

@Path("/accountservice/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountService {

    Map<String, Account> accounts = new HashMap<String, Account>();

    public void init() {

        Account newAccount1 = new Account();
        newAccount1.setId(1);
        newAccount1.setName("Alvin Reyes");

        Account newAccount2 = new Account();
        newAccount2.setId(2);
        newAccount2.setName("Rachelle Ann de Guzman Reyes");

        accounts.put("1", newAccount1);
        accounts.put("2", newAccount2);

    }

    public AccountService() {
        init();
    }

    //localhost:8080/services/rservices/accountservice/accounts/{id}
    @POST
    @Path("/accounts/{id}/")
    public Account getAccount(@PathParam("id") String id) {
        Account c = accounts.get(id);
        return c;
    }

    @GET
    @Path("/accounts/getall")
    public List getAllAccounts() {
        List accountList = new ArrayList();
        for (int i = 0; i <= accounts.size(); i++) {
            accountList.add(accounts.get(i));
        }
        return accountList;
    }
}
