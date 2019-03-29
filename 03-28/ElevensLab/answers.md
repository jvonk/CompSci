### A1E1
```java
rank = cardRank;
suit = cardSuit;
pointValue = cardPointValue;
```

```java
return suit;
```

```java
return rank;
```

```java
return pointValue;
```

```java
return (otherCard.pointValue==pointValue && otherCard.rank==rank && otherCard.suit==suit);
```

```java
return rank+" of "+suit+"(point value = "+pointValue+")";
```

### A1E2
```java
Card[] cs = new Card[] {new Card("9", "Diamonds", 9), new Card("Jack", "Spades", 10), new Card("King", "Clubs", 10)};
for (Card c: cs) {
	System.out.println(c.suit());
	System.out.println(c.rank());
	System.out.println(c.pointValue());
	System.out.println(c.matches(new Card("Jack", "Spades", 10)));
	System.out.println(c+"\n");
}
```

### A2E1
```java
cards=new ArrayList<>();
for (int i = 0; i < ranks.length; i++) {
  for (String suit : suits) {
     cards.add(new Card(ranks[i], suit, values[i]));
  }
}
size = cards.size();
shuffle();
```

```java
return cards.size()==0;
```

```java
return size;
```

```java
if (isEmpty()) {
  return null;
}
size--;
Card c = cards.get(size);
return c;
```

### A2E2
```java
Deck[] cs = new Deck[3];
cs[0] = new Deck(new String[] {"9", "1"}, new String[] {"Diamonds", "Clubs"}, new int[] {9, 1});
cs[1] = new Deck(new String[] {"Jack"}, new String[] {"Spades"}, new int[] {10});
cs[2] = new Deck(new String[] {"King"}, new String[] {"Clubs"}, new int[] {10});
for (Deck c: cs) {
  System.out.println(c.deal());
  System.out.println(c.isEmpty());
  System.out.println(c+"\n");
}
```

### A2Q1
A deck is a group of cards with some methods such that it behaves like a normal deck. 

### A2Q2
The deck will contain 3*2 = 6 cards in total because it has all combinations of ranks and suits. 

### A2Q3
```java
String[] ranks = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"};
String[] suits = {"club", "heart", "diamond", "spade"};
int[] pointValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
Deck d = new Deck(ranks, suits, pointValues);
```

### A2Q4
No because the deck is shuffled afterwards so in the end it makes no real difference. 

### A3E1
```java
int[] temp = new int[values.length];
int i = 0;
for (int j = 0; i < (values.length+1)/2; i++, j+=2) temp[j] = values[i];
for (int j = 1; i < values.length; i++, j+=2) temp[j] = values[i];
for (i = 0; i < values.length; i++) values[i] = temp[i];
```

```java
for (int i = values.length-1; i > 0; i--) {
  int j = (int) (Math.random()*(i+1));
  int temp = values[j];
  values[j]=values[i];
  values[i]=temp;
}
```

### A3E2
The perfect shuffle is worse because it is predictable and always does the same. The selection shuffle is must better. 

### A3Q1
```java
public static String flip {
   return (Math.random()<2/3)?"heads":"tails";
}
```

### A3Q2
```java
public static boolean arePermutations (int[] as, int[] bs) {
  Map<Integer, Integer> map = new HashMap<>();
  for (int a : as) {
     map.putIfAbsent(a, 0);
     map.put(a, map.get(a)+1);
  }
  for (int b : bs) {
     if (map.get(b)==null || map.get(b)==0) return false;
     map.put(b, map.get(b)-1);
  }
  return true;
}
```

### A3Q3
For the sequence {0, 1, 1, 0}

### A4E1
```java
Collections.shuffle(cards);
size = cards.size();
```

### A4E2
```java
Deck deck = new Deck(new String[] {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"}, new String[] {"Diamond", "Spade", "Club", "Heart"}, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10});
System.out.println(deck);
deck.shuffle();
System.out.println(deck);
```

### A6Q1
I won about a third of all games.

Here are the pairs:
* A♠ and J♥
* A♠ and K♦
* 5♠ and 6♣
* 5♣ and 6♣

### A6Q2
Yes because there would be no other way in which to win the game, so you must lose.

### A6Q3
No the game involves no strategy because any pair or triplet is just as good. It ends up with the same results. 

### A7Q1
If you were playing a game of Elevens on your desk, it would be necessary to have a deck of cards and something to cover cards up. 

The private instance variables needed include a board size variable, a array of ranks, array of suits, and array of point values.

### A7Q2
1. Make a new game
2. Make sure that there are at least 9 cards in the deck left over
3. Draw as many cards as possible up to nine from the deck
4. See if there is a set of King, Queen, and Jack and then replace. 
5. Do the same for a pair that adds to 11
6. If 4 and 5 did nothing then the game is over
7. Repeat 4-6 until there are no cards on deck or board
8. Game is won

### A7Q3
Yes, the ElevensBoard class contains everything that is necessary for a game. 

### A7Q4
dealMyCards is called when a new game is started and in the constructor

The anotherPlayIsPossible and isLegal methods should call these methods

It should return {0, 1, 3, 6, 7} It will ignore the null indexes. 

```java
for (int i : cIndexes) System.out.println(board.cards[i]);
```

The method that requires the cardIndexes method is the anotherPlayIsPossible method because it has to check if there are the right values.

### A8Q1
The similarities are that they all use a full deck of cards and a board on which the cards are placed. Some functions can be used for all of them because they are crucial such as the isEmpty function. Yet because the games are still different, most functions will have to be rewritten for the other games. Moreover, a couple functions like checking if there is a Jack, Queen, or King will be completely different or only exist in one game.

### A8Q2
The Board values get initialized by passing them into its' initializer through a super() call. 

### A8Q3
The abstract methods in Board.java include anotherPlayIsPossible and isLegal because these methods require different implementations for each game. They cover all the differences because all of the methods exactly overlap each other. 

### A9E1
```java
if (selectedCards.size()==2) return containsPairSum11(selectedCards);
else if (selectedCards.size()==3) return containsJQK(selectedCards);
else return false;
```

```java
return containsPairSum11(new ArrayList<>(cardIndexes())) || containsJQK(new ArrayList<>(cardIndexes()));
```

```java
for (int i = 0; i < selectedCards.size(); i++) {
  for (int j = i+1; j < selectedCards.size(); j++) {
     if (cardAt(selectedCards.get(i).intValue()).pointValue() + cardAt(selectedCards.get(j).intValue()).pointValue() == 11 ) return true;
  }
}
return false;
```

```java
boolean[] found = new boolean[3];
for (int i : selectedCards) {
  if (cardAt(i).rank().equals("jack")) {
     found[0] = true;
  } else if (cardAt(i).rank().equals("queen")) {
     found[1] = true;
  } else if (cardAt(i).rank().equals("king")) {
     found[2] = true;
  }
}
return found[0]&&found[1]&&found[2];
```

### A9Q1
Size is not an abstract method because it is already kept track of in boards.size() and updated so it will end up being correct for all variations. 

### A9Q2
The logic to select a card is located in the GUI so it does not need to be implemented. 

### A9Q3
Yes, this answer will still work but the different classes would not get to share any logic making this a much poorer answer. If the different Boards were completely different than this would certainly be the preferable answer. 