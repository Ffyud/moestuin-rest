Feature: De moestuin REST service gebruiken

  Background:
    Given er is een moestuin REST service
    And testdata is geschoond

  Scenario: Een tuin toevoegen
    Given er is geen tuin
    When een tuin wordt opgevoerd met naam 'Diverdoatsie' van 5 breed en 5 hoog
    Then bestaat de tuin 'Diverdoatsie'

  Scenario: Een plant toevoegen
    Given een plant 'brocolli' wordt opgevoerd
    Then is de plant opgeslagen

  Scenario: Een plant aan een tuin toevoegen
    Given een tuin wordt opgevoerd met naam 'Diverdoatsie' van 5 breed en 5 hoog
    And er een plant 'bloemkool' is
    When de plant aan de tuin wordt toegevoegd op kolom 1 en rij 2
    Then is de plant opgeslagen op kolom 1 en rij 2 op de tuin

