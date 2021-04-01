package lab4.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Challenge {

    @Column
    private Long chId;

    @Column
    private String challName;

    @Column
    private String startDate;

    @Column
    private String finishDate;

    @Column
    private Long challDistance;

    @Column
    private Long challTime;


    public Challenge() {};

    public Long getChId() {
        return chId;
    }

    public void setChId(Long chId) {
        this.chId = chId;
    }

    public String getChallName() {
        return challName;
    }

    public void setChallName(String challName) {
        this.challName = challName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public Long getChallDistance() {
        return challDistance;
    }

    public void setChallDistance(Long challDistance) {
        this.challDistance = challDistance;
    }

    public Long getChallTime() {
        return challTime;
    }

    public void setChallTime(Long challTime) {
        this.challTime = challTime;
    }

    @Override
    public String toString() {
        return "Challenge{" +
                "chId=" + chId +
                ", challName='" + challName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", finishDate='" + finishDate + '\'' +
                ", challDistance=" + challDistance +
                ", challTime=" + challTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Challenge challenge = (Challenge) o;
        return Objects.equals(chId, challenge.chId) && Objects.equals(challName, challenge.challName) && Objects.equals(startDate, challenge.startDate) && Objects.equals(finishDate, challenge.finishDate) && Objects.equals(challDistance, challenge.challDistance) && Objects.equals(challTime, challenge.challTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chId, challName, startDate, finishDate, challDistance, challTime);
    }
}
