# clown-fiesta
basic spring security based auth

URIs:
Register: http://localhost:8085/api/v1/auth/register (params: String firstname, String lastname, String email, String password)

Authenticate: http://localhost:8085/api/v1/auth/authenticate (params: String email, String password)

Demo get request: http://localhost:8085/api/v1/demo-controller (with Bearer Token authentication)
