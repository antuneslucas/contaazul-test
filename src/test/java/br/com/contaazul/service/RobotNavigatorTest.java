package br.com.contaazul.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.com.contaazul.commons.command.MoveForwardCommand;
import br.com.contaazul.commons.command.RobotCommandFactory;
import br.com.contaazul.commons.command.TurnLeftCommand;
import br.com.contaazul.commons.command.TurnRightCommand;
import br.com.contaazul.domain.Direction;
import br.com.contaazul.domain.Robot;
import br.com.contaazul.service.impl.RobotNavigatorImpl;

public class RobotNavigatorTest {

    @Spy private MoveForwardCommand moveForwardCommand;
    @Spy private TurnRightCommand turnRightCommand;
    @Spy private TurnLeftCommand turnLeftCommand;
    @InjectMocks private RobotCommandFactory robotCommandFactory;

    private RobotNavigator robotNavigator;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        robotNavigator = new RobotNavigatorImpl(robotCommandFactory);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowExceptionIfRobotIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Robot cannot be null!");
        robotNavigator.navigate(null, "MML");
    }

    @Test
    public void shouldThrowExceptionIfCommandsAreNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Commands cannot be empty!");
        navigate(null);
    }

    @Test
    public void shouldThrowExceptionIfCommandsAreEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Commands cannot be empty!");
        navigate("");
    }

    @Test
    public void shouldThrowExceptionIfCommandsAreInvalid() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid command found: 'A'!");
        navigate("MMLA");
    }

    @Test
    public void shouldThrowExceptionIfRobotGoOutsideOfDelimitedAreaNorth() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Robot tried to navigate outside the specified range!");
        navigate("MMMMMM"); //move 6 positions to north in a square of length 5
    }

    @Test
    public void shouldThrowExceptionIfRobotGoOutsideOfDelimitedAreaEast() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Robot tried to navigate outside the specified range!");
        navigate("RMMMMMM"); //move 6 positions to east in a square of length 5
    }

    @Test
    public void shouldThrowExceptionIfRobotGoOutsideOfDelimitedAreaSouth() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Robot tried to navigate outside the specified range!");
        navigate("RRM"); //move 1 positions to south while in position (0,0)
    }

    @Test
    public void shouldThrowExceptionIfRobotGoOutsideOfDelimitedAreaWest() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Robot tried to navigate outside the specified range!");
        navigate("LM"); //move 1 positions to west while in position (0,0)
    }

    @Test
    public void shouldMoveOnlyOneStepForward() {
        Robot robot = navigate("M");

        assertThat(robot, is(notNullValue()));
        assertThat(robot.toString(), is("(0, 1, N)"));

        assertThat(robot.getX(), is(0));
        assertThat(robot.getY(), is(1));
        assertThat(robot.getDirection(), is(Direction.NORTH));
    }

    @Test
    public void shouldFaceEastInSamePositionAfterTurningRight() {
        Robot robot = navigate("R");
        assertThat(robot.toString(), is("(0, 0, E)"));
    }

    @Test
    public void shouldFaceWestInSamePositionAfterTurningLeft() {
        Robot robot = navigate("L");
        assertThat(robot.toString(), is("(0, 0, W)"));
    }

    @Test
    public void shouldFaceNorthInSamePositionAfterDoingACompleteCircle() {
        Robot robot = navigate("LLLL");
        assertThat(robot.toString(), is("(0, 0, N)"));

        Robot robot2 = navigate("RRRR");
        assertThat(robot2.toString(), is("(0, 0, N)"));
    }

    @Test
    public void shouldBeAbleToWalkThroughTheWholeDelimitedArea() {
        Robot robot = navigate("MMMMMRMMMMMRMMMMMRMMMMM");
        assertThat(robot.toString(), is("(0, 0, W)"));
    }

    @Test
    public void shouldAcceptLowerCaseCommandsAsWell() { //my assumption, it's not a requirement of the challenge
        Robot robot = navigate("mmmmm");
        assertThat(robot.toString(), is("(0, 5, N)"));
    }

    private Robot navigate(String commands) {
        return robotNavigator.navigate(new Robot(), commands);
    }

}
