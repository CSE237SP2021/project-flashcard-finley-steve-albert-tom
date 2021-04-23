# "Flashtastic" --- A flashcard app
<!-- Team Member -->
Albert Kao, Finley Li, Steve Li, and Sihan (Tom) Cai


<!-- ABOUT THE PROJECT -->
## Project Description
A flashcard app that allows users to create virtual flashcards with words and definitions in order to study for their classes. Fuctionality wise, it would be very similar to Quizlet, where users can study words and prepare for a quiz or exam.

The primary audience for the app are students who are studying for quizzes or exams, or people wishing to learn new vocabs or concepts. 

For best practice, we take advantage of Junit tests to gauge the correctness of the codes implemented. In order to maintain effective communication between group members, we created a group chat for people to ask and answer questions. We also hosted Zoom meetings regulary to discuss and address problems and challenges that we encountered along the way. 



<!-- Project Iterations -->
## Project Iterations
### Iteration 1:
#### What user stories were completed this iteration?

We designed a basic command-line UI for the menu, including many placeholder sections like viewing sets and adding sets models. Users can choose to create a new study set and change the name of the study set (within classes but not through the command-line UI). In addition, users can add words, definitions to the study set and view all the terms in it. Users can also modify terms and delete terms in a specific study set. To better manage the study set, we created a set manager responsible for managing study sets.

#### What user stories do you intend to complete next iteration?
We plan to add more modes to the app. For example, we would like to create a flashcard mode where the user can study each term individually. We also need to refactor the app so that it could store the data (study set etc.) created by the user locally and allow them to access these data the next time they run the program.  

#### Is there anything that you implemented but doesn't currently work?
We need to allow the main program to run continuously (currently the programs stops after the users add/open a set). One possible solution to this is to put everything in a while loop and add a quit button to stop the program when needed.

#### What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)?
To compile and run the program, simply run the following command: 
```
./run.sh 
``` 


### Iteration 2: 
#### What user stories were completed this iteration?
The menu of the app is fully reworked and now it's fully functional. Users can create study sets, add and edit terms through the menu as they wish.  

#### What user stories do you intend to complete next iteration? 
We need to implement various modes including a study mode where the users can study each term individually and possibly a game mode where the users take quizzes and test their understanding and familiarity with the concepts. 
#### Is there anything that you implemented but doesn't currently work?
We need to come up with ways to store the information locally. For example, the sets and terms created by the user could be stored locally and displayed during another session.

#### What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)?
To compile and run the program, simply run the following command: 
```
./run.sh 
``` 








