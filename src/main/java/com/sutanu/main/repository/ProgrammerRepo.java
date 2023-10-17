package com.sutanu.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sutanu.main.model.Programmer;

@Repository // helps to understand that it is a repo
public interface ProgrammerRepo extends JpaRepository<Programmer, Integer> {

}
