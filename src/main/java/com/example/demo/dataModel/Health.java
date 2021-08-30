package com.example.demo.dataModel;

import lombok.Data;

@Data
public class Health {

    private String healthCheckPass = "healthCheckPass";
    private String healthCheckFailed = "healthCheckFailed";

}
