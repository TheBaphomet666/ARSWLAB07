package com.parcial.Services;

import com.parcial.DbConnector.DbConnector;
import com.parcial.DbConnector.Metadata.Information;
import com.parcial.Services.ServicesImp.StockExchange;
import com.parcial.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.NoSuchElementException;

@Service
public class StockExchangeServiceImp implements StockExchange {
    @Autowired
    Connector con;
    @Autowired
    DbConnector db;

    @Override
    public StringBuffer Consult(String function, String symbol) {
        StringBuffer response=null;
        try {
            //System.out.println("DB TRYING");
            response=new StringBuffer(db.findById(function + "/" + symbol).get().metaData);
            //System.out.println("DB FOUND");
        }
        catch (NoSuchElementException ex){
           // System.out.println("SAVING");
           // System.out.println("EXCEPTION"+ex);
                try {
                    response = con.Fetch(function, symbol);
                    db.save(new Information(function+"/"+symbol,response.toString()));
                    //System.out.println("SAVED");
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }

        return response;
    }
}
