package com.app.admin.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.admin.model.UnIdentifiedPerson;

@Repository
public interface UnIdentifiedPersonRepository extends CrudRepository<UnIdentifiedPerson, Long> {

	UnIdentifiedPerson findByName(String name);

	UnIdentifiedPerson findById(int id);
	List<UnIdentifiedPerson> findAll();


}
