import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.*;
import javax.sound.sampled.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PixelArtLab {
    PixelArtLab() {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
            }
            JFrame frame = new JFrame("PixelArtLab");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            int width = Integer.parseInt(JOptionPane.showInputDialog(null, "Width?", JOptionPane.INFORMATION_MESSAGE));
            int height = Integer.parseInt(JOptionPane.showInputDialog(null, "Height?", JOptionPane.INFORMATION_MESSAGE));
            Game g = new Game(width, height);
            JToolBar tools = new JToolBar();
            JFileChooser file = new JFileChooser();
            JColorChooser colorChooser = new JColorChooser();
            colorChooser.getSelectionModel().addChangeListener((ChangeEvent arg0) -> g.c = colorChooser.getColor());
            colorChooser.setPreviewPanel(new JPanel());
            file.setFileFilter(new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes()));
            tools.setFloatable(false);
            tools.setOpaque(true);
            tools.add(new AbstractAction("Clear") {
                public void actionPerformed(ActionEvent e) {
                    g.set(false);
                }
            });
            tools.add(new AbstractAction("Open") {
                public void actionPerformed(ActionEvent e) {
                    int res = file.showOpenDialog(frame);
                    if (res==JFileChooser.APPROVE_OPTION) {
                        File save = file.getSelectedFile();
                        try {
                            BufferedImage image = ImageIO.read(save);
                            for (int i = 0; i < Math.min(g.board.length, image.getWidth()); i++) {
                                for (int j = 0; j < Math.min(g.board[i].length, image.getHeight()); j++) {
                                    g.board[i][j].setBackground(new Color(image.getRGB(i, j)));
                                }
                            }
                        } catch (Exception ignored) {
                        }
                    }
                }
            });
            tools.add(new AbstractAction("Save") {
                public void actionPerformed(ActionEvent e) {
                    int res = file.showSaveDialog(frame);
                    if (res==JFileChooser.APPROVE_OPTION) {
                        File save = file.getSelectedFile();
                        BufferedImage image = new BufferedImage(g.board.length, g.board[0].length, BufferedImage.TYPE_INT_RGB);
                        for (int i = 0; i < g.board.length; i++) {
                            for (int j = 0; j < g.board[i].length; j++) {
                                image.setRGB(i, j, g.board[i][j].getBackground().getRGB());
                            }
                        }
                        try {
                            String name = save.getName();
                            int last = name.lastIndexOf('.');
                            ImageIO.write(image, last>0?name.substring(last+1):"png", save);
                        } catch (Exception ignored) {
                        }
                    }
                }
            });
            tools.add(new AbstractAction("Undo") {
                public void actionPerformed(ActionEvent e) {
                    if (g.previous.size()<=0) return;
                    Color[][] prev = g.previous.remove(g.previous.size()-1);
                    for (int i = 0; i < g.board.length; i++) {
                        for (int j = 0; j < g.board[i].length; j++) {
                            g.board[i][j].setBackground(prev[i][j]);
                        }
                    }
                }
            });
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(tools, BorderLayout.PAGE_START);
            frame.add(g, BorderLayout.CENTER);
            frame.add(colorChooser, BorderLayout.WEST);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
    public static void main(String[] args) {
        new PixelArtLab();
    }
    public class Game extends JPanel {
        private Cell[][] board;
        List<Color[][]> previous;
        private Color c;
        private int width, height;
        Game (int width, int height) {
            this.width = width;
            this.height=height;
            set(true);
        }
        void set(boolean original) {
            if(original) {
                c = Color.BLACK;
                previous=new ArrayList<>();
                setLayout(new BoardLayoutManager());
                board = new Cell[width][height];
            }
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    if (original) {
                        board[row][col] = new Cell();
                        board[row][col].setBorder(BorderFactory.createEmptyBorder());
                        final int r = row, c = col;
                        board[row][col].addActionListener((ActionEvent e) -> {
                            Color[][] colors = new Color[board.length][];
                            for (int i = 0; i < board.length; i++) {
                                colors[i]=new Color[board[i].length];
                                for (int j = 0; j < board[i].length; j++) {
                                    colors[i][j]=board[i][j].getBackground();
                                }
                            }
                            previous.add(colors);
                            setSelected(r, c);
                        });
                        add(board[row][col], new Point(col, row));
                        board[row][col].setSize(1, 1);
                    }
                    board[row][col].setBackground(Color.WHITE);
                }
            }
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

        void setSelected(int row, int col) {
            board[row][col].setBackground(c);
        }
    }
    class Cell extends JButton {
        Cell() {
            setContentAreaFilled(false);
            setOpaque(true);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(25, 25);
        }
    }

    class BoardLayoutManager implements LayoutManager2 {
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
            Point[] keys = mapComps.keySet().toArray(new Point[0]);
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

        class CellGrid {
            int cellWidth, cellHeight;
            Map<Integer, List<Cell>> mapRows, mapCols;
            private Dimension prefSize;

            CellGrid(Map<Point, Component> mapComps) {
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

            Dimension getPreferredSize() {
                return prefSize;
            }

            class Cell {
                Point point;
                Component component;

                Cell(Point p, Component comp) {
                    this.point = p;
                    this.component = comp;
                }
            }
        }
    }
}