package com.example.myapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

@Entity
@Table(name = "winchmore_tennis_club")
public class winchmoretennisclub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "court_type")
    private String courtType;

    @Column(name = "availability_status")
    private String availabilityStatus;

    @Column(name = "court_number")
    private Integer courtNumber;

    @Transient
    private String clubName = "Winchmore Tennis Club";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourtType() {
        return courtType;
    }

    public void setCourtType(String courtType) {
        this.courtType = courtType;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public Integer getCourtNumber() {
        return courtNumber;
    }

    public void setCourtNumber(Integer courtNumber) {
        this.courtNumber = courtNumber;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public static List<winchmoretennisclub> findByCourtTypeAndAvailability(EntityManager entityManager, String courtType, String availabilityStatus, Integer courtNumber) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<winchmoretennisclub> cq = cb.createQuery(winchmoretennisclub.class);
        Root<winchmoretennisclub> root = cq.from(winchmoretennisclub.class);

        cq.select(root)
          .where(
              cb.equal(root.get("courtType"), courtType),
              cb.equal(root.get("availabilityStatus"), availabilityStatus),
              cb.equal(root.get("courtNumber"), courtNumber)
          );

        return entityManager.createQuery(cq).getResultList();
    }
}
