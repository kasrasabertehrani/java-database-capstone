This Spring Boot application uses both MVC and REST controllers. Thymeleaf templates are used for the Admin and Doctor dashboards, while REST APIs serve all other modules. The application interacts with two databases—MySQL (for patient, doctor, appointment, and admin data) and MongoDB (for prescriptions). All controllers route requests through a common service layer, which in turn delegates to the appropriate repositories. MySQL uses JPA entities while MongoDB uses document models.

1. User access the application through: Thymeleaf-based web dashboards or REST API Controllers
2. Users interaction with the application creates a request which is taken by controllers to the backend system.
3. Service layer takes requests and processes them.
4. Service layer interact with repository layer to fetch/save data.
5. Repository layer is a port which lets Service layer to communicate with underlying databases.
6. Fetched data from databases are mapped into Java classes(Entity objects in case of MySQL and Document objects in case of MongoDB) so that Service layer can interact with them.
7. In case of MVC flow, users are redirected to other pages and in case of REST flow data is serialized to JSON and sent to frontend.