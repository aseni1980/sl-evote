package com.aseni.slevote.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResultDto{

    private Long votingid;
    private Long voterid;
    private Long memberid;
    private String fullname;
    private String logo_url;
    private String percentage;
    private Long totalVotes;
    private Long wonVotes;
    private String partyName;

}
