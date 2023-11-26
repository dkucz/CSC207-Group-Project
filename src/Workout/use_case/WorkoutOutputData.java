package Workout.use_case;

import entity.User;

public class WorkoutOutputData {
    private final String username;
    private final User user;
    private boolean useCaseFailed;

    public WorkoutOutputData(String username, User user, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public User getUser() { return this.user; }
}
