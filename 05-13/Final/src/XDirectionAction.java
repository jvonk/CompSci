import java.awt.event.ActionEvent;

public class XDirectionAction extends AbstractDirectionAction {
    public XDirectionAction(MovementState movementState, int value) {
        super(movementState, value);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getMovementState().xDirection = getValue();
    }
}