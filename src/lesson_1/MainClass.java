public class MainClass {
    public static void main(String[] args) {
        Human human = new Human("Вася");
        Cat cat = new Cat("Барсик");
        Robot robot = new Robot("R2D2");

        Track track = new Track(200);
        Wall wall = new Wall(2);

        Team team = new Team(human, cat, robot);
        track.doIt(team);
        wall.doIt(team);
        team.info();
    }
}
