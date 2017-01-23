package br.com.contaazul.service;

import br.com.contaazul.domain.Robot;

public interface RobotNavigator {

    Robot navigate(Robot robot, String commands);

}
