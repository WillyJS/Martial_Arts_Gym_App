# Deliverable Information
   > Please include your answers below in a good format so it is easy for me to see. For answers to questions please use these Blockquotes. Make sure you also check the kickoff document for more details. Also make sure this thing is well formatted and the links are links in here. 

## 1: Basic Information (needed before you start with your Sprint -- Sprint Planning)

**Topic you chose:** Gym Scheduler

**Sprint Number:** 3

**Scrum Master**: Michael Padilla

**Git Master**: Jesus Quiroz

### Sprint Planning (For Sprint 1-3)
Document your Sprint Planning here. Also check the kickoff document for more details on what needs to be done. This is just the documentation. 

**Sprint Goal:** This sprint will focus on improving usability of the program for class scheduling purposes. Compartmentalization of user access will also be implemented. 

**How many User Stories did you add to the Product Backlog:**  
> The backlog is empty

**How many User Stories did you add to this Sprint:** 
> 8 user stories were added to this sprint.

> Answer the questions below about your Sprint Planning?

**Why did you add these US, why do you think you can get them done in the next Sprint?**

> These user stories align with the requirements outlined in the project kickoff document and will add significant business value to the memoranda improvement effort. The user stories capture broad regions of the program functionality which will allow the team to implement more specialized tasks that are manageable for the expected sprint timeline. 

**Why do you think these fit well with your Sprint goal? (details)**

> These user stories align with implementation of class and user management. Adjustment of the users' permissions is also a part of the functionality added through these tasks which will complete additional program requirements. 

**Do you have a rough idea what you need to do? (if the answer is no then please let me know on Slack)**

> Yes, our team understands the sprint goals and has a good knowledge of the program source code to work on the tasks for this sprint. 



## 2: During the Sprint
> Fill out the Meeting minutes during your Sprint and keep track of things. Update your Quality policies when needed, as explained in the lectures and in the Quality Policy documents on Canvas. 
I would also advise you to already fill out the Contributions section (End of sprint) as you go, to create less work at the end.

### Meeting minutes of your Daily Scrums (3 per week, should not take longer than 10 minutes):
> Add as many rows as needed and fill out the table. (Burndown starts with Sprint 2 and Travis CI starts with Sprint 3, not needed before that). 

| Date   | Attendees        |Meeting notes (very brief)   | Burndown Info (on track, ahead behind is enough) | TravisCI info (does the master pass) | Additional Info  |
|--------|------------------|-------------------------------|---------------|---------------|------------------|
|  11/29 | William Sanchez, Paul Duncanson, Jesus Quiroz, Michael Padilla | Reviewed progress on current sprint and set expectations for remaining time. | behind  | Master passes  |          |
|  12/03 | William Sanchez, Paul Duncanson, Jesus Quiroz, Michael Padilla | Went through deliverable document and statused user stories | behind (only one task remains) | Master passes  |          |
           

### Meeting Summary:

>Stand-up questions:

	1. What have you been working on?
	2. What do you plan on working on?
	3. Do you foresee anything that will make it difficult for you to finish your work?

