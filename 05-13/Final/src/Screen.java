import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Screen extends JPanel {
    public MainPlayer p;
    private MovementState movementState;
    private MovementState position;
    Frame main;
    public Inventory i;
    public ArrayList<Player> players;

    public Screen(Frame main, Inventory i) {
        i.items.add(new Item(0, 0));
        setOpaque(true);
        this.main = main;
        players = new ArrayList<>();
        this.i = i;
        movementState = new MovementState();
        position = new MovementState();
        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_I, 0), "inventory");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "down-pressed");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "down-released");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "down-pressed");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "down-released");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "up-pressed");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "up-released");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "up-pressed");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "up-released");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "left-pressed");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "left-released");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "left-pressed");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "left-released");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "right-pressed");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "right-released");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "right-pressed");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "right-released");

        am.put("inventory", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.actionPerformed(e);
            }
        });
        am.put("down-pressed", new YDirectionAction(movementState, 5));
        am.put("down-released", new YDirectionAction(movementState, 0));
        am.put("up-pressed", new YDirectionAction(movementState, -5));
        am.put("up-released", new YDirectionAction(movementState, 0));
        am.put("left-pressed", new XDirectionAction(movementState, -5));
        am.put("left-released", new XDirectionAction(movementState, 0));
        am.put("right-pressed", new XDirectionAction(movementState, 5));
        am.put("right-released", new XDirectionAction(movementState, 0));

        p = new MainPlayer(300, 300);
        new java.util.Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (movementState.xDirection==0||movementState.yDirection==0) {
                    p.x += movementState.xDirection;
                    p.y += movementState.yDirection;
                } else {
                    p.x += movementState.xDirection*2/3;
                    p.y += movementState.yDirection*2/3;
                }
                if (p.x < -p.width/2) {
                    if (position.xDirection>-1) {
                        position.xDirection--;
                        updatePosition();
                        p.x = getWidth() + p.width/2;
                    } else {
                        p.x = -p.width/2;
                    }
                } else if (p.x > getWidth() + p.width/2) {
                    if (position.xDirection<1) {
                        position.xDirection++;
                        updatePosition();
                        p.x = -p.width/2;
                    } else {
                        p.x = getWidth() + p.width/2;
                    }
                }
                if (p.y < 0) {
                    if (position.yDirection>-1) {
                        position.yDirection--;
                        updatePosition();
                        p.y = getHeight()+p.height;
                    } else {
                        p.y = 0;
                    }
                } else if (p.y > getHeight()+p.height) {
                    if (position.yDirection<1) {
                        position.yDirection++;
                        updatePosition();
                        p.y = 0;
                    } else {
                        p.y = getHeight()+p.height;
                    }
                }
                updateSpeaking();
                repaint();
            }
        }, 0, 1000/60);
    }

    public void updateSpeaking() {
        for (Player player : players) {
            player.speaking = p.intersects(player);
        }
    }

    public void updatePosition() {
        players.clear();
        if (position.yDirection==-1) {
            if (position.xDirection==-1) {

            } else if (position.xDirection==0) {

            } else if (position.xDirection==1) {

            }
        } else if (position.yDirection==0) {
            if (position.xDirection==-1) {

            } else if (position.xDirection==0) {
                Player player = new Player(100, 100);
                players.add(player);
            } else if (position.xDirection==1) {

            }
        } else if (position.yDirection==1) {
            if (position.xDirection==-1) {

            } else if (position.xDirection==0) {

            } else if (position.xDirection==1) {

            }
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Dimension d = getPreferredSize();
        if (position.yDirection==-1) {
            if (position.xDirection==-1) {

            } else if (position.xDirection==0) {

            } else if (position.xDirection==1) {

            }
        } else if (position.yDirection==0) {
            if (position.xDirection==-1) {

            } else if (position.xDirection==0) {
                g.setColor(Color.BLUE);
                g.fillRect(0, 0, d.width, d.height);

            } else if (position.xDirection==1) {

            }
        } else if (position.yDirection==1) {
            if (position.xDirection==-1) {

            } else if (position.xDirection==0) {

            } else if (position.xDirection==1) {

            }
        }
        for (Player player : players) {
            player.drawMe(g);
        }
        p.drawMe(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }

    public class MovementState {
        public int xDirection;
        public int yDirection;
    }

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

    public class YDirectionAction extends AbstractDirectionAction {
        public YDirectionAction(MovementState movementState, int value) {
            super(movementState, value);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getMovementState().yDirection = getValue();
        }
    }

    public class XDirectionAction extends AbstractDirectionAction {
        public XDirectionAction(MovementState movementState, int value) {
            super(movementState, value);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getMovementState().xDirection = getValue();
        }
    }
}