package objectsAndClasses.src;

import java.util.*;

public class Teamwork {
    static class Team {
        private String teamName;
        private String creator;
        private List<String> member;

        public Team(String teamName, String creator) {
            this.creator = creator;
            this.teamName = teamName;
            this.member = new ArrayList<>();
        }

        public Integer getMembersCount() {
            return this.member.size();
        }

        public String getTeamName() {
            return this.teamName;
        }

        public String getCreator() {
            return this.creator;
        }

        public List<String> getMember() {
            return this.member;
        }

        public void sortMembers(List<String> member) {
            Collections.sort(this.member);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Team> teamList = new ArrayList<>();

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String[] teamToRegister = scanner.nextLine().split("\\-");
            String creator = teamToRegister[0];
            String teamName = teamToRegister[1];

            if (doesTeamExist(teamList, teamName)) {
                System.out.printf("Team %s was already created!%n", teamName);
            } else {
                if (doesCreatorExist(teamList, creator)) {
                    System.out.printf("%s cannot create another team!\n", creator);
                } else {
                    System.out.printf("Team %s has been created by %s!%n", teamName, creator);
                    Team team = new Team(teamName, creator);
                    teamList.add(team);
                }
            }
        }

        String input = scanner.nextLine();
        while (!"end of assignment".equals(input)) {
            String[] userToJoin = input.split("->");
            String user = userToJoin[0];
            String teamName = userToJoin[1];

            if (!doesTeamExist(teamList, teamName)) {
                System.out.printf("Team %s does not exist!%n", teamName);
            } else {
                if (doesMemberExist(teamList, user)) {
                    System.out.printf("Member %s cannot join team %s!%n", user, teamName);
                } else {
                    addMember(teamList, user, teamName);
                }
            }
            input = scanner.nextLine();
        }

        teamList.stream()
                .filter(team -> team.getMember().size() > 0)
                .sorted(Comparator.comparing(Team::getMembersCount)
                        .reversed()
                        .thenComparing(Team::getTeamName)).forEach(team -> {
                    System.out.println(team.getTeamName());
                    System.out.println("- " + team.getCreator());
                    team.getMember().stream().sorted(String::compareTo).forEach(member -> {
                        System.out.println("-- " + member);
                    });
                });

        System.out.println("Teams to disband:");
        teamList.stream()
                .filter(team -> team.getMembersCount() == 0)
                .sorted(Comparator.comparing(Team::getTeamName))
                .forEach(team -> System.out.println(team.getTeamName().trim()));
    }

    private static void addMember(List<Team> teamList, String user, String teamName) {
        teamList.stream().forEach(team -> {
            if (team.getTeamName().equals(teamName)) {
                team.getMember().add(user);
            }
        });
    }

    private static boolean doesMemberExist(List<Team> teamList, String user) {
        for (Team team : teamList) {
            if (team.getMember().contains(user) || team.getCreator().equals(user)) {
                return true;
            }
        }
        return false;
    }

    private static boolean doesCreatorExist(List<Team> teamList, String creator) {
        for (Team team : teamList) {
            if (team.getCreator().equals(creator)) {
                return true;
            }
        }
        return false;
    }

    private static boolean doesTeamExist(List<Team> teamList, String teamName) {
        for (Team team : teamList) {
            if (team.getTeamName().equals(teamName)) {
                return true;
            }
        }
        return false;
    }
}