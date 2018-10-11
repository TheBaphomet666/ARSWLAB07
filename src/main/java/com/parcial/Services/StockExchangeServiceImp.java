package com.parcial.Services;

import com.parcial.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class StockExchangeServiceImp implements StockExchange {
    @Autowired
    Connector con;


    @Override
    public StringBuffer Consult(String Symbol, String Mode) {
        StringBuffer response=null;
        try {
            response=con.Fetch(Symbol,Mode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
