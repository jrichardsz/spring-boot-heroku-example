# Test mysql database connection

Endpoint

- http://localhost:8080/database/test

Get parameters:

- jdbcUrl
  - jdbc:mysql://192.168.1.x/acme_db
- jdbcDriver
  - com.mysql.cj.jdbc.Driver
- user
  - root
- password
  - changeme
- sqlTest
  - select 1;
  - url encoded is
    - select%201%3B

```
curl "http://localhost:8080/database/test?jdbcUrl=jdbc:mysql://192.168.1.x/acme_db&jdbcDriver=com.mysql.cj.jdbc.Driver&user=root&password=changeme&sqlTest=select%201%3B"
```
