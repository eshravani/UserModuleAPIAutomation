# User Module REST API Automation

This project is a REST API automation framework developed for the **User Module** of the Petstore Swagger website. It uses Java, Maven, TestNG, and Log4j to structure the tests, with Extent Reports for test reporting.

## Project Structure

The project is structured into four main packages to maintain modularity:

- **endpoints**: Contains all API endpoint classes.
- **payloads**: Contains POJO classes for request payloads.
- **tests**: Contains the test cases for various user operations (create user, get users, update users, and delete users).
- **utilities**: Contains helper classes, including the Extent Report configuration.

## Technology Stack

- **Java**: Programming language for implementation.
- **Maven**: Dependency management and build automation.
- **TestNG**: Testing framework for organizing and executing tests.
- **Log4j**: Logging library for tracking execution.
- **Extent Reports**: Reporting library for generating detailed test reports.

## Project Setup

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd <repository-folder>
Import Project in IDE

Import as a Maven project in your preferred IDE (e.g., IntelliJ, Eclipse).
Install Dependencies

Run the following Maven command to install project dependencies:
bash
Copy code
mvn clean install
Test Execution
To run the tests, use the following Maven command:
bash
Copy code
mvn test
TestNG will execute all test cases in the tests package.
Reports
Extent Report: After test execution, an Extent Report will be generated in the /reports directory.
Log4j Logs: Log files generated during test execution are available in the /logs directory.
Logging
Log4j is used to capture logs for each test case. Logs can be found in the /logs folder and are useful for debugging and tracking execution details.

Packages and Key Components
endpoints

Contains classes for each endpoint.
Manages API requests and responses.
payloads

Contains POJO classes for building request payloads.
tests

Houses the main test cases for user module operations:
createUser: Adds a new user.
getUsers: Retrieves user details.
updateUser: Modifies user information.
deleteUser: Deletes a user record.
utilities

Contains utility files, including Extent Report configuration.
Future Improvements
Add data-driven tests for various user scenarios.
Implement CI/CD integration for automated test execution.
Enhance reporting and logging configurations.
Contributing
Fork the repository.
Create a new branch.
Make your changes and commit them.
Push to the branch.
Open a pull request.
License
This project is open-source and available under the MIT License.

