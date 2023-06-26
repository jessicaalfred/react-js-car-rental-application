# Car Rental System

<b>Spring-Boot React Project</b>

_A web project using ReactJs, Spring Boot and PostgreSQL_

#### The project is built using the MVC Web project methodology

![image](https://user-images.githubusercontent.com/34398606/169754661-3ae625c9-0ff8-4110-9db2-436aea5028ca.png)

## Starting 🚀

These instructions will allow you to get a copy of the project running on your local machine for development and testing purposes.

### Requirements 📋

Software and tools you will need to run this project:

- Java 11 (_tested version_)
- Node v14.17.3 (_tested version_)
- Eclipse
- VS Code (_Reccomended for frontend developement_)

### Local deployment 🔧

There are two ways to work in your local environment:

1. Spring-Boot app in port 8080 and React app in port 3000 (_Recommended for development_)
2. Both apps running in port 8080

Let's see how to work with each option.

_Note: both frontend and backend are configured to start on path /projectname. Moreover frontend subpaths follow this pattern: /projectname/#/subpath (due to deployment requirements it is necessary to use HashRouter instead of BrowserRouter)_

**1. Access frontend in port 3030 (_Reccomended for development_)**

- Install your maven project
  ```
  mvn clean install
  ```
- Start backend sever
  ```
  mvn spring-boot:run
  ```
- Install your frontend app (not necessary if mvn install was executed correctly)
  ```
  npm install
  ```
- Start react app
  ```
  npm start
  ```

Now you can test your app in http://localhost:3000/rentberry (frontend)

**2. Access frontend in port 8080**

- Install your maven project
  ```
  mvn clean install
  ```
- Start the application
  `mvn spring-boot:run`
  Thanks to the provided plugin configuration you can access your React app directly on http://localhost:8080/rentberry

## Deployment 📦

Production deploy will be made via Jenkins to Kubernetes.

Steps to be followed:

1. Build the project
   ```
   mvn clean install
   ```
2. Create docker image
   ```
   mvn k8s:build
   ```
3. Undeploy Kubernetes app (_only needed if app is already deployed_)
   ```
   mvn k8s:undeploy
   ```
4. Push image to GitLab registry
   ```
   mvn k8s:push
   ```
5. Deploy pushed image to Kubernetes
   ```
   # Generate deploy files
   mvn k8s:resource
   # Deploy to Kubernetes
   mvn k8s:deploy
   ```

## Built with 🛠️

- [Spring-Boot](https://spring.io/projects/spring-boot) - Backend
- [React](https://es.reactjs.org/) - User Interface
- [PostgreSQL](https://www.postgresql.org/) - Database
- [Maven](https://maven.apache.org/) & [yarn](https://yarnpkg.com/) - Project Management
- [Kubernetes](https://kubernetes.io/) & [Docker](https://www.docker.com/) - Deployment

## Debug

- Just in case if the tomcat fails and says port 8080 alread in use, then open cmd in admin mode and type <br />
 ```
 netstat -ao | find "8080" 
 Taskkill /PID 20712 /F
 ```

## Author ✒️

- **Jessica Alfred*
