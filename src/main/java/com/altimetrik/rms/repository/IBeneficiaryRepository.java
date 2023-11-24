package com.altimetrik.rms.repository;

import com.altimetrik.rms.entity.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBeneficiaryRepository extends JpaRepository<Beneficiary,Integer> {
}
