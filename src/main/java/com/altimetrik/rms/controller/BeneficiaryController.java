package com.altimetrik.rms.controller;

import com.altimetrik.rms.entity.Beneficiary;
import com.altimetrik.rms.entity.Remitter;
import com.altimetrik.rms.repository.IBeneficiaryRepository;
import com.altimetrik.rms.services.IBeneficiaryService;
import com.altimetrik.rms.services.IRemitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BeneficiaryController {
    @Autowired
    private IBeneficiaryService iBeneficiaryService;
    @PostMapping(path="/addBeneficiary")
    @ResponseBody
    public Beneficiary registerBeneficiary(@RequestBody Beneficiary beneficiary)
    {
        //service layer
        return iBeneficiaryService.addBeneficiary(beneficiary);
    }
    @PutMapping(path="/updateBeneficiary")
    @ResponseBody
    public Beneficiary updateBeneficiary(@RequestBody Beneficiary beneficiary)
    {
        //service layer
        return iBeneficiaryService.updateBeneficiary(beneficiary);
    }
}
