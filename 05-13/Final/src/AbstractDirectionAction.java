import javax.swing.*;

public abstract class AbstractDirectionAction extends AbstractAction {
    private final MovementState movementState;
    private final int value;

    public AbstractDirectionAction(MovementState movementState, int value) {
        this.movementState = movementState;
        this.value = value;
    }

    public MovementState getMovementState() {
        return movementState;
    }

    public int getValue() {
        return value;
    }
}