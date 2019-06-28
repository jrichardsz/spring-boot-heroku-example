# java class with multiple entrypoints

com.springwalk.sample.config.SpringSecurityConfig

# Endpoint with security 01 (basic)

```
curl -u john123:password  http://localhost:8083/user
```

# Endpoint with security 02 (public)

```
curl http://localhost:8083/guest/1
```

As you can see, you could have two groups of endpoints. Group A with some kind of security and group B with another security engine or without security.
