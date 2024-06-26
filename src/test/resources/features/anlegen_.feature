#language:de
Funktionalität: (AoF-An-300) Anlegen von Spielsteinen

  Szenario: Anlegen innerhalb gültiger Positionen
  Testfall: 300-1
    Angenommen ein Spieler möchte einen Stein anlegen
    Und die Position für den Stein liegt zwischen x[-50, 50] und y[-50, 50]
    Wenn der Stein angelegt wird
    Dann wird der Zug akzeptiert

  Szenario: Anlegen muss nach bestimmten Regeln erfolgen
  Testfall: 300-2
    Angenommen es ist der erste Zug eines Spielers
    Und der Spieler möchte einen Stein anlegen
    Wenn der Stein ohne angrenzende Steine angelegt wird
    Dann wird der Zug akzeptiert

  Szenario: Anlegen nicht möglich nach einer Bewegung
  Testfall: 300-3
    Angenommen ein Spieler hat in seinem Zug bereits einen Stein bewegt
    Und der Spieler möchte anschließend einen Stein anlegen
    Wenn der Spieler versucht, den Stein anzulegen
    Dann wird der Zug nicht akzeptiert
