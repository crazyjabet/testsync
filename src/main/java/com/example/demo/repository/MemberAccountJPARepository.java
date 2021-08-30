package com.example.demo.repository;

import com.example.demo.entityModel.MemberAccountJPA;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MemberAccountJPARepository extends CrudRepository<MemberAccountJPA, Long> {

    List<MemberAccountJPA> findAll();

    List<MemberAccountJPA> findByEmail(String email);

}