> Add rows as needed and add the number how many meetings for each team member:

  ## William J Sanchez : 2 meetings
  ### Meeting 1:
	1. Added Manage button to admin screen.  Added GUI for user management.  In User management panel I crated two buttons.  Admin will be able to search for an individual user to change his access or remove from the system. Added button for Admin to see a list of all users registered in the system.
	2. Refining US66Task80 after it's been implemented continue with another open task.
	3. No.
  ### Meeting 2:
	1. Added version and build number implementation.
	2. Retrospective.
	3. no.

  ## Paul Duncanson : 2 meetings
  ### Meeting 1:
	1. I have been working on creating a DojoClass class to represent classes that can be created at our dojo.
	2. I plan on improving the functionality of the dojoClass based on the requirements from the kickoff documentation.
	3. I don't foresee any issues that will prevent me from finishing my tasks.
  ### Meeting 2:
	1. I have been working on implementing the DojoClass and Room classes.
	2. Sprint Retrospective
	3. No, everything should be finished on time.

  ## Jesus Quiroz : 2 meetings
  ### Meeting 1:
	1. Working on implementing the functionality for search user under user management
	2. Will move to the display all users implementation
	3. As long as this week's assignment is not as time consuming as the last one I should be good.
  ### Meeting 2:
	1. Finished the display all users feature to complete the user management portion of the project
	2. Sprint retrospective, final pull request approvals
	3. No

  ## Ryan Was : 2 meetings
  ### Meeting 1:
	1. Changing the software to no longer refer to Memoranda (Dojo Manager Instead)
	2. Removing the Editor Tab.
	3. Thanksgiving and work for other classes.
  ### Meeting 2:
	1. Removing the Editor panel, since there is no need for it that we can see, and fixing is has proven to be more complex than previously thought.
	2. Finishing leftover tasks and testing.
	3. Work (Other courses and otherwise)

  ## Michael Padilla : 2 meetings
  ### Meeting 1:
	1. I have not started my user story assignments for this sprint.
	2. I plan on starting to review the progress made by my teammates to implement my own code.
	3. Time limitations between school and work might make it difficult for this sprint.
  ### Meeting 2:
	1. I have taken up the task to create the class room database to support user story 69
	2. I plan on reviewing the progress made by Paul in this user story to understand how to implement this task.
	3. Again, time constraints may complicate my ability to dedicate adequate time to development of this task.

## 3: After the Sprint

### Sprint Review
Answer as a team!

**Screen Cast link**: https://youtu.be/VDF7GQPYx0M

> Answer the following questions as a team. 

**What do you think is the value you created this Sprint?**

> This sprint added the utilization of class scheduling in accordance with the requirements in the kickoff document. The classes allow a maximum of 20 students for public classes and only 1 for private classes. The trainer levels are also taken into account for the trainer assignments. User compartmentalization now impacts the access levels for program functionality, which impedes accidental data changes. 

**Do you think you worked enough and that you did what was expected of you?**

> The team dedicated a significant amount of time to producing the quality code added in this sprint. The expectations from the kickoff document were met through the user stories that were completed. 

**Would you say you met the customers’ expectations? Why, why not?**

> The program does meet the customers' expectations for this sprint. We've developed the user stories that build upon usability of the program for class scheduling and separates access levels for the different users. 


### Sprint Retrospective

> Include your Sprint retrospective here and answer the following questions in an evidence based manner as a team (I do not want each of your individuals opinion here but the team perspective). By evidence-based manner it means I want a Yes or No on each of these questions, and for you to provide evidence for your answer. That is, don’t just say "Yes we did work at a consistent rate because we tried hard"; say "we worked at a consistent rate because here are the following tasks we completed per team member and the rate of commits in our Git logs."

**Did you meet your sprint goal?**

> The team did meet the spring goals of class scheduling and access compartmentalization. The one task in user story 69 that was not completed is not critical for class scheduling. 

**Did you complete all stories on your Spring Backlog?**

> One user story (69) was not completed. The rest are finished.

**If not, what went wrong?**

> The missing user story task was not completed due to time constraints. The assignee did not dedicate enough time to develop and test the appropriate code to complete it. 

**Did you work at a consistent rate of speed, or velocity? (Meaning did you work during the whole Sprint or did you start working when the deadline approached.)**

> The sprint rate of speed does not match the ideal because it shows that a significant amount of the points were completed between 2 days (November 29 and November 30). The points distribution could have been improved for a more accurate repesentation of the work involved in each user story. 

**Did you deliver business value?**

> The team did deliver business value in this sprint's contributions because functionality of the program is expanded to allow class scheduling. The administration of users was also added which corresponds to the user able to have customers and manage their access levels for interaction with the program. 

**Are there things the team thinks it can do better in the next Sprint?**

> Time management is a key point in development of the user story tasks, and this can be improved to ensure a more steady sprint velocity. Allocation of user story points can be more accurate as well so the burn-down chart is more representative of the effort put into development of the product. 

**How do you feel at this point? Get a pulse on the optimism of the team.**

> The team is proud of the work that has been put into this project and confident that the code additions are of good quality and contribute to business value development. 

