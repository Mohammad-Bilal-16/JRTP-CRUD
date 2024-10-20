package com.example.mini_project_01.service;

import com.example.mini_project_01.model.Contact;
import com.example.mini_project_01.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactServices{

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public String saveContact(Contact contact) {

        contact = contactRepository.save(contact);

        if(contact.getId() != null){
            return "Contact saved successfully in D.B";
        }else{
            return "Contact failed to save in D.B";
        }
    }

    @Override
    public List<Contact> getAllContact() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(int id) {
        Optional<Contact> findById = contactRepository.findById(id);

        if(findById.isPresent()){
            return findById.get();
        }
        return null;
    }

    @Override
    public String update(Contact contact) {
        if(contactRepository.existsById(contact.getId())){
            contactRepository.save(contact);
            return "update success in D.B!!!";
        }else {
            return "No Record found!!!";
        }
    }

    @Override
    public String deleteContactById(Integer id) {

        if(contactRepository.existsById(id)) {
            contactRepository.deleteById(id);
            return "Record Deleted!!!";
        }else {
            return "No Record Found!!!";
        }

    }
}
