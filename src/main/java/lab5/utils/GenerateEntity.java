package lab5.utils;

import lab5.models.Challenge;
import lab5.models.Runner;
import lab5.models.Training;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateEntity {

    public static List<Challenge> genChallenge(int num){
        List<Challenge> challenges = new ArrayList<>();
        for (int i = 0; i<num; i++){
            Challenge challenge = new Challenge();
            challenge.setChallName(genStr());
            challenge.setStartDate(genStr());
            challenge.setFinishDate(genStr());
            challenge.setChallDistance(genLong());
            challenge.setChallTime(genLong());
            challenges.add(challenge);
        }
        return challenges;
    }

    public static List<Training> genTraining(int num){
        List<Training> trainingList = new ArrayList<>();
        for (int i = 0; i<num; i++) {
            Training training = new Training();
            training.setId(genLong());
            training.setDistance(genLong());
            training.setTotalTime(genStr());
            training.setDate(genStr());
            trainingList.add(training);
        }
        return trainingList;
    }

    private static List<Runner> genRunner(int num, int TrainingNums) {
        List<Runner> runnerList = new ArrayList<>();
        for (int i=0; i<num; i++) {
            Runner runner = new Runner();
            runner.setId(genLong());
            runner.setFirstName(genStr());
            runner.setLastName(genStr());
            runner.setAge(genLong());
            runner.setWeight(genLong());
            runner.setHeight(genLong());
            runner.setTrainingList(genTraining(5));
            runnerList.add(runner);
        }
        return runnerList;
    }

    private static String genStr() {
        Random random = new Random();
        char[] word = new char[random.nextInt(9)+5];
        for (int i = 0; i < word.length; i++) {
            word[i] = (char) ('a' + random.nextInt(26));
        }
        return new String(word);
    }

    private static int genInt() {
        return new Random().nextInt(10000000);
    }

    public static Long genLong() {
        return Long.valueOf(genInt());
    }
}
