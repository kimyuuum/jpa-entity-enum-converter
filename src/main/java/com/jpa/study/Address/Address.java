package com.jpa.study.Address;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class Address {

    @Column(name = "address")
    @JsonProperty("address_main")
    private String address;

    @Column(name = "address_detail")
    @JsonProperty("address_detail")
    private String addressDetail;

    @Column(name = "zipcode")
    @JsonProperty("zipcode")
    private String zipCode;

    @Builder
    public Address(String address, String addressDetail, String zipCode){
        this.address = address;
        this.addressDetail = addressDetail;
        this.zipCode = zipCode;
    }

    public String getFullAddress() {
        return this.address + " "
                + this.addressDetail + " "
                + this.zipCode;
    }

}

