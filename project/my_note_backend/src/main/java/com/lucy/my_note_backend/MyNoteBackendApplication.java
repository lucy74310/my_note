package com.lucy.my_note_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class MyNoteBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyNoteBackendApplication.class, args);
    }

}
