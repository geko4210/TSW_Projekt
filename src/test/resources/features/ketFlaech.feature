#language:de
Funktionalität: (AoF-KS-500) Ketten und Spielfläche Regeln

  Szenario: Alle Steine müssen verbunden sein
  Testfall: 500-1
    Angenommen das Spiel ist in der Phase des Anlegens oder Bewegens
    Und ein Spieler hat einen Stein bewegt oder angelegt
    Wenn die Spielfläche überprüft wird
    Dann müssen alle Steine mindestens eine Verbindung haben

  Szenario: Keine Kettenbildung erlaubt mit drei Einzelverbindungen
  Testfall: 500-2
    Angenommen es gibt eine Kette von Froschsteinen
    Und ein Spieler fügt einen weiteren Froschstein hinzu
    Wenn die Kette drei oder mehr Einzelverbindungen hat
    Dann wird der Zug nicht akzeptiert

