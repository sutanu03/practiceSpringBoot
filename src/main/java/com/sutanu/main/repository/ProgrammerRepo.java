package com.sutanu.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sutanu.main.model.Programmer;

@Repository // helps to understand that it is a repo
public interface ProgrammerRepo extends JpaRepository<Programmer, Integer> {

	// using query dsl
	//List<Programmer> findBypLang(String pLang);
	
	// using query annotation
	//in traditional way we write : select * from programmer where pLang = ?
	@Query("from Programmer where pLang = ?1")
	List<Programmer> findName(String pLang);

}
