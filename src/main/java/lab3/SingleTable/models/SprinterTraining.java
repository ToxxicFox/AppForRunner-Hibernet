package lab3.SingleTable.models;

import lab3.JoinedTable.models.Training;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class SprinterTraining extends Training {

    @Column
    private long avgLap;

    @Column
    private long numSegments;

    @Column
    private long totalDistance;

    @Column
    private long bestSigment;

    public SprinterTraining() {};

    public long getAvgLap() {
        return avgLap;
    }

    public void setAvgLap(long avgLap) {
        this.avgLap = avgLap;
    }

    public long getNumSegments() {
        return numSegments;
    }

    public void setNumSegments(long numSegments) {
        this.numSegments = numSegments;
    }

    public long getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(long totalDistance) {
        this.totalDistance = totalDistance;
    }

    public long getBestSigment() {
        return bestSigment;
    }

    public void setBestSigment(long bestSigment) {
        this.bestSigment = bestSigment;
    }

    @Override
    public String toString() {
        return "Training{" + super.toString() +
                "avgLap=" + avgLap +
                ", numSegments=" + numSegments +
                ", totalDistance=" + totalDistance +
                ", bestSigment=" + bestSigment +
                '}';
    }
}
