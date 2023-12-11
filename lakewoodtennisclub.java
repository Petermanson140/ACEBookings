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
@Table(name = "lakewoodtennisclub")
public class lakewoodtennisclub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other fields

    @Column(name = "surfacetype")
    private String surfacetype;

    @Column(name = "availability_status")
    private String availabilityStatus;

    @Transient
    private String clubName = "Lakewood Tennis Club";

    // Getters and setters for the fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Other getters and setters for other fields

    public String getSurfacetype() {
        return surfacetype;
    }

    public void setSurfacetype(String surfacetype) {
        this.surfacetype = surfacetype;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    // Method to retrieve courts by surfacetype with club name and availability status
    public static List<lakewoodtennisclub> findBySurfacetypeWithClubNameAndAvailability(EntityManager entityManager, String surfacetype, String availabilityStatus) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<lakewoodtennisclub> cq = cb.createQuery(lakewoodtennisclub.class);
        Root<lakewoodtennisclub> root = cq.from(lakewoodtennisclub.class);

        cq.select(root)
          .where(
              cb.equal(root.get("surfacetype"), surfacetype),
              cb.equal(root.get("availabilityStatus"), availabilityStatus)
          );

        return entityManager.createQuery(cq).getResultList();
    }
}