### Contributions:

> In this section I want you to point me to your main contributions (each of you individually). Some of the topcs are not needed for the first deliverables (you should know which things you should have done in this Sprint, if you don't then you have probably missed something):

#### William Sanchez:
  **Links to GitHub commits with main code contribution (up to 5 links) - all Sprints:

    - https://github.com/amehlhase316/Dresden-2/tree/US1
    - https://github.com/amehlhase316/Dresden-2/tree/US15
    - https://github.com/amehlhase316/Dresden-2/tree/US29
    - https://github.com/amehlhase316/Dresden-2/tree/US32
    - https://github.com/amehlhase316/Dresden-2/tree/US39Task57

 **What was your main contribution to the Quality Policy documentation?:

    -  

#### Paul Duncanson:
  **Links to GitHub commits with main code contribution (up to 5 links) - all Sprints:

    - https://github.com/amehlhase316/Dresden-2/tree/US19
    - https://github.com/amehlhase316/Dresden-2/tree/US29
    - https://github.com/amehlhase316/Dresden-2/tree/US4
    - https://github.com/amehlhase316/Dresden-2/tree/US40
    - https://github.com/amehlhase316/Dresden-2/tree/US41 

 **What was your main contribution to the Quality Policy documentation?:

    - 

#### Ryan Was:
  **Links to GitHub commits with main code contribution (up to 5 links) - all Sprints:

    - https://github.com/amehlhase316/Dresden-2/tree/US19
    - https://github.com/amehlhase316/Dresden-2/tree/US29
    - https://github.com/amehlhase316/Dresden-2/tree/US17
    - https://github.com/amehlhase316/Dresden-2/tree/US43
    - https://github.com/amehlhase316/Dresden-2/tree/US42
 
 **What was your main contribution to the Quality Policy documentation?:

    - 

#### Michael Padilla:
  **Links to GitHub commits with main code contribution (up to 5 links) - all Sprints:

    - https://github.com/amehlhase316/Dresden-2/tree/US3
    - https://github.com/amehlhase316/Dresden-2/tree/US18
    - https://github.com/amehlhase316/Dresden-2/tree/US70
 
 **What was your main contribution to the Quality Policy documentation?:

    - Main contribution is the US70 code review


 #### Jesus Quiroz:
  **Links to GitHub commits with main code contribution (up to 5 links) - all Sprints:

    - https://github.com/amehlhase316/Dresden-2/tree/US2
    - https://github.com/amehlhase316/Dresden-2/tree/US19
    - https://github.com/amehlhase316/Dresden-2/tree/US26
    - https://github.com/amehlhase316/Dresden-2/tree/US39
    - https://github.com/amehlhase316/Dresden-2/tree/US39Task50

 **What was your main contribution to the Quality Policy documentation?:

    -   

  
   **GitHub links to your Unit Tests (up to 3 links) -- Sprint 2 and 3:

    - https://github.com/amehlhase316/Dresden-2/tree/dev/src/test/java

  **GitHub links to your Code Reviews (up to 3 links) -- Sprint 2 and 3:

    - https://github.com/amehlhase316/Dresden-2/tree/dev/CodeReviews



## 4: Checklist for you to see if you are done
- [X] Filled out the complete form from above, all fields are filled and written in full sentences
- [X] Read the kickoff again to make sure you have all the details
- [X] User Stories that were not completed, were left in the Sprint and a copy created
- [X] Your Quality Policies are accurate and up to date
- [X] **Individual** Survey was submitted **individually** (create checkboxes below -- see Canvas to get link)
  - [X] Jesus Quiroz
  - [X] Paul Duncanson
  - [X] William Sanchez
  - [X] Michael Padilla
  - [X] Ryan Was
- [N/A] The original of this file was copied for the next Sprint (needed for all but last Sprint where you do not need to copy it anymore)
  - [ ] Basic information (part 1) for next Sprint was included (meaning Spring Planning is complete)
  - [ ] All User Stories have acceptance tests
  - [ ] User Stories in your new Sprint Backlog have initial tasks which are in New
  - [ ] You know how to proceed
