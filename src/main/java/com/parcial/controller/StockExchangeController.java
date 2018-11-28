package com.parcial.controller;

import com.parcial.Services.StockExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{function}/{symbol}")
    public StringBuffer getStockExchange(@PathVariable("function") String function,@PathVariable("symbol") String symbol){
        System.out.println("ENTRADA:"+function+"/"+symbol);
        System.out.println("LLEGO?");
        return se.Consult(function,symbol);
    }

}
