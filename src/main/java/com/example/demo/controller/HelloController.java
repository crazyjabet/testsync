package com.example.demo.controller;

import com.example.demo.dataModel.Health;
import com.example.demo.entityModel.MemberAccountJPA;
import com.example.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Slf4j
@RestController
//@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    MemberService memberService;

    @GetMapping("/health")
    public String greeting() {
        log.info("hello");
        System.err.println("====== Error hello ======");
        return new Health().getHealthCheckPass();
    }

    @GetMapping("/add")
    public String add(){
        return String.valueOf(memberService.addMember());
    }

    @GetMapping("/dbtest")
    public String getDbData() {
        List<MemberAccountJPA> allMembers = memberService.getAllMembers();
        log.info("memberService.getAllMembers() length=>" + allMembers.size());
        log.info("===== address ====>" + allMembers.get(0).getAddress());
        return allMembers.toString();
    }

    @GetMapping("/priv")
    public String priv() {
        log.info("priv");
        System.err.println("====== priv hello ======");
        try{
//            URL url = new URL("http://example.com");
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            con.setRequestMethod("GET");
//            con.setDoOutput(true);
//            DataOutputStream out = new DataOutputStream(con.getOutputStream());
//            out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
//            out.flush();
//            out.close();
// Create a neat value object to hold the URL
            URL url = new URL("http://fargate-test-728461985.us-west-2.elb.amazonaws.com:8080/test/health");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("accept", "text/html");
            InputStream responseStream = connection.getInputStream();
            StringBuilder out = new StringBuilder();
            final int bufferSize = 1024;
            final char[] buffer = new char[bufferSize];
            Reader in = new InputStreamReader(responseStream, "UTF-8");
            for (; ; ) {
                int rsz = in.read(buffer, 0, buffer.length);
                if (rsz < 0)
                    break;
                out.append(buffer, 0, rsz);
            }
            return "API Response=>" + out.toString();
        }catch(Exception e){
            e.printStackTrace();
            return "error";
        }
    }

}
