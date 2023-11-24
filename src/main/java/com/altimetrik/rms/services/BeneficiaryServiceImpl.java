package com.altimetrik.rms.services;

import com.altimetrik.rms.entity.Beneficiary;
import com.altimetrik.rms.entity.Remitter;
import com.altimetrik.rms.repository.IBeneficiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BeneficiaryServiceImpl implements IBeneficiaryService {
    @Autowired
    IBeneficiaryRepository iBeneficiaryRepository;

    @Override
    public Beneficiary addBeneficiary(Beneficiary beneficiary) {
        {
            return iBeneficiaryRepository.save(beneficiary);
        }
    }

    @Override
    public Beneficiary updateBeneficiary(Beneficiary beneficiary) {
        Optional<Beneficiary> opt = iBeneficiaryRepository.findById(beneficiary.getBeneficiaryAccountNumber());

        if (opt.isPresent()) {
            Beneficiary existingBeneficiary = opt.get();

            existingBeneficiary.setCurrentBalance(beneficiary.getCurrentBalance());
            iBeneficiaryRepository.save(existingBeneficiary);
            return existingBeneficiary;
        }

        return null;
    }
}
