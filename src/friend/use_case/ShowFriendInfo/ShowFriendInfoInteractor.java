package friend.use_case.ShowFriendInfo;

import friend.view.FriendViewManager;

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
        FriendViewManager friendViewManager = this.showFriendInfoPresenter.getFriendViewManager();
        ShowFriendInfoOutputData showFriendInfoOutputData = new ShowFriendInfoOutputData(currentUserName,friendUsername,friendGmail,friendViewManager);

        this.showFriendInfoPresenter.prepareSuccessView(showFriendInfoOutputData);
    }
}
