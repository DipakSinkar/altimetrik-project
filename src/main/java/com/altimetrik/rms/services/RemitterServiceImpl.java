package com.altimetrik.rms.services;

import com.altimetrik.rms.entity.Remitter;
import com.altimetrik.rms.repository.IRemitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Service
public class RemitterServiceImpl implements IRemitterService{
    @Autowired
    IRemitterRepository iRemitterRepository;
    @Override
    public Remitter registerRemitter(Remitter remitter) {
        return iRemitterRepository.save(remitter) ;
    }

    @Override
    public Remitter getRemitterById(int remitterAccNo) {
        Optional<Remitter> opt=iRemitterRepository.findById(remitterAccNo);
        Remitter remitter=null;
        if(opt.isPresent())
        {
            remitter=opt.get();
        }
        return remitter;
    }
    @Override
    public Remitter updateRemitter(Remitter remitter) {
        Optional<Remitter> opt=iRemitterRepository.findById(remitter.getRemitterAccountNumber());
        if(!opt.isEmpty())
        {
            iRemitterRepository.save(remitter);
        }
        return remitter;
    }

}
