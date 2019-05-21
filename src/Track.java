public class Track {
    private int value;

    public Track(int value) {
        this.value = value;
    }

    public void doIt(Team team) {
        if (team.human.getLengthMax() >= value) {
            team.human.run(value);
            team.human.setCanGo(true);
        } else {
            team.human.run(value);
            System.out.println(team.human.getName() + " выбывает из соревнований");
        }

        if (team.cat.getLengthMax() >= value) {
            team.cat.setCanGo(true);
            team.cat.run(value);
        } else {
            team.cat.run(value);
            System.out.println(team.cat.getName() + " выбывает из соревнований");
        }

        if (team.robot.getLengthMax() >= value) {
            team.robot.setCanGo(true);
            team.robot.run(value);
        } else {
            team.robot.run(value);
            System.out.println(team.robot.getName() + " выбывает из соревнований");
        }
        System.out.println("--------------------");
    }
}
