package com.restapi.restapi.models.vanue;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Type {
    @Id
    @GeneratedValue
    private Long id;
    private String type;

    public Type(String type) {
        this.type = type;
    }
    public Type() {

    }
}
