-----Java Library Management System-------

A standalone java Swing-based application to manage books in a library.


1) Features
   * Login & Logout System (Admin/Librarian).
   * Role-based access.
   * Add/Delete/Issue/Return Books.
   * MySQL database integration.
   * Real-time status updates for books.
   * GUI using Java Swing.

2) Tools Used
   * Java SE(Swing, JDBC)
   * MySQL
   * Eclipse
  
3) How to Run (Option A)
   * Make sure MySQL is running and Database is created. below is the example which i have implement in database.
   * I have created "library_db" database and created two tables 1. users. 2.books.
   * In DBConnection file change your username and password to your current MySQL credentials for smooth connection. otherwise your database will not connect to project.
   * In users table i have added the name,password,role (here you can add custom password if you want while login to LibrarySystem).
   * In books table i have added attributes like id,title,author,satus.
   * Then import project or JavaFile(Total 4) into Eclipse make sure you add the JDBC driver to your classpath to connect it to your database.
   * As you run the project name "LoginScreen" use default Credentials to login.(**Admin** Username:admin1 Password:adminpass & **Librarian** Username:librarian1 Password:libpass)
   * Login Successfull... Congrats..!!! Start adding books and Managing it in your own way.
  
4) Option B
   * First download the 4 java files then Create Package in your editor(Eclipse or anyother) and copy code manually and save it as the same name which i have uploaded.
   * Once you created and copy all the code in all 4 different classes then saved it and add the jdbc driver to your project.
   * Make sure you already created the database and created all the necessary tables and attributes in Mysql.
   * Time to Run your project open the LoginScreen.java File and Run it.
   * You will see the Login Page just enter the username & password and start adding and managing books.
   * Thankyou !!!!   

****Author***
**Nishant Gharat**
