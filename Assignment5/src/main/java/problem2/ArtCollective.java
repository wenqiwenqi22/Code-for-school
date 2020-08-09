package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ArtCollective is an object that has group name and list of members(artists)
 */
public class ArtCollective {
    private String groupName;
    private List<Artist> listOfMembers;

    /**
     * Constructs an ArtCollective object with a group name and list of members
     * @param groupName - the group name for the ArtCollective
     * @param listOfMembers - the list of membersfor the ArtCollective
     */
    public ArtCollective(String groupName, List<Artist> listOfMembers) {
        this.groupName = groupName;
        this.listOfMembers = listOfMembers;
    }

    /**
     * Returns the  group name of the specific ArtCollective
     * @return the group name of the specific ArtCollective
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Returns the  list of members  of the specific ArtCollective
     * @return the  list of members  of the specific ArtCollective
     */
    public List<Artist> getListOfMembers() {
        return listOfMembers;
    }

    /**
     * Returns true if two ArtCollective object has the same group name and same members, otherwise return false.
     * @param o - the object wanted to compare with
     * @return true if two ArtCollective object has the same group name and same members, otherwise return false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtCollective that = (ArtCollective) o;
        if (!groupName.equals(that.groupName)){
            return false;
        }else {
            if (listOfMembers.size() != that.listOfMembers.size()) {
                return false;
            }else {
                //copy that
                List<Artist> copy = new ArrayList<>();
                for (int i = 0; i < that.listOfMembers.size(); i++){
                    copy.add(that.listOfMembers.get(i));
                }
                // loop the list of member and check if there is a same memeber in the copy list, if yes, make it null in the copy list and break
                for (int i = 0; i < listOfMembers.size(); i++){
                    for (int j = 0; j < copy.size(); j++){
                        if (listOfMembers.get(i).equals(copy.get(j))){
                            copy.set(j, null);
                            break;
                        }
                    }
                }
                //check if the whole copy list is null, if yes, then means two list are the same,otherwise return false
                for (int i = 0; i < copy.size(); i++){
                    if (copy.get(i)!= null) {
                        return false;
                    }
                }
                return true;
            }
        }

    }

    /**
     * Return the hashcode for the ArtCollective object
     * @return the hashcode for the ArtCollective object
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(groupName);
        for (int i = 0; i < listOfMembers.size(); i++) {
            result += result + listOfMembers.get(i).getFirstName().hashCode()
                    + listOfMembers.get(i).getLastName().hashCode();
        }
        return result;
    }

    /**
     * Return the overrided toString result of ArtCollective object
     * @return the overrided toString result of ArtCollective object
     */
    @Override
    public String toString() {
        return "ArtCollective{" +
                "groupName='" + groupName + '\'' +
                ", listOfMembers=" + listOfMembers +
                '}';
    }
}
