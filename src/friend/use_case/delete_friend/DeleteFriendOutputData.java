package friend.use_case.delete_friend;

public class DeleteFriendOutputData {
    String deletedFriendUsername;
    boolean deleteSuccess;
    public DeleteFriendOutputData(boolean deleteSuccess, String deletedFriendUsername){
        this.deleteSuccess = deleteSuccess;
        this.deletedFriendUsername = deletedFriendUsername;
    }
    public boolean isDeleteSuccess() {
        return deleteSuccess;
    }
    public String getDeletedFriendUsername(){
        return this.deletedFriendUsername;
    }
}
