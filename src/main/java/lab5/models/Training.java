package lab5.models;

import javax.persistence.*;
import java.util.Objects;

@Table
@Entity
public class Training {
    @Id
    @GeneratedValue(generator = "increment")
    @Column
    private Long id;

    @Column
    private Long distance;

    @Column
    private String totalTime;

    @Column
    private String date;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ch_id", referencedColumnName = "id")
    private Challenge challenge = new Challenge();

    public Training() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Training training = (Training) o;
        return Objects.equals(id, training.id) && Objects.equals(distance, training.distance) && Objects.equals(totalTime, training.totalTime) && Objects.equals(date, training.date) && Objects.equals(challenge, training.challenge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, distance, totalTime, date, challenge);
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", distance=" + distance +
                ", totalTime='" + totalTime + '\'' +
                ", date='" + date + '\'' +
                ", challenge=" + challenge +
                '}';
    }
}
