package com.everis.msbootcoin.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document
@Builder
@Getter
@Setter
public class BootCoinAccount {

    @Id
    private String id;
    private String docNumber;
    private DocType docType;
    private String email;
    private String phoneNumber;
    private BigDecimal accountBalance;
    private Date createdAt;
    private Date modifiedAt;
}
