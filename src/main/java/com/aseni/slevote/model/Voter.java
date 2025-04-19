package com.aseni.slevote.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Voter extends AbstractModel<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voterid;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 250)
    private String address;

    @Column(nullable = false, length = 15)
    private String nic;

    @Column(nullable = false, length = 100)
    private String district;

    @Column(nullable = false, length = 100)
    private String province;

    @Column(nullable = true)
    private String postalcode;

    @Column(nullable = false)
    private String officeid;

    @Column(nullable = false)
    private String status = "PENDING";

}
