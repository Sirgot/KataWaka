package waka.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import waka.access.User;
import waka.conta.Movimiento;

import javax.persistence.*;

@Repository
public class JPAWakaRepository {

    private static final Logger log = LoggerFactory.getLogger(JPAWakaRepository.class);
    private MovementStore movementStore;
    private UserStore userStore;

    public boolean saveUser (User param) {
        return userStore.save(param) != null;
    }

    public boolean saveMovement (Movimiento param) {
        return movementStore.save(param) != null;
    }


    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate (User user) {
        if (user.getId() == 0) {
            log.info("[USER AUDIT] About to add a user");
        } else {
            log.info("[USER AUDIT] About to update/delete user: " + user.getId());
        }
    }

    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate (User user) {
        log.info("[USER AUDIT] add/update/delete complete for user: " + user.getId());
    }

    @PostLoad
    private void afterLoad (User user) {
        log.info("[USER AUDIT] user loaded from database: " + user.getId());
    }
}
