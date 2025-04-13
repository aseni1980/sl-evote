package com.aseni.slevote.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member extends AbstractModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberid;

    @Column(nullable = false, length = 150)
    private String fullname;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "partyid")
    private Party party;

    @Column(nullable = false, length = 150)
    private String qualification;

    @Column(nullable = true)
    private String imageurl;


}
