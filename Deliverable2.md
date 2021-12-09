# Deliverable Information
   > Please include your answers below in a good format so it is easy for me to see. For answers to questions please use these Blockquotes. Make sure you also check the kickoff document for more details. Also make sure this thing is well formatted and the links are links in here. 

## 1: Basic Information (needed before you start with your Sprint -- Sprint Planning)

**Topic you chose:** Gym Scheduling

**Sprint Number:** 2

**Scrum Master**: Ryan Was

**Git Master**: Paul Duncanson

### Sprint Planning (For Sprint 1-3)
Sprint 1 Planning Meeting 10/18/20:
Team reviewed the code individually to get a sense of what we had to work with.  We Then came up with our own items to add to the product backlog and the sprint backlog on taiga.  We then came up with tasks that helped us achieve our sprint goal.  

Sprint 2 Planning Meeting 11/02/20:
GitHub Workflow overview for Sprint 2. Team reviewed the code and US/tasks completed in Sprint 1 individually and then shared our thoughts on our progress.  We then collaborated and came up with our own User Stories to add to the product backlog and the sprint backlog on taiga.  We then discussed tasks that helped us achieve our sprint goal.

Sprint 2 Planning Meeting 11/04/20:
Finalize planning and update Taiga board.  Double check deliverable documents.

Sprint 2 Review/Sprint 3 Planning Meeting 11/17/20:
Review Sprint 2 and Plan Sprint 3.


**Sprint Goal:** Implement Back-End Functionality and Account Creation/Access.

**How many User Stories did you add to the Product Backlog:**  5

**How many User Stories did you add to this Sprint:** 8

> Answer the questions below about your Sprint Planning?

**Why did you add these US, why do you think you can get them done in the next Sprint?**

> After updating the general UI, we felt that it would be appropriate to transition into implementing more of the core functionality in order to provide business value.

**Why do you think these fit well with your Sprint goal? (details)**

> These User Stories all continue to build toward the end-goal of a functional, professional gym scheduling software.

**Do you have a rough idea what you need to do? (if the answer is no then please let me know on Slack)**

> Yes.

## 2: During the Sprint
> Fill out the Meeting minutes during your Sprint and keep track of things. Update your Quality policies when needed, as explained in the lectures and in the Quality Policy documents on Canvas. 
I would also advise you to already fill out the Contributions section (End of sprint) as you go, to create less work at the end.

### Meeting minutes of your Daily Scrums (3 per week, should not take longer than 10 minutes):
> Add as many rows as needed and fill out the table. (Burndown starts with Sprint 2 and Travis CI starts with Sprint 3, not needed before that). 

| Date   | Attendees        |Meeting notes                  | Burndown Info | TravisCI info | Additional Info  |
|--------|------------------|-------------------------------|---------------|---------------|------------------|
|  11/09 | William Sanchez, | JSon Login/Reg, UI Fixes      | on track      | Still in dev  |                  |
           Paul Duncanson,
           Ryan Was,
           Jesus Quiroz,
           Michael Padilla

| Date   | Attendees        |Meeting notes                  | Burndown Info     | TravisCI info | Additional Info  |
|--------|------------------|-------------------------------|-------------------|---------------|------------------|
|  11/12 | William Sanchez, | More JSON Login/Reg,   	    | back on track     | Still in dev  |                  |
           Paul Duncanson,    Preferences Menu, Burndown,     after being
           Ryan Was,          Plugins                         slightly behind
           Jesus Quiroz,
           Michael Padilla

| Date   | Attendees        |Meeting notes                  | Burndown Info     | TravisCI info | Additional Info  |
|--------|------------------|-------------------------------|-------------------|---------------|------------------|
|  11/15 | William Sanchez, | More JSON Login/Reg,   	    | on track,     	| Still in dev  |                  |
           Paul Duncanson,    Preferences Menu		      but finishing
           Ryan Was,                                   	      with unfinished
           Jesus Quiroz,				      US
           Michael Padilla


### Meeting Summary:

>Questions:

	1. What have you been working on?
	2. What do you plan on working on?
	3. Do you foresee anything that will make it difficult for you to finish your work?

