import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

public class Screen extends JPanel {
    public static boolean SHOW_BOUNDARY = false;
    public MainPlayer p;
    private MovementState movementState;
    private MovementState position;
    public Frame main;
    public Inventory i;
    public ArrayList<Player> players;
    public ArrayList<Item> items;
    public HashSet<String> questsCompleted;
    public HashMap<Point, ArrayList<Item>> oldItems;
    public BufferedImage castleBackground, forestPath, forestPathUp, godBackground, grassBackground, rockBackground, caveBackground, bridgeBackground, endBackground;
    public Clip collect, mission, theme;
    public boolean[][] canMove;

    public Screen(Frame main, Inventory i) {
        try {
            AudioInputStream collectIn = AudioSystem.getAudioInputStream(new File("sound/collect.wav"));
            collect = AudioSystem.getClip();
            collect.open(collectIn);
            AudioInputStream missionIn = AudioSystem.getAudioInputStream(new File("sound/mission.wav"));
            mission = AudioSystem.getClip();
            mission.open(missionIn);
            AudioInputStream themeIn = AudioSystem.getAudioInputStream(new File("sound/theme.wav"));
            theme = AudioSystem.getClip();
            theme.open(themeIn);
            playClip(theme);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        setOpaque(true);
        this.main = main;
        players = new ArrayList<>();
        items = new ArrayList<>();
        oldItems = new HashMap<>();
        questsCompleted = new HashSet<>();
        this.i = i;
        movementState = new MovementState();
        position = new MovementState();
        canMove = new boolean[3][3];
        canMove[2][2] = true;
        try {
            castleBackground = ImageIO.read(new File("img/castle.png"));
            forestPath = ImageIO.read(new File("img/forest.png"));
            forestPathUp = ImageIO.read(new File("img/forest2.png"));
            godBackground = ImageIO.read(new File("img/god.png"));
            grassBackground = ImageIO.read(new File("img/grass.png"));
            rockBackground = ImageIO.read(new File("img/rocks.png"));
            caveBackground = ImageIO.read(new File("img/cave.png"));
            bridgeBackground = ImageIO.read(new File("img/bridge.png"));
            endBackground = ImageIO.read(new File("img/end.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0), "cheat");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "space");
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

        am.put("cheat", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!questsCompleted.contains("Coconuts")) {
                    Player soldier2 = null;
                    while (soldier2 == null) {
                        for (Player player : players) {
                            player.toSay.clear();
                            if (player.name.equals("Soldier 2")) {
                                soldier2 = player;
                            }
                        }
                        if (soldier2 == null) {
                            updateSays(p, "I'm not interested!");
                        }
                    }
                    updateSays(soldier2, "Well, why not?");
                } else if (!questsCompleted.contains("Black Knight")) {
                    for (Player player : players) {
                        player.toSay.clear();
                        if (player.name.equals("Black Knight")) {
                            player.image = ((BlackKnight) player).images[4];
                            updateSays(player, "Oh. Oh, I see. Running away, eh? You yellow bastards! Come back here and take what's coming to you. I'll bite your legs off!");
                        }
                    }
                } else if (!questsCompleted.contains("Talk to God")) {
                    for (Player player : players) {
                        player.toSay.clear();
                        if (player.name.equals("God")) {
                            updateSays(player, "Arthur, this is the Holy Grail. Look well, Arthur, for it is your sacred task to seek this grail. That is your purpose, Arthur: the quest for the Holy Grail.");
                        }
                    }
                } else if (!questsCompleted.contains("Don't die to Ni")) {
                    for (Player player : players) {
                        player.toSay.clear();
                        if (player.name.equals("Head Knight of Ni")) {
                            updateSays(player, "Now... go!");
                        }
                    }
                } else if (!questsCompleted.contains("Defeat the Knights who say Ni")) {
                    Shrubbery shrubbery = new Shrubbery(p.x, p.y);
                    shrubbery.setName("For you!");
                    i.items.add(shrubbery);
                    playClip(collect);
                    updatePosition(new Point(position.xDirection, position.yDirection));
                    for (Player player : players) {
                        player.toSay.clear();
                        if (player.name.equals("Head Knight of Ni")) {
                            updateSays(player, "Ooh! I said it again! And there again! That's three 'it's! Ohh!");
                        }
                    }
                } else if (!questsCompleted.contains("Talk to Tim")) {
                    for (Player player : players) {
                        player.toSay.clear();
                        if (player.name.equals("Tim the Enchanter")) {
                            updateSays(player, "Follow. But! Follow only if ye be men of valour, for the entrance to this cave is guarded by a creature so foul, so cruel that no man yet has fought with it and lived! Bones of full fifty men lie strewn about its lair. So, brave knights, if you do doubt your courage or your strength, come no further, for death awaits you all with nasty, big, pointy teeth.");
                        }
                    }
                } else if (!questsCompleted.contains("Defeat the Killer Rabbit of Caerbannog")) {
                    for (Player player : players) {
                        player.toSay.clear();
                        if (player.name.equals("King Arthur")) {
                            updateSays(player, "Right! One!... Two!... Five!");
                        }
                    }
                } else if (!questsCompleted.contains("Defeat the Bridge Keeper")) {
                    for (Player player : players) {
                        player.toSay.clear();
                        if (player.name.equals("Bridge Keeper")) {
                            updateSays(player, "Huh? I-- I don't know that. Auuuuuuuugh!");
                        }
                    }
                } else {
                    updateSays(p, "!End");
                }
                repaint();
            }
        });
        am.put("space", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loop:
                for (Item item : items) {
                    if (item == null) continue;
                    if (item.speaking) {
                        i.items.add(item);
                        playClip(collect);
                        items.remove(item);
                        return;
                    }
                }
                for (Player player : players) {
                    if (player == null) continue;
                    if (player.speaking) {
                        String say = player.nextSay();
                        if (say == null) continue;
                        updateSays(player, say);
                        return;
                    }
                }
                repaint();
            }
        });
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
        p.setName("King Arthur");
        new java.util.Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Point oldPosition = new Point(position.xDirection, position.yDirection);
                if (movementState.xDirection==0||movementState.yDirection==0) {
                    p.x += movementState.xDirection;
                    p.y += movementState.yDirection;
                } else {
                    p.x += movementState.xDirection*2/3;
                    p.y += movementState.yDirection*2/3;
                }
                if (p.x < -p.width/2) {
                    if (position.xDirection > -1 && canMove[position.xDirection][position.yDirection + 1]) {
                        position.xDirection--;
                        updatePosition(oldPosition);
                        p.x = getWidth() + p.width/2;
                    } else {
                        p.x = -p.width/2;
                    }
                } else if (p.x > getWidth() + p.width/2) {
                    if (position.xDirection < 1 && canMove[position.xDirection + 2][position.yDirection + 1]) {
                        position.xDirection++;
                        updatePosition(oldPosition);
                        p.x = -p.width/2;
                    } else {
                        p.x = getWidth() + p.width / 2;
                    }
                }
                if (p.y < 0) {
                    if (position.yDirection > -1 && canMove[position.xDirection + 1][position.yDirection]) {
                        position.yDirection--;
                        updatePosition(oldPosition);
                        p.y = getHeight() + p.height;
                    } else {
                        p.y = 0;
                    }
                } else if (p.y > getHeight() + p.height) {
                    if (position.yDirection < 1 && canMove[position.xDirection + 1][position.yDirection + 2]) {
                        position.yDirection++;
                        updatePosition(oldPosition);
                        p.y = 0;
                    } else {
                        p.y = getHeight() + p.height;
                    }
                }
                p.updateImage(movementState);
                updateSpeaking();
                repaint();
            }
        }, 0, 1000/60);
        i.screen = this;
        Point oldPosition = new Point(position.xDirection, position.yDirection);
        position.xDirection = 1;
        position.yDirection = 1;
        updatePosition(oldPosition);
        p.x = 500;
        p.y = 580;
    }

    public void playClip(Clip c) {
        c.setMicrosecondPosition(0);
        c.start();
    }

    public void updateSays(Player thePlayer, String s) {
        Player soldier2 = null;
        for (Player player : players) {
            if (player.conditionalSays.containsKey(thePlayer) && player.conditionalSays.get(thePlayer).containsKey(s)) {
                for (String b : player.conditionalSays.get(thePlayer).get(s)) {
                    if (b.charAt(0) != '!') {
                        player.addSay(b);
                    } else {
                        String[] strings = b.split("!");
                        if (strings[1].equals("ITEM")) {
                            if (strings[2].equals("Scroll")) {
                                if (strings[3].equals("African vs European Swallow")) {
                                    canMove[1][2] = true;
                                }
                                Scroll i = new Scroll(player.x, player.y);
                                i.setName(strings[3]);
                                items.add(i);
                                updateSpeaking();
                            } else if (strings[2].equals("Coconuts")) {
                                Coconuts c = new Coconuts(player.x, player.y);
                                c.setName(strings[3]);
                                items.add(c);
                                updateSpeaking();
                            } else if (strings[2].equals("Shrubbery")) {
                                Shrubbery shrubbery = new Shrubbery(player.x, player.y);
                                shrubbery.setName("For you!");
                                items.add(shrubbery);
                                updateSpeaking();
                            } else {
                                throw new Error("Item not recognized: " + strings[2] + " with name " + strings[3]);
                            }
                        } else if (strings[1].equals("DAMAGE")) {
                            if (strings[2].equals("blackknight")) {
                                for (Player player1 : players) {
                                    if (player1 instanceof BlackKnight && player1.name.equals("Black Knight")) {
                                        BlackKnight blackKnight = (BlackKnight) player1;
                                        blackKnight.updateImage(blackKnight.state + 1);
                                    }
                                }
                            } else {
                                throw new Error("Player to damage not recognized: " + strings[2]);
                            }
                        } else if (strings[1].equals("MISSION")) {
                            questsCompleted.add(strings[2]);
                            System.out.println(" ???");
                            playClip(mission);
                            if (strings[2].equals("Coconuts")) {
                                canMove[1][2] = true;
                            } else if (strings[2].equals("Black Knight")) {
                                canMove[0][2] = true;
                            } else if (strings[2].equals("Talk to God")) {
                                canMove[0][1] = true;
                            } else if (strings[2].equals("Don't die to Ni")) {
                                canMove[0][0] = true;
                            } else if (strings[2].equals("Defeat the Knights who say Ni")) {
                                canMove[1][1] = true;
                            } else if (strings[2].equals("Talk to Tim")) {
                                canMove[1][0] = true;
                            } else if (strings[2].equals("Defeat the Killer Rabbit of Caerbannog")) {
                                canMove[2][0] = true;
                            } else if (strings[2].equals("Defeat the Bridge Keeper")) {
                                canMove[2][1] = true;
                            } else {
                                throw new Error("Quest not recognized: " + strings[2]);
                            }
                        } else if (strings[1].equals("SPAWN")) {
                            if (strings[2].equals("Holy Grail")) {
                                HolyGrail h = new HolyGrail(300, 200);
                                h.setName("Just a vision can't pick up yet! Congrats on the smart thinking though!");
                                h.canPickUp = false;
                                items.add(h);
                                h.fadeIn(this, 1.0);
                            } else if (strings[2].equals("Soldier 2")) {
                                for (Player soldier1 : players) {
                                    if (soldier1.name.equals("Soldier 1")) {
                                        soldier2 = new Soldier(150, 570);
                                        soldier2.setName("Soldier 2");
                                        soldier2.addSay("It could be carried by an African swallow!");

                                        soldier2.addConditionalSay(soldier2, "It could be carried by an African swallow!", "!ITEM!Scroll!African vs European Swallow");

                                        soldier1.addConditionalSay(soldier2, "It could be carried by an African swallow!", "Oh, yeah, an African swallow maybe, but not a European swallow. That's my point.");
                                        soldier1.addConditionalSay(soldier1, "Oh, yeah, an African swallow maybe, but not a European swallow. That's my point.", "But then of course, uh, African swallows are non-migratory.");
                                        soldier1.addConditionalSay(soldier1, "But then of course, uh, African swallows are non-migratory.", "So, they couldn't bring a coconut back anyway.");

                                        soldier2.addConditionalSay(soldier1, "So, they couldn't bring a coconut back anyway.", "Wait a minute! Supposing two swallows carried it together?");

                                        soldier1.addConditionalSay(soldier2, "Wait a minute! Supposing two swallows carried it together?", "No, they'd have to have it on a line.");

                                        soldier2.addConditionalSay(soldier1, "No, they'd have to have it on a line.", "Well, simple! They'd just use a strand of creeper!");

                                        soldier1.addConditionalSay(soldier2, "Well, simple! They'd just use a strand of creeper!", "What, held under the dorsal guiding feathers?");

                                        soldier2.addConditionalSay(soldier1, "What, held under the dorsal guiding feathers?", "Well, why not?");

                                        thePlayer.addConditionalSay(soldier2, "Well, why not?", "!MISSION!Coconuts");

                                        soldier2.fadeIn(this, 1.0);
                                        break;
                                    }
                                }
                            } else {
                                throw new Error("Item to spawn not recognized: " + strings[2]);
                            }
                        } else if (strings[1].equals("END")) {
                            playClip(theme);
                            main.actionPerformed(new ActionEvent(this, -1, "End"));
                        } else {
                            throw new Error("Command not recognized: " + strings[1]);
                        }
                    }
                }
            }
        }
        if (soldier2 != null) {
            players.add(soldier2);
        }
    }

    public void updateSpeaking() {
        for (Item item : items) {
            item.speaking = item.canPickUp && p.intersects(item);
        }
        for (Player player : players) {
            player.speaking = player.canPickUp && p.intersects(player);
        }
    }

    public void updatePosition(Point old) {
        Point pos = new Point(position.xDirection, position.yDirection);
        ArrayList<Item> itemsNew = new ArrayList<>();
        if (oldItems.containsKey(pos)) itemsNew.addAll(oldItems.get(pos));
        oldItems.putIfAbsent(old, new ArrayList<>());
        oldItems.putIfAbsent(pos, new ArrayList<>());
        oldItems.get(old).clear();
        for (Item item : items) {
            if (item.canPickUp) oldItems.get(old).add(item);
        }
        items.clear();
        items.addAll(itemsNew);
        players.clear();
        players.add(p);
        p.toSay.clear();
        p.conditionalSays.clear();
        if (position.yDirection==-1) {
            if (position.xDirection==-1) {
                Roger r = new Roger(200, 350);
                r.setName("Roger the Shrubber");

                r.addSay("Are you saying 'ni' to that old woman?");

                p.addConditionalSay(r, "Are you saying 'ni' to that old woman?", "Erm,... yes.");

                r.addConditionalSay(p, "Erm,... yes.", "Oh, what sad times are these when passing ruffians can say 'ni' at will to old ladies.");
                r.addConditionalSay(r, "Oh, what sad times are these when passing ruffians can say 'ni' at will to old ladies.", "There is a pestilence upon this land. Nothing is sacred.");
                r.addConditionalSay(r, "There is a pestilence upon this land. Nothing is sacred.", "Even those who arrange and design shrubberies are under considerable economic stress at this period in history.");

                p.addConditionalSay(r, "Even those who arrange and design shrubberies are under considerable economic stress at this period in history.", "Did you say 'shrubberies'?");

                r.addConditionalSay(p, "Did you say 'shrubberies'?", "Yes. Shrubberies are my trade.");
                r.addConditionalSay(r, "Yes. Shrubberies are my trade.", "I am a shrubber. My name is 'Roger the Shrubber'.");
                r.addConditionalSay(r, "I am a shrubber. My name is 'Roger the Shrubber'.", "I arrange, design, and sell shrubberies.");

                p.addConditionalSay(r, "I arrange, design, and sell shrubberies.", "Might we buy one?");

                p.addConditionalSay(p, "Might we buy one?", "!ITEM!Shrubbery");

                players.add(r);
            } else if (position.xDirection==0) {
                TimTheEnchanter t = new TimTheEnchanter(100, 530);
                t.setName("Tim the Enchanter");

                Rabbit rabbit = new Rabbit(420, 380);
                rabbit.setName("Killer Rabbit of Caerbannog");

                Galahad g = new Galahad(350, 580);
                g.setName("Galahad");

                Robin r = new Robin(230, 580);
                r.setName("Robin");

                Lancelot lancelot = new Lancelot(470, 580);
                lancelot.setName("Lancelot");

                t.addSay("Behold the cave of Caerbannog!");

                p.addConditionalSay(t, "Behold the cave of Caerbannog!", "Right! Keep me covered.");

                g.addConditionalSay(p, "Right! Keep me covered.", "What with?");

                p.addConditionalSay(g, "What with?", "W-- just keep me covered.");

                t.addConditionalSay(p, "W-- just keep me covered.", "There he is!");

                p.addConditionalSay(t, "There he is!", "What, behind the rabbit?");

                t.addConditionalSay(p, "What, behind the rabbit?", "Well, that's no ordinary rabbit!");
                t.addConditionalSay(t, "Well, that's no ordinary rabbit!", "That's the most foul, cruel, and bad-tempered rodent you ever set eyes on!");
                t.addConditionalSay(t, "That's the most foul, cruel, and bad-tempered rodent you ever set eyes on!", "Look, that rabbit's got a vicious streak a mile wide! It's a killer!");

                g.addConditionalSay(t, "Look, that rabbit's got a vicious streak a mile wide! It's a killer!", "Get stuffed!");

                t.addConditionalSay(g, "Get stuffed!", "I'm warning you!");

                r.addConditionalSay(t, "I'm warning you!", "What's he do, nibble your bum?");

                t.addConditionalSay(r, "What's he do, nibble your bum?", "He's got huge, sharp-- eh-- he can leap about-- look at the bones!");

                rabbit.addConditionalSay(t, "He's got huge, sharp-- eh-- he can leap about-- look at the bones!", "Arghh!");

                t.addConditionalSay(rabbit, "Arghh!", "I warned you, but did you listen to me? Oh, no, you knew it all, didn't you? Oh, it's just a harmless little bunny, isn't it? Well, it's always the same. I always tell them--");

                p.addConditionalSay(t, "I warned you, but did you listen to me? Oh, no, you knew it all, didn't you? Oh, it's just a harmless little bunny, isn't it? Well, it's always the same. I always tell them--", "Oh shut up! Charge!");

                rabbit.addConditionalSay(p, "Oh shut up! Charge!", "Aaaaugh! Aaaugh!");

                p.addConditionalSay(rabbit, "Aaaaugh! Aaaugh!", "Run away! Run away!");
                p.addConditionalSay(p, "Run away! Run away!", "We'd better not risk another frontal assault. That rabbit's dynamite.");

                r.addConditionalSay(p, "We'd better not risk another frontal assault. That rabbit's dynamite.", "Would it help to confuse it if we run away more?");

                p.addConditionalSay(r, "Would it help to confuse it if we run away more?", "Oh, shut up and go and change your armor.");

                g.addConditionalSay(p, "Oh, shut up and go and change your armor.", "Let us taunt it! It may become so cross that it will make a mistake.");

                lancelot.addConditionalSay(g, "Let us taunt it! It may become so cross that it will make a mistake.", "We have the Holy Hand Grenade.");

                p.addConditionalSay(lancelot, "We have the Holy Hand Grenade.", "Yes, of course! The Holy Hand Grenade of Antioch! 'Tis one of the sacred relics Brother Maynard carries with him! Brother Maynard! Bring up the Holy Hand Grenade!");

                p.addConditionalSay(p, "Yes, of course! The Holy Hand Grenade of Antioch! 'Tis one of the sacred relics Brother Maynard carries with him! Brother Maynard! Bring up the Holy Hand Grenade!", "!ITEM!Scroll!Holy Hand Grenade");

                p.addConditionalSay(p, "Yes, of course! The Holy Hand Grenade of Antioch! 'Tis one of the sacred relics Brother Maynard carries with him! Brother Maynard! Bring up the Holy Hand Grenade!", "Right! One!... Two!... Five!");

                p.addConditionalSay(p, "Right! One!... Two!... Five!", "!MISSION!Defeat the Killer Rabbit of Caerbannog");

                players.add(t);
                players.add(rabbit);
                players.add(g);
                players.add(r);
                players.add(lancelot);
            } else if (position.xDirection==1) {
                BridgeKeeper b = new BridgeKeeper(250, 550);
                b.setName("Bridge Keeper");

                b.addSay("Stop! Who would cross the Bridge of Death must answer me these questions three, ere the other side he see.");
                b.addConditionalSay(b, "Stop! Who would cross the Bridge of Death must answer me these questions three, ere the other side he see.", "What... is your name?");

                p.addConditionalSay(b, "What... is your name?", "It is 'Arthur', King of the Britons.");

                b.addConditionalSay(p, "It is 'Arthur', King of the Britons.", "What... is your quest?");

                p.addConditionalSay(b, "What... is your quest?", "To seek the Holy Grail.");

                b.addConditionalSay(p, "To seek the Holy Grail.", "What... is the air-speed velocity of an unladen swallow?");

                p.addConditionalSay(b, "What... is the air-speed velocity of an unladen swallow?", "What do you mean? An African or European swallow?");

                b.addConditionalSay(p, "What do you mean? An African or European swallow?", "Huh? I-- I don't know that. Auuuuuuuugh!");

                p.addConditionalSay(b, "Huh? I-- I don't know that. Auuuuuuuugh!", "!MISSION!Defeat the Bridge Keeper");

                players.add(b);
            }
        } else if (position.yDirection==0) {
            if (position.xDirection==-1) {
                boolean flag = false;
                for (Item item : i.items) {
                    if (item instanceof Shrubbery) {
                        flag = true;
                        break;
                    }
                }
                NiKnight n = new NiKnight(275, 300);
                n.setName("Head Knight of Ni");
                if (flag) {
                    p.addSay("O Knights of Ni, we have brought you your shrubbery. May we go now?");

                    n.addConditionalSay(p, "O Knights of Ni, we have brought you your shrubbery. May we go now?", "It is a good shrubbery. I like the laurels particularly,... but there is one small problem.");
                    n.addConditionalSay(n, "It is a good shrubbery. I like the laurels particularly,... but there is one small problem.", "We are now... no longer the Knights Who Say 'Ni'.");
                    n.addConditionalSay(n, "We are now... no longer the Knights Who Say 'Ni'.", "We are now the Knights Who Say 'Ecky-ecky-ecky-ecky-pikang-zoop-boing-goodem-zu-owly-zhiv'.");
                    n.addConditionalSay(n, "We are now the Knights Who Say 'Ecky-ecky-ecky-ecky-pikang-zoop-boing-goodem-zu-owly-zhiv'.", "Therefore, we must give you a test.");

                    p.addConditionalSay(n, "Therefore, we must give you a test.", "What is this test, O Knights of-- knights who till recently said 'ni'?");

                    n.addConditionalSay(p, "What is this test, O Knights of-- knights who till recently said 'ni'?", "Firstly, you must find... another shrubbery!");

                    p.addConditionalSay(n, "Firstly, you must find... another shrubbery!", "Not another shrubbery!");

                    n.addConditionalSay(p, "Not another shrubbery!", "Then, when you have found the shrubbery, you must place it here beside this shrubbery, only slightly higher so you get the two-level effect with a little path running down the middle.");
                    n.addConditionalSay(n, "Then, when you have found the shrubbery, you must place it here beside this shrubbery, only slightly higher so you get the two-level effect with a little path running down the middle.", "Then, when you have found the shrubbery, you must cut down the mightiest tree in the forest... with... a herring!");

                    p.addConditionalSay(n, "Then, when you have found the shrubbery, you must cut down the mightiest tree in the forest... with... a herring!", "We shall do no such thing!");

                    n.addConditionalSay(p, "We shall do no such thing!", "Oh, please!");

                    p.addConditionalSay(n, "Oh, please!", "Cut down a tree with a herring? It can't be done.");

                    p.addConditionalSay(p, "Cut down a tree with a herring? It can't be done.", "!ITEM!Scroll!It");

                    n.addConditionalSay(p, "Cut down a tree with a herring? It can't be done.", "Augh! Ohh! Don't say that word.");

                    p.addConditionalSay(n, "Augh! Ohh! Don't say that word.", "How can we not say the word if you don't tell us what it is?");

                    n.addConditionalSay(p, "How can we not say the word if you don't tell us what it is?", "Aaaaugh! Stop saying the word! The word we cannot hear! Ow! He said it again!");
                    n.addConditionalSay(n, "Aaaaugh! Stop saying the word! The word we cannot hear! Ow! He said it again!", "Wait! I said it! I said it!");
                    n.addConditionalSay(n, "Wait! I said it! I said it!", "Ooh! I said it again! And there again! That's three 'it's! Ohh!");

                    p.addConditionalSay(n, "Ooh! I said it again! And there again! That's three 'it's! Ohh!", "!MISSION!Defeat the Knights who say Ni");
                } else {
                    n.addSay("Ni!");

                    p.addConditionalSay(n, "Ni!", "Who are you?");

                    n.addConditionalSay(p, "Who are you?", "We are the Knights Who Say... 'Ni'!");

                    p.addConditionalSay(n, "We are the Knights Who Say... 'Ni'!", "No! Not the Knights Who Say 'Ni'!");

                    n.addConditionalSay(p, "No! Not the Knights Who Say 'Ni'!", "We are the keepers of the sacred words: 'Ni', 'Peng', and 'Neee-wom'!");

                    p.addConditionalSay(n, "We are the keepers of the sacred words: 'Ni', 'Peng', and 'Neee-wom'!", "Those who hear them seldom live to tell the tale.");

                    n.addConditionalSay(p, "Those who hear them seldom live to tell the tale.", "The Knights Who Say 'Ni' demand a sacrifice.");

                    p.addConditionalSay(n, "The Knights Who Say 'Ni' demand a sacrifice.", "Knights of Ni, we are but simple travellers who seek the enchanter who lives beyond these woods.");

                    n.addConditionalSay(p, "Knights of Ni, we are but simple travellers who seek the enchanter who lives beyond these woods.", "Ni! Ni! Ni! Ni! Ni!...");

                    p.addConditionalSay(n, "Ni! Ni! Ni! Ni! Ni!...", "Ow! Ow! Ow! Agh!");

                    n.addConditionalSay(p, "Ow! Ow! Ow! Agh!", "We shall say 'ni' again to you if you do not appease us.");

                    p.addConditionalSay(n, "We shall say 'ni' again to you if you do not appease us.", "Well, what is it you want?");

                    n.addConditionalSay(p, "Well, what is it you want?", "You must return here with a shrubbery, or else, you will never pass through this wood... alive.");

                    p.addConditionalSay(n, "You must return here with a shrubbery, or else, you will never pass through this wood... alive.", "O Knights of Ni, you are just and fair, and we will return with a shrubbery.");

                    n.addConditionalSay(p, "O Knights of Ni, you are just and fair, and we will return with a shrubbery.", "One that looks nice.");

                    n.addConditionalSay(n, "One that looks nice.", "And not too expensive.");

                    p.addConditionalSay(n, "And not too expensive.", "Of course.");

                    n.addConditionalSay(p, "Of course.", "Now... go!");

                    p.addConditionalSay(n, "Now... go!", "!MISSION!Don't die to Ni");
                }
                players.add(n);
            } else if (position.xDirection==0) {
                TimTheEnchanter t = new TimTheEnchanter(350, 470);
                t.setName("Tim the Enchanter");

                t.addSay("I... am an enchanter.");

                p.addConditionalSay(t, "I... am an enchanter.", "By what name are you known?");

                t.addConditionalSay(p, "By what name are you known?", "There are some who call me... 'Tim'?");

                p.addConditionalSay(t, "There are some who call me... 'Tim'?", "Greetings, Tim the Enchanter.");

                t.addConditionalSay(p, "Greetings, Tim the Enchanter.", "Greetings, King Arthur!");

                p.addConditionalSay(t, "Greetings, King Arthur!", "You know my name?");

                t.addConditionalSay(p, "You know my name?", "I do.");
                t.addConditionalSay(t, "I do.", "You seek the Holy Grail!");

                p.addConditionalSay(t, "You seek the Holy Grail!", "Yes, we're-- we're looking for the Holy Grail. Our quest is to find the Holy Grail.");
                p.addConditionalSay(p, "Yes, we're-- we're looking for the Holy Grail. Our quest is to find the Holy Grail.", "And so, we're-- we're-- we're looking for it.");
                p.addConditionalSay(p, "And so, we're-- we're-- we're looking for it.", "Uh-- uh, so, uh, anything that you could do to, uh-- to help... would be... very... helpful.");
                p.addConditionalSay(p, "Uh-- uh, so, uh, anything that you could do to, uh-- to help... would be... very... helpful.", "Fine. Um, I don't want to waste any more of your time, but, uh, I don't suppose you could, uh, tell us where we might find a, um-- find a, uh-- a, um-- a, uh--");

                t.addConditionalSay(p, "Fine. Um, I don't want to waste any more of your time, but, uh, I don't suppose you could, uh, tell us where we might find a, um-- find a, uh-- a, um-- a, uh--", "A what...?");

                p.addConditionalSay(t, "A what...?", "A g-- a-- a g-- a g-- a-- a g--");

                t.addConditionalSay(p, "A g-- a-- a g-- a g-- a-- a g--", "A grail?!");

                p.addConditionalSay(t, "A grail?!", "Yes. Look, um, you're a busy man, uh--");

                t.addConditionalSay(p, "Yes. Look, um, you're a busy man, uh--", "Yes, I can help you find the Holy Grail.");
                t.addConditionalSay(t, "Yes, I can help you find the Holy Grail.", "To the north there lies a cave-- the cave of Caerbannog-- wherein, carved in mystic runes upon the very living rock, the last words of Olfin Bedwere of Rheged...");
                t.addConditionalSay(t, "To the north there lies a cave-- the cave of Caerbannog-- wherein, carved in mystic runes upon the very living rock, the last words of Olfin Bedwere of Rheged...", "...make plain the last resting place of the most Holy Grail.");

                p.addConditionalSay(t, "...make plain the last resting place of the most Holy Grail.", "Where could we find this cave, O Tim?");

                t.addConditionalSay(p, "Where could we find this cave, O Tim?", "Follow. But! Follow only if ye be men of valour, for the entrance to this cave is guarded by a creature so foul, so cruel that no man yet has fought with it and lived! Bones of full fifty men lie strewn about its lair. So, brave knights, if you do doubt your courage or your strength, come no further, for death awaits you all with nasty, big, pointy teeth.");

                p.addConditionalSay(t, "Follow. But! Follow only if ye be men of valour, for the entrance to this cave is guarded by a creature so foul, so cruel that no man yet has fought with it and lived! Bones of full fifty men lie strewn about its lair. So, brave knights, if you do doubt your courage or your strength, come no further, for death awaits you all with nasty, big, pointy teeth.", "!MISSION!Talk to Tim");

                players.add(t);
            } else if (position.xDirection==1) {
                Police e = new Police(400, 400);
                e.setName("Police Officer");


                p.addSay("Charge!");

                e.addConditionalSay(p, "Charge!", "Come on. Anybody armed must go, too.");
                e.addConditionalSay(e, "Come on. Anybody armed must go, too.", "Put this man in the van.");
                e.addConditionalSay(e, "Put this man in the van.", "Pull that off. My, that's an offensive weapon, that is.");

                p.addConditionalSay(e, "Pull that off. My, that's an offensive weapon, that is.", "!END");

                players.add(e);
            }
        } else if (position.yDirection==1) {
            if (position.xDirection==-1) {
                Player b = new Player(300, 565, 375, 500);
                b.setName("God");

                b.addSay("Arthur! Arthur, King of the Britons! Oh, don't grovel!");
                b.addConditionalSay(b, "Arthur! Arthur, King of the Britons! Oh, don't grovel!", "One thing I can't stand, it's people groveling.");

                p.addConditionalSay(b, "One thing I can't stand, it's people groveling.", "Sorry.");

                b.addConditionalSay(p, "Sorry.", "And don't apologize. Every time I try to talk to someone it's 'sorry this' and 'forgive me that' and 'I'm not worthy'.");

                p.addConditionalSay(b, "And don't apologize. Every time I try to talk to someone it's 'sorry this' and 'forgive me that' and 'I'm not worthy'.", "Yes, Lord.");

                b.addConditionalSay(p, "Yes, Lord.", "Right! Arthur, King of the Britons, your Knights of the Round Table shall have a task to make them an example in these dark times.");

                p.addConditionalSay(b, "Right! Arthur, King of the Britons, your Knights of the Round Table shall have a task to make them an example in these dark times.", "Good idea, O Lord!");

                b.addConditionalSay(p, "Good idea, O Lord!", "'Course it's a good idea! Behold!");

                b.addConditionalSay(b, "'Course it's a good idea! Behold!", "Arthur, this is the Holy Grail. Look well, Arthur, for it is your sacred task to seek this grail. That is your purpose, Arthur: the quest for the Holy Grail.");

                b.addConditionalSay(b, "Arthur, this is the Holy Grail. Look well, Arthur, for it is your sacred task to seek this grail. That is your purpose, Arthur: the quest for the Holy Grail.", "!SPAWN!Holy Grail");

                p.addConditionalSay(b, "Arthur, this is the Holy Grail. Look well, Arthur, for it is your sacred task to seek this grail. That is your purpose, Arthur: the quest for the Holy Grail.", "!MISSION!Talk to God");

                players.add(b);
            } else if (position.xDirection==0) {
                BlackKnight b = new BlackKnight(170, 475);
                b.setName("Black Knight");

                p.addSay("I am Arthur, King of the Britons.");
                p.addConditionalSay(p, "I am Arthur, King of the Britons.", "I seek the finest and the bravest knights in the land to join me in my court at Camelot.");
                p.addConditionalSay(p, "I seek the finest and the bravest knights in the land to join me in my court at Camelot.", "You have proved yourself worthy. Will you join me?");
                p.addConditionalSay(p, "You have proved yourself worthy. Will you join me?", "You make me sad. So be it. Come, Patsy.");

                b.addConditionalSay(p, "You make me sad. So be it. Come, Patsy.", "None shall pass.");

                p.addConditionalSay(b, "None shall pass.", "What?");

                b.addConditionalSay(p, "What?", "None shall pass!");

                p.addConditionalSay(b, "None shall pass!", "I have no quarrel with you, good Sir Knight, but I must cross this bridge.");

                b.addConditionalSay(p, "I have no quarrel with you, good Sir Knight, but I must cross this bridge.", "Then you shall die.");

                p.addConditionalSay(b, "Then you shall die.", "I command you, as King of the Britons, to stand aside!");

                b.addConditionalSay(p, "I command you, as King of the Britons, to stand aside!", "I move for no man.");

                p.addConditionalSay(b, "I move for no man.", "So be it!");

                p.addConditionalSay(p, "So be it!", "!DAMAGE!blackknight");

                p.addConditionalSay(p, "So be it!", "!ITEM!Scroll!Ooh look an arm!");

                p.addConditionalSay(p, "So be it!", "Now stand aside, worthy adversary.");

                b.addConditionalSay(p, "Now stand aside, worthy adversary.", "'Tis but a scratch.");

                p.addConditionalSay(b, "'Tis but a scratch.", "A scratch? Your arm's off!");

                b.addConditionalSay(p, "A scratch? Your arm's off!", "I've had worse.");

                p.addConditionalSay(b, "I've had worse.", "You liar!");

                b.addConditionalSay(p, "You liar!", "Come on, you pansy!");

                p.addConditionalSay(b, "Come on, you pansy!", "!DAMAGE!blackknight");

                p.addConditionalSay(b, "Come on, you pansy!", "Victory is mine!");

                p.addConditionalSay(p, "Victory is mine!", "We thank Thee Lord, that in Thy mer...");

                b.addConditionalSay(p, "We thank Thee Lord, that in Thy mer...", "Hah! Come on, then.");

                p.addConditionalSay(b, "Hah! Come on, then.", "Eh. You are indeed brave, Sir Knight, but the fight is mine.");

                b.addConditionalSay(p, "Eh. You are indeed brave, Sir Knight, but the fight is mine.", "Oh, had enough, eh?");

                p.addConditionalSay(b, "Oh, had enough, eh?", "Look, you stupid bastard. You've got no arms left.");

                b.addConditionalSay(p, "Look, you stupid bastard. You've got no arms left.", "Just a flesh wound.");

                b.addConditionalSay(b, "Just a flesh wound.", "Chicken!");

                b.addConditionalSay(b, "Chicken!", "Chickennn!");

                p.addConditionalSay(b, "Chickennn!", "Look, I'll have your leg.");

                p.addConditionalSay(p, "Look, I'll have your leg.", "!DAMAGE!blackknight");

                p.addConditionalSay(p, "Look, I'll have your leg.", "!ITEM!Scroll!Ooh look a leg!");

                b.addConditionalSay(p, "Look, I'll have your leg.", "Right. I'll do you for that!");

                p.addConditionalSay(b, "Right. I'll do you for that!", "What are you going to do, bleed on me?");

                b.addConditionalSay(p, "What are you going to do, bleed on me?", "I'm invincible!");

                p.addConditionalSay(b, "I'm invincible!", "You're a looney.");

                b.addConditionalSay(p, "You're a looney.", "The Black Knight always triumphs! Have at you! Come on, then.");

                p.addConditionalSay(b, "The Black Knight always triumphs! Have at you! Come on, then.", "!DAMAGE!blackknight");

                b.addConditionalSay(b, "The Black Knight always triumphs! Have at you! Come on, then.", "Oh? All right, we'll call it a draw.");

                b.addConditionalSay(b, "Oh? All right, we'll call it a draw.", "Oh. Oh, I see. Running away, eh? You yellow bastards! Come back here and take what's coming to you. I'll bite your legs off!");

                p.addConditionalSay(b, "Oh. Oh, I see. Running away, eh? You yellow bastards! Come back here and take what's coming to you. I'll bite your legs off!", "!MISSION!Black Knight");

                players.add(b);
            } else if (position.xDirection==1) {
                Soldier soldier1 = new Soldier(400, 530);

                soldier1.setName("Soldier 1");

                soldier1.addSay("Halt! Who goes there?");

                p.addConditionalSay(soldier1, "Halt! Who goes there?", "It is I, Arthur, son of Uther Pendragon, from the castle of Camelot. King of the Britons, defeater of the Saxons, Sovereign of all England!");
                p.addConditionalSay(p, "It is I, Arthur, son of Uther Pendragon, from the castle of Camelot. King of the Britons, defeater of the Saxons, Sovereign of all England!", "We have ridden the length and breadth of the land in search of knights who will join me in my court at Camelot. I must speak with your lord and master.");

                soldier1.addConditionalSay(p, "We have ridden the length and breadth of the land in search of knights who will join me in my court at Camelot. I must speak with your lord and master.", "What? Ridden on a horse?");

                p.addConditionalSay(soldier1, "What? Ridden on a horse?", "Yes!");

                soldier1.addConditionalSay(p, "Yes!", "You've got two empty halves of coconut and you're bangin' 'em together.");
                soldier1.addConditionalSay(soldier1, "You've got two empty halves of coconut and you're bangin' 'em together.", "Where'd you get the coconuts?");

                p.addConditionalSay(soldier1, "Where'd you get the coconuts?", "We found them.");

                soldier1.addConditionalSay(p, "We found them.", "Found them? In Mercia?");
                soldier1.addConditionalSay(soldier1, "Found them? In Mercia?", "The coconut's tropical! This is a temperate zone.");

                p.addConditionalSay(soldier1, "The coconut's tropical! This is a temperate zone.", "!ITEM!Coconuts!From Mercia");

                p.addConditionalSay(soldier1, "The coconut's tropical! This is a temperate zone.", "The swallow may fly south with the sun or the house martin or the plover may seek warmer climes in winter, yet these are not strangers to our land?");

                soldier1.addConditionalSay(p, "The swallow may fly south with the sun or the house martin or the plover may seek warmer climes in winter, yet these are not strangers to our land?", "Are you suggesting coconuts migrate?");

                p.addConditionalSay(soldier1, "Are you suggesting coconuts migrate?", "Not at all. They could be carried by the husk.");

                soldier1.addConditionalSay(p, "Not at all. They could be carried by the husk.", "It's not a question of where he grips it! It's a simple question of weight ratios! A five ounce bird could not carry a one pound coconut.");

                soldier1.addConditionalSay(soldier1, "It's not a question of where he grips it! It's a simple question of weight ratios! A five ounce bird could not carry a one pound coconut.", "Listen. In order to maintain air-speed velocity, a swallow needs to beat its wings forty-three times every second, right?");

                p.addConditionalSay(soldier1, "Listen. In order to maintain air-speed velocity, a swallow needs to beat its wings forty-three times every second, right?", "I'm not interested!");

                p.addConditionalSay(p, "I'm not interested!", "!SPAWN!Soldier 2");

                players.add(soldier1);
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
                g.drawImage(grassBackground, 0, 0, null);
            } else if (position.xDirection==0) {
                g.drawImage(caveBackground, 0, 0, null);
            } else if (position.xDirection==1) {
                g.drawImage(bridgeBackground, 0, 0, null);
            }
        } else if (position.yDirection==0) {
            if (position.xDirection==-1) {
                g.drawImage(forestPathUp, 0, 0, null);
            } else if (position.xDirection==0) {
                g.drawImage(rockBackground, 0, 0, null);
            } else if (position.xDirection==1) {
                g.drawImage(endBackground, 0, 0, null);
            }
        } else if (position.yDirection==1) {
            if (position.xDirection==-1) {
                g.drawImage(godBackground, 0, 0, null);
            } else if (position.xDirection==0) {
                g.drawImage(forestPath, 0, 0, null);
            } else if (position.xDirection==1) {
                g.drawImage(castleBackground, 0, 0, null);
            }
        }
        for (Player player : players) {
            player.drawMe(g);
        }
        for (Player player : players) {
            if (player.speaking) player.speak(g);
        }
        for (Item item : items) {
            item.drawMe(g);
        }
        p.drawMe(g);
        g.drawString("X: " + position.xDirection, 10, 15);
        g.drawString("Y: " + position.yDirection, 10, 30);
        g.drawString(questsCompleted.size() + "/" + 8, 470, 85);
        if (questsCompleted.size() > 0) {
            int xPosition = 470;
            int yPosition = 100;
            g.drawString("Completed Quests: ", xPosition, yPosition);
            for (String quest : questsCompleted) {
                g.drawString(quest, xPosition, yPosition += 15);
            }
        }
        g.setColor(Color.BLACK);
    }

    public void dropItem(Item item) {
        item.x = p.x;
        item.y = p.y;
        this.items.add(item);
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }
}