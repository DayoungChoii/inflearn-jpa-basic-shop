package jpabook.jpashop;

import jpabook.entitymapping.Team;
import jpabook.entitymapping.User;
import jpabook.jpashop.domain.Member;

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
            em.persist(team);

            User user = new User();
            user.setUsername("user1");
            user.setTeam(team);
            em.persist(user);

            em.flush();
            em.clear();

            User foundMember = em.find(User.class, user.getId());
            List<User> users = foundMember.getTeam().getUserList();

            for (User u : users) {
                System.out.println("u = " + u.getId() );
            }

            tx.commit();
        } catch (Exception e) {

        }finally {
            em.close();
        }
        emf.close();
    }
}