> Add rows as needed and add the number how many meetings for each team member:

  ## William J Sanchez : 3 meetings
  ### Meeting 1:
	1. Created Login GUI and functionality.  Created blackbox and whitebox tests for login class.
	2. Creating Registration GUI and functionality.  Creating blackbox and whitebox tests for registration class.
	3. No.
  
  ### Meeting 2:
	1. What have you been working on? creating the registration UI. Debugging login window with splash screen.
	2. What do you plan on working on? Refine the Login and registration windows.  Pick up an available task afterwards.
	3. Do you foresee anything that will make it difficult for you to finish your work? No. (edited) 

  ### Meeting 3:
	1. Login and Registration windows now have the enter key implementation.
	2. Sprint 2 Retrospective with group.
	3. No

  ## Paul Duncanson : 3 meetings
  ### Meeting 1:
	1. I have been working on modifying the preferences menu. 
	2. I will continue fixing more issues with the preferences menu
	3. No, I should be able to finish my tasks.

  ### Meeting 2:
	1. I have been working on getting a cross computer task and events saved solution.
	2. I plan on streamlining the preferences menu to be more appropriate to our gym system.
	3. No, although I have been having some issues with my IDE and some of our more recent builds.  I believe I have found a workaround solution for the problem.

  ### Meeting 3:
	1. I have been working finishing up my preference menu update.
	2. I will help out with the sprint 2 retrospective.
	3. I don't foresee any issues with accomplishing this task.

  ## Ryan Was : 3 Meetings
  ### Meeting 1:
	1. I have been working on creating testing package/classes, a minor ui change (stickers).
	2. I am planning on starting with creating a persistent event database/file.  After that I will be taking another task/US and helping with others' tasks when I can.
	3. I have course and other work going on elsewhere, but I will do my best!


  ### Meeting 2:
	1. Implementing test packages and classes, methods to populate user objects using JSON, managing documentation (scrum), and beginning to implement the font size feature.
	2. I am planning on finishing the font size edit feature, and then testing all I can.
	3. No.


  ### Meeting 3:
	1. Testing, closing open tasks, documentation, test classes, and attempting to fix the editing panel.
	2. Continuing to work on documentation for this deliverable, and hopefully finishing the editor panel task if I have the time.
	3. Time constraints and other work.

  ## Michael Padilla : 3 Meetings
  ### Meeting 1:

	1. Starting to investigate possible options for automatically updating the build/revision number for the program.
	2. Implementing possible GIT options for managing versions.
	3. I do not expect to encounter difficulties with completing the tasks.

  ### Meeting 2:
	1. Still reviewing options for build/version auto-update implementation.
	2. Selecting the best path forward and implementing for testing before pushing to dev.
	3. I don't have any technical limitations, but finding time to work on this is becoming a challenge. I'm trying to set aside any free-time to dedicate to this user story. (edited) 

  ### Meeting 3:
	1. Continued attempts to realize automatic version/build numbers for GUI.
	2. Sprint has concluded. No additional work planned. Provided java code included limitation for version/build manipulation.
	3. End of sprint. No work to complete.

  ## Jesus Quiroz : 3 Meetings 
  ### Meeting 1:
	1. What have you been working on? Implementing a way to store users information for login by using JSON
	2. What do you plan on working on? Finalizing the implementation for login and move on the JSON implementation required to add/edit/delete users (Registry)
	3. Do you foresee anything that will make it difficult for you to finish your work? I am a little behind on my homework due to work, but I plan to continue my work on the project on Tuesday once I finish with the homework assignment
  
  ### Meeting 2:
	1. Running spot bugs and checkstyle audits on my newly added classes. Working on the back end of the user registration part by incorporating methods to add to the json database.
	2. Finish registration part, run audits, check for pending tasks and/or if help is needed
	3. No

  ### Meeting 3:
	1. Finished json user implementation along with test classes, checkstyle, and spotbugs audits for my new classes
	2. Assist where needed and the sprint retrospective
	3. No

## 3: After the Sprint

### Sprint Review
Answer as a team!

**Screen Cast link**: https://youtu.be/27HItU_4LIg

> Answer the following questions as a team. 

**What do you think is the value you created this Sprint?**

> Work was done on the preferences menu, as well as implementing login/registration functionality/GUI and backend classes/linking classes to database.
> System is now more secure.

**Do you think you worked enough and that you did what was expected of you?**

> Considering we completed our core objectives, we feel that we worked enough.  We finished our most important tasks.

**Would you say you met the customers’ expectations? Why, why not?**

> We feel that we did meet the customer's expectations, as they can now login, register, and access a persistent set of scheduler events.
> This is in line with our stated Sprint goals.


### Sprint Retrospective

> Include your Sprint retrospective here and answer the following questions in an evidence based manner as a team (I do not want each of your individuals opinion here but the team perspective). By evidence-based manner it means I want a Yes or No on each of these questions, and for you to provide evidence for your answer. That is, don’t just say "Yes we did work at a consistent rate because we tried hard"; say "we worked at a consistent rate because here are the following tasks we completed per team member and the rate of commits in our Git logs."

**Did you meet your sprint goal?**

> Yes.  We completed the list of core features/functionality that we sought out to complete during the Sprint.

**Did you complete all stories on your Sprint Backlog?**

> We did not.  There are 2 remaining tasks which will be moved into the next Sprint.

**Did you work at a consistent rate of speed, or velocity? (Meaning did you work during the whole Sprint or did you start working when the deadline approached.)**

