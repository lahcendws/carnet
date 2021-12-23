package com.example.carnetdevoyage.entity;

import javax.persistence.Entity;
import javax.persistence.*;

import javax.persistence.GenerationType;
@Entity
public class Liens {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String galerie;
    private String webSite;
    private String lienUtile;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private Etape etape;

    public Etape getEtape() {
        return etape;
    }

    public void setEtape(Etape etape) {
        this.etape = etape;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Liens() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGalerie() {
        return galerie;
    }

    public void setGalerie(String galerie) {
        this.galerie = galerie;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getLienUtile() {
        return lienUtile;
    }

    public void setLienUtile(String lienUtile) {
        this.lienUtile = lienUtile;
    }

    public Liens(Long id, String galerie, String webSite, String lienUtile) {
        this.id = id;
        this.galerie = galerie;
        this.webSite = webSite;
        this.lienUtile = lienUtile;
    }
}
