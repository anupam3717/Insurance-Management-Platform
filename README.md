
# Insurance Management System (Secure Insurance API)

Tech Stack: Spring Mvc, Spring Data Jpa, Jwt role based authentication, Exception Handling.


## Overview
This project is an Insurance Management System built using Spring Boot and Hibernate, providing a secure API for managing clients, policies, and claims. The system uses role-based authentication and authorization, allowing for different levels of access and control.
## Features
✦Client management: add, update, and delete clients with their personal details

✦Policy management: add, update, and delete policies for clients with their coverage and premium details.

✦Claim management: add, update, and delete claims for policies with their status and payout details

✦Role-based authentication and authorization: control access to API endpoints based on user roles

✦JWT token-based authentication: secure the API using JSON Web Tokens (JWT)
## File Structure
![alt text](https://github.com/anupam3717/Insurance-Management-Platform/blob/master/screenshot/project%20structure%201.png?raw=true)
![alt text](https://github.com/anupam3717/Insurance-Management-Platform/blob/master/screenshot/project%20structure%202.png?raw=true)
## Project Approach
The project was approached in a step-by-step manner, starting with database design and followed by building the backend logic and API endpoints. The project structure follows the Model-View-Controller (MVC) pattern, with separate packages for controllers, services, repositories, and models. The project also utilizes the HikariCP connection pool for efficient database management.
## Challenges Faced
One of the main challenges faced during the project was dealing with the complex data relationships between clients, policies, and claims. Bi-directional one-to-many relationships were implemented between the entities, which required careful consideration of data management and error handling. Additionally, implementing JWT authentication and integrating it with the API endpoints required significant effort, especially when it came to handling role-based access control.
## Conclusion
Overall, the Insurance Management System project was a challenging but rewarding experience that helped me develop my skills in Spring Boot development, database management, and API design. I'm confident that this project will serve as a strong foundation for future development projects in the insurance domain.
