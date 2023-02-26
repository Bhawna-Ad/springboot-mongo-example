package com.example.sbmongoexample.controller;

import com.example.sbmongoexample.model.Student;
import com.example.sbmongoexample.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Properties;

@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

//    private final JavaMailSender mailSender;
//
//    private final String toEmail;
//
//    private final String fromEmail;
//
//    public StudentController(JavaMailSender mailSender, @Value("${email.to}") String toEmail, @Value("${email.from}") String fromEmail) {
//        this.mailSender = mailSender;
//        this.toEmail = toEmail;
//        this.fromEmail = fromEmail;
//    }

//    @Bean
//    public JavaMailSender javaMailSender() {
//        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
//        javaMailSender.setHost("smtp.gmail.com");
//        javaMailSender.setPort(587);
//        javaMailSender.setUsername(@gmail.com");
//        javaMailSender.setPassword("");
//
//        Properties props = javaMailSender.getJavaMailProperties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.debug", "true");
//
//        return javaMailSender;
//    }

    @PostMapping("/")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        Student data = this.studentRepository.save(student);
//        sendEmail("Added new data", "Added new Student data.");
        return ResponseEntity.ok(data);
    }

//    private void sendEmail(String subject, String text) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(fromEmail);
//        message.setTo(toEmail);
//        message.setSubject(subject);
//        message.setText(text);
//        mailSender.send(message);
//    }

    @GetMapping("/")
    public ResponseEntity<?> getStudents() {
        return ResponseEntity.ok(this.studentRepository.findAll());
    }
}
