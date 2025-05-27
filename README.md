# Budget Savings


<!-- ABOUT THE PROJECT -->
## About The Project
This is a fullstack application created with Java and Vaadin components. It uses supabase for authentication of users and a postgresql database.



<!-- GETTING STARTED -->
## Getting Started
The application is hosted on Render, but it can also be run locally with your own supabase setup.
Render link https://budget-savings.onrender.com/

To get a local copy up and running follow these steps:

### Installation

1. Clone the repo
   ```sh
   git clone git@github.com:Vikl5/budget-savings.git
   cd budget-savings
   ```
2. Configure Supabase env vaiables
    You need to add a supabase url, anon-key and a database password. See the [Supabase docs](https://supabase.com/docs/guides/auth) for how to find these.
    In your terminal execute the following:
    ```sh
    export SUPABASE_URL=YOUR_SUPABASE_URL
    export SUPABASE_ANON_KEY=YOUR_ANON_KEY
    export SUPABASE_PASSWORD=YOUR_DB_PASSWORD
    ```
3. Build and run the project
   ```sh
   ./mvnw clean install -DskipTests
   ./mvnw spring-boot:run
   ```

<!-- CONTRIBUTING -->
## Contributing

If you have a suggestion that would make this better, please fork the repo and create a pull request.
Here are a few things of the top of my head which are missing:

- Allow authenticated users to update the database
- Add graphs to visualize the data from the database
- Github Actions for automatically build and deploy the Docker image to Render
- Add Dependabot to keep libraries up to date

<!-- ARCHITECTURE -->
## Architecture
A high level overview of the current version of the application


<img width="1238" alt="Screenshot 2025-05-27 at 12 51 04" src="https://github.com/user-attachments/assets/015fbc5e-d940-46ed-9b42-8f981894b2b4" />


<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.




<!-- CONTACT -->
## Contact

E-mail: Vikl5@protonmail.com

