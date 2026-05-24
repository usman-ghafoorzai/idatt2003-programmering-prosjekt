# IDATT2003 Programmering Prosjekt

This repository contains my programming project from **IDATT2003** at NTNU.

It is a small Java/JavaFX card game coursework project where a random hand is dealt and simple hand checks are shown in the UI.

## Course Context

- **Course:** IDATT2003
- **Institution:** NTNU
- **Type:** student coursework project

## Features

- Deal a random 5-card hand from a deck
- Show cards in a JavaFX interface
- Check and display the sum of card faces
- Check and display whether all cards have the same suit
- Check and display whether the hand contains the queen of spades
- Check and display hearts in the hand

## Architecture / Structure

```text
src/main/java/edu/ntnu/idatt2003/
├── model/       PlayingCard, DeckOfCards, HandOfCards
├── view/        JavaFX UI classes
├── controller/  Controller connecting UI and model
└── Main.java    JavaFX application entry point
```

## Technologies

- Java 21
- JavaFX
- Maven
- JUnit dependency included in the project

## How to run

From the repository root:

```bash
mvn javafx:run
```

## Limitations

- Coursework project, not a production-ready application
- Small scope focused on course requirements
- No advanced packaging or deployment setup

## Academic integrity

This repository is shared as portfolio and course documentation.

If you are taking the same or a similar course, use it only as reference and write your own solution.
