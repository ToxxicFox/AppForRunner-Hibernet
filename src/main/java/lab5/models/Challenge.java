package lab5.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Table
@Entity
public class Challenge {
    @Id
    @GeneratedValue(generator = "increment")
    @Column
    private Long id;

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

    @ManyToMany(mappedBy = "challenges")
    private List<Runner> runnerList;

    public Challenge() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Runner> getRunnerList() {
        return runnerList;
    }

    public void setRunnerList(List<Runner> runnerList) {
        this.runnerList = runnerList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Challenge challenge = (Challenge) o;
        return Objects.equals(id, challenge.id) && Objects.equals(challName, challenge.challName) && Objects.equals(startDate, challenge.startDate) && Objects.equals(finishDate, challenge.finishDate) && Objects.equals(challDistance, challenge.challDistance) && Objects.equals(challTime, challenge.challTime) && Objects.equals(runnerList, challenge.runnerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, challName, startDate, finishDate, challDistance, challTime, runnerList);
    }
}
