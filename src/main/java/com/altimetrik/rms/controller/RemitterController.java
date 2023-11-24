package com.altimetrik.rms.controller;

import com.altimetrik.rms.entity.Remitter;
import com.altimetrik.rms.services.IRemitterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:5173")
@Controller
public class RemitterController {
    @Autowired
    private IRemitterService iRemitterService;
    @PostMapping(path="/registerRemitter")
    @ResponseBody
    public Remitter registerCustomer(@RequestBody Remitter remitter)
    {
        //service layer
        return iRemitterService.registerRemitter(remitter);
    }
    @GetMapping(path="/getRemitter/{remitter_account_number}")
    @ResponseBody
    public Remitter getRemitterByAccountNumber(@PathVariable("remitter_account_number")int remitterAccNo)
    {
        //service layer
        return iRemitterService.getRemitterById(remitterAccNo);
    }
    @RequestMapping(path="/updateRemitter",method = RequestMethod.PUT)
    @ResponseBody
    public Remitter updateCustomerById(@RequestBody Remitter remitter)
    {
        //service layer
        return iRemitterService.updateRemitter(remitter);
    }
    @GetMapping(path="/getUserName")
    @ResponseBody
    public Remitter getUserName(@PathVariable("remitter_account_number")int remitterAccNo)
    {
        //service layer
        return iRemitterService.getRemitterById(remitterAccNo);
    }

}
