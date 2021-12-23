package com.example.carnetdevoyage.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Etape {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ville;
    private Date dateEtape;
    private String resume;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private Destination destination;

    public Etape() {
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateEtape() {
        return dateEtape;
    }

    public void setDateEtape(Date dateEtape) {
        this.dateEtape = dateEtape;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Etape(Long id, String ville, Date dateEtape, String resume, User user, Destination destination) {
        this.id = id;
        this.ville = ville;
        this.dateEtape = dateEtape;
        this.resume = resume;
        this.user = user;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Etape{" +
                "id=" + id +
                ", ville='" + ville + '\'' +
                ", dateEtape=" + dateEtape +
                ", resume='" + resume + '\'' +
                ", user=" + user +
                ", destination=" + destination +
                '}';
    }
}
