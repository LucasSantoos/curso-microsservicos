package com.santos.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santos.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
