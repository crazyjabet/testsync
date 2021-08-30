package com.example.demo.service;

import com.example.demo.entityModel.MemberAccountJPA;
import com.example.demo.repository.MemberAccountJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberAccountJPARepository memberRepository;

    public List<MemberAccountJPA> getAllMembers(){
        return memberRepository.findAll();
    }

    public Long addMember() {
        MemberAccountJPA memberAccountJPA = new MemberAccountJPA();
        memberAccountJPA.setAddress("aa12398765AAAA");
        memberAccountJPA.setEmail("aa@gmail.com");
        memberAccountJPA.setCellphone("0987654321");
        return memberRepository.save(memberAccountJPA).getId();
    }

}
