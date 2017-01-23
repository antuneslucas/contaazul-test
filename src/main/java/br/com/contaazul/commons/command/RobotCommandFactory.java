package br.com.contaazul.commons.command;

import javax.inject.Inject;

public class RobotCommandFactory {

    private final MoveForwardCommand moveForwardCommand;
    private final TurnRightCommand turnRightCommand;
    private final TurnLeftCommand turnLeftCommand;

    @Inject
    public RobotCommandFactory(MoveForwardCommand moveForwardCommand, TurnRightCommand turnRightCommand, TurnLeftCommand turnLeftCommand) {
        this.moveForwardCommand = moveForwardCommand;
        this.turnRightCommand = turnRightCommand;
        this.turnLeftCommand = turnLeftCommand;
    }

    public RobotCommand getRobotCommand(char commandCode) {
        switch(commandCode) {
            case 'M' : return moveForwardCommand;
            case 'R' : return turnRightCommand;
            case 'L' : return turnLeftCommand;

            default  : return null;
        }
    }

}
