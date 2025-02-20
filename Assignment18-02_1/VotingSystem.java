import java.util.*;
public class VotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>();
    private Map<String, Integer> orderedVoteMap = new LinkedHashMap<>();
    private Map<String, Integer> sortedVoteMap = new TreeMap<>();
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        orderedVoteMap.put(candidate, orderedVoteMap.getOrDefault(candidate, 0) + 1);
        sortedVoteMap.put(candidate, sortedVoteMap.getOrDefault(candidate, 0) + 1);
    }
    public Map<String, Integer> getVotesInOrder() {
        return new LinkedHashMap<>(orderedVoteMap);
    }
    public Map<String, Integer> getVotesSorted() {
        return new TreeMap<>(sortedVoteMap);
    }
    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        system.castVote("Khushi");
        system.castVote("Piyush");
        system.castVote("Khushi");
        system.castVote("Aditya");
        system.castVote("Piyush");
        System.out.println("Votes in order: " + system.getVotesInOrder());
        System.out.println("Votes sorted: " + system.getVotesSorted());
    }
}
