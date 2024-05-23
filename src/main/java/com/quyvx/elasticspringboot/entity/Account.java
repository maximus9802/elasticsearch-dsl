package com.quyvx.elasticspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "bank")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {
    @Id
    @JsonProperty("_id")
    private String id;

    @JsonProperty("account_number")
    private Long accountNumber;


    private Long balance;

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    private Long age;

    private String gender;

    private String address;

    private String employer;

    private String email;

    private String city;

    private String state;
}
