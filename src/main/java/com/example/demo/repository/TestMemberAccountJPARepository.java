package com.example.demo.repository;

import com.example.demo.entityModel.MemberAccountJPA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestMemberAccountJPARepository extends JpaRepository<MemberAccountJPA, Long> {

    List<MemberAccountJPA> findAll();

    List<MemberAccountJPA> findByEmail(String email);

}