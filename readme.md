# ©MARVEL S.H.I.E.L.D. R&D

# Installation guide

Git-clone the project then :

1. Verify that you're on the master branch.
2. Start your server MAMP/XAMP/WAMP.
3. Run the SQL Script available in annexes/ to build the database.
4. In the `src/main/resources/` folder, there is a file `application.properties`.
   .You must verify that the database connectivity data is set to your needs otherwise, update it.
5. Before you build the dependencies or run the project make sure your project is setup in the springboot environment.   
6. Build the dependencies, select JDK 16 if not specified.
7. Start the springboot project.
8. Install nodejs https://nodejs.org/en/.  
9. Execute the following command in your terminal `npm install vue`.
10. With your terminal go into src/frontend/src and run `npm install`.
11. With your terminal go into src/frontend/src and run the command `npm run serve` to start the server.
12. Clik on the link http://localhost:3000/.

### The app is running!

If you need any help in how to make the application work, you can find a guide in annexes/Manuel d'utilisation.
