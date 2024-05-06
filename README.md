<a name="readme-top"></a>

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <!-- <a href="https://github.com/othneildrew/Best-README-Template">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a> -->

  <h3 align="center">Hexagonal Architecture</h3>

</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <!-- <li><a href="#roadmap">Roadmap</a></li> -->
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project




This project demonstrates a Spring application built under the Hexagonal Architecture, also known as Ports and Adapters Architecture. This approach aims for high cohesion and low coupling, promoting:

Separation of concerns: Business logic resides in the core of the application, isolated from external technologies and frameworks.
Improved testability: The focus on the core facilitates the creation of unit and integration tests, ensuring code reliability.
Robust maintainability: The modular architecture allows for easy modification and addition of functionalities without affecting the core code.
Flexibility: The application easily adapts to different technologies and frameworks, as the core remains independent.
Project Highlights:

Docker configurations: Automate the building, testing, and deployment of the application in Docker containers.
Postman collection for API testing: Facilitate the testing of the application's REST APIs with pre-configured Postman collections.
ArchUnit for Architecture Validation: Use ArchUnit to ensure that the application structure follows the principles of Hexagonal Architecture.
Benefits of Hexagonal Architecture:

Cleaner and more robust code: The separation of responsibilities makes the code easier to understand and maintain.
Easier testing: The modular architecture facilitates more comprehensive unit and integration tests.
Flexibility for change: The application easily adapts to new technologies and requirements.
Improved code reusability: Components can be easily reused in other applications.



### Built With

- Java Development Kit (JDK)
- Docker
- Postman (para testar as chamadas à API)
- Mockoon (para simular a API externa)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started


### Prerequisites

* Java 17
* Maven 

### Installation

_Below is an example of how you can instruct your audience on installing and setting up your app. This template doesn't rely on any external dependencies or services._

1. Clone the repo
   ```sh
   git clone git@github.com:pedrop3/hexagonal.git
   ```
2. Install dependencs
   ```sh
   mvn clean install compile
   ```
4. If you're using Visual Studio Code, you can simply run the project by configuring the `launch.json`


<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- USAGE EXAMPLES -->
## Usage
1. Run Docker Compose to start Kafka and MongoDB services:
   ```sh
    cd docker-local
    docker-compose up -d
   ```
## Testing API

1. **Import Postman Collection:**
   - Download the `Hexagonal.postman_collection.json`.
   - Open Postman.
   - Import the downloaded collection into Postman.

2. **Ensure Application is Running:**
   - Make sure the application is up and running.

3. **Test Endpoints:**
   - Use the endpoints provided in the Postman collection to test the functionality of the application.

## Simulating External API with Mockoon

1. **Install Mockoon:**
   - Install Mockoon from [here](https://mockoon.com/).

2. **Import Data:**
   - Download `addresses.json`.
   - Open Mockoon.
   - Import `addresses.json` into Mockoon to set up the simulation of the external API.

3. **Start Mockoon Server:**
   - Start the Mockoon server.

4. **Configure Application:**
   - Update the Spring application settings to make calls to the simulated API instead of the real API.

## Hexagonal Architecture Verification with ArchUnit

The project includes automated tests using ArchUnit to ensure that the hexagonal architecture is correctly followed. These tests are automatically executed during the compilation phase.
<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ROADMAP
## Roadmap

- [x] Add Changelog
- [x] Add back to top links
- [ ] Add Additional Templates w/ Examples
- [ ] Add "components" document to easily copy & paste sections of the readme
- [ ] Multi-language Support
    - [ ] Chinese
    - [ ] Spanish

See the [open issues](https://github.com/othneildrew/Best-README-Template/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#readme-top">back to top</a>)</p> -->



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the MIT License.
<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Linkedin: [https://www.linkedin.com/in/pedrohmsantos/](https://www.linkedin.com/in/pedrohmsantos/)

<p align="right">(<a href="#readme-top">back to top</a>)</p>