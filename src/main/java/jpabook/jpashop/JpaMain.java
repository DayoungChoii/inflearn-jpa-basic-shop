package jpabook.jpashop;

import jpabook.entitymapping.Team;
import jpabook.entitymapping.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //저장
            Team team = new Team();
            team.setName("TeamA");
//            team.getUserList().add(user);
            em.persist(team);

            User user = new User();
            user.setUsername("user1");
            user.changeTeam(team);
            em.persist(user);

            em.flush();
            em.clear();

            Team foundTeam = em.find(Team.class, team.getTeamId());
            List<User> userList = foundTeam.getUserList();
            for (User u : userList) {
                System.out.println("u = " + u.getUsername());
            }

            tx.commit();
        } catch (Exception e) {

        }finally {
            em.close();
        }
        emf.close();
    }
}
