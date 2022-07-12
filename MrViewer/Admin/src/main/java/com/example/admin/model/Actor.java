package com.example.admin.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actorId")
    private long actorId;

    @NotBlank
    @NotNull
    @Column(name = "actorName")
    private String actorName;

    @NotBlank
    @NotNull
    @Column(name = "actorGender")
    private String actorGender;

    public Actor() {
    }

    public Actor(long actorId, String actorName, String actorGender) {
        this.actorId = actorId;
        this.actorName = actorName;
        this.actorGender = actorGender;
    }

    public long getActorId() {
        return this.actorId;
    }

    public void setActorId(long actorId) {
        this.actorId = actorId;
    }

    public String getActorName() {
        return this.actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorGender() {
        return this.actorGender;
    }

    public void setActorGender(String actorGender) {
        this.actorGender = actorGender;
    }

    public Actor actorId(long actorId) {
        setActorId(actorId);
        return this;
    }

    public Actor actorName(String actorName) {
        setActorName(actorName);
        return this;
    }

    public Actor actorGender(String actorGender) {
        setActorGender(actorGender);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " actorId='" + getActorId() + "'" +
                ", actorName='" + getActorName() + "'" +
                ", actorGender='" + getActorGender() + "'" +
                "}";
    }
}
