package Friend.use_case;

public class DeleteFriendOutputData {
    boolean deleteSuccess;
    public DeleteFriendOutputData(boolean deleteSuccess){
        this.deleteSuccess = deleteSuccess;
    }
    public boolean isDeleteSuccess() {
        return deleteSuccess;
    }
}
