package lab5.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table
@Entity
public class Runner {
    @Id
    @GeneratedValue(generator = "increment")
    @Column
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Long age;

    @Column
    private Long weight;

    @Column
    private Long height;

    @Column
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Training> trainingList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "RUNNER_CHALLS",
            joinColumns = @JoinColumn(name = "Runner_id"),
            inverseJoinColumns = @JoinColumn(name = "Challenge_id")
    )
    private List<Challenge> challenges = new ArrayList<>();

    public Runner() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public List<Training> getTrainingList() {
        return trainingList;
    }

    public void setTrainingList(List<Training> trainingList) {
        this.trainingList = trainingList;
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Runner runner = (Runner) o;
        return Objects.equals(id, runner.id) && Objects.equals(firstName, runner.firstName) && Objects.equals(lastName, runner.lastName) && Objects.equals(age, runner.age) && Objects.equals(weight, runner.weight) && Objects.equals(height, runner.height) && Objects.equals(trainingList, runner.trainingList) && Objects.equals(challenges, runner.challenges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, weight, height, trainingList, challenges);
    }

    @Override
    public String toString() {
        return "Runner{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", trainingList=" + trainingList +
                ", challenges=" + challenges +
                '}';
    }
}
