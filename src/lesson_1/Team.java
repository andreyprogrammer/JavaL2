public class Team {
    Human human;
    Cat cat;
    Robot robot;

    public Team(Human human, Cat cat, Robot robot) {
        this.human = human;
        this.cat = cat;
        this.robot = robot;
    }

    public void info() {
        System.out.println("---------------------");
        if (human.isCanGo()) System.out.println(human.getName() + " выполнил задания");
            else System.out.println(human.getName() + " не выполнил задания");
        if (cat.isCanGo()) System.out.println(cat.getName() + " выполнил задания");
            else System.out.println(cat.getName() + " не выполнил задания");
        if (robot.isCanGo()) System.out.println(robot.getName() + " выполнил задания");
            else System.out.println(robot.getName() + " не выполнил задания");
    }
}
