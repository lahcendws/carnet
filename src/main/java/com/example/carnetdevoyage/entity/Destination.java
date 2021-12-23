package com.example.carnetdevoyage.entity;

import javax.persistence.*;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Date;

@Entity
public class Destination {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pays;
    private Date dateDebut;
    private Date dateFin;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public User getUser() {
        return user;
    }
    public Destination() {
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    public Destination(Long id, String pays, Date dateDebut, Date dateFin, User user) {
        this.id = id;
        this.pays = pays;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.user = user;
    }

}