> Due to our different schedules, some changes were made in a way that did not result in a smooth burndown chart.  We had periods of time
> where we could not consistently make commits.

**Did you deliver business value?**

> Yes, we did deliver business value.  We added new features, and made the system more secure.  The user can now create an account, and login to the system.
> The preferences menu also now has a more intuitive feel, less irrelevant and/or confusing options.  Tasks are now persistent, and they can be accessed on 
> different systems.

**Are there things the team thinks it can do better in the next Sprint?**

> We can further hone our estimation methods, so that we can more accurately predict how much work will get done during our next Sprint.
> We also now know a little bit more about the software, and will be able to more efficiently make changes and implement new functionality.


**How do you feel at this point? Get a pulse on the optimism of the team.**

> We are motivated to move on to our final Sprint, and to get this project looking and operating according to the customer's specifications.

### Contributions:

> In this section I want you to point me to your main contributions (each of you individually). Some of the topcs are not needed for the first deliverables (you should know which things you should have done in this Sprint, if you don't then you have probably missed something):

#### William Sanchez:
  **Links to GitHub commits with main code contribution (up to 5 links) - all Sprints:

    - https://github.com/amehlhase316/Dresden-2/tree/US1
    - https://github.com/amehlhase316/Dresden-2/tree/US15
    - https://github.com/amehlhase316/Dresden-2/tree/US29
    - https://github.com/amehlhase316/Dresden-2/tree/US32
    - https://github.com/amehlhase316/Dresden-2/tree/US39Task57
    
#### Paul Duncanson:
  **Links to GitHub commits with main code contribution (up to 5 links) - all Sprints:

    - https://github.com/amehlhase316/Dresden-2/tree/US19
    - https://github.com/amehlhase316/Dresden-2/tree/US29
    - https://github.com/amehlhase316/Dresden-2/tree/US4
    - https://github.com/amehlhase316/Dresden-2/tree/US40
    - https://github.com/amehlhase316/Dresden-2/tree/US41

    
#### Ryan Was:
  **Links to GitHub commits with main code contribution (up to 5 links) - all Sprints:

    - https://github.com/amehlhase316/Dresden-2/tree/US19
    - https://github.com/amehlhase316/Dresden-2/tree/US29
    - https://github.com/amehlhase316/Dresden-2/tree/US17
    - https://github.com/amehlhase316/Dresden-2/tree/US43
    - https://github.com/amehlhase316/Dresden-2/tree/US42
    
#### Michael Padilla:
  **Links to GitHub commits with main code contribution (up to 5 links) - all Sprints:

    - https://github.com/amehlhase316/Dresden-2/tree/US3
    - https://github.com/amehlhase316/Dresden-2/tree/US18
    
  #### Jesus Quiroz:
  **Links to GitHub commits with main code contribution (up to 5 links) - all Sprints:

    - https://github.com/amehlhase316/Dresden-2/tree/US2
    - https://github.com/amehlhase316/Dresden-2/tree/US19
    - https://github.com/amehlhase316/Dresden-2/tree/US26
    - https://github.com/amehlhase316/Dresden-2/tree/US39
    - https://github.com/amehlhase316/Dresden-2/tree/US39Task50
    
   **GitHub links to your Unit Tests (up to 3 links) -- Sprint 2 and 3:

    - https://github.com/amehlhase316/Dresden-2/tree/dev/src/test/test
    - link2

  **GitHub links to your Code Reviews (up to 3 links) -- Sprint 2 and 3:

    - https://github.com/amehlhase316/Dresden-2/tree/dev/CodeReviews

  **How did you contribute to Static Analysis -- Sprint 3:

    - 
 
 **What was your main contribution to the Quality Policy documentation?:

    - The entire team came to a consensus on a approach on how to push to the dev branch and perform code reviews after completing user stories. 
  
## 4: Checklist for you to see if you are done
- [X] Filled out the complete form from above, all fields are filled and written in full sentences
- [X] Read the kickoff again to make sure you have all the details
- [X] User Stories that were not completed, were left in the Sprint and a copy created
- [X] Your Quality Policies are accurate and up to date
- [X] **Individual** Survey was submitted **individually** (create checkboxes below -- see Canvas to get link)
  - [X] Ryan Was
  - [X] Michael Padilla
  - [X] Jesus Quiroz
  - [X] Paul Duncanson
  - [X] William Sanchez

- [X] The original of this file was copied for the next Sprint (needed for all but last Sprint where you do not need to copy it anymore)
  - [X] Basic information (part 1) for next Sprint was included (meaning Spring Planning is complete)
  - [X] All User Stories have acceptance tests
  - [X] User Stories in your new Sprint Backlog have initial tasks which are in New
  - [X] You know how to proceed
