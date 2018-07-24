Feature:Car Test

  Scenario: Check the characteristics of the two models of cars
    Given Open http://www.cars.com
    When Select tab Research
      Then The Research page opens
    When Search for the car by random characteristics
      Then The FoundCar page opens
    When Go to the tab Compare Trims
      Then The CompareTrims page opens
    When Remember the characteristics of the car for the base trim
      And Go to the main page
      Then Open http://www.cars.com
    When Select tab Research
      Then The Research page opens
    When Search for the car by random characteristics
      Then The FoundCar page opens
    When Go to the tab Compare Trims
      Then The CompareTrims page opens
    When Remember the characteristics of the car for the base trim
      And Back to the Research page
      Then The Research page opens
    When Click on the Side-by-Side Comparisons section
      Then The SideBySide page opens
    When Choose the model selected in steps 2-5
      Then The CompareCars page opens
    When Using Add another car, we add to the comparison the model obtained in step 7
      Then Check the comparison page for 2 models