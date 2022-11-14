package TeamMode;

import entities.RealPlayer;

public class TeamPlayer extends RealPlayer {
        private Team teamOfPlayer;
        public TeamPlayer(String name, Team team){
                super(name);
                teamOfPlayer=team;
        }

        public String getTeamName() {
                return teamOfPlayer.getName();
        }

        public void setTeamName(String name) {
                this.teamOfPlayer.setName(name);
        }

        public Team getTeamOfPlayer() {
                return teamOfPlayer;
        }

        public void setTeamOfPlayer(Team teamOfPlayer) {
                this.teamOfPlayer = teamOfPlayer;
        }
}
