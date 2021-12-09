Reviewed by Jesus Quiroz (jaquiro1)

US32 LoginWindow.java Manual Inspection Review Results:  

|ID #	| LoginWindow.java Line Number	|	Problem Description		|Problem Category	|Problem Severity	|Testing Required	|
|-------|-------------------------------|---------------------------------------|-----------------------|-----------------------|-----------------------|
|US32-1	|		1		|	File Banner Missing		|	CG		|	LOW		|	NO		|
|-------|-------------------------------|---------------------------------------|-----------------------|-----------------------|-----------------------|
|US32-2	|	       119		|	Inconsistant Indentation	|	CG		|	LOW		|	NO		|
|-------|-------------------------------|---------------------------------------|-----------------------|-----------------------|-----------------------|
|US32-3 |	       108		|	Hard coded user credentials	|	FD		|	LOW		|	NO		|

Above review resulting in 0 bugs and only a couple of coding standards violations were observerd. This class is only partially completed as of  11/08/20
that is why the Functinal Defect is of low prioriity as it will be removed once the json user login functionality is implemented. Since there were no bugs 
encountered, there will not be any corrections made at this point and a static analysis will be performed once the entire login class is commplete. The 
Checktyle and Spotbugs audits that will be perfomed at a later time will account for all  FD and CG issues. 