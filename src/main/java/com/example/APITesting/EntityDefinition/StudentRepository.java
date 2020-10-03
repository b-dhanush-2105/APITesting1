package com.example.APITesting.EntityDefinition;

import org.springframework.data.jpa.repository.JpaRepository;

interface StudentRepository extends JpaRepository<StudentEntity,Long> {

}
