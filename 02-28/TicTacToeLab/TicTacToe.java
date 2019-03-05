import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.util.List;
import java.util.*;
import javax.sound.sampled.*;

public class TicTacToe {
    public TicTacToe() {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }
            JFrame frame = new JFrame("TicTacToe");
            frame.getContentPane().setBackground(Color.white);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JLabel l = new JLabel("WINS", JLabel.CENTER);
            Game g = new Game(l);
            g.setBackground(Color.white);
            frame.add( l, BorderLayout.NORTH);
            frame.add(g);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
    public static void main(String[] args) {
        new TicTacToe();
    }
    public class Game extends JPanel {
        private int[] wins = new int[2];
        private Cell[][] board;
        private Image[] images;
        private int turn = -1;
        private boolean over, mode;
        private JLabel l;
        public Game (JLabel l) {
            this.l = l;
            set(true);
        }
        public void updateLabel() {
            l.setFont(new Font(l.getFont().getName(), Font.PLAIN, getWidth()/20));
        }
        public void set(boolean original) {
            l.setText("WINS      X: "+String.valueOf(wins[0])+"      O: "+String.valueOf(wins[1]));
            mode = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO PLAY AGAINST A AI?", "CHOOSE MODE", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            over = false;
            setLayout(new BoardLayoutManager());
            if(original) board = new Cell[3][3];
            removeAll();
            turn = -1;
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    if (original) {
                        board[row][col] = new Cell();
                        final int r = row, c = col;
                        board[row][col].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                setSelected(r, c);
                            }
                        });
                        board[row][col].addComponentListener(new ComponentAdapter() {
                            @Override
                            public void componentResized(ComponentEvent e) {
                                updateLabel();
                                Cell btn = (Cell) e.getComponent();
                                if (btn != null)
                                    btn.resetIcon(btn.type == -1 ? null : images[btn.type]);
                            }
                        });
                    }
                    board[row][col].type = -1;
                    board[row][col].setBackground(Color.WHITE);
                    add(board[row][col], new Point(col, row));
                    board[row][col].setSize(1, 1);
                }
            }
            images = new Image[2];
            for (int i = 0; i < 2; i++) {
                try {
                    images[i] = ImageIO.read(new File(i == 0 ? "image/BLACK.png" : "image/WHITE.png"));
                } catch (Exception ec) {
                    ec.printStackTrace();
                    System.exit(1);
                }
            }
            turn = wins[0]>wins[1]?1:0;
            final int w = 2;
            board[0][1].setBorder(new MatteBorder(0, w, 0, w, Color.BLACK));
            board[1][0].setBorder(new MatteBorder(w, 0, w, 0, Color.BLACK));
            board[1][2].setBorder(new MatteBorder(w, 0, w, 0, Color.BLACK));
            board[2][1].setBorder(new MatteBorder(0, w, 0, w, Color.BLACK));
            board[1][1].setBorder(new MatteBorder(w, w, w, w, Color.BLACK));
        }

        public boolean checkTicTacToe() {
            for (int i = 0; i < 3; i++) {
                if (board[i][0].type==turn&&board[i][1].type==turn&&board[i][2].type==turn) return true;
                if (board[0][i].type==turn&&board[1][i].type==turn&&board[2][i].type==turn) return true;
            }
            if (board[0][0].type==turn&&board[1][1].type==turn&&board[2][2].type==turn) return true;
            if (board[2][0].type==turn&&board[1][1].type==turn&&board[0][2].type==turn) return true;
            return false;
        }

        public boolean checkFull() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].type==-1) return false;
                }
            }
            return true;
        }

        public void move (int row, int col) {
            board[row][col].type = turn;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j].resetIcon(board[i][j].type==-1?null:images[board[i][j].type]);
                }
            }
            if (checkTicTacToe()) {
                playSound("win.wav");
                wins[turn]++;
                if (JOptionPane.showConfirmDialog(null, (turn==0 ? "X" : "O") + " WINS! RESTART?", "GAME OVER", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    set(false);
                } else {
                    over = true;
                }
            } else if (checkFull()) {
                playSound("tie.wav");
                if (JOptionPane.showConfirmDialog(null, "TIE! RESTART?", "GAME OVER", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    set(false);
                } else {
                    over = true;
                }
            }
            if (turn!=-1)turn = (turn+1)%2;
        }
        public synchronized void playSound(final String url) {
            try {
                Clip clip = AudioSystem.getClip();
                clip.stop();
                clip.open(AudioSystem.getAudioInputStream(new File("sound/" + url)));
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(url);
                System.exit(1);
            }
        }

        public Point calcMove() {
            for (int i = 0; i < 3; i++) {
                int prev = (i+2)%3;
                int next = (i+1)%3;
                for (int j = 0; j < 3; j++) {
                    if (board[prev][j].type==turn&&board[next][j].type==turn&&board[i][j].type==-1) return new Point(i, j);
                    if (board[j][prev].type==turn&&board[j][next].type==turn&&board[j][i].type==-1) return new Point(j, i);
                }
                if (board[prev][prev].type==turn&&board[next][next].type==turn&&board[i][i].type==-1) return new Point(i, i);
                if (board[2-prev][prev].type==turn&&board[2-next][next].type==turn&&board[2-i][i].type==-1) return new Point(2-i, i);
            }
            for (Point p : new Point[] {new Point(1, 1), new Point(0, 0), new Point(0, 2), new Point(2, 0), new Point(2, 2),
                    new Point(0, 1), new Point(1, 0), new Point(1, 2), new Point(2, 1)}) {
                if (board[p.x][p.y].type==-1) {
                    return p;
                }
            }
            return null;
        }
        public void setSelected(int row, int col) {
            if (over) return;
            if (board[row][col].type==-1) {
                playSound("tick.wav");
                move (row, col);
                if (!over&&mode) {
                    Point p = calcMove();
                    move(p.x, p.y);
                }
            }
        }
    }
    public class Cell extends JButton {
        public int type;

        public Cell() {
            setContentAreaFilled(false);
            setOpaque(true);
        }

        public void resetIcon(Image image) {
            this.setIcon(image == null ? null : new ImageIcon(image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(25, 25);
        }
    }

    public class BoardLayoutManager implements LayoutManager2 {
        private Map<Point, Component> mapComps = new HashMap<>(25);

        @Override
        public void addLayoutComponent(Component comp, Object constraints) {
            if (constraints instanceof Point) {
                mapComps.put((Point) constraints, comp);
            } else {
                throw new IllegalArgumentException("ChessBoard constraints must be a Point");
            }
        }

        @Override
        public Dimension maximumLayoutSize(Container target) {
            return preferredLayoutSize(target);
        }

        @Override
        public float getLayoutAlignmentX(Container target) {
            return 0.5f;
        }

        @Override
        public float getLayoutAlignmentY(Container target) {
            return 0.5f;
        }

        public void invalidateLayout(Container target) {
        }

        public void addLayoutComponent(String name, Component comp) {
        }

        @Override
        public void removeLayoutComponent(Component comp) {
            Point[] keys = mapComps.keySet().toArray(new Point[mapComps.size()]);
            for (Point p : keys) {
                if (mapComps.get(p).equals(comp)) {
                    mapComps.remove(p);
                    break;
                }
            }
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            return new CellGrid(mapComps).getPreferredSize();
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return preferredLayoutSize(parent);
        }

        @Override
        public void layoutContainer(Container parent) {
            CellGrid grid = new CellGrid(mapComps);
            int cellSize = Math.min(parent.getWidth(), parent.getHeight()) / Math.max(grid.mapRows.size(), grid.mapCols.size());
            int xOffset = (parent.getWidth() - (cellSize * grid.mapCols.size())) / 2;
            int yOffset = (parent.getHeight() - (cellSize * grid.mapRows.size())) / 2;
            for (Integer row : grid.mapRows.keySet()) {
                for (CellGrid.Cell cell : grid.mapRows.get(row)) {
                    Component comp = cell.component;
                    comp.setLocation(xOffset + (cell.point.x * cellSize), yOffset + (cell.point.y * cellSize));
                    comp.setSize(cellSize, cellSize);
                }
            }
        }

        public class CellGrid {
            public int cellWidth, cellHeight;
            public Map<Integer, List<Cell>> mapRows, mapCols;
            private Dimension prefSize;

            public CellGrid(Map<Point, Component> mapComps) {
                mapRows = new HashMap<>(25);
                mapCols = new HashMap<>(25);
                for (Point p : mapComps.keySet()) {
                    List<Cell> rows = mapRows.get(p.y);
                    List<Cell> cols = mapCols.get(p.x);
                    if (rows == null) {
                        rows = new ArrayList<>(25);
                        mapRows.put(p.y, rows);
                    }
                    if (cols == null) {
                        cols = new ArrayList<>(25);
                        mapCols.put(p.x, cols);
                    }
                    Cell cell = new Cell(p, mapComps.get(p));
                    rows.add(cell);
                    cols.add(cell);
                }
                cellHeight = 0;
                cellWidth = 0;
                for (List<Cell> comps : mapRows.values()) {
                    for (Cell cell : comps) {
                        cellWidth = Math.max(cellWidth, cell.component.getPreferredSize().width);
                        cellHeight = Math.max(cellHeight, cell.component.getPreferredSize().height);
                    }
                }
                prefSize = new Dimension(Math.max(cellHeight, cellWidth) * mapCols.size(), Math.max(cellHeight, cellWidth) * mapRows.size());
            }

            public Dimension getPreferredSize() {
                return prefSize;
            }

            public class Cell {
                public Point point;
                public Component component;

                public Cell(Point p, Component comp) {
                    this.point = p;
                    this.component = comp;
                }
            }
        }
    }
}