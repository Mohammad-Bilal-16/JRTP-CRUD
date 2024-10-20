package com.example.mini_project_01.repository;

import com.example.mini_project_01.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact , Integer> {
}
