package com.altimetrik.rms.services;

import com.altimetrik.rms.entity.Beneficiary;

public interface IBeneficiaryService {
    public Beneficiary addBeneficiary(Beneficiary beneficiary);
    public Beneficiary updateBeneficiary(Beneficiary beneficiary);
}
