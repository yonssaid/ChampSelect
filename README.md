# ChampSelect – Champion Draft Recommendation via A* Search
This Java project implements a champion selection algorithm for League of Legends using A* search. It recommends optimized champion picks based on synergy, counter-matchups, pick order, and role constraints. Each node in the search tree represents a partial draft, and the algorithm prioritizes balanced and safe team compositions.

Developed by Yons Said.

## How to Build and Run

### Using IntelliJ
1. Open the project in IntelliJ.
2. Right-click `Main.java` and select "Run 'Main.main()'".
3. The console will display the recommended champion draft.

### Using Command Line
Navigate to the project directory and run:

```bash
javac Main.java
java Main
