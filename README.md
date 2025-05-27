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

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.




<!-- CONTACT -->
## Contact

E-mail: Vikl5@protonmail.com

