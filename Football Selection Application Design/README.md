## Design a production ready application football team selection based on input "player applications" and provided selection criterion. Output should either have both selection groups(Strikers & Defenders) or none, which should have equal number of candidates who meets the criterion. Select best candidate if there is a clash.

### Below are class diagrams for selection criterion.
____
FitnessFactor
-minHeight = 5.8 -maxBmi = 23
______

______
StrikerExperienceFactor
-minGoalsScored = 50
______

______
DefenderExperienceFactor
-minGoalsDefended = 30
______

Sample Input:    
Sorted based on name and space separated.     
First line: number of rows
Second line: number of columns
Next Lines: Name(string) Height(decimal) BMI(decimal) Scores(int) Defends(int)

4   
5    
Boateng 6.1 22 24 45   
Kaka 6 22 1 1    
Ronaldo 5.8 21 120 0   
Suarez 5.9 20 100 1.  

____
Sample Output:
Sorted based on name.   
Boateng SELECT DEFENDER      
Kaka REJECT NA
Ronaldo SELECT STRIKER   
Saurez REJECT NA


As you can see, selection comprises equal number (one) of both strikers (Ronaldo) and defenders (Boateng) while the rest (Kaka, Suarez) have been rejected despite one of them (Suarez) matching the selection criteria.
