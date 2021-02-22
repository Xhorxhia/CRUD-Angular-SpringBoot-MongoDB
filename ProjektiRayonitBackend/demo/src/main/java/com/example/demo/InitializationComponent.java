package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Camera;
import com.example.demo.repository.CameraRepository;

public class InitializationComponent {
	
	@Autowired
    private CameraRepository rep;

    @PostConstruct
    private void init(){
        
        rep.deleteAll();

        Camera c =new Camera();
        c.setId(1);
        c.setName("Sony");
        c.setModel("334FF");
        c.setResolution("140");
        c.setIp("224535");
        rep.save(c);

    }     
}
