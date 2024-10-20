package com.example.mini_project_01.service;

import com.example.mini_project_01.model.Contact;

import java.util.List;

public interface ContactServices {

    public String saveContact(Contact contact);
    public List<Contact> getAllContact();
    public Contact getContactById(int id);
    public String update(Contact contact);
    public String deleteContactById(Integer id);
}
