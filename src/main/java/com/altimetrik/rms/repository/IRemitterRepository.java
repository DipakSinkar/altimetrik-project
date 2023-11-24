package com.altimetrik.rms.repository;

import com.altimetrik.rms.entity.Remitter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRemitterRepository extends JpaRepository<Remitter,Integer> {
}
