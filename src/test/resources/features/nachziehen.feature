#language:de
Funktionalität: (AoF-N-400) Nachziehen von Spielsteinen

  Szenario: Nachziehen überspringen, wenn Beutel leer ist
  Testfall: 400-1
    Angenommen der Beutel ist leer
    Und es ist Zeit zum Nachziehen
    Wenn ein Spieler versucht, einen Stein zu ziehen
    Dann wird das Nachziehen übersprungen

  Szenario: Hand voll, Nachziehen übersprungen
  Testfall: 400-2
    Angenommen ein Spieler hat bereits volle Hand
    Und es ist Zeit zum Nachziehen
    Wenn der Spieler versucht, einen Stein zu ziehen
    Dann wird das Nachziehen übersprungen

  Szenario: Korrekte Steinanzahl nach dem Nachziehen
  Testfall: 400-3
    Angenommen es ist Zeit zum Nachziehen
    Und ein Spieler zieht einen Stein
    Wenn die Hand des Spielers überprüft wird
    Dann ist die Anzahl der Steine in der Hand korrekt
