#language:de
Funktionalität: (AoF-B-200) Bewegungsregeln für das Spiel

  Szenario: Stein bewegt sich in einer geraden Linie
  Testfall: 200-1
    Angenommen das Spiel ist aktiv
    Und ein Spieler will einen Stein bewegen
    Wenn der Spieler den Stein in einer geraden Linie bewegt
    Dann wird der Zug als gültig anerkannt

  Szenario: Mehrere Bewegungen in einem Zug
  Testfall: 200-2
    Angenommen ein Spieler ist am Zug
    Und der Spieler hat einen Stein ausgewählt
    Wenn der Spieler den Stein mehrfach in einer Linie bewegt
    Dann werden alle Bewegungen korrekt ausgeführt

  Szenario: Bewegung mit Steinen der eigenen Farbe
  Testfall: 200-3
    Angenommen ein Spieler möchte einen Stein bewegen
    Und der Stein gehört zur Farbe des Spielers
    Wenn der Spieler den Stein bewegt
    Dann wird die Bewegung durchgeführt

  Szenario: Eingekreister Stein darf bewegt werden
  Testfall: 200-4
    Angenommen ein Stein ist von anderen Steinen umgeben
    Wenn der Spieler den eingekreisten Stein bewegen möchte
    Dann ist die Bewegung möglich
