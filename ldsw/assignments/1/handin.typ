#set heading(numbering: "1.1")
#align(center,text(size:20pt,[Linked Data & Semantic Web\ Assignment 1]))

= Include other competency questions that might be missing here
- Does a course have at least one lecturer?
- Is there a course that all students attend?
- Is there a student that doesn't follow any computer science modules?
- How many students are attending the university?

= Design the very same conceptual model that was given as an UML class diagram
#image("university uml.jpg",width: 50%)
= Define a dictionary for the case

/ University: An institution of higher education having authority to award bachelors' and higher degrees, usually having research facilities
/ Person: a human being as distinguished from an animal or a thing
/ Lecturer: A person that teaches one or more modules
/ Student: A person formally engaged in learning, especially one enrolled in a school or college; pupil.
/ Module/Course: a program of instruction, as in a college or university.
/ To teach: to impart knowledge of or skill in; give instruction in.
/ To study: to apply oneself to the acquisition of knowledge, as by reading, investigation, or practice.

= Define a list of possible rules and constraints that should be applied to the conceptual module
- A person cannot be both student and lecturer
- StaffIDs must be positive
- StudentIDs must be positive
- A student must be studying at least 6 courses
- A lecturer cannot teach more than 4 courses
- A person's name and surname must only contain letters

