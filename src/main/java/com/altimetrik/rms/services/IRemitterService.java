package com.altimetrik.rms.services;

import com.altimetrik.rms.entity.Remitter;

public interface IRemitterService {
public Remitter registerRemitter(Remitter remitter);
public Remitter getRemitterById(int remitterAccountNumber);
public Remitter updateRemitter(Remitter remitter);
}
