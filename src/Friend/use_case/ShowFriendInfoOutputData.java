package Friend.use_case;

import java.util.ArrayList;

public class ShowFriendInfoOutputData{
    private String currentUserName;
    private String friendUserName;
    private String friendGmail;
    public ShowFriendInfoOutputData(String currentUserName,String friendUserName, String friendGmail){
        this.currentUserName = currentUserName;
        this.friendUserName = friendUserName;
        this.friendGmail = friendGmail;
    }
    public ArrayList<String> getOutputDataAsAList() {
        ArrayList<String> outputDataList = new ArrayList<>();
        outputDataList.add(this.currentUserName);
        outputDataList.add(this.friendUserName);
        outputDataList.add(this.friendGmail);
        return outputDataList;
    }
}
