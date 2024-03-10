package com.parking.domain.vehicle;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.parking.domain.users.Users;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Vehicle {
    @Id
    private String id;

    @JsonProperty("vehicle_brand")
    private String brand;

    private String model;

    @JsonProperty("vehicle_plate")
    private String plate;

    @DBRef
    private Users user;
}
