public class Wall {
    private int value;

    public Wall(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void doIt(Team team) {
        if (team.human.isCanGo()) {
            if (team.human.getHeightMax() >= value) {
                team.human.jump(value);
            } else {
                team.human.jump(value);
                System.out.println(team.human.getName() + " выбывает из соревнований");
                team.human.setCanGo(false);
            }
        }

        if (team.cat.isCanGo()) {
            if (team.cat.getHeightMax() >= value) {
                team.cat.jump(value);
            } else {
                team.cat.jump(value);
                System.out.println(team.cat.getName() + " выбывает из соревнований");
                team.cat.setCanGo(false);
            }
        }

        if (team.robot.isCanGo()) {
            if (team.robot.getHeightMax() >= value) {
                team.robot.jump(value);
            } else {
                team.robot.jump(value);
                System.out.println(team.robot.getName() + " выбывает из соревнований");
                team.robot.setCanGo(false);
            }
        }
    }
}
