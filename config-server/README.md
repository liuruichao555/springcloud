## spring cloud server
    1. profiles
       bootstrap: http://localhost:8080/configserver/bootstrap
       application: http://localhost:8080/configserver/application
    2. refresh
       http://localhost:8080/refresh
       
## 资源规则

| Path             | Description  |
|------------------|--------------|
| /{app}/{profile} | Configuration data for app in Spring profile (comma-separated).|
| /{app}/{profile}/{label} | Add a git label |
| /{app}/{profiels}{label}/{path} | An environment-specific plain text config file (at "path") |