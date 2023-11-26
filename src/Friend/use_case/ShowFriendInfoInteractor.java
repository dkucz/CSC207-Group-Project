package Friend.use_case;

public class ShowFriendInfoInteractor implements ShowFriendInfoInputBoundary{
    private final ShowFriendInfoOutputBoundary showFriendInfoPresenter;
    public ShowFriendInfoInteractor(ShowFriendInfoOutputBoundary showFriendInfoPresenter){
        this.showFriendInfoPresenter = showFriendInfoPresenter;
    }
    @Override
    public void execute(ShowFriendInfoInputData showFriendInfoInputData) {
        String currentUserName = showFriendInfoInputData.getCurrentUserName();
        String friendUsername = showFriendInfoInputData.getFriendUsername();
        String friendGmail = showFriendInfoInputData.getFriendGmail();
        ShowFriendInfoOutputData showFriendInfoOutputData = new ShowFriendInfoOutputData(currentUserName,friendUsername,friendGmail);

        this.showFriendInfoPresenter.prepareSuccessView(showFriendInfoOutputData);
    }
}
