import java.awt.event.ActionEvent;

public class YDirectionAction extends AbstractDirectionAction {
    public YDirectionAction(MovementState movementState, int value) {
        super(movementState, value);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getMovementState().yDirection = getValue();
    }
}