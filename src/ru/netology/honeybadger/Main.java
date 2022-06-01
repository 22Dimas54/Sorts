package ru.netology.honeybadger;

public class Main {

    public static void main(String[] args) {
        int[][] regionalTeams = {{45, 31, 24, 22, 20, 17, 14, 13, 12, 10}, {31, 18, 15, 12, 10, 8, 6, 4, 2, 1}, {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}};
        for (int e : nationalTeam(regionalTeams)) {
            System.out.println(e);
        }
    }

    private static int[] nationalTeam(int[][] regionalTeams) {
        int[] team = regionalTeams[0];
        for (int i = 1; i < regionalTeams.length; i++) {
            team = merge(team, regionalTeams[i]);
        }
        return team;
    }

    private static int[] merge(int[] team, int[] regionalTeam) {
        int[] result = new int[team.length];
        int ia = 0;
        int ib = 0;
        int ic = 0;
        while (ia < team.length || ib < regionalTeam.length) {
            if (ia == team.length) {
                result[ic] = regionalTeam[ib];
                ib++;
            } else if (ib == regionalTeam.length) {
                result[ic] = team[ia];
                ia++;
            } else {
                if (team[ia] >= regionalTeam[ib]) {
                    result[ic] = team[ia];
                    ia++;
                } else {
                    result[ic] = regionalTeam[ib];
                    ib++;
                }
                ic++;
                if (result[result.length - 1] != 0) {
                    return result;
                }
            }
        }
        return result;
    }
}
