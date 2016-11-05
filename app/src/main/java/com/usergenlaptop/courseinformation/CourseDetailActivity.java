package com.usergenlaptop.courseinformation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CourseDetailActivity extends AppCompatActivity {

    private String courseSelected;
    //BUSA 2720
    private final String BUSA2720name = "Business in a Networked Economy";
    private final String BUSA2720desc = "This course introduces students to basic business concepts and processes. The course starts from a global perspective examining the Canadian business environment, ethics and entrepreneurship. After students have an understanding of the Canadian business environment, the course looks at the main areas of concern for most businesses: managing people, managing operations and information, managing marketing and managing financial issues.";
    //COMM 1116
    private final String COMM1116name = "Business Communications 1";
    private final String COMM1116desc = "Information technology professionals spend time each day communicating orally and in writing with their supervisors, colleagues and clients. As problem-solvers and entrepreneurs in industry, you need to communicate quickly, clearly, and effectively. This course will teach you how to be a professional and efficient communicator at work. You will write effective business correspondence and instructions and deliver a formal oral presentation to your set. The first term establishes the principles and basic patterns on which you will build more advanced applications in the second term.";
    //COMP 1100
    private final String COMP1100name = "CST Program Fundamentals";
    private final String COMP1100desc = "The course covers topics of importance to new and continuing students on how to balance school and related activities to enhance chances of success in their academic careers. In this course students will learn a variety of different techniques to improve study habits, note taking, and time management skills. The class will also present other topics of interest to CST students and will introduce students to various support systems at BCIT.";
    //COMP 1111
    private final String COMP1111name = "Essential Skills for Computing";
    private final String COMP1111desc = "This course addresses technology expertise expected of our students but not specifically addressed in their other courses. These survival skills will better equip our CST students to succeed in their main programs of study.";
    //COMP 1113
    private final String COMP1113name = "Applied Mathematics";
    private final String COMP1113desc = "Comp 1113 is partially discrete mathematics, partially an introduction to linear equations. The purpose of this course is to give a strong foundation for future technical and programming courses. The course is divided into three parts: (1) Boolean algebra and design of logic circuits; (2) number systems and data representation; and (3) functions, linear equations, vectors and matrices.";
    //COMP 1510
    private final String COMP1510name = "Programming Methods";
    private final String COMP1510desc = "This course is the foundation for all future programming courses and complements COMP 1536. This course introduces the fundamental concepts of programming from an object-oriented perspective. Through the study of object design, this course also introduces the basics of human-computer interfaces, graphics, and the social implications of computing, along with some coverage of software engineering.";
    //COMP 1536
    private final String COMP1536name = "Introduction to Web Development";
    private final String COMP1536desc = "This course is a web design and programming course with an emphasis on good planning, interface design, multimedia, client-side scripting with JavaScript, server-side scripting, and best practices. COMP 1536 will provide students with a solid understanding about how web applications are constructed and deployed. Students will be taught to use client-side RAD tools in order to enhance their productivity. Students will complete a number of assignments and exams as well as one larger project.";

    //COMM 2216
    private final String COMM2216name = "Business Communications 2";
    private final String COMM2216desc = "Information technology professionals spend time each day communicating orally and in writing with their supervisors, colleagues and clients. As problem-solvers and entrepreneurs in industry, you need to communicate quickly, clearly, and effectively. This course will build on the skills you learned in first term to be an efficient and professional communicator at work. You will learn how to conduct an effective job search and write the accompanying resume and cover letter to support it. You will also write effective reports, deliver a persuasive oral presentation to your set, and participate effectively in meetings and group work. You will prepare a formal report and present it orally and in writing. Prerequisites: COMM 1116";
    //COMP 2121
    private final String COMP2121name = "Discrete Mathematics";
    private final String COMP2121desc = "Discrete Mathematics concerns processes that consist of a sequence of individual steps. The ideas of discrete mathematics underline the science and technology specific to computer applications. The Discrete Mathematics course provides the mathematical basis and concepts for applications in computer science: elementary logic, the logic of quantified statements, methods of proof, set theory, discrete functions, relations, counting and probabilities, sequences and mathematical induction, recursion, graphs, trees, and Boolean algebra. Prerequisites: COMP 1113";
    //COMP 2510
    private final String COMP2510name = "Procedural Programming in C";
    private final String COMP2510desc = "This hands-on course follows on from COMP 1510 in the full-time CST Diploma. Students are introduced to the procedural programming paradigm using the C programming language. Topics include: language syntax, common coding styles and idioms and the implementation of selected data structures and algorithms in C. Successful participants will learn how to design and build modular multi-file C programs and be prepared to move on to several higher level courses. COMP 2510 Procedural Programming in C is a required course in the full-time CST Diploma before option placement. It needs to be completed prior to a number of courses in second year including COMP 3512 Object Oriented Programming in C++, and COMP 4735 Operating Systems. Prerequisites: COMP 1510";
    //COMP 2526
    private final String COMP2526name = "Object-Oriented Programming with Java";
    private final String COMP2526desc = "Students continue to learn to develop applications with the Java language using the Object Oriented Paradigm. Focus is on problem solving, proper Object Oriented Programming techniques, and clear coding style. The three fundamentals of OOP are covered data abstraction and encapsulation, inheritance, and polymorphism with emphasis on the last two (inheritance and polymorphism). Data structures including Linked Lists, Queues, Stacks and Trees will be examined along with some common search and sort algorithms. Basic Java is explored including interfaces, exception handling, and user interfaces. Features of the latest Java Development Kit will also be examined. Several Java packages are examined including java.io, java.awt, swing, and others. Prerequisites: COMP 1510";
    //COMP 2714
    private final String COMP2714name = "Relational Database Systems";
    private final String COMP2714desc = "This course covers relational database technology, including basic concepts, relational algebra, enhanced entity-relationship data modeling, functional dependencies and normalization, design methodology, SQL query language (DDL and DML), views, access control and transaction management. Students design and implement a database application using RDBMS. Also covers some current database trends such as data warehousing and OLAP, and use of databases through web technology.";
    //COMP 2721
    private final String COMP2721name = "Computer Organization/Architecture";
    private final String COMP2721desc = "Computer organization is a fundamental topic for computer science students and for any future programmers. The course gives a good understanding of the computer hardware and how software is built on a specific hardware. The computer is regarded as a hierarchy of levels, each one performing some well-defined functions from the device level (hardware) to the problem-oriented language level. Each level is discussed and analyzed in detail. Prerequisites: COMP 1113 and COMP 1510";
    //COMP 2910
    private final String COMP2910name = "Projects";
    private final String COMP2910desc = "Students work in teams of four or five to complete an internal software development or IT project. Teams will proceed through the majority of the software development lifecycle, from requirements gathering to specification to implementation and delivery. The course is focused on developing teamwork and project management skills as well as an understanding of the development lifecycle. The project will simultaneously allow students to apply their previously-developed technical knowledge. Prerequisites: COMP 1510";

    //COMP 3512
    private final String COMP3512name = "Object Oriented Programming in C++";
    private final String COMP3512desc = "This course covers a paradigm in programming which deals with classes and objects. A number of features of the C++ language will be covered including inheritance, polymorphism, templates, exceptions and the Standard Template Library. Prerequisites: COMP 2510";
    //COMP 3711
    private final String COMP3711name = "Object Oriented Analysis and Design";
    private final String COMP3711desc = "This course introduces the students to the concepts of object oriented analysis and design. They will get the knowledge and the hands on experience to implement all the steps of an agile, iterative and incremental analysis and design process, from the planning and project management to the release and QA of the code. Use case documents are written to capture and analyze the requirements. The students will gain proficiency using Rational Rose and UML (Unified Modeling Language) to visually document the process. Design patterns, best practices, code generation and reverse engineering are used as a base for design and implementation. The course also introduces quality assurance concepts and the students will use automated software testing to create and execute test plans and test scripts. NOTE: In Part-time Studies, this course was replaced by COMP 3831. Prerequisites: COMP 2526";
    //COMP 3721
    private final String COMP3721name = "Introduction to Data Communications";
    private final String COMP3721desc = "This course covers the basic concepts and terminologies related to data communications, networking and network topologies. Students will learn about the TCP/IP protocol suite and the principles of protocols at the physical, data link, network and transport layers, the characteristics of transmission media, analog/digital transmission, multiplexing/switching techniques, basic error detection and correction, elementary data link protocols, flow control and an introduction to routing and congestion control issues. Multiple access protocols, the UDP and TCP protocols, networking and internetworking devices, LANs and WANs will also be discussed. Prerequisites: COMP 2721";
    //COMP 3760
    private final String COMP3760name = "Algorithm Analysis and Design";
    private final String COMP3760desc = "In this course, students will develop their ability to analyze and design computer algorithms. In particular, students will analyze the time and space complexity of programs, solve difficult programming problems using algorithmic techniques, and prove that their solution is correct. The emphasis will be on developing the practical skills of analysis and design. Topics covered may vary each term. Prerequisites: COMP 2121 and COMP 2526";
    //COMP 3900
    private final String COMP3900name = "Computer Projects Practicum 1";
    private final String COMP3900desc = "Allows students to work on projects within guidelines specified by faculty. The projects are drawn from a variety of sources, especially from industrial situations, and may require extensive contact with the business community. Students work in teams and seek advice from a faculty member acting as their project supervisor. Prerequisites: Completion of first year CST and Admission into a CST Option.";
    //COMP 3920
    private final String COMP3920name = "Database Systems 1";
    private final String COMP3920desc = "This course is for students who have a special interest in database technology. Topics include: the importance of data in an organization; relational algebra and advanced SQL; conceptual, logical and physical data modeling; functional dependencies and normal forms; data integrity; data access methods including hashing and indexing; external sorting techniques; database design, implementation, administration and programming; performance tuning and optimization. Students will use common industry database software products such as Microsoft SQL Server and/or Oracle DBMSs. Prerequisites: COMP 2714";
    //COMP 4925
    private final String COMP4925name = "Selected Topics in Database Systems";
    private final String COMP4925desc = "This course focuses on advanced topics in database technologies, database systems design and development tools, data management, enterprise servers and systems, and relevant related areas. Topics reflect on the current trends in the use of databases in the industry. Some of these topics include: business intelligence, data warehousing and OLAP, databases on the web, database applications based on 3-tier and n-tier models, development for enterprise systems, and connectivity and GUI development. Students will develop such database-related applications using software tools and products from Microsoft and/or Oracle.";

    //BLAW 3600
    private final String BLAW3600name = "Computers and the Law";
    private final String BLAW3600desc = "The course offers basic knowledge of Canadian law with emphasis on how the law affects those in the computer industry. The course includes the law of tort, contracts, sale of goods, secured transactions, employment, intellectual property, partnerships and companies.";
    //COMP 4100
    private final String COMP4100name = "Career Preparation";
    private final String COMP4100desc = "Students will explore employment options in information technology and develop a skill set to prepare for success in their career. Students will learn to make a positive first impression, will develop presentation and self-marketing skills and explore team building. Interview, job search and resume writing skills will also be developed. Traditional, contract, freelance work and self-employment will be discussed.";
    //COMP 4735
    private final String COMP4735name = "Operating Systems";
    private final String COMP4735desc = "This course is focused on basic concepts in operating systems: structure, operating systems services, how these services are used and implemented, processor management, processes and threads, kernel architecture, inter-process communication, synchronization and mutual exclusion, deadlock and starvation, memory organization and management, virtual memory, processor scheduling, input/output management, disk scheduling, and file management. To illustrate the concepts, each topic includes examples of real life design choices used in modern operating systems (e.g., UNIX, Linux, Windows, and Android). Prerequisites: COMP 2721 and COMP 3512";
    //COMP 4900
    private final String COMP4900name = "Computer Projects Practicum 2";
    private final String COMP4900desc = "Allows students to work on projects within guidelines specified by faculty. The projects are drawn from a variety of sources, especially from industrial situations, and may require extensive contact with the business community. Students work in teams and seek advice from a faculty member acting as their project supervisor. Prerequisites: Completion of first year CST and Admission into a CST Option.";
    //COMP 3717
    private final String COMP3717name = "Mobile Application Development with Android";
    private final String COMP3717desc = "This hands-on course introduces Android Application Development on mobile and tablet platforms to experienced Java Application Developers. Continuing on from COMP 2526, the Java programming language is used to develop, debug and deploy Android applications. Labs and assignments explore and use the Android SDK tools - avd, adb, ddms, etc., to configure and troubleshoot Android applications on the emulator(s). Topics include: Designing user interfaces with Views, Fragments, Layouts and Activities. Students learn to manage Android Resources, work with Manifest files, Persist data using SQLite DB, Create Services and Content Providers. Other topics of discussion include Location Based Services, Telephony, Multimedia APIs and Cloud to Device Messaging. By the end of this course successful participants will complete a final project which includes building, packaging and publishing an Android application for a mobile device or tablet. Prerequisites: COMP 2526";
    //COMP 4560
    private final String COMP4560name = "Computer Graphics for Computer Systems Technology";
    private final String COMP4560desc = "Covers basic operations in two-and three-dimensions, including the mathematical representation of basic geometric objects, definition of coordinate systems and mappings, transformations, simple animation, and viewing. Transformations and projections are presented in a matrix formulation. The course also introduces lighting models, colour models and methods for constructing curves. Prerequisites: (COMP 2510 or COMP 2526) and COMP 1113";
    //COMP 4711
    private final String COMP4711name = "Introduction to Internet Software Development";
    private final String COMP4711desc = "This course provides the students with an opportunity to develop a software application that works across the internet. An overview of various internet software development technologies is provided. Students will learn how to build a web application using a modern webapp MVC framework and Apache server technology; and how to use XML for data representation, structure and transport. Prerequisites: COMP 2510 or COMP 2526";
    //COMP 4921
    private final String COMP4921name = "Database Systems 2";
    private final String COMP4921desc = "This course is for students who have a special interest in database technology. Topics include: database transactions, concurrency control and recovery techniques in multi-user database systems, database security, distributed databases, and current trends in database technologies. Students will use common industry database software products such as Microsoft SQL Server and/or Oracle DBMSs. Database application development emphasizes the use of Oracle tools, including PL/SQL, Embedded SQL using Pro*C, Java JDBC using JDeveloper, and an introduction to Oracle ADF Development. Prerequisites: COMP 3920";

    private TextView courseName;
    private TextView courseDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        courseName = (TextView) findViewById(R.id.course_detail_title);
        courseDesc = (TextView) findViewById(R.id.course_detail_desc);
        courseSelected = getIntent().getStringExtra("courseSelected");
        setDetail(courseSelected);
    }

    private void setDetail(String course) {
        switch(course) {
            case "BUSA 2720":
                courseName.setText(BUSA2720name);
                courseDesc.setText(BUSA2720desc);
                break;
            case "COMM 1116":
                courseName.setText(COMM1116name);
                courseDesc.setText(COMM1116desc);
                break;
            case "COMP 1100":
                courseName.setText(COMP1100name);
                courseDesc.setText(COMP1100desc);
                break;
            case "COMP 1111":
                courseName.setText(COMP1111name);
                courseDesc.setText(COMP1111desc);
                break;
            case "COMP 1113":
                courseName.setText(COMP1113name);
                courseDesc.setText(COMP1113desc);
                break;
            case "COMP 1510":
                courseName.setText(COMP1510name);
                courseDesc.setText(COMP1510desc);
                break;
            case "COMP 1536":
                courseName.setText(COMP1536name);
                courseDesc.setText(COMP1536desc);
                break;
            case "COMM 2216":
                courseName.setText(COMM2216name);
                courseDesc.setText(COMM2216desc);
                break;
            case "COMP 2121":
                courseName.setText(COMP2121name);
                courseDesc.setText(COMP2121desc);
                break;
            case "COMP 2510":
                courseName.setText(COMP2510name);
                courseDesc.setText(COMP2510desc);
                break;
            case "COMP 2526":
                courseName.setText(COMP2526name);
                courseDesc.setText(COMP2526desc);
                break;
            case "COMP 2714":
                courseName.setText(COMP2714name);
                courseDesc.setText(COMP2714desc);
                break;
            case "COMP 2721":
                courseName.setText(COMP2721name);
                courseDesc.setText(COMP2721desc);
                break;
            case "COMP 2910":
                courseName.setText(COMP2910name);
                courseDesc.setText(COMP2910desc);
                break;
            case "COMP 3512":
                courseName.setText(COMP3512name);
                courseDesc.setText(COMP3512desc);
                break;
            case "COMP 3711":
                courseName.setText(COMP3711name);
                courseDesc.setText(COMP3711desc);
                break;
            case "COMP 3721":
                courseName.setText(COMP3721name);
                courseDesc.setText(COMP3721desc);
                break;
            case "COMP 3760":
                courseName.setText(COMP3760name);
                courseDesc.setText(COMP3760desc);
                break;
            case "COMP 3900":
                courseName.setText(COMP3900name);
                courseDesc.setText(COMP3900desc);
                break;
            case "COMP 3920":
                courseName.setText(COMP3920name);
                courseDesc.setText(COMP3920desc);
                break;
            case "COMP 4925":
                courseName.setText(COMP4925name);
                courseDesc.setText(COMP4925desc);
                break;
            case "BLAW 3600":
                courseName.setText(BLAW3600name);
                courseDesc.setText(BLAW3600desc);
                break;
            case "COMP 4100":
                courseName.setText(COMP4100name);
                courseDesc.setText(COMP4100desc);
                break;
            case "COMP 4735":
                courseName.setText(COMP4735name);
                courseDesc.setText(COMP4735desc);
                break;
            case "COMP 4900":
                courseName.setText(COMP4900name);
                courseDesc.setText(COMP4900desc);
                break;
            case "COMP 3717":
                courseName.setText(COMP3717name);
                courseDesc.setText(COMP3717desc);
                break;
            case "COMP 4560":
                courseName.setText(COMP4560name);
                courseDesc.setText(COMP4560desc);
                break;
            case "COMP 4711":
                courseName.setText(COMP4711name);
                courseDesc.setText(COMP4711desc);
                break;
            case "COMP 4921":
                courseName.setText(COMP4921name);
                courseDesc.setText(COMP4921desc);
                break;
            default: break;
        }

    }
}
