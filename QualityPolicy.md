### Quality Policy
> Describe your Quality Policy in detail for this Sprint (remember what I ask you to do when I talk about the "In your Project" part in the lectures and what is mentioned after each assignment (in due course you will need to fill out all of them, 
check which ones are needed for each Deliverable). You should keep adding things to this file and adjusting your policy as you go.

**GitHub Workflow** (due start Sprint 1)
  > We will create a Dev branch that we will use to work off of. We will also create task branches that we will use to work on our individual tasks. When the user story merges into dev are done for the sprint, a pull request into master will be opened to merge our collective changes. The Git master will approve pull requests into dev and master after confirming that the code review and applicable JUnit tests have been completed. 

**Unit Tests Blackbox** (due start Sprint 2)
  > Unit Tests will be done on each task while in the "ready for test" category.
  > Our commit comments for Unit testing will identify the Unit Test we are committing.
  > We will be using JUnit 4 for all Blackbox testing.


 **Unit Tests Whitebox** (due start Sprint 2)
  > We will commit to achieving at least 60% code coverage.
  > We will be using EclEmma in the Eclipse IDE for Whitebox testing.
  > Unit Tests will be done on each task while in the "ready for test" category.
  > We will be using JUnit 4 for all Whitebox testing.


**Code Review** (due start Sprint 2)
  > At least one person other than the author of the code will perform a code review.
  > Code reviews will be generally informal, with the possibility of a more structured and formal review if necessary.
  > If a task can be tested simply by opening the program or viewing a changed image/text field, it will not require a Black/Whitebox test.

  > Include a checklist/questions list which every developer will need to fill out/answer when creating a Pull Request to the Dev branch. 

|	File Name	|	Has Been Reviewed	|	Reviewed By		|	Review Form Filename		|	Blackbox Tested? (Filename)	|	Whitebox Tested? (Filename)	|
|-----------------------|-------------------------------|-------------------------------|---------------------------------------|---------------------------------------|---------------------------------------|
|			|				|				|					|					|					|

  > Include a checklist/question list which every reviewer will need to fill out/anser when conducting a review, this checklist (and the answers of course) need to be put into the Pull Request review.

Checklist/Review Form:

|ID #	|	File and Line Number	|	Problem Description		|Problem Category	|Problem Severity	|Testing Required	|
|-------|-------------------------------|---------------------------------------|-----------------------|-----------------------|-----------------------|
|	|				|					|			|			|			|


Category: CS – Code Smell defect. CG – Violation of a coding guideline. Provide the
guideline number. FD – Functional defect. Code will not produce the expected
result. MD – Miscellaneous defect, for all other defects.

Severity: BR - Blocker, must be fixed asap. MJ – Major, of high importance but not a Blocker LOW – Low

Testing Required: Y/N - Whether or not issue needs Black/Whitebox testing or if it can be tested simply by opening a program or viewing an icon/text field.


**Static Analysis**  (due start Sprint 3)
  > Ensure code is compliant with Checkstyle and Spotbugs standards for all newly introduced classes.

**Continuous Integration**  (due start Sprint 3)
  > Ensure that Travis CI clears branch before merging into dev branch.
