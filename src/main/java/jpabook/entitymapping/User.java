package jpabook.entitymapping;

import javax.persistence.*;

@Entity
public class User {

    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long Id;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name="TEAM_ID")
//    private Long teamId;

    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;

    @OneToOne
    @JoinColumn(name="LOCKER_ID")
    private Locker locker;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   /* public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }*/

    public Team getTeam() {
        return team;
    }

    //연관관계 메소드
    public void changeTeam(Team team) {
        this.team = team;
        team.getUserList().add(this);
    }
}
