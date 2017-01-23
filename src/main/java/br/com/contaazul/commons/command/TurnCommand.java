package br.com.contaazul.commons.command;

import br.com.contaazul.domain.Direction;
import br.com.contaazul.domain.Robot;

interface TurnCommand extends RobotCommand {

    /**
    * This method works like a clock, a positive value of step will turn in clockwise direction
    * and a negative value of step will turn in a counter-clockwise direction.
    * Possible values of {@link Direction} are: NORTH, EAST, SOUTH and WEST
    *
    */
    default void turn(Robot robot, int numberOfSteps) {
        int normalizedNumberOfSteps = numberOfSteps % 4;
        int newDirectionValue = (robot.getDirection().getValue() + normalizedNumberOfSteps + 4) % 4;

        robot.setDirection(Direction.getByValue(newDirectionValue));
    }

}
