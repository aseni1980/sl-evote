package com.aseni.slevote.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Party extends AbstractModel<Long> {

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 250)
    private String address;

    @Column(nullable = false, length = 150)
    private String secretaryname;

    @Column(nullable = false, length = 15)
    private String telephone;

    @Column(nullable = true)
    private String logo_url;

    @Column(nullable = false, unique = true)
    private Integer acknowledged = 0;


}
