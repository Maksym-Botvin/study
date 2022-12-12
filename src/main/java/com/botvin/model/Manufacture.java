package com.botvin.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Manufacture {
    private String manufacture;

    public Manufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}
