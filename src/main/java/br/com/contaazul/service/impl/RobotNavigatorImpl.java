package br.com.contaazul.service.impl;

import static java.util.Objects.isNull;

import javax.inject.Inject;

import br.com.contaazul.commons.command.RobotCommand;
import br.com.contaazul.commons.command.RobotCommandFactory;
import br.com.contaazul.domain.Robot;
import br.com.contaazul.service.RobotNavigator;

public class RobotNavigatorImpl implements RobotNavigator {

    //improvement:
    // maybe receive these values in the constructor to make it more generic,
    // or load it from a property file and set in the @PostConstruct
    private static final int MIN_X = 0;
    private static final int MIN_Y = 0;
    private static final int MAX_X = 5;
    private static final int MAX_Y = 5;

    private final RobotCommandFactory robotCommandFactory;

    @Inject
    public RobotNavigatorImpl(RobotCommandFactory robotCommandFactory) {
        this.robotCommandFactory = robotCommandFactory;
    }

    @Override
    public Robot navigate(Robot robot, String commands) {
        if(isNull(robot))
            throw new IllegalArgumentException("Robot cannot be null!");

        if(isEmpty(commands))
            throw new IllegalArgumentException("Commands cannot be empty!");

        for(char command : commands.toUpperCase().toCharArray())
            applyCommand(robot, command);

        return robot;
    }

    private void applyCommand(Robot robot, char commandCode) {
        RobotCommand robotCommand = robotCommandFactory.getRobotCommand(commandCode);
        if(isNull(robotCommand))
            throw new IllegalArgumentException(String.format("Invalid command found: '%c'!", commandCode));

        robotCommand.execute(robot);

        if(!isRobotStateValid(robot))
            throw new IllegalArgumentException("Robot tried to navigate outside the specified range!");
    }

    private boolean isRobotStateValid(Robot robot) {
        return isInValidRange(robot.getX(), MIN_X, MAX_X) && isInValidRange(robot.getY(), MIN_Y, MAX_Y);
    }

    private boolean isInValidRange(int numberToVerify, int min, int max) {
        return min <= numberToVerify && numberToVerify <= max;
    }

    private boolean isEmpty(String str) {
        return isNull(str) || str.isEmpty();
    }

}
