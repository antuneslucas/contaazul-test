package br.com.contaazul.commons.command;

import br.com.contaazul.domain.Robot;

public class TurnLeftCommand implements TurnCommand {

    @Override
    public void execute(Robot robot) {
        turn(robot, -1);
    }

}
