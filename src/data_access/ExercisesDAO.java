package data_access;

import Workout.data_access.WorkoutDataAccessInterface;
import entity.User;
import entity.Workout;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ExercisesDAO implements WorkoutDataAccessInterface {



    public void getExercisesInfo(Workout workout, String muscle) {
        //Muscle Examples: triceps, shoulders, biceps, shoulders, back, shoulders,

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://exercises-by-api-ninjas.p.rapidapi.com/v1/exercises?muscle="+muscle)
                .get()
                .addHeader("X-RapidAPI-Key", "a8fc50a2c9msh57dbb5dc403db24p16e3edjsn380e88665efe")
                .addHeader("X-RapidAPI-Host", "exercises-by-api-ninjas.p.rapidapi.com")
                .build();


        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string(); // Store the response body in a variable
            //System.out.println(response);
            if (responseBody.equals("[]")) {
                System.out.println("No exercises found for this muscle");
                workout.setExercisesInfo("No exercises found for this muscle");
                return;
            }
            workout.setExercisesInfo(responseBody);
            System.out.println(responseBody);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void findOfType(Workout workout, String type) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://exercises-by-api-ninjas.p.rapidapi.com/v1/exercises?type="+type)
                .get()
                .addHeader("X-RapidAPI-Key", "a8fc50a2c9msh57dbb5dc403db24p16e3edjsn380e88665efe")
                .addHeader("X-RapidAPI-Host", "exercises-by-api-ninjas.p.rapidapi.com")
                .build();

        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string(); // Store the response body in a variable
            //System.out.println(response);
            workout.setExercisesInfo(responseBody);
            if (responseBody.equals("[]")) {
                System.out.println("No exercises found for this type");
                return;
            }
            System.out.println(responseBody);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void exercisesOnDifficulty(Workout workout, String difficulty) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://exercises-by-api-ninjas.p.rapidapi.com/v1/exercises?difficulty="+difficulty)
                .get()
                .addHeader("X-RapidAPI-Key", "a8fc50a2c9msh57dbb5dc403db24p16e3edjsn380e88665efe")
                .addHeader("X-RapidAPI-Host", "exercises-by-api-ninjas.p.rapidapi.com")
                .build();


        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string(); // Store the response body in a variable
            System.out.println(response);
            workout.setExercisesInfo(responseBody);
            if (responseBody.equals("[]")) {
                System.out.println("Not a valid difficulty");
                return;
            }
            System.out.println(responseBody);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addExercise(String user, String exerciseName, int day) {}

    @Override
    public void save(User user) throws ExecutionException, InterruptedException {

    }

    @Override
    public ArrayList<ArrayList<String>> getExerciseSchedule(String username) throws ExecutionException, InterruptedException {
        return null;
    }

    @Override
    public ArrayList<ArrayList<String>> addExerciseToSchedule(String username, int day, String exerciseName) throws ExecutionException, InterruptedException {
        return null;
    }

    @Override
    public boolean hasFiveExercises(String username, int day) throws ExecutionException, InterruptedException {
        return false;
    }

    @Override
    public boolean exerciseScheduleExists(String username) throws ExecutionException, InterruptedException {
        return false;
    }


    @Override
    public boolean existsByMuscle(String identifer) {
        String[] validMuscles = {
                "abdominals", "abductors", "adductors", "biceps", "calves",
                "chest", "forearms", "glutes", "hamstrings", "lats",
                "lower_back", "middle_back", "neck", "quadriceps", "traps", "triceps"
        };

        for (String muscle : validMuscles) {
            if (muscle.equalsIgnoreCase(identifer)) {
                return true; // Input matches a valid muscle
            }
        }

        return false;
    }

    @Override
    public boolean existsByType(String type){


        String[] validTypes = {
            "cardio", "olympic_weightlifting", "plyometrics", "powerlifting",
            "strength", "stretching", "strongman"
        };

        for (String muscle : validTypes) {
        if (muscle.equalsIgnoreCase(type)) {
            return true;
            }
        }

        return false;
    }

    @Override
    public boolean existsByDifficulty(String difficulty) {
        String[] validMuscles = {
                "beginner", "intermediate", "expert"
        };

        for (String muscle : validMuscles) {
            if (muscle.equalsIgnoreCase(difficulty)) {
                return true;
            }
        }

        return false;
    }

}
