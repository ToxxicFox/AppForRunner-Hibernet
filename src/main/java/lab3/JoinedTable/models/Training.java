package lab3.JoinedTable.models;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Training {
    @Id
    @GeneratedValue(generator = "increment")
    @Column
    private long id;

    @Column
    private long distance;

    @Column
    private String typeOfTraining;

    @Column
    private long duration;

    public Training() {};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public String getTypeOfTraining() {
        return typeOfTraining;
    }

    public void setTypeOfTraining(String typeOfTraining) {
        this.typeOfTraining = typeOfTraining;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", distance=" + distance +
                ", typeOfTraining=" + typeOfTraining +
                ", duration=" + duration +
                '}';
    }
}
