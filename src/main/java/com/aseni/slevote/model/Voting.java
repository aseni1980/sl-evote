package com.aseni.slevote.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Voting extends AbstractModel<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long votingid;

    @Column
    private Long voterid;

    @Column
    private Long memberid;

}
