package com.to.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.to.Model.todo;
@Component
@Repository("todoRepository")
public interface todoRepository extends JpaRepository<todo , Integer> {
	
}

