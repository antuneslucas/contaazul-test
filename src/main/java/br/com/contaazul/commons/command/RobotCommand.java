package br.com.contaazul.commons.command;

import br.com.contaazul.domain.Robot;

public interface RobotCommand {

    void execute(Robot robot);

}
