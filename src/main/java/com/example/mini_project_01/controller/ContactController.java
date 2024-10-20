package com.example.mini_project_01.controller;

import com.example.mini_project_01.model.Contact;
import com.example.mini_project_01.service.ContactServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "This is contact Table..")
public class ContactController {

    @Autowired
    ContactServices contactServices;

    @ApiOperation(value = "This operation is for storing data in D.B...")
    @PostMapping("/contact")
    public String createContact(@RequestBody Contact contact){
        String status = contactServices.saveContact(contact);
        return status;
    }

    @GetMapping("/contacts")
    public List<Contact> listOfContacts(){
        return contactServices.getAllContact();
    }

    @GetMapping("/conatct/{id}")
    public Contact getContactById(@PathVariable Integer id){
        return contactServices.getContactById(id);
    }
}