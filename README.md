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
  
3) How to Run
   * Make sure MySQL is running and Database is created. below is the example which i have implement in database.
   * i have created "library_db" database and created two tables 1. users. 2.books.
   * In DBConnection file change your username and password to your current MySQL credentials for smooth connection. otherwise your database will not connect to project.
   * in users table i have added the name,password,role (here you can add custom password if you want while login to LibrarySystem).
   * in books table i have added attributes like id,title,author,satus.
   * Then import project or JavaFile(Total 4) into Eclipse make sure you add the JDBC driver to your classpath to connect it to your database.
   * As you run the project name "LoginScreen" use default Credentials to login.(**Admin** Username:admin1 Password:adminpass & **Librarian** Username:librarian1 Password:libpass)
   * Login Successfull... Congrats..!!! Start adding books and Managing it in your own way.
   * Thankyou !!!!   

****Author***
**Nishant Gharat**
