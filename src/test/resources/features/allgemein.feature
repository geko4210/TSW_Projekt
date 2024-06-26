#language:de
Funktionalität: (AoF-Al-100) Allgemeine Spielregeln für das Plugin

  Szenario: Prüfung der Existenz von Steinen eigener Farbe
  Testfall: 100-1
    Angenommen ein Spiel läuft
    Und das Spiel hat mindestens einen Stein auf dem Spielfeld
    Wenn das GUI überprüft, ob Steine der eigenen Farbe vorhanden sind
    Dann gibt es mindestens einen Stein der ziehenden Farbe auf dem Feld

  Szenario: Überprüfung der Spieleranzahl im zulässigen Bereich
  Testfall: 100-2
    Angenommen ein Spiel ist initialisiert mit <Spieler> Spielern
    Wenn das GUI die Anzahl der Spieler abfragt
    Dann sollte die Antwort zwischen 2 und 4 liegen

  Szenario: Start des Spiels mit zufälligem Ziehen der Spielsteine
  Testfall: 100-3
    Angenommen das Spiel beginnt
    Und jeder Spieler hat noch keine Steine gezogen
    Wenn jeder Spieler "Anzahl der Spieler * 2" Spielsteine zufällig zieht
    Dann hat jeder Spieler die entsprechende Anzahl an Steinen in seiner Hand

  Szenario: Überprüfung der Spielfarbenanzahl entspricht Spieleranzahl
  Testfall: 100-4
    Angenommen das Spiel ist mit <Spieler> Spielern gestartet
    Wenn das GUI die Anzahl der Spielfarben abfragt
    Dann gibt es so viele Spielfarben wie Spieler

  Szenario: Korrekte Anzahl von Spielsteinen pro Farbe
  Testfall: 100-5
    Angenommen das Spiel ist gestartet
    Und jede Farbe wurde bereits mindestens einmal gezogen
    Wenn das GUI die Anzahl der Spielsteine einer Farbe abfragt
    Dann sind es genau 10 Spielsteine pro Farbe
