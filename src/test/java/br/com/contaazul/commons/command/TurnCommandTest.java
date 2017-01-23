package br.com.contaazul.commons.command;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doCallRealMethod;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.contaazul.domain.Direction;
import br.com.contaazul.domain.Robot;

@RunWith(MockitoJUnitRunner.class)
public class TurnCommandTest {

    @Mock TurnCommand turnCommand;

    @Before
    public void init() {
        doCallRealMethod().when(turnCommand).turn(any(Robot.class), any(Integer.class));
    }

    @Test
    public void testTurnOnceToTheRight() {
        Robot robot = buildRobot(Direction.NORTH);
        turnCommand.turn(robot, 1);

        assertThat(robot.toString(), is("(0, 0, E)"));
    }

    @Test
    public void testTurnFiveTimesToTheRight() {
        Robot robot = buildRobot(Direction.NORTH);
        turnCommand.turn(robot, 5);

        assertThat(robot.toString(), is("(0, 0, E)"));
    }

    @Test
    public void testTurnOnceToTheLeft() {
        Robot robot = buildRobot(Direction.NORTH);
        turnCommand.turn(robot, -1);

        assertThat(robot.toString(), is("(0, 0, W)"));
    }

    @Test
    public void testTurnFiveTimesToTheLeft() {
        Robot robot = buildRobot(Direction.NORTH);
        turnCommand.turn(robot, -5);

        assertThat(robot.toString(), is("(0, 0, W)"));
    }

    private Robot buildRobot(Direction direction) {
        return new Robot(0, 0, direction);
    }

}
