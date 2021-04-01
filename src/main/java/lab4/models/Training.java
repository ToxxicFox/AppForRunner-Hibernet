package lab4.models;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Table
@Entity
public class Training {

    @Id
    @GeneratedValue(generator = "increment")
    @Column
    private Long Id;

    @Column
    private Long distance;

    @ElementCollection
    @CollectionTable(name = "Tags")
    @Column
    private Set<String> tags;

    @ElementCollection
    @CollectionTable(name = "Challenges")
    @OrderColumn
    @Column
    private List<String> challenges;

    @ElementCollection
    @CollectionTable(name = "Weather")
    @MapKeyColumn(name = "Weath")
    @Column
    private Map<String, String> weather;

    @ElementCollection
    @CollectionTable(name = "ChallengeList")
    @AttributeOverride(
            name = "challName",
            column = @Column(name = "chl_name")
    )
    private Set<Challenge> challengeSet;

    @Column
    private String totalTime;

    @Column
    private String date;

    public Training() {};

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public List<String> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<String> challenges) {
        this.challenges = challenges;
    }

    public Map<String, String> getWeather() {
        return weather;
    }

    public void setWeather(Map<String, String> weather) {
        this.weather = weather;
    }

    public Set<Challenge> getChallengeSet() {
        return challengeSet;
    }

    public void setChallengeSet(Set<Challenge> challengeSet) {
        this.challengeSet = challengeSet;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Training training = (Training) o;
        return Id.equals(training.Id) && distance.equals(training.distance) && tags.equals(training.tags) && challenges.equals(training.challenges) && weather.equals(training.weather) && challengeSet.equals(training.challengeSet) && totalTime.equals(training.totalTime) && date.equals(training.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, distance, tags, challenges, weather, challengeSet, totalTime, date);
    }

    @Override
    public String toString() {
        return "Training{" +
                "Id=" + Id +
                ", distance=" + distance +
                ", tags=" + tags +
                ", challenges=" + challenges +
                ", weather=" + weather +
                ", challengeSet=" + challengeSet +
                ", totalTime='" + totalTime + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
