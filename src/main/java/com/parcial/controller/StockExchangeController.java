package com.parcial.controller;

import com.parcial.Services.StockExchange;
import com.parcial.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController("/StockExchange")
public class StockExchangeController {

    @Autowired
    StockExchange se;

    @RequestMapping()
    public String getTestString(){


        return "hola mundo!!";
    }

   /* @PostMapping()
    public void postData(@RequestBody Todo todo){

    }

*/
    @GetMapping("/{Symbol}/{Mode}")
    public StringBuffer getStockExchange(@PathVariable("Symbol") String Symbol,@PathVariable("Mode") String Mode){
        System.out.println("ENTRADA:"+Symbol+"_"+Mode);
        System.out.println("LLEGO?");
        return se.Consult("MSFT",Mode);
    }

}
