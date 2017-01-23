package br.com.contaazul.commons.command;

import br.com.contaazul.domain.Robot;

public class MoveForwardCommand implements RobotCommand {

    @Override
    public void execute(Robot robot) {
        switch (robot.getDirection()) {
            case NORTH:
                robot.increaseY();
                break;
            case SOUTH:
                robot.decreaseY();
                break;
            case EAST:
                robot.increaseX();
                break;
            case WEST:
                robot.decreaseX();
                break;
        }
    }

}
