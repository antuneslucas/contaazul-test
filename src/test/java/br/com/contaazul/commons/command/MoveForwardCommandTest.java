package br.com.contaazul.commons.command;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.contaazul.domain.Direction;
import br.com.contaazul.domain.Robot;

@RunWith(MockitoJUnitRunner.class)
public class MoveForwardCommandTest {

    @Spy MoveForwardCommand moveForwardCommand;

    @Test
    public void shouldMoveTowardsNorth() {
        Robot robot = buildRobotAt2x2Position(Direction.NORTH);
        moveForwardCommand.execute(robot);

        assertThat(robot.toString(), is("(2, 3, N)"));
    }

    @Test
    public void shouldMoveTowardsSouth() {
        Robot robot = buildRobotAt2x2Position(Direction.SOUTH);
        moveForwardCommand.execute(robot);

        assertThat(robot.toString(), is("(2, 1, S)"));
    }

    @Test
    public void shouldMoveTowardsEast() {
        Robot robot = buildRobotAt2x2Position(Direction.EAST);
        moveForwardCommand.execute(robot);

        assertThat(robot.toString(), is("(3, 2, E)"));
    }

    @Test
    public void shouldMoveTowardsWest() {
        Robot robot = buildRobotAt2x2Position(Direction.WEST);
        moveForwardCommand.execute(robot);

        assertThat(robot.toString(), is("(1, 2, W)"));
    }

    private Robot buildRobotAt2x2Position(Direction direction) {
        return new Robot(2, 2, direction);
    }

}
