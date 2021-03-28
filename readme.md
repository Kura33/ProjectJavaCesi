# ©MARVEL S.H.I.E.L.D. R&D

# Installation guide

Git-clone the project then

1. checkout master
2. Start your server MAMP/XAMP/WAMP
3. Run the SQL Script available in annexes/ to build the database
4. In the folder `src/main/resources/` folder, there is a file `application.properties`
   .You must verify that the database connectivity data is set to your needs otherwise, update it
5. Build the dependencies
6. Start the springboot project
7. With your terminal go into src/frontend/src and run `npm install` and `npm install --save axios vue-axios`
8. With your terminal go into src/frontend/src and run the command `npm run serve` to start the server and go locally
9. Clik on the link http://localhost:3000/

### The app is running!

If you need any help in how to make the application work, you can find a guide in annexes/Manuel\ d'utilisation
